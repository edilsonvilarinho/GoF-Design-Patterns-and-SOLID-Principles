package br.com.edilsonvilarinho.solid.singleResposabilityPrinciple;

import br.com.edilsonvilarinho.exception.RadiusInvalidException;

public class Ball implements Volume {

    private final Double radius;

    public Ball(Double radius) throws RadiusInvalidException {
        if (radius == null || radius <= 0) throw new RadiusInvalidException("Radius invalid");
        this.radius = radius;
    }

    @Override
    public Double calculate() {
        return (4 / 3) * (Math.PI * (Math.pow(radius, 3)));
    }
}
