package com.ssau.laboop.functions.impl;

import com.ssau.laboop.functions.MathFunction;

public class CompositeFunction implements MathFunction {
    MathFunction firstFunction, secondFunction;

    public CompositeFunction(MathFunction firstFunction,MathFunction secondFunction)
    {
        this.firstFunction = firstFunction;
        this.secondFunction = secondFunction;
    }

    @Override
    public double apply(double x) {
        return secondFunction.apply(firstFunction.apply(x));
    }
}
