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
    private String academicEmail;
    private String aboutMe;
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
        this.aboutMe = "";
        this.academicEmail = "";
    }

    public User(String nameUser, String surname, String email, String academicEmail,
                String password,  boolean readerOrAuthor, String aboutMe) {
        this.surname = surname;
        this.password = password;
        this.nameUser = nameUser;
        this.readerOrAuthor = readerOrAuthor;
        this.email = email;
        this.aboutMe = aboutMe;
        this.academicEmail = academicEmail;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return nameUser;
    }

    public void setName(String nameUser) {
        this.nameUser = nameUser;
    }

    public boolean getReaderOrAuthor() {
        return readerOrAuthor;
    }

    public void setReaderOrAuthor(boolean readerOrAuthor) {
        this.readerOrAuthor = readerOrAuthor;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail() {
        this.email = email;
    }

    public String getAcademicEmail() {
        return academicEmail;
    }

    public void setAcademicEmail(String academicEmail) {
        this.academicEmail = academicEmail;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", nameUser='" + nameUser + '\'' +
                ", readerOrAuthor=" + readerOrAuthor +
                ", email='" + email + '\'' +
                ", academicEmail='" + academicEmail + '\'' +
                ", aboutMe='" + aboutMe + '\'' +
                '}';
    }
}