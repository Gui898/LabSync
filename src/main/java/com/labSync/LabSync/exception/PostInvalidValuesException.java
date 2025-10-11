package com.labSync.LabSync.exception;

public class PostInvalidValuesException extends RuntimeException {

    public PostInvalidValuesException(){
        super("Valores inválidos para o Post");
    }

    public PostInvalidValuesException(String message) {
        super(message);
    }
}
