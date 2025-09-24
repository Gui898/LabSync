package com.labSync.LabSync.models;
import java.util.ArrayList;
public class User {

    private long idUser;
    private String surname;
    private String password;
    private String nameUser;
    //true for author, false for reader.
    private boolean readerOrAuthor;
    private String email;
    private ArrayList<Project> projects;
    private ArrayList<Posts> posts;
    private ArrayList<Favorite> favorites;

    public User() {
        this.idUser = 0;
        this.surname = "";
        this.password = "";
        this.nameUser = "";
        this.readerOrAuthor = false;
        this.email = "";
    }

    public User(String surname, String password, String nameUser, boolean readerOrAuthor, String email) {
        this.surname = surname;
        this.password = password;
        this.nameUser = nameUser;
        this.readerOrAuthor = readerOrAuthor;
        this.email = email;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String password() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String nameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public boolean readerOrAuthor() {
        return readerOrAuthor;
    }

    public void setReaderOrAuthor(boolean readerOrAuthor) {
        this.readerOrAuthor = readerOrAuthor;
    }
    public String email() {
        return email;
    }

    public void setEmail() {
        this.email = email;
    }
}