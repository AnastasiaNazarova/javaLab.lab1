package com.ssau.laboop.operations;

import com.ssau.laboop.functions.factory.ArrayTabulatedFunctionFactory;
import com.ssau.laboop.functions.factory.TabulatedFunctionFactory;
import com.ssau.laboop.tabulatedFunction.TabulatedFunction;
import com.ssau.laboop.tabulatedFunction.impl.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TabulatedDifferentialOperatorTest {

    @Test
    void derive() {
        double[] xValue = new double[]{1., 2., 3.};
        double[] yValue = new double[]{2., 4., 6.};
        TabulatedFunctionFactory arrayFactory = new ArrayTabulatedFunctionFactory();
        TabulatedFunction arrayTabFunc = arrayFactory.create(xValue,yValue);

        TabulatedDifferentialOperator differentialOperator = new TabulatedDifferentialOperator();

        TabulatedFunction deriveTabArray = differentialOperator.derive(arrayTabFunc);
        for (Point point : deriveTabArray) {
            assertEquals(point.y, 2);
        }

    }

    @Test
    void getFactory() {
    }

    @Test
    void setFactory() {
    }
}