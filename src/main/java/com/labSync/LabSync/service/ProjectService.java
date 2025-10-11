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

    public Project getProjectById(int id){
        if(projectDAO.findById(id) == null){
            throw new ProjectNotFoundException();
        }
        return projectDAO.findById(id);
    }

    public List<Project> getAllProjects(){
        if(projectDAO.findAll() == null){
            throw new ProjectNotFoundException();
        }
        return projectDAO.findAll();
    }

    private void validateProject(Project project){
        if(project == null){
            throw new ProjectNotFoundException();
        }

        if(projectDAO.findByTitle(project.getTitle()) != null){
            throw new ProjectConflictException();
        }

        if(project.getTitle() == null || project.getCategory() == null || project.getTextProjects() == null){
            throw new ProjectInvalidValuesException();
        }
    }

}
