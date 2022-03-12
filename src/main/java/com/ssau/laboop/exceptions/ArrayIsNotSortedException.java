package com.ssau.laboop.exceptions;

public class ArrayIsNotSortedException extends RuntimeException{
    public ArrayIsNotSortedException() {
    }

    public ArrayIsNotSortedException(String message) {
        super(message);
    }
}
