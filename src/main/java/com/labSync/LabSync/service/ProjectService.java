package com.labSync.LabSync.service;

import com.labSync.LabSync.models.Project;
import com.labSync.LabSync.persistence.DAOS.ProjectDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    ProjectDAO projectDAO;

    public ProjectService(ProjectDAO projectDAO){
        this.projectDAO = projectDAO;
    }

    public Project addProject(Project project){
        projectDAO.add(project);
        return project;
    }

    public Project updateProject(Project project){
        projectDAO.edit(project);
        return project;
    }

    public long delete(long id){
        projectDAO.delete(id);
        return id;
    }

    public Project getProjectById(int id){
        return projectDAO.findById(id);
    }

    public List<Project> getAllProjects(){
        return projectDAO.findAll();
    }

}
