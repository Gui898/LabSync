package com.labSync.LabSync.service;

import com.labSync.LabSync.exception.FavoriteNotFoundException;
import com.labSync.LabSync.exception.PostNotFoundException;
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
        if(favorite.getPosts() == null){
            throw new PostNotFoundException("Não foi possível adicionar o favorito, post nulo.");
        }
        favoriteDAO.add(favorite);
        return favorite;
    }

    public Favorite updateFavorite(Favorite favorite){
        if(favorite == null){
            throw new FavoriteNotFoundException();
        }
        favoriteDAO.edit(favorite);
        return favorite;
    }

    public long delete(long id){
        favoriteDAO.delete(id);
        return id;
    }

    public long deleteByUserId(long id){
        favoriteDAO.deleteByUserId(id);
        return id;
    }

    public long deleteByIdPost(long idPost) {
        favoriteDAO.deleteByPostId(idPost);
        return idPost;
    }

    public void deleteByPostAndUserId(long idPost, long idUser){
        favoriteDAO.deleteByPostAndUserId(idPost, idUser);
    }

    public Favorite getFavoriteById(long id) {
        if(favoriteDAO.findById(id) == null){
            throw new FavoriteNotFoundException();
        }
        return favoriteDAO.findById(id);
    }

    public List<Favorite> getAllFavoritesByUserId(long id){
        if(favoriteDAO.findAllByUserID(id) == null){
            throw new FavoriteNotFoundException("Favoritos não encontrados.");
        }
        return favoriteDAO.findAllByUserID(id);
    }

    public List<Favorite> getAllFavorites() {
        if(favoriteDAO.findAll() == null){
            throw new FavoriteNotFoundException("Favoritos não encontrados.");
        }
        return favoriteDAO.findAll();
    }

}