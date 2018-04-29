package com.rafael.creditcard.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmericanExpress extends CreditCard{

    public static final Integer AMEX_15 = 15;
    public static final List<String> STARTING_CHARACTERS_AMEX = new ArrayList<String>(Arrays.asList("34", "37"));

    public AmericanExpress(String number) {
        super(number);
    }

    @Override
    public String toString() {
        return "AmericanExpress{ Number: " + super.getNumber() + "}";
    }
}
