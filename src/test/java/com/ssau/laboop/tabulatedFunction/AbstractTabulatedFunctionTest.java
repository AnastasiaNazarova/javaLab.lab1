package com.ssau.laboop.tabulatedFunction;

import com.ssau.laboop.exceptions.ArrayIsNotSortedException;
import com.ssau.laboop.exceptions.DifferentLengthOfArraysException;
import com.ssau.laboop.tabulatedFunction.MockTabulatedFunction;
import com.ssau.laboop.tabulatedFunction.impl.ArrayTabulatedFunction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractTabulatedFunctionTest {

    private MockTabulatedFunction mockObj = new MockTabulatedFunction();

    @Test
    void interpolate() {
        assertEquals(mockObj.interpolate(-0.5, 0, 1, 1, 10), -3.5);
        assertEquals(mockObj.interpolate(0, 0, 1, 1, 10), 1);
        assertEquals(mockObj.interpolate(1, 0, 1, 1, 10), 10);
        assertEquals(mockObj.interpolate(2, 0, 1, 1, 10), 19);
    }

    @Test
    void apply() {
        assertEquals(mockObj.apply(-0.5), -3.5);
        assertEquals(mockObj.apply(0), 1);
        assertEquals(mockObj.apply(1), 10);
        assertEquals(mockObj.apply(2), 19);
    }

    @Test
    void testCheckLengthIsTheSame() {
        try {
            double[] x = new double[]{1., 2., 3., 4., 5.};
            double[] y = new double[]{1., 2., 3., 4., 5.};
            AbstractTabulatedFunction.checkLengthIsTheSame(x,y);

            double[] x2 = new double[]{1., 2., 3.};
            double[] y2 = new double[]{1., 2., 3., 4., 5.};
            AbstractTabulatedFunction.checkLengthIsTheSame(x2,y2);
        }
        catch (DifferentLengthOfArraysException e){
            e.printStackTrace();
        }
    }

    @Test
    void checkLengthIsTheSame() {
        try {
            double[] x = new double[]{1., 2., 3., 4., 5.};
            AbstractTabulatedFunction.checkSorted(x);

            double[] x2 = new double[]{4., 2., 3.};
            AbstractTabulatedFunction.checkSorted(x2);
        }
        catch (ArrayIsNotSortedException e){
            e.printStackTrace();
        }
    }


    @Test
    void testToString() {
        double[] xValues = new double[]{1., 2., 3.};
        double[] yValues = new double[]{2, 4., 6.};
        TabulatedFunction tabulatedFunction = new ArrayTabulatedFunction(xValues,yValues);
        assertEquals(tabulatedFunction.toString(), "ArrayTabulatedFunction size = 3\n[1.0; 2.0]\n[2.0; 4.0]\n[3.0; 6.0]");
    }
}