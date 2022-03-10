package com.ssau.laboop.functions;

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
}