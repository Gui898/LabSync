package com.labSync.LabSync.exception;

public class ProjectNotFoundException extends RuntimeException {

    public ProjectNotFoundException(){
        super("Projeto não encontrado!");
    }

    public ProjectNotFoundException(String message) {
        super(message);
    }

}
