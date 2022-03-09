package com.ssau.laboop.functions;

import com.ssau.laboop.functions.impl.IncFunction;
import com.ssau.laboop.functions.impl.SqrFunction;
import com.ssau.laboop.functions.impl.UnitFunction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathFunctionTest {

    @Test
    void andThen() {
        IncFunction incFunction = new IncFunction();
        SqrFunction sqrFunction = new SqrFunction();
        UnitFunction unitFunction = new UnitFunction();
        assertEquals(incFunction.andThen(sqrFunction).andThen(unitFunction).apply(5), 1);
        assertEquals(incFunction.andThen(sqrFunction).apply(5), 36);
    }
}