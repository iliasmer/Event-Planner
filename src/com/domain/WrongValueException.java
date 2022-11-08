package com.domain;

public class WrongValueException extends Exception{
    public WrongValueException(String errorMessage) {
        super(errorMessage);
    }
}
