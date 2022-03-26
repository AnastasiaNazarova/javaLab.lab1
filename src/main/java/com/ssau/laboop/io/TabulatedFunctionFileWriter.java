package com.ssau.laboop.io;

import com.ssau.laboop.functions.impl.SqrFunction;
import com.ssau.laboop.tabulatedFunction.impl.ArrayTabulatedFunction;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TabulatedFunctionFileWriter {
    public static void main(String[] args) {

        ArrayTabulatedFunction function = new ArrayTabulatedFunction(new SqrFunction(),1,10,10);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output/array function.txt"))){
            FunctionsIO.writeTabulatedFunction(bufferedWriter,function);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
