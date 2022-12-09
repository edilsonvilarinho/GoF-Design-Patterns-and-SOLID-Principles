package br.com.edilsonvilarinho.solid.singleResposabilityPrinciple;

import br.com.edilsonvilarinho.exception.BiggerBaseInvalidException;
import br.com.edilsonvilarinho.exception.HeightInvalidException;
import br.com.edilsonvilarinho.exception.MinorBaseInvalidException;

public class Trapeze implements Area {
    private final Double minorBase;
    private final Double biggerBase;
    private final Double height;

    public Trapeze(Double minorBase, Double biggerBase, Double height) throws MinorBaseInvalidException, HeightInvalidException, BiggerBaseInvalidException {
        if (isInvalid(minorBase)) throw new MinorBaseInvalidException("Minor Base invalid");
        if (isInvalid(biggerBase)) throw new BiggerBaseInvalidException("Bigger Base invalid");
        if (isInvalid(height)) throw new HeightInvalidException("Height invalid");
        this.minorBase = minorBase;
        this.biggerBase = biggerBase;
        this.height = height;
    }

    private boolean isInvalid(Double value) {
        return value == null || value <= 0;
    }

    @Override
    public Double calculate() {
        return ((this.biggerBase + this.minorBase) * height) / 2;
    }
}
