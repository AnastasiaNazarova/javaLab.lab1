package com.ssau.laboop.functions.factory;

import com.ssau.laboop.tabulatedFunction.TabulatedFunction;
import com.ssau.laboop.tabulatedFunction.impl.StrictTabulatedFunction;
import com.ssau.laboop.tabulatedFunction.impl.UnmodifiableTabulatedFunction;

public interface TabulatedFunctionFactory {
    TabulatedFunction create(double[] xValues, double[] yValues);
    default TabulatedFunction createStrict(double[] xValues, double[] yValues){
       return new StrictTabulatedFunction(create( xValues, yValues));
    }

    default TabulatedFunction createUnmodifiable (double[] xValues, double[] yValues){
        return new UnmodifiableTabulatedFunction(create(xValues, yValues));
    }

    default TabulatedFunction createStrictUnmodifiable (double[] xValues, double[] yValues){
        return new StrictTabulatedFunction(new UnmodifiableTabulatedFunction(create(xValues, yValues)));
    }
}
