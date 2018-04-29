package com.rafael.creditcard;

import com.rafael.creditcard.business.CreditCardLogic;
import com.rafael.creditcard.entity.AmericanExpress;
import com.rafael.creditcard.entity.CreditCard;
import com.rafael.creditcard.entity.MasterCard;
import com.rafael.creditcard.entity.Visa;
import com.rafael.creditcard.exception.CreditCardException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CreditCardTest {


    private CreditCardLogic creditCardLogic = new CreditCardLogic();

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void nonvalid_invalid_characters() throws CreditCardException{
        thrown.expect(CreditCardException.class);
        thrown.expectMessage("Credit card number format contains wrong values");
        CreditCard result = creditCardLogic.getCreditCardFromNumber("378282246310005AAAA");
    }

    @Test
    public void nonvalid_more_numbers() throws CreditCardException{
        thrown.expect(CreditCardException.class);
        thrown.expectMessage("Credit card number length not valid");
        CreditCard result = creditCardLogic.getCreditCardFromNumber("37828224631000512312311");
    }

    @Test
    public void nonvalid_luhn_algorithm() throws CreditCardException{
        thrown.expect(CreditCardException.class);
        thrown.expectMessage("The credit card does not meet the Luhn algorithm");
        CreditCard result = creditCardLogic.getCreditCardFromNumber("458282246310005");

    }

    @Test
    public void nonvalid_starting_number() throws CreditCardException {
        thrown.expect(CreditCardException.class);
        thrown.expectMessage("The credit card number doesn't start with the right values");
        CreditCard result = creditCardLogic.getCreditCardFromNumber("6011030269807922");
    }

    @Test
    public void valid_american_express() throws CreditCardException{
        CreditCard result = creditCardLogic.getCreditCardFromNumber("378282246310005");
        Assert.assertEquals(result.getClass(), AmericanExpress.class);

        result = creditCardLogic.getCreditCardFromNumber("371449635398431");
        Assert.assertEquals(result.getClass(), AmericanExpress.class);
    }

    @Test
    public void valid_mastercard() throws CreditCardException{
        CreditCard result = creditCardLogic.getCreditCardFromNumber("5555555555554444");
        Assert.assertEquals(result.getClass(), MasterCard.class);

        result = creditCardLogic.getCreditCardFromNumber("5105105105105100");
        Assert.assertEquals(result.getClass(), MasterCard.class);
    }

    @Test
    public void valid_visa() throws CreditCardException{
        CreditCard result = creditCardLogic.getCreditCardFromNumber("4111111111111111");
        Assert.assertEquals(result.getClass(), Visa.class);

        result = creditCardLogic.getCreditCardFromNumber("4012888888881881");
        Assert.assertEquals(result.getClass(), Visa.class);
    }
}
