package com.ssau.laboop.io;

import com.ssau.laboop.functions.factory.ArrayTabulatedFunctionFactory;
import com.ssau.laboop.functions.factory.TabulatedFunctionFactory;
import com.ssau.laboop.operations.TabulatedDifferentialOperator;

import java.io.*;

public class TabulatedFunctionFileInputStream {
    public static void main(String[] args) {
        TabulatedFunctionFactory arrayFunc = new ArrayTabulatedFunctionFactory();
        try (BufferedInputStream bufferedInputStream  = new BufferedInputStream(new FileInputStream("input/function.bin"))){
            System.out.println(FunctionsIO.readTabulatedFunction(bufferedInputStream, new ArrayTabulatedFunctionFactory()).toString());
            bufferedInputStream.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Введите размер и значения функции:");
            System.out.println(new TabulatedDifferentialOperator().derive(FunctionsIO.readTabulatedFunction(
                    new BufferedReader(new InputStreamReader(System.in)), new ArrayTabulatedFunctionFactory())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
