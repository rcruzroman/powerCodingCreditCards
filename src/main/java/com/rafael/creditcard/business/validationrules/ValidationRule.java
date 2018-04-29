package com.rafael.creditcard.business.validationrules;

import com.rafael.creditcard.exception.CreditCardException;

public interface ValidationRule {
    void validate(String creditCardNumber) throws CreditCardException;
}
