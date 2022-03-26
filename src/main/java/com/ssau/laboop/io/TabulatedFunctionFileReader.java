package com.ssau.laboop.io;

import com.ssau.laboop.functions.factory.ArrayTabulatedFunctionFactory;
import com.ssau.laboop.functions.factory.TabulatedFunctionFactory;

import java.io.*;

public class TabulatedFunctionFileReader {
    public static void main(String[] args) {

        TabulatedFunctionFactory arrayFunc = new ArrayTabulatedFunctionFactory();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("input/function.txt"))){
            System.out.println(FunctionsIO.readTabulatedFunction(bufferedReader, new ArrayTabulatedFunctionFactory()).toString());
            bufferedReader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
