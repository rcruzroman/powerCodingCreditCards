package com.rafael.creditcard.business.validationrules;

import com.rafael.creditcard.exception.CreditCardException;

public class LuhnRule implements ValidationRule {

    public void validate(String creditCardNumber) throws CreditCardException{
        if(!LuhnRule.Check(creditCardNumber)){
            throw new CreditCardException("The credit card does not meet the Luhn algorithm");
        }
    }

    public static boolean Check(String ccNumber) {
        int sum = 0;
        boolean alternate = false;
        for (int i = ccNumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(ccNumber.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }
}
