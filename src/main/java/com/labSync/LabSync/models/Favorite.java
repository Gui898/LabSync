package com.labSync.LabSync.models;

public class Favorite {

    private Posts post;
    private User user;

    public Favorite() {
    }

    public Favorite(Posts post, User user) {
        this.post = post;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Posts getPosts() {
        return post;
    }

    public void setPosts(Posts post) {
        this.post = post;
    }
}
