package com.labSync.LabSync.persistence.DAOS;

import com.labSync.LabSync.models.Favorite;
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
public class FavoriteDAO implements DAOMethods<Favorite> {

    MySqlConnection connection;

    public FavoriteDAO (MySqlConnection connection){
        this.connection = connection;
    }

    @Override
    public void add(Favorite favorite) {
        this.connection.openConnection();
        String sql = "INSERT INTO favorite VALUES (NULL, ?, ?);";
        try{
            PreparedStatement st = this.connection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setLong(1, favorite.getPosts().getIdPost());
            st.setLong(2, favorite.getUser().getIdUser());
            st.executeUpdate();

            ResultSet rs = st.getGeneratedKeys();
            if(rs.next()){
                favorite.setIdFavorite(rs.getLong(1));
            }
            st.close();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            this.connection.closeConnection();
        }
    }

    @Override
    public void edit(Favorite favorite) {
        throw new UnsupportedOperationException("Este método não é suportado por esta classe.");
    }

    @Override
    public void delete(long id) {
        this.connection.openConnection();
        String sql = "DELETE FROM favorite WHERE id_favorite=?;";
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
    public Favorite findById(long id) {
        this.connection.openConnection();
        String sql = "SELECT * FROM favorite WHERE id_favorite=?;";
        Favorite fav = null;
        try{
            PreparedStatement st = this.connection.getConnection().prepareStatement(sql);
            st.setLong(1, id);

            ResultSet rs = st.executeQuery();
            if(rs.next()){
                PostsDAO postDAO = new PostsDAO(this.connection);
                UserDAO userDAO = new UserDAO(this.connection);
                fav = new Favorite(postDAO.findById(rs.getLong("id_post")),
                        userDAO.findById(rs.getLong("id_user")));
                fav.setIdFavorite(rs.getLong("id_favorite"));
            }
            st.close();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            this.connection.closeConnection();
        }

        return fav;
    }

    @Override
    public List<Favorite> findAll() {
        this.connection.openConnection();
        String sql = "SELECT * FROM favorite;";
        List<Favorite> list = new ArrayList<>();
        try{
            PreparedStatement st = this.connection.getConnection().prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while(rs.next()){
                PostsDAO postDAO = new PostsDAO(this.connection);
                UserDAO userDAO = new UserDAO(this.connection);
                Favorite fav = new Favorite(postDAO.findById(rs.getLong("id_post")),
                        userDAO.findById(rs.getLong("id_user")));
                fav.setIdFavorite(rs.getLong("id_favorite"));

                list.add(fav);
                st.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            this.connection.closeConnection();
        }

        return list;
    }

    public List<Favorite> findByUserId(long idUser, User user) throws SQLException {
        List<Favorite> favorites = new ArrayList<>();
        String sql = "SELECT * FROM favorite WHERE id_user = ?";
        PreparedStatement st = this.connection.getConnection().prepareStatement(sql);
        st.setLong(1, idUser);
        ResultSet rs = st.executeQuery();

        PostsDAO postDAO = new PostsDAO(this.connection);
        while (rs.next()) {

            Favorite fav = new Favorite(
                    postDAO.findById(rs.getLong("id_post")),
                    user
            );
            fav.setIdFavorite(rs.getLong("id_favorite"));
            favorites.add(fav);
        }

        st.close();
        return favorites;
    }
}
