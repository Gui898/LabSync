package com.labSync.LabSync.models;
import java.util.ArrayList;

public class Favorite {

    private User user;
    private ArrayList<Posts> posts;
    public Favorite() {
    }

    public Favorite(User user) {
        this.user = user;
        this.posts = new ArrayList<Posts>();
    }
}
