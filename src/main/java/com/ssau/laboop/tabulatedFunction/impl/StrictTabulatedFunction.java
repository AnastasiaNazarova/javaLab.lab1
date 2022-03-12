package com.ssau.laboop.tabulatedFunction.impl;

import com.ssau.laboop.tabulatedFunction.TabulatedFunction;

import java.util.Iterator;

// Класс вводит запрет на интерполяцию для табулированных функций
public class StrictTabulatedFunction implements TabulatedFunction {

    private TabulatedFunction tabulatedFunction;

    public StrictTabulatedFunction(TabulatedFunction tabulatedFunction) {
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
        tabulatedFunction.setY(index, value);
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
        if (tabulatedFunction.indexOfX(x) == -1) {
            throw new UnsupportedOperationException("Функция apply не поддерживается");
        }
        else {
            return tabulatedFunction.apply(x);
        }
    }

    @Override
    public Iterator<Point> iterator() {
        return tabulatedFunction.iterator();
    }
}
