package com.ssau.laboop.functions.impl;

import com.ssau.laboop.functions.MathFunction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTabulatedFunctionTest {

    private final double[] xValues = new double[]{1., 2., 3., 4., 5.};
    private final double[] yValues = new double[] {10, 20., 30., 40., 50.};

    private MathFunction func = new SqrFunction();

    private ArrayTabulatedFunction initializeArrayThroughTwoArrays() {
        return new ArrayTabulatedFunction(xValues, yValues);
    }

    private ArrayTabulatedFunction initializeArrayThroughMathFunction() {
        return new ArrayTabulatedFunction(func, 0,10, 11);
    }

    @Test
    public void testConstructor() {
        ArrayTabulatedFunction firstArray = initializeArrayThroughTwoArrays();
        for (int i = 0; i < 5; i++) {
            assertEquals(firstArray.getY(i), 10 * (i + 1));
        }
        ArrayTabulatedFunction secondArray = initializeArrayThroughMathFunction();
        for (int i = 0; i < 11; i++) {
            assertEquals(secondArray.getY(i), i * i);
        }
    }

    @Test
    void interpolate() {
        ArrayTabulatedFunction firstArray = initializeArrayThroughTwoArrays();
        ArrayTabulatedFunction secondArray = initializeArrayThroughMathFunction();
        assertEquals(firstArray.interpolate(2.5, 2,3, 4, 9), 6.5);
        assertEquals(firstArray.interpolate(0, 0,1, 0, 1), 0);
        assertEquals(firstArray.interpolate(10, 9,10, 81, 100), 100);
        assertEquals(firstArray.interpolate(11, 9,10, 81, 100), 119);

        assertEquals(secondArray.interpolate(10, 9,10, 81, 100), 100);
        assertEquals(secondArray.interpolate(11, 9,10, 81, 100), 119);

    }

    @Test
    void apply() {

    }

    @Test
    void andThen() {
    }

    @Test
    void getCount() {
    }

    @Test
    void getX() {
    }

    @Test
    void getY() {
    }

    @Test
    void setY() {
    }

    @Test
    void indexOfX() {
    }

    @Test
    void indexOfY() {
    }

    @Test
    void leftBound() {
    }

    @Test
    void rightBound() {
    }

    @Test
    void floorIndexOfX() {
    }

    @Test
    void extrapolateLeft() {
    }

    @Test
    void extrapolateRight() {
    }

    @Test
    void insert() {
        ArrayTabulatedFunction firstArray = initializeArrayThroughTwoArrays();
        firstArray.insert(-2, 5);
        assertEquals(firstArray.getY(0), 5);
        firstArray.insert(6, 10);
        assertEquals(firstArray.getY(6), 10);
    }

    @Test
    void remove() {
    }
}