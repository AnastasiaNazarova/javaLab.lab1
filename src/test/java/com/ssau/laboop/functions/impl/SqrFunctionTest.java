package com.ssau.laboop.functions.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SqrFunctionTest {

    @Test
    void test() {
        SqrFunction sqrFunction = new SqrFunction();
        assertEquals(sqrFunction.apply(1), 1);
        assertEquals(sqrFunction.apply(2),4 );
        assertEquals(sqrFunction.apply(3),9 );
    }
}