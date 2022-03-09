package com.ssau.laboop.functions.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZeroFunctionTest {

    @Test
    void apply() {
        double zeroValue = 0;
        ZeroFunction zeroFunction = new ZeroFunction();
        assertEquals(zeroFunction.apply(1), zeroValue);
        assertEquals(zeroFunction.apply(2),zeroValue );
        assertEquals(zeroFunction.apply(3),zeroValue );
    }
}