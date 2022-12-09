package br.com.edilsonvilarinho.solid.singleResposabilityPrinciple;

import br.com.edilsonvilarinho.exception.HeightInvalidException;
import br.com.edilsonvilarinho.exception.RadiusInvalidException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @Test
    void calculateValid() throws RadiusInvalidException {
        Area area = new Circle(1.0);
        assertEquals(area.calculate(), Math.PI);
    }

    @Test
    void heightInvalid() {
        assertThrowsExactly(RadiusInvalidException.class, () -> {
            Area area = new Circle(-1.0);
            assertEquals(area.calculate(), Math.PI);
        });
    }

    @Test
    void calculateInvalid() throws RadiusInvalidException {
        Area area = new Circle(2.0);
        assertNotEquals(area.calculate(), Math.PI);
    }
}