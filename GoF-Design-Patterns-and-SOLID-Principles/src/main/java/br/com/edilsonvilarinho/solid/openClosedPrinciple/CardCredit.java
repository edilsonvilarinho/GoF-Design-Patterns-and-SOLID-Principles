package br.com.edilsonvilarinho.solid.openClosedPrinciple;

import br.com.edilsonvilarinho.exception.LimitInvalidException;
import br.com.edilsonvilarinho.exception.PaymentInvalidException;

public class CardCredit implements Payment, Extract {

    private Double limit;

    public CardCredit(Double limit) throws LimitInvalidException {
        if (limit == null || limit < 0) throw new LimitInvalidException("Limit invalid");
        this.limit = limit;
    }

    @Override
    public void pay(Double value) throws PaymentInvalidException {
        if (this.limit < value) throw new PaymentInvalidException("Payment invalid");
        this.limit = this.limit - value;
    }

    @Override
    public double show() {
        return limit;
    }
}
