package com.example.service.impl

import com.example.dto.card.CardCreationDto
import com.example.dto.card.CardDto
import com.example.dto.mapper.CardDtoMapper
import com.example.dto.mapper.TransactionDtoMapper
import com.example.dto.transaction.TransactionDto
import com.example.entity.Account
import com.example.entity.Card
import com.example.entity.Order
import com.example.entity.Transaction
import com.example.exception.AccountWithIdNotFoundException
import com.example.exception.CardWithIdNotFoundException
import com.example.exception.NotEnoughMoneyException
import com.example.exception.OrderWithIdNotFoundException
import com.example.repository.AccountRepository
import com.example.repository.CardRepository
import com.example.repository.OrderRepository
import com.example.repository.TransactionRepository
import com.example.service.CardService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.sql.Date
import java.util.*

@Service
class CardServiceImpl(
    private val cardRepository: CardRepository,
    private val accountRepository: AccountRepository,
    private val orderRepository: OrderRepository,
    private val transactionRepository: TransactionRepository,
): CardService {
    override fun findById(id: UUID): CardDto {
        val card: Card = cardRepository.findById(id)
            .orElseThrow{ CardWithIdNotFoundException(id) }

        return CardDtoMapper.convertEntityToDto(card)
    }

    override fun findByAccountId(accountId: UUID): List<CardDto> {
        return cardRepository.findByOwner_Id(accountId).stream()
            .map(CardDtoMapper::convertEntityToDto)
            .toList()
    }

    @Transactional
    override fun addCard(accountId: UUID, creationDto: CardCreationDto): CardDto {
        val account: Account = accountRepository.findById(accountId)
            .orElseThrow{ AccountWithIdNotFoundException(accountId) }

        val card = CardDtoMapper.convertDtoToEntity(creationDto)
        card.owner = account

        cardRepository.save(card)

        account.cards.plusAssign(card)

        return CardDtoMapper.convertEntityToDto(card)
    }

    @Transactional
    override fun pay(cardId: UUID, orderId: UUID): TransactionDto {
        val card: Card = cardRepository.findById(cardId)
            .orElseThrow { CardWithIdNotFoundException(cardId) }
        val order: Order = orderRepository.findById(orderId)
            .orElseThrow { OrderWithIdNotFoundException(orderId) }

        if(card.money < order.summaryPrice)
            throw NotEnoughMoneyException(card.number, order.summaryPrice)

        card.money -= order.summaryPrice

        val transaction = Transaction(
            card,
            order,
            Date(System.currentTimeMillis())
        )

        transactionRepository.save(transaction)

        card.transactions.plusAssign(transaction)

        return TransactionDtoMapper.convertEntityToDto(transaction)
    }

    override fun deleteById(id: UUID) {
        cardRepository.findById(id)
            .orElseThrow { CardWithIdNotFoundException(id) }

        cardRepository.deleteById(id)
    }
}