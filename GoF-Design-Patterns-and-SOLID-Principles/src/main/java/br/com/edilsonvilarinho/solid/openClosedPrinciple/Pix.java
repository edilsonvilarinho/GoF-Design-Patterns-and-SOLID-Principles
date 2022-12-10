package br.com.edilsonvilarinho.solid.openClosedPrinciple;

import br.com.edilsonvilarinho.exception.BalanceInvalidException;
import br.com.edilsonvilarinho.exception.PaymentInvalidException;

public class Pix implements Payment, Extract {

    private Double balance;

    public Pix(Double balance) throws BalanceInvalidException {
        if (balance == null || balance < 0) throw new BalanceInvalidException("Balance invalid");
        this.balance = balance;
    }

    @Override
    public void pay(Double value) throws PaymentInvalidException {
        if (this.balance < value) throw new PaymentInvalidException("Payment invalid");
        this.balance = this.balance - value;
    }

    @Override
    public double show() {
        return this.balance;
    }
}
