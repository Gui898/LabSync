package com.labSync.LabSync.exception;

public class UserUnauthorizedException extends RuntimeException {

    public UserUnauthorizedException(){
        super("Usuário não autorizado.");
    }

    public UserUnauthorizedException(String cause) {
        super("Usuário não autorizado. Causa: " + cause);
    }



}
