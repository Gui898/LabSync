package com.labSync.LabSync.exception;

public class UserInvalidValuesException extends RuntimeException {

    public UserInvalidValuesException(){
        super("Você inseriu valores inválidos para o usuário.");
    }

    public UserInvalidValuesException(String cause) {
        super("Você inseriu valores inválidos para o usuário. Causa: " + cause);
    }
}
