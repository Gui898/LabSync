package com.labSync.LabSync.models;

import java.util.List;

public class User {

    private long idUser;
    private String nameUser;
    private String surname;
    private String email;
    private String password;
    private String academicEmail;
    private String aboutMe;
    //true for author, false for reader.
    private boolean readerOrAuthor;
    private List<Project> projects;
    private List<Posts> posts;
    private List<Favorite> favorites;

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

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<Posts> getPosts() {
        return posts;
    }

    public void setPosts(List<Posts> posts) {
        this.posts = posts;
    }

    public List<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Favorite> favorites) {
        this.favorites = favorites;
    }

    public void addPost(Posts post) {
        this.posts.add(post);
    }

    public void addProject(Project project) {
        this.projects.add(project);
    }

    public void addFavorite(Favorite favorite) {
        this.favorites.add(favorite);
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
                ", projects=" + projects +
                ", posts=" + posts +
                ", favorites=" + favorites +
                '}';
    }
}