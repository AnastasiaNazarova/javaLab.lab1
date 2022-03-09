package com.ssau.laboop.functions.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitFunctionTest {

    @Test
    void apply() {
        double unitValue = 1;
        UnitFunction unitFunction = new UnitFunction();
        assertEquals(unitFunction.apply(1), unitValue);
        assertEquals(unitFunction.apply(2), unitValue );
        assertEquals(unitFunction.apply(3), unitValue );
    }
}