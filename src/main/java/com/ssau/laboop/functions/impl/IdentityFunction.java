package com.ssau.laboop.functions.impl;

import com.ssau.laboop.functions.MathFunction;

public class IdentityFunction implements MathFunction {
    @Override
    public double apply(double x) {
        return x;
    }
}
