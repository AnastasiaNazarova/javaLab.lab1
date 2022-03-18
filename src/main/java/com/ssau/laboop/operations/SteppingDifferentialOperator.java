package com.ssau.laboop.operations;

import com.ssau.laboop.functions.MathFunction;

import static java.lang.Double.NaN;

abstract public class SteppingDifferentialOperator implements DifferentialOperator <MathFunction> {

    protected  double step;
    public SteppingDifferentialOperator(double step) {
        this.step = step;
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        if(step <= 0 || step == Double.POSITIVE_INFINITY || step == NaN) throw new IllegalArgumentException();
        this.step = step;
    }

}
