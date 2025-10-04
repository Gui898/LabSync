package com.labSync.LabSync.persistence.DAOS;

import com.labSync.LabSync.models.User;
import com.labSync.LabSync.persistence.DAOMethods;
import com.labSync.LabSync.persistence.MySqlConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements DAOMethods<User> {

    MySqlConnection connection;

    public UserDAO(MySqlConnection mySqlConnection){
        this.connection = mySqlConnection;
    }


    @Override
    public void add(User user) {
        this.connection.openConnection();
        String sql = "INSERT INTO users VALUES (NULL, ?, ?, ?, ?, ?, ?, ?);";
        try{
            PreparedStatement st = connection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, user.getName());
            st.setString(2, user.getSurname());
            st.setString(3, user.getEmail());
            st.setString(4, user.getAcademicEmail());
            st.setString(5, user.getPassword());
            st.setBoolean(6, user.getReaderOrAuthor());
            st.setString(7, user.getAboutMe());
            st.executeUpdate();

            ResultSet rs = st.getGeneratedKeys();
            if(rs.next()){
                user.setIdUser(rs.getLong(1));
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            this.connection.closeConnection();
        }
    }

    @Override
    public void edit(User user) {
        this.connection.openConnection();
        String sql = "UPDATE users SET nameUser=?, surname=?, email=?, academicEmail=?, passwordUser=?," +
                "readerOrAuthor=?, aboutMe=? WHERE id_user=?;";
        try{
            PreparedStatement st = connection.getConnection().prepareStatement(sql);
            st.setString(1, user.getName());
            st.setString(2, user.getSurname());
            st.setString(3, user.getEmail());
            st.setString(4, user.getAcademicEmail());
            st.setString(5, user.getPassword());
            st.setBoolean(6, user.getReaderOrAuthor());
            st.setString(7, user.getAboutMe());
            st.setLong(8, user.getIdUser());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            this.connection.closeConnection();
        }
    }

    @Override
    public void delete(User user) {
        this.connection.openConnection();
        String sql = "DELETE FROM users WHERE id_user=?;";
        try {
            PreparedStatement st = connection.getConnection().prepareStatement(sql);
            st.setLong(1, user.getIdUser());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            this.connection.closeConnection();
        }
    }

    @Override
    public User findById(long id) {
        this.connection.openConnection();
        String sql = "SELECT * FROM users WHERE id_user=?;";
        User user = null;
        try{
            PreparedStatement st = this.connection.getConnection().prepareStatement(sql);
            st.setLong(1, id);

            ResultSet rs = st.executeQuery();
            if(rs.next()){
                user = new User(rs.getString("nameUser"), rs.getString("surname"),
                        rs.getString("email"), rs.getString("academicEmail"),
                        rs.getString("passwordUser"), rs.getBoolean("readerOrAuthor"),
                        rs.getString("aboutMe"));
                user.setIdUser(rs.getLong("id_user"));
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            this.connection.closeConnection();
        }
        return user;
    }

    public User findByIdComplete(long id) {
        this.connection.openConnection();
        String sql = "SELECT * FROM users WHERE id_user=?;";
        User user = null;
        try{
            PreparedStatement st = this.connection.getConnection().prepareStatement(sql);
            st.setLong(1, id);

            ResultSet rs = st.executeQuery();
            if(rs.next()){
                user = new User(rs.getString("nameUser"), rs.getString("surname"),
                        rs.getString("email"), rs.getString("academicEmail"),
                        rs.getString("passwordUser"), rs.getBoolean("readerOrAuthor"),
                        rs.getString("aboutMe"));
                user.setIdUser(rs.getLong("id_user"));

                ProjectDAO projectDAO = new ProjectDAO(this.connection);
                user.setProjects(projectDAO.findByUserId(user.getIdUser(), user));

                FavoriteDAO favoriteDAO = new FavoriteDAO(this.connection);
                user.setFavorites(favoriteDAO.findByUserId(user.getIdUser(), user));

                PostsDAO postsDAO = new PostsDAO(this.connection);
                user.setPosts(postsDAO.findByUserId(user.getIdUser(), user));
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            this.connection.closeConnection();
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        this.connection.openConnection();
        String sql = "SELECT * FROM users";
        List<User> list = new ArrayList<>();
        try{
            PreparedStatement st = this.connection.getConnection().prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while(rs.next()){
                User user = new User(rs.getString("nameUser"), rs.getString("surname"),
                        rs.getString("email"), rs.getString("academicEmail"),
                        rs.getString("passwordUser"), rs.getBoolean("readerOrAuthor"),
                        rs.getString("aboutMe"));
                user.setIdUser(rs.getLong("id_user"));

                ProjectDAO projectDAO = new ProjectDAO(this.connection);
                user.setProjects(projectDAO.findByUserId(user.getIdUser(), user));

                FavoriteDAO favoriteDAO = new FavoriteDAO(this.connection);
                user.setFavorites(favoriteDAO.findByUserId(user.getIdUser(), user));

                PostsDAO postsDAO = new PostsDAO(this.connection);
                user.setPosts(postsDAO.findByUserId(user.getIdUser(), user));

                list.add(user);
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            this.connection.closeConnection();
        }
        return list;
    }
}
