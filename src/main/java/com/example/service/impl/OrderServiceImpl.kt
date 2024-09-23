package com.example.service.impl

import com.example.dto.mapper.OrderDtoMapper
import com.example.dto.order.OrderCreationDto
import com.example.dto.order.OrderDto
import com.example.entity.Account
import com.example.entity.Item
import com.example.entity.Order
import com.example.exception.AccountWithIdNotFoundException
import com.example.exception.ItemWithIdNotFoundException
import com.example.exception.OrderWithIdNotFoundException
import com.example.repository.AccountRepository
import com.example.repository.ItemRepository
import com.example.repository.OrderRepository
import com.example.service.OrderService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.sql.Date
import java.util.*

@Service
class OrderServiceImpl(
    private val accountRepository: AccountRepository,
    private val orderRepository: OrderRepository,
    private val itemRepository: ItemRepository,
): OrderService {
    override fun findById(id: UUID): OrderDto {
        val order: Order = orderRepository.findById(id)
            .orElseThrow { OrderWithIdNotFoundException(id) }

        return OrderDtoMapper.convertEntityToDto(order)
    }

    @Transactional
    override fun addOrder(accountId: UUID, orderCreationDto: OrderCreationDto): OrderDto {
        val account:Account = accountRepository.findById(accountId)
            .orElseThrow{ AccountWithIdNotFoundException(accountId) }
        val items: MutableList<Item> = mutableListOf()
        var summaryPrice = 0.0

        for (itemId: UUID in orderCreationDto.itemsId){
            val item: Item = itemRepository.findById(itemId)
                .orElseThrow { ItemWithIdNotFoundException(itemId) }

            items += item

            summaryPrice += item.price
        }

        val order: Order = Order(
            Date(System.currentTimeMillis()),
            account,
            summaryPrice,
            items
        )

        orderRepository.save(order)

        account.orders.plusAssign(order)

        for(item: Item in order.items)
            item.orders.plusAssign(order)

        //TODO(add transaction)

        return OrderDtoMapper.convertEntityToDto(order)
    }

    override fun deleteById(id: UUID) {
        orderRepository.findById(id)
            .orElseThrow { OrderWithIdNotFoundException(id) }

        orderRepository.deleteById(id)
    }
}