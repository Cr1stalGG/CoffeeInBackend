package com.example.exception;

public class LackOfMoneyException extends RuntimeException{
    public LackOfMoneyException(String cardNumber, double summaryPrice){
        super(String.format("Card with '%s' has less money than order's price '%d'", cardNumber, summaryPrice));
    }
}
