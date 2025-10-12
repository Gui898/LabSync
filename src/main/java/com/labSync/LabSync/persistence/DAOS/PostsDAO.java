package com.labSync.LabSync.persistence.DAOS;

import com.labSync.LabSync.models.Posts;
import com.labSync.LabSync.models.Project;
import com.labSync.LabSync.models.User;
import com.labSync.LabSync.persistence.DAOMethods;
import com.labSync.LabSync.persistence.MySqlConnection;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PostsDAO implements DAOMethods<Posts> {

    MySqlConnection connection;

    public PostsDAO(MySqlConnection connection) {
        this.connection = connection;
    }


    @Override
    public void add(Posts posts) {
        this.connection.openConnection();
        String sql = "INSERT INTO posts VALUES (NULL, ?, ?, ?);";
        try{
            PreparedStatement st = this.connection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setLong(1, posts.getLikes());
            st.setLong(2, posts.getUser().getIdUser());
            st.setLong(3, posts.getProject().getIdProject());
            st.executeUpdate();

            ProjectDAO pd = new ProjectDAO(this.connection);
            pd.edit(posts.getProject());

            ResultSet rs = st.getGeneratedKeys();
            if(rs.next()){
                posts.setIdPost(rs.getLong(1));
            }
            st.close();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            this.connection.closeConnection();
        }
    }

    @Override
    public void edit(Posts posts) {
        this.connection.openConnection();
        String sql = "UPDATE posts SET likes=? WHERE id_post=?;";
        try{
            PreparedStatement st = this.connection.getConnection().prepareStatement(sql);
            st.setLong(1, posts.getLikes());
            st.setLong(2, posts.getIdPost());
            st.executeUpdate();
            st.close();
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            this.connection.closeConnection();
        }
    }

    @Override
    public void delete(long id) {
        this.connection.openConnection();
        String sql = "DELETE FROM posts WHERE id_post=?;";
        try{
            PreparedStatement st = this.connection.getConnection().prepareStatement(sql);
            st.setLong(1, id);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            this.connection.closeConnection();
        }
    }

    @Override
    public Posts findById(long id) {
        this.connection.openConnection();
        String sql = "SELECT * FROM posts pt INNER JOIN project pr ON pt.id_project = pr.id_project " +
                "WHERE pt.id_post=?;";
        Posts post = null;
        try{
            PreparedStatement st = this.connection.getConnection().prepareStatement(sql);
            st.setLong(1, id);

            ResultSet rs = st.executeQuery();
            if(rs.next()){
                User user = new UserDAO(connection).findById(rs.getLong("id_user"));
                Project project = new Project(rs.getString("title"), rs.getString("category"),
                        rs.getString("text_project"), rs.getString("used_tech"),
                        rs.getString("used_instruments"), user);
                project.setIdProject(rs.getLong("id_project"));

                post = new Posts(rs.getLong("likes"), project);
                post.setIdPost(rs.getLong("id_post"));
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally{
            this.connection.closeConnection();
        }

        return post;
    }

    @Override
    public List<Posts> findAll() {
        this.connection.openConnection();
        String sql = "SELECT * FROM posts pt INNER JOIN project pr ON pt.id_project = pr.id_project;";
        List<Posts> list = new ArrayList<>();
        try{
            PreparedStatement st = this.connection.getConnection().prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while(rs.next()){
                User user = new UserDAO(connection).findById(rs.getLong("id_user"));
                Project project = new Project(rs.getString("title"), rs.getString("category"),
                        rs.getString("text_project"), rs.getString("used_tech"),
                        rs.getString("used_instruments"), user);
                project.setIdProject(rs.getLong("id_project"));

                Posts post = new Posts(rs.getLong("likes"), project);
                post.setIdPost(rs.getLong("id_post"));

                list.add(post);
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally{
            this.connection.closeConnection();
        }
        return list;
    }

    public List<Posts> findAllByUserId(long idUser){
        this.connection.openConnection();
        String sql = "SELECT * FROM posts pt INNER JOIN project pr ON pt.id_project = pr.id_project " +
                "WHERE pt.id_user = ?;";
        List<Posts> list = new ArrayList<>();
        try{
            PreparedStatement st = this.connection.getConnection().prepareStatement(sql);
            st.setLong(1, idUser);

            ResultSet rs = st.executeQuery();
            while(rs.next()){
                User user = new UserDAO(connection).findById(idUser);
                Project project = new Project(rs.getString("title"), rs.getString("category"),
                        rs.getString("text_project"), rs.getString("used_tech"),
                        rs.getString("used_instruments"), user);
                project.setIdProject(rs.getLong("id_project"));

                Posts post = new Posts(rs.getLong("likes"), project);
                post.setIdPost(rs.getLong("id_post"));
                list.add(post);
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally{
            this.connection.closeConnection();
        }
        return list;
    }

}
