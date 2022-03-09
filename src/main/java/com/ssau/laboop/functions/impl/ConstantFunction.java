package com.ssau.laboop.functions.impl;

import com.ssau.laboop.functions.MathFunction;

public class ConstantFunction implements MathFunction {
    private final double constant;
    public ConstantFunction(double constant) {
        this.constant = constant;
    }

    @Override
    public double apply(double x) {
        return constant;
    }
}
