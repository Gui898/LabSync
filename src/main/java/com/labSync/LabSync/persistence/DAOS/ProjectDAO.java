package com.labSync.LabSync.persistence.DAOS;

import com.labSync.LabSync.models.Project;
import com.labSync.LabSync.persistence.DAOMethods;
import com.labSync.LabSync.persistence.MySqlConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAO implements DAOMethods<Project> {

    MySqlConnection connection;

    public ProjectDAO(MySqlConnection mySqlConnection){
        this.connection = mySqlConnection;
    }


    @Override
    public void add(Project project) {
        this.connection.openConnection();
        String sql = "INSERT INTO project VALUES (NULL, ?, ?, ?, ?, ?, ?, ?);";
        try{
            PreparedStatement st = this.connection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, project.getTitle());
            st.setString(2, project.getCategory());
            st.setString(3, project.getUsedInstruments());
            st.setString(4, project.getTextProjects());
            st.setString(5, project.getUsedTech());
            st.setBoolean(6, project.isPost());
            st.setLong(7, project.getUser().getIdUser());
            st.executeUpdate();

            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                project.setIdProject(rs.getLong(1));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            this.connection.closeConnection();
        }
    }

    @Override
    public void edit(Project project) {
        this.connection.openConnection();
        String sql = "UPDATE project SET title=?, category=?, " +
                "used_instruments=?, text_project=?, conclusion=?, used_tech=? " +
                "WHERE id_project=?;";
        try{
            PreparedStatement st = this.connection.getConnection().prepareStatement(sql);
            st.setString(1, project.getTitle());
            st.setString(2, project.getCategory());
            st.setString(3, project.getUsedInstruments());
            st.setString(4, project.getTextProjects());
            st.setString(5, project.getUsedTech());
            st.setBoolean(6, project.isPost());
            st.setLong(7, project.getIdProject());
            st.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            this.connection.closeConnection();
        }
    }

    @Override
    public void delete(Project project) {
        this.connection.openConnection();
        String sql = "DELETE FROM project WHERE id_project=?;";
        try{
            PreparedStatement st = this.connection.getConnection().prepareStatement(sql);
            st.setLong(1, project.getIdProject());
            st.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            this.connection.closeConnection();
        }
    }

    @Override
    public Project findById(long id) {
        this.connection.openConnection();
        String sql = "SELECT * FROM project WHERE id_project=?;";
        Project project = null;
        try{
            PreparedStatement st = this.connection.getConnection().prepareStatement(sql);
            st.setLong(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()) {
                project = new Project(rs.getString("title"),
                        rs.getString("category"),
                        rs.getString("text_project"),
                        rs.getString("used_tech"),
                        rs.getString("used_instruments"),
                        null
                );
                project.setIsPost(rs.getBoolean("is_post"));
                project.setIdProject(rs.getLong("id_project"));
                UserDAO userDAO = new UserDAO(this.connection);
                project.setUser(userDAO.findById(rs.getLong("id_user")));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return project;
    }

    @Override
    public List<Project> findAll() {
        this.connection.openConnection();
        String sql = "SELECT * FROM project;";
        List<Project> list = new ArrayList<>();
        try{
            PreparedStatement st = this.connection.getConnection().prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()) {
                Project project = new Project(rs.getString("title"),
                        rs.getString("category"),
                        rs.getString("text_project"),
                        rs.getString("used_tech"),
                        rs.getString("used_instruments"),
                        null
                );
                project.setIsPost(rs.getBoolean("is_post"));
                project.setIdProject(rs.getLong("id_project"));
                UserDAO userDAO = new UserDAO(this.connection);
                project.setUser(userDAO.findById(rs.getLong("id_user")));

                list.add(project);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return list;
    }
}
