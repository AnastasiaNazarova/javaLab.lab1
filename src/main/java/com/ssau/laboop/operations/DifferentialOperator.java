package com.ssau.laboop.operations;

import com.ssau.laboop.functions.MathFunction;

public interface DifferentialOperator <T extends MathFunction>{
    T derive(T function);
}
