package com.labSync.LabSync.persistence.DAOS;

import com.labSync.LabSync.models.Project;
import com.labSync.LabSync.persistence.DAOMethods;
import com.labSync.LabSync.persistence.MySqlConnection;

import java.util.List;

public class ProjectDAO implements DAOMethods<Project> {

    MySqlConnection connection;

    public ProjectDAO(MySqlConnection mySqlConnection){
        this.connection = mySqlConnection;
    }


    @Override
    public void add(Project project) {
        this.connection.openConnection();
        
    }

    @Override
    public void edit(Project project) {

    }

    @Override
    public void delete(Project project) {

    }

    @Override
    public Project findById(long id) {
        return null;
    }

    @Override
    public List<Project> findAll() {
        return List.of();
    }
}
