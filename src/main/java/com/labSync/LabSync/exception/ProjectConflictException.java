package com.labSync.LabSync.exception;

public class ProjectConflictException extends RuntimeException{

    public ProjectConflictException(){
        super("Já existe um projeto com esse título.");
    }

    public ProjectConflictException(String cause) {
        super("Projeto já existe. Causa: " + cause);
    }

}