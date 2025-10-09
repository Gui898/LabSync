package com.labSync.LabSync.exception;

public class FavoriteNotFoundException extends RuntimeException {

    public FavoriteNotFoundException(){
        super("Favorito não encontrado");
    }

    public FavoriteNotFoundException(String message) {
        super(message);
    }
}
