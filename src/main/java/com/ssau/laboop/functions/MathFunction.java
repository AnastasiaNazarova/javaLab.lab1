package com.ssau.laboop.functions;

import com.ssau.laboop.functions.impl.CompositeFunction;

public interface MathFunction {
    double apply(double x);
    default CompositeFunction andThen(MathFunction afterFunction)
    {
        return new CompositeFunction(this,afterFunction);
    };
}
