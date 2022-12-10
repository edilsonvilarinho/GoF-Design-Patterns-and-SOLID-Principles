package br.com.edilsonvilarinho.solid.openClosedPrinciple;

import br.com.edilsonvilarinho.exception.PaymentInvalidException;

public interface Payment {
    void pay(Double value) throws PaymentInvalidException;
}
