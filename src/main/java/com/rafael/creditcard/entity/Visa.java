package com.rafael.creditcard.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Visa extends CreditCard{

    public static final Integer VISA_13 = 13;
    public static final Integer VISA_16 = 16;
    public static final List<String> STARTING_CHARACTERS_VISA = new ArrayList<String>(Arrays.asList("4"));

    public Visa(String number) {
        super(number);
    }

    @Override
    public String toString() {
        return "Visa{ Number: " + super.getNumber() + "}";
    }
}
