package com.labSync.LabSync.models;

import java.util.Set;

public class Posts {

    private long idPost;
    private long likes;
    //comments
    private User user;
    private Project project;
    private Set<Favorite> favorites;

    public Posts () {
        this.idPost = 0;
        this.likes = 0;
    }

    public Posts(long likes, Project project) throws Exception {
        this.likes = likes;
        if (!project.isPost()) {
            this.project = project;
            this.project.setIsPost(true);
            this.user = project.getUser();
        }else {
            System.out.println("Já é um post");
        }
    }

    public long getIdPost() {
        return idPost;
    }

    public void setIdPost(long idPost) {
        this.idPost = idPost;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Set<Favorite> getFavorites() {
        return favorites;
    }

    public void setFavorites(Set<Favorite> favorites) {
        this.favorites = favorites;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "project=" + project +
                ", likes=" + likes +
                ", idPost=" + idPost +
                '}';
    }
}
