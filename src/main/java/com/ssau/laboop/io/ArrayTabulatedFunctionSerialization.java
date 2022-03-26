package com.ssau.laboop.io;

import com.ssau.laboop.functions.factory.ArrayTabulatedFunctionFactory;
import com.ssau.laboop.functions.impl.SqrFunction;
import com.ssau.laboop.operations.TabulatedDifferentialOperator;
import com.ssau.laboop.tabulatedFunction.TabulatedFunction;
import com.ssau.laboop.tabulatedFunction.impl.ArrayTabulatedFunction;

import java.io.*;

public class ArrayTabulatedFunctionSerialization {

    private static SqrFunction sqrFunction = new SqrFunction();
    private static TabulatedDifferentialOperator diffOperator = new TabulatedDifferentialOperator();

    public static void main(String[] args) {

        try (BufferedOutputStream fileOutputStream = new BufferedOutputStream(
                new FileOutputStream("output/serialized array functions.bin"))) {

            TabulatedFunction arrayFunc = new ArrayTabulatedFunction(sqrFunction, 0, 10, 11);
            TabulatedFunction arrayFuncFirstDerive = diffOperator.derive(arrayFunc);
            TabulatedFunction arrayFuncSecondDerive = diffOperator.derive(arrayFuncFirstDerive);

            FunctionsIO.serialize(fileOutputStream, arrayFunc);
            FunctionsIO.serialize(fileOutputStream, arrayFuncFirstDerive);
            FunctionsIO.serialize(fileOutputStream, arrayFuncSecondDerive);


        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(
                new FileInputStream("output/serialized array functions.bin"))) {
            System.out.println(FunctionsIO.deserialize(bufferedInputStream).toString());
            System.out.println(FunctionsIO.deserialize(bufferedInputStream).toString());
            System.out.println(FunctionsIO.deserialize(bufferedInputStream).toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
