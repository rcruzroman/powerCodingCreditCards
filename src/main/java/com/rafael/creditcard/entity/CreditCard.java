package com.rafael.creditcard.entity;

public class CreditCard {

    public CreditCard(String number) {
        this.number = number;
    }

    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
