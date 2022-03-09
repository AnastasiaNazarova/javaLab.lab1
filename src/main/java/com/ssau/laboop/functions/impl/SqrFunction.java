package com.ssau.laboop.functions.impl;

import com.ssau.laboop.functions.MathFunction;

import static java.lang.Math.*;

public class SqrFunction implements MathFunction {
    @Override
    public double apply(double x) {
        return pow(x,2);
    }
}
