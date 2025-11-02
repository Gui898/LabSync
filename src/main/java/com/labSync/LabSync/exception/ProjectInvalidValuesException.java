package com.labSync.LabSync.exception;

public class ProjectInvalidValuesException extends RuntimeException {
    public ProjectInvalidValuesException(){
        super("Valores inválidos ou não adicionados para o projeto");
    }

    public ProjectInvalidValuesException(String message) {
        super("Você inseriu valores inválidos para o projeto. Causa: " + message);
    }
}
