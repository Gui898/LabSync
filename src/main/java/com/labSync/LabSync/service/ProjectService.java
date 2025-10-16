package com.labSync.LabSync.service;

import com.labSync.LabSync.exception.ProjectConflictException;
import com.labSync.LabSync.exception.ProjectInvalidValuesException;
import com.labSync.LabSync.exception.ProjectNotFoundException;
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
        validateProject(project);
        projectDAO.add(project);
        return project;
    }

    public Project updateProject(Project project){
        validateProject(project);
        projectDAO.edit(project);
        return project;
    }

    public long delete(long id){
        projectDAO.delete(id);
        return id;
    }

    public long deleteByUserId(long id){
        projectDAO.deleteByUserId(id);
        return id;
    }

    public Project getProjectById(long id){
        if(projectDAO.findById(id) == null){
            throw new ProjectNotFoundException();
        }
        return projectDAO.findById(id);
    }

    public List<Project> getProjectsByUserId(long userId){
        if(projectDAO.findAllByUserId(userId).isEmpty()){
            throw new ProjectNotFoundException("Projetos não encontrados");
        }
        return projectDAO.findAllByUserId(userId);
    }

    public List<Project> getAllProjects(){
        if(projectDAO.findAll().isEmpty()){
            throw new ProjectNotFoundException();
        }
        return projectDAO.findAll();
    }

    private void validateProject(Project project){
        if(project == null){
            throw new ProjectNotFoundException();
        }

        for(Project p : projectDAO.findByTitle(project.getTitle())){
            if(p.getIdProject() == project.getIdProject()){
                throw new ProjectConflictException();
            }
        }

        if(project.getTitle() == null || project.getCategory() == null || project.getTextProjects() == null){
            throw new ProjectInvalidValuesException();
        }
    }

}
