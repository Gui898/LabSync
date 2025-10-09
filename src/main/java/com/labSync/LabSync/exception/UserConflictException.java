package com.labSync.LabSync.exception;

public class UserConflictException extends RuntimeException{

    public UserConflictException(){
        super("Usuário já existe.");
    }

    public UserConflictException(String cause) {
        super("Usuário já existe. Causa: " + cause);
    }

}
