package com.ssau.laboop.functions.factory;

import com.ssau.laboop.tabulatedFunction.TabulatedFunction;
import com.ssau.laboop.tabulatedFunction.impl.ArrayTabulatedFunction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTabulatedFunctionFactoryTest {
    private final double[] xValues = new double[]{1., 2., 3., 4., 5.};
    private final double[] yValues = new double[]{2., 4., 6., 8., 10.};

    @Test
    public void Create() {
        TabulatedFunctionFactory arrayTabulatedFunctionFactory = new ArrayTabulatedFunctionFactory();
        TabulatedFunction func = arrayTabulatedFunctionFactory.create(xValues, yValues);
        assertTrue(func instanceof ArrayTabulatedFunction);

    }

}