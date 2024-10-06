package com.example.dto.mapper;

import com.example.dto.card.CardCreationDto;
import com.example.dto.card.CardDto;
import com.example.dto.transaction.TransactionDto;
import com.example.entity.Card;
import com.example.entity.Transaction;
import lombok.experimental.UtilityClass;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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
        Random random = new Random();
        Double money = random.nextDouble(3000) + 500;
        return new Card(source.getNumber(), source.getPassword(), source.getCvv(), money);
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
        else
            return source.stream()
                    .map(TransactionDtoMapper::convertEntityToDto)
                    .toList();
    }
}
