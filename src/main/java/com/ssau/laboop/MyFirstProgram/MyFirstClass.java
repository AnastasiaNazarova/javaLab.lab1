package com.ssau.laboop.MyFirstProgram;

import com.ssau.laboop.MyFirstProgram.myfirstpackage.MySecondClass;


public class MyFirstClass {
    public static void main(String[] s) {
        MySecondClass o = new MySecondClass(2,5);
        System.out.println(o.add());
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j <= 8; j++) {
                o.setFirstValue(i);
                o.setSecondValue(j);
                System.out.println(o.add());
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}