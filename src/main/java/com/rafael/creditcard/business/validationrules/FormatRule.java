package com.rafael.creditcard.business.validationrules;

import com.rafael.creditcard.entity.CreditCard;
import com.rafael.creditcard.exception.CreditCardException;

public class FormatRule implements ValidationRule {

    @Override
    public void validate(String creditCardNumber) throws CreditCardException {
        String regex = "\\d+";
        if(!creditCardNumber.matches(regex)){
            throw new CreditCardException("Credit card number format contains wrong values");
        }
    }
}
