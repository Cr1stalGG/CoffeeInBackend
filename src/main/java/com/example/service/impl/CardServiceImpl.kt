package com.example.service.impl

import com.example.dto.card.CardDto
import com.example.dto.mapper.CardDtoMapper
import com.example.entity.Card
import com.example.exception.CardWithIdNotFoundException
import com.example.repository.CardRepository
import com.example.service.CardService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CardServiceImpl(
    private val cardRepository: CardRepository,
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

    override fun deleteById(id: UUID) {
        cardRepository.findById(id)
            .orElseThrow { CardWithIdNotFoundException(id) }

        cardRepository.deleteById(id)
    }
}