package br.com.edilsonvilarinho.solid.openClosedPrinciple;

import br.com.edilsonvilarinho.exception.AmountInvalidException;
import br.com.edilsonvilarinho.exception.PaymentInvalidException;

public class Checkout {

    private final Payment payment;
    private final Double amount;

    public Checkout(Payment payment, Double amount) throws PaymentInvalidException, AmountInvalidException {
        if (payment == null) throw new PaymentInvalidException("Payment invalid");
        if (amount == null || amount <= 0) throw new AmountInvalidException("Amount invalid");
        this.payment = payment;
        this.amount = amount;
    }

    public void finalizePayment() throws PaymentInvalidException {
        payment.pay(amount);
    }
}
