package com.ssau.laboop.functions.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstantFunctionTest {

    @Test
    void apply() {
        double testValue = 5;
        ConstantFunction constantFunction = new ConstantFunction(testValue);
        assertEquals(constantFunction.apply(1), testValue);
        assertEquals(constantFunction.apply(2),testValue );
        assertEquals(constantFunction.apply(3),testValue );
    }
}