package br.com.edilsonvilarinho.solid.singleResposabilityPrinciple;

import br.com.edilsonvilarinho.exception.HeightInvalidException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

    @Test
    void caculateValid() throws HeightInvalidException {
        Area area = new Square(4.0);
        assertEquals(area.calculate(), 16.0);
    }

    @Test
    void heightInvalid() {
        assertThrowsExactly(HeightInvalidException.class, () -> {
            Area area = new Square(-4.0);
            assertEquals(area.calculate(), 16.0);
        });
    }

    @Test
    void calculateInvalid() throws HeightInvalidException {
        Area area = new Square(4.0);
        assertNotEquals(area.calculate(), 8.0);
    }
}