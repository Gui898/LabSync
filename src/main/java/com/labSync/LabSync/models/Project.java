package com.labSync.LabSync.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Project {

    private long idProject;
    private String title;
    private String category;
    private String usedInstruments;
    private String textProjects;
    private String usedTech;
    private boolean hasPost;
    private User user;
    //false is sketch

    public Project() {
        this.idProject = 0;
        this.category = "";
        this.title = "";
        this.textProjects = "";
        this.usedInstruments = "";
        this.usedTech = "";
        this.hasPost = false;
    }

    public Project(String title, String category, String textProjects, String usedTech, String usedInstruments, User user) {
        this.category = category;
        this.title = title;
        this.textProjects = textProjects;
        this.usedInstruments = usedInstruments;
        this.usedTech = usedTech;
        this.hasPost = false;
        this.user = user;
    }

    public long getIdProject() {
        return idProject;
    }

    public void setIdProject(long idProject) {
        this.idProject = idProject;
    }

    public String getCategory () {
        return category;
    }

    public void setCategory (String category) {
        this.category = category;
    }

    public String getTitle () {
        return title;
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getTextProjects () {
        return textProjects;
    }

    public void setTextProjects (String textProjects) {
        this.textProjects = textProjects;
    }

    public String getUsedInstruments () {
        return usedInstruments;
    }

    public void setUsedInstruments (String usedInstruments) {
        this.usedInstruments = usedInstruments;
    }

    public String getUsedTech () {
        return usedTech;
    }

    public void setUsedTech (String usedTech) {
        this.usedTech = usedTech;
    }

    public boolean getHasPost() {
        return hasPost;
    }

    public void setHasPost(boolean isPost) {
        this.hasPost = isPost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Project{" +
                "idProject=" + idProject +
                ", title='" + title + '\'' +
                "hasPost: " + hasPost +
                '}';
    }
}