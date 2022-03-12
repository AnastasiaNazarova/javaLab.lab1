package com.ssau.laboop.tabulatedFunction;

import com.ssau.laboop.exceptions.ArrayIsNotSortedException;
import com.ssau.laboop.exceptions.DifferentLengthOfArraysException;

abstract public class AbstractTabulatedFunction implements TabulatedFunction {

    public abstract int getCount();//Метод получения количества табулированных значений

    public abstract double getX(int index);//Метод, получающий значение аргумента x по номеру индекса

    public abstract double getY(int index);//Метод, получающий значение y по номеру индекса

    public abstract void setY(int index, double value);//Метод, задающий значение y по номеру индекса

    public abstract int indexOfX(double x);//Метод, возвращающий индекс аргумента x

    public abstract int indexOfY(double y);//Метод, возвращающий индекс аргумента y

    public abstract double leftBound();//Метод, возвращающий самый левый x

    public abstract double rightBound();//Метод, возвращающий самый правый x

    abstract protected int floorIndexOfX(double x);//Метод поиска индекса x

    abstract protected double extrapolateLeft(double x);//Метод экстраполяции слева

    abstract protected double extrapolateRight(double x);//Метод экстраполяции справа

    public double interpolate(double x, double leftX, double rightX, double leftY, double rightY) {
        return leftY + (rightY - leftY) * (x - leftX) / (rightX - leftX);
    }

    @Override
    public double apply(double x) {
        if (x < leftBound()) return extrapolateLeft(x);
        else if (x > rightBound()) return extrapolateRight(x);
        else if (indexOfX(x) != -1) return getY(indexOfX(x));
        else {
            int floorIndex = floorIndexOfX(x);
            return interpolate(x, floorIndex - 1, floorIndex, getY(floorIndex - 1), getY(floorIndex));
        }
    }

    //проверяет, что массивы имеют одинаковую длину
      public static void checkLengthIsTheSame(double[] xValues, double[] yValues) {
        if (xValues.length != yValues.length) throw new DifferentLengthOfArraysException("Длина массивов различна");
    }

    //проверяет что массив отсортирован
     public static void checkSorted(double[] xValues) {
        for(int i=0;i<xValues.length-1;i++)
        {
            if(xValues[i]>xValues[i+1]) throw new ArrayIsNotSortedException("Массив не отсортирован");
        }
    }
}
