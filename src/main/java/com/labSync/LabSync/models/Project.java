package com.labSync.LabSync.models;

public class Project {

    private long idProject;
    private String title;
    private String category;
    private String usedInstruments;
    private String textProjects;
    private String conclusion;
    private String usedTech;
    private User user;
    private boolean isPost;
    //false is sketch

    public Project() {
        this.idProject = 0;
        this.category = "";
        this.title = "";
        this.textProjects = "";
        this.usedInstruments = "";
        this.usedTech = "";
        this.conclusion = "";
    }

    public Project(String category, String title, String textProjects, String usedInstruments, String usedTech, String conclusion) {
        this.category = category;
        this.title = title;
        this.textProjects = textProjects;
        this.usedInstruments = usedInstruments;
        this.usedTech = usedTech;
        this.conclusion = conclusion;

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

    public String getConclusion () {
        return conclusion;
    }

    public void setConclusion (String conclusion) {
        this.conclusion = conclusion;
    }

    public boolean isPost() {
        return isPost;
    }

    public void setIsPost(boolean isPost) {
        this.isPost = isPost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}