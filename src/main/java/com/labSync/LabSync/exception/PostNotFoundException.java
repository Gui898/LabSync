package com.labSync.LabSync.exception;

public class PostNotFoundException extends RuntimeException {

    public PostNotFoundException(){
        super("Post não encontrado");
    }

    public PostNotFoundException(String message) {
        super("Post não encontrado, " + message);
    }
}
