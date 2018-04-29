package com.rafael.creditcard.business.validationrules;

import com.rafael.creditcard.entity.AmericanExpress;
import com.rafael.creditcard.entity.MasterCard;
import com.rafael.creditcard.entity.Visa;
import com.rafael.creditcard.exception.CreditCardException;

public class LengthRule implements ValidationRule {

    public void validate(String creditCardNumber) throws CreditCardException {
        Integer creditCardNumberLength = creditCardNumber.length();
        if (!creditCardNumberLength.equals(AmericanExpress.AMEX_15)
                && !creditCardNumberLength.equals(Visa.VISA_13)
                && !creditCardNumberLength.equals(Visa.VISA_16)
                && !creditCardNumberLength.equals(MasterCard.MASTERCARD_16)) {
            throw new CreditCardException("Credit card number length not valid");
        }
    }
}
