package com.labSync.LabSync.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Favorite {

    private long idFavorite;
    private Posts post;
    private User user;

    public Favorite() {
        this.idFavorite = 0;
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

    public long getIdFavorite() {
        return idFavorite;
    }

    public void setIdFavorite(long idFavorite) {
        this.idFavorite = idFavorite;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "post=" + post +
                ", idFavorite=" + idFavorite +
                '}';
    }
}
