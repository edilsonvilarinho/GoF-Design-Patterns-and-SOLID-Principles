package br.com.edilsonvilarinho.solid.openClosedPrinciple;

import br.com.edilsonvilarinho.exception.BalanceInvalidException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class CardDebitTest {

    @Test
    void cardDebitValid() throws BalanceInvalidException {
        CardDebit cardDebit = new CardDebit(100.0);
        assertEquals(cardDebit.show(), 100.0);
    }

    @Test
    void balanceCardDebitInvalid() {
        assertThrowsExactly(BalanceInvalidException.class, () -> {
            CardDebit cardDebit = new CardDebit(-100.0);
        });
    }

}