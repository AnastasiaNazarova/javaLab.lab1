package com.ssau.laboop.io;

import com.ssau.laboop.functions.impl.SqrFunction;
import com.ssau.laboop.operations.TabulatedDifferentialOperator;
import com.ssau.laboop.tabulatedFunction.impl.ArrayTabulatedFunction;

import java.io.*;

public class ArrayTabulatedFunctionSerializationXML {
    private static SqrFunction sqrFunction = new SqrFunction();
    private static TabulatedDifferentialOperator diffOperator = new TabulatedDifferentialOperator();

    public static void main(String[] args) {

        try (BufferedWriter fileWriter = new BufferedWriter(
                new FileWriter("output/serializedXML.xml"))) {
            ArrayTabulatedFunction arrayFunc = new ArrayTabulatedFunction(sqrFunction, 0, 10, 11);
            FunctionsIO.serializeXml(fileWriter, arrayFunc );

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader("output/serializedXML.xml"))) {
            ArrayTabulatedFunction function = FunctionsIO.deserializeXml(bufferedReader);
            System.out.println(function.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
