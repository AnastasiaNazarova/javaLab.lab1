package com.ssau.laboop.operations;

import com.ssau.laboop.exceptions.InconsistentFunctionsException;
import com.ssau.laboop.functions.factory.ArrayTabulatedFunctionFactory;
import com.ssau.laboop.functions.factory.TabulatedFunctionFactory;
import com.ssau.laboop.tabulatedFunction.TabulatedFunction;
import com.ssau.laboop.tabulatedFunction.impl.Point;

public class TabulatedFunctionOperationService {

    TabulatedFunctionFactory factory;

    public TabulatedFunctionOperationService(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }

    public TabulatedFunctionOperationService() {
        this.factory = new ArrayTabulatedFunctionFactory();
    }

    public TabulatedFunctionFactory getFactory() {
        return factory;
    }

    public void setFactory(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }

    public static Point[] asPoints(TabulatedFunction tabulatedFunction) {
        Point[] points = new Point[tabulatedFunction.getCount()];
        int i = 0;
        for (Point currentPoint : tabulatedFunction) {
            points[i] = currentPoint;
            i++;
        }
        return points;
    }

    private interface BiOperation {
        double apply(double u, double v);
    }

    private TabulatedFunction doOperation(TabulatedFunction firstFunc, TabulatedFunction secondFunc, BiOperation operation) {
        if (firstFunc.getCount() != secondFunc.getCount()) {
            throw new InconsistentFunctionsException("Количество точек в табулированных функциях различно");
        }
        Point[] firstPoints = asPoints(firstFunc);
        double[] xValues = new double[firstFunc.getCount()];
        double[] yValues = new double[firstFunc.getCount()];

        Point[] secondPoints = asPoints(secondFunc);
        for (int i = 0; i < firstFunc.getCount(); i++) {
            if (firstPoints[i].x != secondPoints[i].x) {
                throw new InconsistentFunctionsException("Соответствующие значения x не совпадают");
            }
            xValues[i] = firstPoints[i].x;
            yValues[i] = operation.apply(firstPoints[i].y, secondPoints[i].y);
        }
        return factory.create(xValues, yValues);
    }

    private TabulatedFunction doOperation(TabulatedFunction a, TabulatedFunction b, String operation) {
        TabulatedFunction function = null;
        switch (operation) {
            case "+": {
                function = doOperation(a, b, Double::sum);
                break;
            }
            case "-": {
                function = doOperation(a, b, (u, v) -> u - v);
                break;
            }
            case "*": {
                function = doOperation(a, b, (u, v) -> u * v);
                break;
            }
            case "/": {
                function = doOperation(a, b, (u, v) -> u / v);
                break;
            }
        }
        return function;
    }


    public TabulatedFunction sum(TabulatedFunction a, TabulatedFunction b) {
        return doOperation(a, b, "+");
    }

    public TabulatedFunction subtract(TabulatedFunction a, TabulatedFunction b) {
        return doOperation(a, b, "-");
    }

    public TabulatedFunction multiplication(TabulatedFunction a, TabulatedFunction b) {
        return doOperation(a, b, "*");
    }


    public TabulatedFunction division(TabulatedFunction a, TabulatedFunction b) {
        return doOperation(a, b, "/");
    }
}
