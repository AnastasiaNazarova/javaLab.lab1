package com.ssau.laboop.functions.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompositeFunctionTest {

    @Test
    void apply() {
        SqrFunction sqrFunction = new SqrFunction();
        IncFunction incFunction = new IncFunction();
        CompositeFunction compositeFunction = new CompositeFunction(sqrFunction, incFunction);

        assertEquals(compositeFunction.apply(1), 2);
        assertEquals(compositeFunction.apply(2), 5);
        assertEquals(compositeFunction.apply(3), 10);
    }
}