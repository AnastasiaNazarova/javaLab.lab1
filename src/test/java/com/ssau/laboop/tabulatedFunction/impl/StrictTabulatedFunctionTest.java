package com.ssau.laboop.tabulatedFunction.impl;

import com.ssau.laboop.tabulatedFunction.TabulatedFunction;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StrictTabulatedFunctionTest {

    @Test
    void Test1() {
        TabulatedFunction array = new StrictTabulatedFunction(new ArrayTabulatedFunction(new double[]{1., 2., 3., 4., 5.}, new double[]{2., 4., 6., 8., 10.}));
        assertEquals(array.getCount(), 5);
        assertEquals(array.getX(0), 1);
        assertEquals(array.apply(2), 4);
        array.setY(1, 0);
        assertEquals(array.getY(1), 0);
        assertEquals(array.indexOfX(1), 0);
        assertEquals(array.indexOfY(2), 0);
        assertEquals(array.leftBound(), 1);
        assertEquals(array.rightBound(), 5);
        assertEquals(array.iterator().next().x, 1);
        assertThrows(UnsupportedOperationException.class, () -> array.apply(5.5));
    }
}