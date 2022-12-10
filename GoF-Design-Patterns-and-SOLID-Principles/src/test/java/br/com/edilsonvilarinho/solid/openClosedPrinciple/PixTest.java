package br.com.edilsonvilarinho.solid.openClosedPrinciple;

import br.com.edilsonvilarinho.exception.BalanceInvalidException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class PixTest {

    @Test
    void pixValid() throws BalanceInvalidException {
        Pix pix = new Pix(100.0);
        assertEquals(pix.show(), 100.0);
    }

    @Test
    void balancePixInvalid() {
        assertThrowsExactly(BalanceInvalidException.class, () -> {
            Pix pix = new Pix(-100.0);
        });
    }
}