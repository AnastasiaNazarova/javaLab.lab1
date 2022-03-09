package com.ssau.laboop.MyFirstProgram.myfirstpackage;

public class MySecondClass{
    int firstValue, secondValue;

    public MySecondClass(int firstValue, int secondValue)
    {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    public int getFirstValue() {
        return firstValue;
    }

    public int getSecondValue() {
        return secondValue;
    }

    public void setFirstValue(int firstValue){
        this.firstValue = firstValue;
    }

    public void setSecondValue(int secondValue){
        this.secondValue = secondValue;
    }

    public int add()
    {
        return  firstValue + secondValue;
    }
}

