package com.ssau.laboop.tabulatedFunction;

import com.ssau.laboop.functions.MathFunction;
import com.ssau.laboop.tabulatedFunction.impl.Point;

public interface TabulatedFunction extends MathFunction, Iterable<Point> {
    int getCount();//Метод получения количества табулированных значений
    double getX(int index);//Метод, получающий значение аргумента x по номеру индекса
    double getY(int index);//Метод, получающий значение y по номеру индекса
    void setY(int index, double value);//Метод, задающий значение y по номеру индекса

    int indexOfX(double x);//Метод, возвращающий индекс аргумента x
    int indexOfY(double y);//Метод, возвращающий индекс аргумента y
    double leftBound();//Метод, возвращающий самый левый x
    double rightBound();//Метод, возвращающий самый правый x
}
