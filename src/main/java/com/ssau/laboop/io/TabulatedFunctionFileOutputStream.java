package com.ssau.laboop.io;

import com.ssau.laboop.functions.impl.SqrFunction;
import com.ssau.laboop.tabulatedFunction.impl.ArrayTabulatedFunction;

import java.io.*;

public class TabulatedFunctionFileOutputStream {
    public static void main(String[] args) {
        ArrayTabulatedFunction function = new ArrayTabulatedFunction(new SqrFunction(),1,10,10);
        try( BufferedOutputStream bufferedWriter = new BufferedOutputStream(
                new FileOutputStream("output/array function.bin"))) {
            FunctionsIO.writeTabulatedFunction(bufferedWriter,function);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
