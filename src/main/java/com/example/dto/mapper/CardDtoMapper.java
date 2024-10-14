package com.example.dto.mapper;

import com.example.dto.card.CardCreationDto;
import com.example.dto.card.CardDto;
import com.example.dto.transaction.TransactionDto;
import com.example.entity.Card;
import com.example.entity.Transaction;
import lombok.experimental.UtilityClass;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Optional;

@UtilityClass
public class CardDtoMapper {
    public static CardDto convertEntityToDto(Card source){
        return Optional.ofNullable(source)
                .map(CardDtoMapper::buildDto)
                .orElse(null);
    }

    public static Card convertDtoToEntity(CardCreationDto source){
        return Optional.ofNullable(source)
                .map(CardDtoMapper::buildEntity)
                .orElse(null);
    }

    private static Card buildEntity(CardCreationDto source){
        return Card.builder()
                .number(source.getNumber())
                .password(source.getPassword())
                .cvv(source.getCvv())
                .money((double) new Random().nextInt(500,3000))
                .build();
    }

    private static CardDto buildDto(Card source){
        return CardDto.builder()
                .uuid(source.getId())
                .number(source.getNumber())
                .transactions(buildTransactions(source.getTransactions()))
                .build();
    }

    private static List<TransactionDto> buildTransactions(List<Transaction> source){
        if(source == null)
            return new ArrayList<>();

        return source.stream()
                .map(TransactionDtoMapper::convertEntityToDto)
                .toList();
    }
}
