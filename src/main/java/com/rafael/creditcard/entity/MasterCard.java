package com.rafael.creditcard.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MasterCard extends CreditCard {

    public static final Integer MASTERCARD_16 = 16;
    public static final List<String> STARTING_CHARACTERS_MASTERCARD = new ArrayList<String>(Arrays.asList("51", "52", "53", "54", "55"));

    public MasterCard(String number) {
        super(number);
    }

    @Override
    public String toString() {
        return "MasterCard{ Number: " + super.getNumber() + "}";
    }
}
