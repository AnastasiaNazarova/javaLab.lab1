package com.ssau.laboop.operations;

import com.ssau.laboop.exceptions.InconsistentFunctionsException;
import com.ssau.laboop.functions.factory.ArrayTabulatedFunctionFactory;
import com.ssau.laboop.functions.factory.TabulatedFunctionFactory;
import com.ssau.laboop.tabulatedFunction.TabulatedFunction;
import com.ssau.laboop.tabulatedFunction.impl.ArrayTabulatedFunction;
import com.ssau.laboop.tabulatedFunction.impl.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TabulatedFunctionOperationServiceTest {

    double[] xValues = new double[]{1., 2., 3., 4., 5.};
    double[] yValues = new double[]{2., 4., 6., 8., 10.};
    double[] xValues2 = new double[]{1., 2., 3., 4., 5.};
    double[] yValues2 = new double[]{10., 20., 30., 40., 50.};

    @Test
    void asPoints() {
        TabulatedFunction tabFunc = (new ArrayTabulatedFunctionFactory()).create(xValues, yValues);
        Point[] points = TabulatedFunctionOperationService.asPoints(tabFunc);
        int i = 0;
        for (Point point : points) {
            assertEquals(point.x, tabFunc.getX(i));
            assertEquals(point.y, tabFunc.getY(i++));
        }
    }

    @Test
    public void testSum() {
        TabulatedFunctionFactory arrayFactory = new ArrayTabulatedFunctionFactory();
        TabulatedFunctionOperationService operationServiceThroughArray = new TabulatedFunctionOperationService(arrayFactory);
        TabulatedFunction a = arrayFactory.create(xValues, yValues);
        TabulatedFunction b = arrayFactory.create(xValues2, yValues2);
        TabulatedFunction resultSumThroughArray = operationServiceThroughArray.sum(a, b);

        int i = 0;
        for (Point point : resultSumThroughArray) {
            assertEquals(point.x, xValues[i]);
            assertEquals(point.y, yValues[i] + yValues2[i++]);
        }
    }

    @Test
    public void testSubtract() {
        TabulatedFunctionFactory arrayFactory = new ArrayTabulatedFunctionFactory();
        TabulatedFunctionOperationService operationServiceThroughArray = new TabulatedFunctionOperationService(arrayFactory);
        TabulatedFunction a = arrayFactory.create(xValues, yValues);
        TabulatedFunction b = arrayFactory.create(xValues2, yValues2);
        TabulatedFunction resultSumThroughArray = operationServiceThroughArray.subtract(a, b);

        int i = 0;
        for (Point point : resultSumThroughArray) {
            assertEquals(point.x, xValues[i]);
            assertEquals(point.y, yValues[i] - yValues2[i++]);
        }
    }

    @Test
    public void testMultiplication() {
        TabulatedFunctionFactory arrayFactory = new ArrayTabulatedFunctionFactory();
        TabulatedFunctionOperationService operationServiceThroughArray = new TabulatedFunctionOperationService(arrayFactory);
        TabulatedFunction a = arrayFactory.create(xValues, yValues);
        TabulatedFunction b = arrayFactory.create(xValues2, yValues2);
        TabulatedFunction resultSumThroughArray = operationServiceThroughArray.multiplication(a, b);

        int i = 0;
        for (Point point : resultSumThroughArray) {
            assertEquals(point.x, xValues[i]);
            assertEquals(point.y, yValues[i] * yValues2[i++]);
        }
    }

    @Test
    public void testDivision() {
        TabulatedFunctionFactory arrayFactory = new ArrayTabulatedFunctionFactory();
        TabulatedFunctionOperationService operationServiceThroughArray = new TabulatedFunctionOperationService(arrayFactory);
        TabulatedFunction a = arrayFactory.create(xValues, yValues);
        TabulatedFunction b = arrayFactory.create(xValues2, yValues2);
        TabulatedFunction resultSumThroughArray = operationServiceThroughArray.division(a, b);

        int i = 0;
        for (Point point : resultSumThroughArray) {
            assertEquals(point.x, xValues[i]);
            assertEquals(point.y, yValues[i] / yValues2[i++]);
        }
    }
}