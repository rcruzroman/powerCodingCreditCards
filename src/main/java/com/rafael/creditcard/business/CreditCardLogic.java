package com.rafael.creditcard.business;

import com.rafael.creditcard.business.validationrules.*;
import com.rafael.creditcard.entity.CreditCard;
import com.rafael.creditcard.exception.CreditCardException;
import com.rafael.creditcard.factory.CreditCardFactory;

import java.util.ArrayList;
import java.util.List;

public class CreditCardLogic {

    private CreditCardFactory creditCardFactory;

    //To enforce to use singleton pattern
    private CreditCardFactory getSingletonCreditCardFactory(){
        if(creditCardFactory == null){
            creditCardFactory = new CreditCardFactory();
        }
        return creditCardFactory;
    }

    public CreditCard getCreditCardFromNumber(String creditCardNumber) throws CreditCardException{
        validateCreditCardNumber(creditCardNumber);
        return getSingletonCreditCardFactory().getCreditCard(creditCardNumber);
    }

    private void validateCreditCardNumber(String creditCardNumber) throws CreditCardException {

        List<ValidationRule> validationRules = new ArrayList<ValidationRule>();
        validationRules.add(new FormatRule());
        validationRules.add(new LengthRule());
        validationRules.add(new LuhnRule());
        validationRules.add(new StartingNumberRule());

        for (ValidationRule validationRule: validationRules) {
            validationRule.validate(creditCardNumber);
        }
    }


}
