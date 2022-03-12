package com.ssau.laboop.tabulatedFunction.impl;

import com.ssau.laboop.tabulatedFunction.TabulatedFunction;

import java.util.Iterator;

//Вносит запрет на модификацию значений табулированной функции
public class UnmodifiableTabulatedFunction implements TabulatedFunction {

    private TabulatedFunction tabulatedFunction;

    public UnmodifiableTabulatedFunction(TabulatedFunction tabulatedFunction) {
        this.tabulatedFunction = tabulatedFunction;
    }

    @Override
    public int getCount() {
        return tabulatedFunction.getCount();
    }

    @Override
    public double getX(int index) {
        return  tabulatedFunction.getX(index);
    }

    @Override
    public double getY(int index) {
        return  tabulatedFunction.getY(index);
    }

    @Override
    public void setY(int index, double value) {
       throw  new UnsupportedOperationException("Недопустимо изменение y");
    }

    @Override
    public int indexOfX(double x) {
        return tabulatedFunction.indexOfX(x);
    }

    @Override
    public int indexOfY(double y) {
        return tabulatedFunction.indexOfY(y);
    }

    @Override
    public double leftBound() {
        return tabulatedFunction.leftBound();
    }

    @Override
    public double rightBound() {
        return tabulatedFunction.rightBound();
    }

    @Override
    public double apply(double x) {
        return tabulatedFunction.apply(x);
    }

    @Override
    public Iterator<Point> iterator() {
        return tabulatedFunction.iterator();
    }
}
