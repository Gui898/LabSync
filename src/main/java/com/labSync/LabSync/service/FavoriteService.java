package com.labSync.LabSync.service;

import com.labSync.LabSync.models.Favorite;
import com.labSync.LabSync.persistence.DAOS.FavoriteDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

    FavoriteDAO favoriteDAO;

    public FavoriteService(FavoriteDAO favoriteDAO){
        this.favoriteDAO = favoriteDAO;
    }

    public Favorite addFavorite(Favorite favorite){
        favoriteDAO.add(favorite);
        return favorite;
    }

    public Favorite updateFavorite(Favorite favorite){
        favoriteDAO.edit(favorite);
        return favorite;
    }

    public Favorite delete(Favorite favorite){
        favoriteDAO.delete(favorite);
        return favorite;
    }

    public Favorite getFavoriteById(int id) {
        return favoriteDAO.findById(id);
    }

    public List<Favorite> getAllFavorites() {
        return favoriteDAO.findAll();
    }

}
