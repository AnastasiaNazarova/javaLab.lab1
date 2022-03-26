package com.ssau.laboop.io;

import com.ssau.laboop.functions.impl.SqrFunction;
import com.ssau.laboop.operations.TabulatedDifferentialOperator;
import com.ssau.laboop.tabulatedFunction.impl.ArrayTabulatedFunction;

import java.io.*;

public class ArrayTabulatedFunctionSerializationJson {
    private static SqrFunction sqrFunction = new SqrFunction();
    private static TabulatedDifferentialOperator diffOperator = new TabulatedDifferentialOperator();

    public static void main(String[] args) {

        try (BufferedWriter fileWriter = new BufferedWriter(
                new FileWriter("output/serializedJSON.json"))) {
            ArrayTabulatedFunction arrayFunc = new ArrayTabulatedFunction(sqrFunction, 0, 10, 11);
            FunctionsIO.serializeJson(fileWriter, arrayFunc);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader("output/serializedJSON.json"))) {
            ArrayTabulatedFunction function = FunctionsIO.deserializeJson(bufferedReader);
            System.out.println(function.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
