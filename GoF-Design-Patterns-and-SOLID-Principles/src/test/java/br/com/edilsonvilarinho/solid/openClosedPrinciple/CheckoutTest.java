package br.com.edilsonvilarinho.solid.openClosedPrinciple;

import br.com.edilsonvilarinho.exception.AmountInvalidException;
import br.com.edilsonvilarinho.exception.BalanceInvalidException;
import br.com.edilsonvilarinho.exception.LimitInvalidException;
import br.com.edilsonvilarinho.exception.PaymentInvalidException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class CheckoutTest {

    @Test
    void checkoutFinalizePaymentCardCreditValid() throws LimitInvalidException, AmountInvalidException, PaymentInvalidException {
        CardCredit cardCredit = new CardCredit(100.0);
        Checkout checkout = new Checkout(cardCredit, 50.0);
        checkout.finalizePayment();
        assertEquals(cardCredit.show(), 50.0);
    }

    @Test
    void checkoutCardCreditPaymentInvalid() {
        assertThrowsExactly(PaymentInvalidException.class, () -> {
            CardCredit cardCredit = new CardCredit(100.0);
            Checkout checkout = new Checkout(cardCredit, 500.0);
            checkout.finalizePayment();
        });
    }

    @Test
    void checkoutFinalizePaymentCardDebitValid() throws AmountInvalidException, PaymentInvalidException, BalanceInvalidException {
        CardDebit cardDebit = new CardDebit(100.0);
        Checkout checkout = new Checkout(cardDebit, 50.0);
        checkout.finalizePayment();
        assertEquals(cardDebit.show(), 50.0);
    }

    @Test
    void checkoutCardDebitPaymentInvalid() {
        assertThrowsExactly(PaymentInvalidException.class, () -> {
            CardDebit cardDebit = new CardDebit(100.0);
            Checkout checkout = new Checkout(cardDebit, 5000.0);
            checkout.finalizePayment();
        });
    }

    @Test
    void checkoutFinalizePaymentPixValid() throws AmountInvalidException, PaymentInvalidException, BalanceInvalidException {
        Pix pix = new Pix(100.0);
        Checkout checkout = new Checkout(pix, 50.0);
        checkout.finalizePayment();
        assertEquals(pix.show(), 50.0);
    }

    @Test
    void checkoutFinalizePaymentPixInvalid() {
        assertThrowsExactly(PaymentInvalidException.class, () -> {
            Pix pix = new Pix(100.0);
            Checkout checkout = new Checkout(pix, 5000.0);
            checkout.finalizePayment();
        });
    }

    @Test
    void checkoutAmountPaymentInvalid() {
        assertThrowsExactly(AmountInvalidException.class, () -> {
            CardDebit cardDebit = new CardDebit(100.0);
            Checkout checkout = new Checkout(cardDebit, -5000.0);
            checkout.finalizePayment();
        });
    }
}