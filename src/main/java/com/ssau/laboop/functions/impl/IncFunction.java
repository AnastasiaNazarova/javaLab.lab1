package com.ssau.laboop.functions.impl;

import com.ssau.laboop.functions.MathFunction;

public class IncFunction implements MathFunction {
    @Override
    public double apply(double x) {
        return ++x;
    }
}
