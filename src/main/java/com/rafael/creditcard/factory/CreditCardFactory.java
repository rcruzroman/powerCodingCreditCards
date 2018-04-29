package com.rafael.creditcard.factory;

import com.rafael.creditcard.entity.AmericanExpress;
import com.rafael.creditcard.entity.CreditCard;
import com.rafael.creditcard.entity.MasterCard;
import com.rafael.creditcard.entity.Visa;
import com.rafael.creditcard.exception.CreditCardException;

public class CreditCardFactory {

    public CreditCard getCreditCard(String creditCardNumber) throws CreditCardException{

        if(isAMEX(creditCardNumber)){
            return new AmericanExpress(creditCardNumber);
        }else if(isMasterCard(creditCardNumber)){
            return new MasterCard(creditCardNumber);
        }else if(isVisa(creditCardNumber)){
            return new Visa(creditCardNumber);
        }else{
            throw new CreditCardException("The credit card number is not neither American Express nor MasterCard nor Visa");
        }

    }

    private static Boolean isAMEX(String creditCardNumber){
        return creditCardNumber.length() == AmericanExpress.AMEX_15
                && AmericanExpress.STARTING_CHARACTERS_AMEX.stream().anyMatch(initialCharacters -> creditCardNumber.startsWith(initialCharacters));
    }

    private static Boolean isMasterCard(String creditCardNumber){
        return creditCardNumber.length() == MasterCard.MASTERCARD_16
                && MasterCard.STARTING_CHARACTERS_MASTERCARD.stream().anyMatch(initialCharacters -> creditCardNumber.startsWith(initialCharacters));
    }

    private static Boolean isVisa(String creditCardNumber){
        return (creditCardNumber.length() == Visa.VISA_13 || creditCardNumber.length() == Visa.VISA_16)
                && Visa.STARTING_CHARACTERS_VISA.stream().anyMatch(initialCharacters -> creditCardNumber.startsWith(initialCharacters));
    }
}
