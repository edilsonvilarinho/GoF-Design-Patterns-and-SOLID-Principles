package br.com.edilsonvilarinho.solid.singleResposabilityPrinciple;

import br.com.edilsonvilarinho.exception.RadiusInvalidException;

public class Circle implements Area {
    private final Double radius;

    public Circle(Double radius) throws RadiusInvalidException {
        if (radius == null || radius <= 0) throw new RadiusInvalidException("Radius invalid");
        this.radius = radius;
    }

    @Override
    public Double calculate() {
        return Math.PI * (Math.pow(radius, 2));
    }
}
