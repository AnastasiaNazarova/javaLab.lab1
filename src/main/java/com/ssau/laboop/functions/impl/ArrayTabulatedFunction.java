package com.ssau.laboop.functions.impl;

import com.ssau.laboop.functions.AbstractTabulatedFunction;
import com.ssau.laboop.functions.MathFunction;

import java.util.Arrays;

public class ArrayTabulatedFunction extends AbstractTabulatedFunction {

    private double[] xValues, yValues; // массив области определения и области значений
    private int count;// длина массива

    public ArrayTabulatedFunction(double[] xValues, double[] yValues) {
        count = xValues.length;// если длины массивов разные, то выкинуть исключение
        this.xValues = Arrays.copyOf(xValues, count);
        this.yValues = Arrays.copyOf(yValues, count);
    }

    /*
     * source - передаваемая функция
     * xForm - начало интервала по x
     * xTo - конец интервала
     * count -количество точек
     * */
    public ArrayTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) {
        this.count = count;
        xValues = new double[count];
        yValues = new double[count];
        if (xTo < xFrom) {
            double saveValue = xTo;
            xTo = xFrom;
            xFrom = saveValue;
        }
        if(xTo!=xFrom){
            double xStep = (xTo - xFrom) / (count - 1);// шаг дискретизации
            for (int i = 0; i < count; i++) {
                xValues[i] = xFrom + i * xStep;
                yValues[i] = source.apply(xValues[i]);
            }
        }
        else{
            for (int i = 0; i < count; i++) {
                xValues[i] = xTo;
                yValues[i] = source.apply(xTo);
            }
        }
    }

    //Метод получения количества табулированных значений
    @Override
    public int getCount() {
        return count;
    }

    //Метод, получающий значение аргумента x по номеру индекса
    @Override
    public double getX(int index) {
        return xValues[index];
    }

    //Метод, получающий значение аргумента y по номеру индекса
    @Override
    public double getY(int index) {
        return yValues[index];
    }

    //Метод, задающий значение y по номеру индекса
    @Override
    public void setY(int index, double value) {
        yValues[index] = value;
    }

    //Метод, возвращающий индекс аргумента x
    @Override
    public int indexOfX(double x) {
        for(int i=0;i<count;i++)
        {
            if(xValues[i] == x) return i;
        }
        return -1;
    }

    //Метод, возвращающий индекс аргумента y
    @Override
    public int indexOfY(double y) {
        for(int i=0;i<count;i++)
        {
            if(yValues[i] == y) return i;
        }
        return -1;
    }

    //Метод, возвращающий самый левый x
    @Override
    public double leftBound() {
        return xValues[0];
    }

    //Метод, возвращающий самый правый x
    @Override
    public double rightBound() {
        return xValues[count - 1];
    }

    //Метод поиска индекса x
    @Override
    protected int floorIndexOfX(double x) {

        if(x < xValues[0]) return 0;
        for (int i = 0; i < count; i++) {
            if (xValues[i] > x) {
                return i - 1;
            }
        }
        return count;
    }

    //Метод экстраполяции слева
    @Override
    protected double extrapolateLeft(double x) {
        return interpolate(x, xValues[0], xValues[1], yValues[0], yValues[1]);
    }

    //Метод экстраполяции справа
    @Override
    protected double extrapolateRight(double x) {
        return interpolate(x, xValues[count-2], xValues[count-1], yValues[count-2], yValues[count-1]);
    }
}
