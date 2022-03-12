package com.ssau.laboop.functions.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdentityFunctionTest {

    @Test
    void apply() {
        IdentityFunction identityFunction = new IdentityFunction();
        assertEquals(identityFunction.apply(1), 1);
        assertEquals(identityFunction.apply(2), 2);
        assertEquals(identityFunction.apply(3),3 );
    }
}