package com.ssau.laboop.operations;

import com.ssau.laboop.functions.MathFunction;
import com.ssau.laboop.functions.factory.ArrayTabulatedFunctionFactory;
import com.ssau.laboop.functions.factory.TabulatedFunctionFactory;
import com.ssau.laboop.tabulatedFunction.TabulatedFunction;
import com.ssau.laboop.tabulatedFunction.impl.Point;

public class TabulatedDifferentialOperator implements DifferentialOperator<TabulatedFunction>{

    TabulatedFunctionFactory factory;

    public TabulatedDifferentialOperator() {
        this.factory = new ArrayTabulatedFunctionFactory();
    }

    public TabulatedDifferentialOperator(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }

    //возвращает производную входной функции
    @Override
    public TabulatedFunction derive(TabulatedFunction function) {
        Point[] points = TabulatedFunctionOperationService.asPoints(function);
        int count = points.length;
        double[] xValue = new double[count];
        double[] yValue = new double[count];

        for(int i=0; i<count-1;i++)
        {
            xValue[i] = points[i].x;
            yValue[i] = (points[i+1].y - points[i].y)/(points[i+1].x - points[i].x) ;
        }
        xValue[count-1] = points[count-1].x;
        yValue[count-1] = (points[count-1].y - points[count-2].y)/(points[count-1].x - points[count-2].x) ;
        return factory.create(xValue,yValue);
    }

    public TabulatedFunctionFactory getFactory() {
        return factory;
    }

    public void setFactory(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }


}
