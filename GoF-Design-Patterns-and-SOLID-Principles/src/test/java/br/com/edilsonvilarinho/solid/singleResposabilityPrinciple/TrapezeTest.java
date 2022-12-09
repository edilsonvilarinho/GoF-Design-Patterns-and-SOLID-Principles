package br.com.edilsonvilarinho.solid.singleResposabilityPrinciple;

import br.com.edilsonvilarinho.exception.BiggerBaseInvalidException;
import br.com.edilsonvilarinho.exception.HeightInvalidException;
import br.com.edilsonvilarinho.exception.MinorBaseInvalidException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrapezeTest {

    @Test
    void caculateValid() throws HeightInvalidException, MinorBaseInvalidException, BiggerBaseInvalidException {
        Area area = new Trapeze(1.0, 1.0, 1.0);
        assertEquals(area.calculate(), 1);
    }

    @Test
    void heightInvalid() {
        assertThrowsExactly(HeightInvalidException.class, () -> {
            Area area = new Trapeze(1.0, 1.0, -1.0);
            assertEquals(area.calculate(), 1);
        });
    }

    @Test
    void minorBaseInvalid() {
        assertThrowsExactly(MinorBaseInvalidException.class, () -> {
            Area area = new Trapeze(-1.0, 1.0, 1.0);
            assertEquals(area.calculate(), 1);
        });
    }

    @Test
    void biggerBaseInvalid() {
        assertThrowsExactly(BiggerBaseInvalidException.class, () -> {
            Area area = new Trapeze(1.0, -1.0, 1.0);
            assertEquals(area.calculate(), 1);
        });
    }

    @Test
    void calculateInvalid() throws HeightInvalidException, MinorBaseInvalidException, BiggerBaseInvalidException {
        Area area = new Trapeze(1.0, 1.0, 1.0);
        assertNotEquals(area.calculate(), 2);
    }
}