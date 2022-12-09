package br.com.edilsonvilarinho.solid.singleResposabilityPrinciple;

import br.com.edilsonvilarinho.exception.RadiusInvalidException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BallTest {

    @Test
    void calculateValid() throws RadiusInvalidException {
        Volume area = new Ball(7.0);
        assertEquals(area.calculate(), 1077.5662801812991);
    }

    @Test
    void heightInvalid() {
        assertThrowsExactly(RadiusInvalidException.class, () -> {
            Volume area = new Ball(-7.0);
            assertEquals(area.calculate(), 1077.5662801812991);
        });
    }

    @Test
    void calculateInvalid() throws RadiusInvalidException {
        Volume area = new Ball(7.0);
        assertNotEquals(area.calculate(), 1078.5662801812991);
    }
}