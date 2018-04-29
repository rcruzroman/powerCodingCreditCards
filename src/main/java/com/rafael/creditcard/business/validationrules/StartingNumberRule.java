package com.rafael.creditcard.business.validationrules;

import com.rafael.creditcard.entity.AmericanExpress;
import com.rafael.creditcard.entity.MasterCard;
import com.rafael.creditcard.entity.Visa;
import com.rafael.creditcard.exception.CreditCardException;

import java.util.ArrayList;
import java.util.List;

public class StartingNumberRule implements ValidationRule {

    public void validate(final String creditCardNumber) throws CreditCardException {
        List<String> allCards = new ArrayList<String>();
        allCards.addAll(AmericanExpress.STARTING_CHARACTERS_AMEX);
        allCards.addAll(MasterCard.STARTING_CHARACTERS_MASTERCARD);
        allCards.addAll(Visa.STARTING_CHARACTERS_VISA);

        Boolean cardValid = allCards.stream().anyMatch(initialCharacters -> creditCardNumber.startsWith(initialCharacters));

        if (!cardValid) {
            throw new CreditCardException("The credit card number doesn't start with the right values");
        }
    }
}
