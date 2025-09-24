package com.labSync.LabSync.models;

public class Posts {

    private long idPost;
    private long likes;
    //comentarios
    private User user;
    private Project project;
    private Favorite favorite;

    public Posts () {
        this.idPost = 0;
        this.likes = 0;
    }

    public Posts(long likes, User user, Project project) {
        this.likes = likes;
        this.user = user;
        if (project.isPost()) {
            this.project = project;
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
}
