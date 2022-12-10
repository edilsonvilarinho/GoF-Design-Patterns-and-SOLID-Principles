package br.com.edilsonvilarinho.solid.openClosedPrinciple;

import br.com.edilsonvilarinho.exception.LimitInvalidException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class CardCreditTest {

    @Test
    void payValid() throws LimitInvalidException {
        CardCredit cardCredit = new CardCredit(100.0);
        assertEquals(cardCredit.show(), 100.0);
    }

    @Test
    void limitCardCreditInvalid() {
        assertThrowsExactly(LimitInvalidException.class, () -> {
            CardCredit cardCredit = new CardCredit(-100.0);
        });
    }

}