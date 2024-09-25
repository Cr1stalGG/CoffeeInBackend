package com.example.service.impl

import com.example.dto.mapper.OrderDtoMapper
import com.example.dto.order.OrderCreationDto
import com.example.dto.order.OrderDto
import com.example.entity.Account
import com.example.entity.Item
import com.example.entity.Order
import com.example.entity.OrderStatus
import com.example.exception.AccountWithIdNotFoundException
import com.example.exception.CannotChangeOrderStatusException
import com.example.exception.ItemWithIdNotFoundException
import com.example.exception.OrderStatusWithNameNotFoundException
import com.example.exception.OrderWithIdNotFoundException
import com.example.repository.AccountRepository
import com.example.repository.ItemRepository
import com.example.repository.OrderRepository
import com.example.repository.OrderStatusRepository
import com.example.service.OrderService
import com.example.service.enums.OrderStatusEnum
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.sql.Date
import java.util.UUID

@Service
class OrderServiceImpl(
    private val accountRepository: AccountRepository,
    private val orderRepository: OrderRepository,
    private val itemRepository: ItemRepository,
    private val orderStatusRepository: OrderStatusRepository,
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

        val order = Order(
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

    @Transactional
    override fun changeOrderStatus(orderId: UUID): OrderDto {
        val order: Order = orderRepository.findById(orderId)
            .orElseThrow { OrderWithIdNotFoundException(orderId) }

        val newOrderStatusName: String = when(order.orderStatus.name){
            OrderStatusEnum.STATUS_TAKEN.value -> OrderStatusEnum.STATUS_IN_PROGRESS.value
            OrderStatusEnum.STATUS_IN_PROGRESS.value -> OrderStatusEnum.STATUS_DONE.value
            else -> throw CannotChangeOrderStatusException(order.orderStatus.name)
        }

        val previousOrderStatus: OrderStatus = order.orderStatus
        val newOrderStatus: OrderStatus = orderStatusRepository.findByName(newOrderStatusName)
            .orElseThrow{ OrderStatusWithNameNotFoundException(newOrderStatusName) }

        previousOrderStatus.orders.minusAssign(order)

        order.orderStatus = newOrderStatus
        newOrderStatus.orders.plusAssign(order)

        return OrderDtoMapper.convertEntityToDto(order)
    }

    override fun deleteById(id: UUID) {
        orderRepository.findById(id)
            .orElseThrow { OrderWithIdNotFoundException(id) }

        orderRepository.deleteById(id)
    }
}