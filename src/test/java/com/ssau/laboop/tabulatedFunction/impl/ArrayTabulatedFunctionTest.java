package com.ssau.laboop.tabulatedFunction.impl;

import com.ssau.laboop.exceptions.ArrayIsNotSortedException;
import com.ssau.laboop.exceptions.DifferentLengthOfArraysException;
import com.ssau.laboop.functions.MathFunction;
import com.ssau.laboop.functions.impl.SqrFunction;
import com.ssau.laboop.tabulatedFunction.impl.ArrayTabulatedFunction;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTabulatedFunctionTest {

    private final double[] xValues = new double[]{1., 2., 3., 4., 5.};
    private final double[] yValues = new double[]{10, 20., 30., 40., 50.};

    private MathFunction func = new SqrFunction();

    private ArrayTabulatedFunction initializeArrayThroughTwoArrays() {
        return new ArrayTabulatedFunction(xValues, yValues);
    }

    private ArrayTabulatedFunction initializeArrayThroughMathFunction() {
        return new ArrayTabulatedFunction(func, 0, 10, 11);
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

        try {
            double[] x = new double[]{1., 2., 3., 4., 5.};
            double[] y = new double[]{1., 2., 3.};
            ArrayTabulatedFunction errorArray = new ArrayTabulatedFunction(x, y);
        } catch (DifferentLengthOfArraysException e) {
            e.printStackTrace();
        }

        try {
            double[] x2 = new double[]{2., 3., 4., 1., 5.};
            double[] y2 = new double[]{1., 2., 3., 4., 5.};
            ArrayTabulatedFunction errorArray2 = new ArrayTabulatedFunction(x2, y2);
        } catch (ArrayIsNotSortedException e) {
            e.printStackTrace();
        }

    }


    @Test
    void interpolate() {
        ArrayTabulatedFunction firstArray = initializeArrayThroughTwoArrays();
        ArrayTabulatedFunction secondArray = initializeArrayThroughMathFunction();
        assertEquals(firstArray.interpolate(2.5, 2, 3, 4, 9), 6.5);
        assertEquals(firstArray.interpolate(0, 0, 1, 0, 1), 0);
        assertEquals(firstArray.interpolate(10, 9, 10, 81, 100), 100);
        assertEquals(firstArray.interpolate(11, 9, 10, 81, 100), 119);

        assertEquals(secondArray.interpolate(10, 9, 10, 81, 100), 100);
        assertEquals(secondArray.interpolate(11, 9, 10, 81, 100), 119);

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
        ArrayTabulatedFunction firstArray = initializeArrayThroughTwoArrays();
        ArrayTabulatedFunction secondArray = initializeArrayThroughMathFunction();
        for (int i = 0; i < firstArray.getCount(); i++) {
            assertEquals(firstArray.getX(i), (i + 1));
        }
        for (int i = 0; i < secondArray.getCount(); i++) {
            assertEquals(secondArray.getX(i), i);
        }
        try {
            double x = secondArray.getX(-2);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getY() {
        ArrayTabulatedFunction firstArray = initializeArrayThroughTwoArrays();
        ArrayTabulatedFunction secondArray = initializeArrayThroughMathFunction();

        try {
            for (int i = 0; i < firstArray.getCount(); i++) {
                assertEquals(firstArray.getY(i), 10 * (i + 1));
            }
            for (int i = 0; i < secondArray.getCount(); i++) {
                assertEquals(secondArray.getY(i), i * i);
            }
            double y = secondArray.getY(-2);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
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
        ArrayTabulatedFunction firstArray = initializeArrayThroughTwoArrays();
        ArrayTabulatedFunction secondArray = initializeArrayThroughMathFunction();
        try {
            assertEquals(firstArray.floorIndexOfX(1), 0);
            assertEquals(firstArray.floorIndexOfX(1.5), 0);

            assertEquals(secondArray.floorIndexOfX(1), 1);
            assertEquals(secondArray.floorIndexOfX(11), 11);

            assertEquals(firstArray.floorIndexOfX(-5), 0);
            assertEquals(secondArray.floorIndexOfX(-5), 0);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

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

    @Test
    void iterator() {
        ArrayTabulatedFunction firstArray = initializeArrayThroughTwoArrays();
        Iterator<Point> iterator = firstArray.iterator();
        int i = 0;
        for (Point point : firstArray) {
            assertEquals(point.x, firstArray.getX(i));
            assertEquals(point.y, firstArray.getY(i));
            i++;
        }
        i = 0;
        while (iterator.hasNext()) {
            Point point = iterator.next();
            assertEquals(point.x, firstArray.getX(i));
            assertEquals(point.y, firstArray.getY(i));
            i++;
        }
        assertThrows(NoSuchElementException.class, iterator::next);
    }
}