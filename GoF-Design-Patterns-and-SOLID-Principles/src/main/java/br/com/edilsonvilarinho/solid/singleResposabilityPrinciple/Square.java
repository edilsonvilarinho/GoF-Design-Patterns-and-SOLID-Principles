package br.com.edilsonvilarinho.solid.singleResposabilityPrinciple;

import br.com.edilsonvilarinho.exception.HeightInvalidException;

public class Square implements Area {
    private final Double height;

    public Square(Double height) throws HeightInvalidException {
        if (height == null || height <= 0) throw new HeightInvalidException("Invalid Height");
        this.height = height;
    }

    @Override
    public Double calculate() {
        return Math.pow(height, 2);
    }
}
