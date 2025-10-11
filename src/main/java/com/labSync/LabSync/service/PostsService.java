package com.labSync.LabSync.service;

import com.labSync.LabSync.exception.PostInvalidValuesException;
import com.labSync.LabSync.exception.PostNotFoundException;
import com.labSync.LabSync.models.Posts;
import com.labSync.LabSync.persistence.DAOS.PostsDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostsService {

    PostsDAO postsDAO;

    public PostsService(PostsDAO postsDAO){
        this.postsDAO = postsDAO;
    }

    public Posts addPost(Posts post){
        if (post == null) {
            throw new PostInvalidValuesException();
        }
        postsDAO.add(post);
        return post;
    }

    public Posts updatePost(Posts post){
        if (post == null) {
            throw new PostInvalidValuesException();
        }
        postsDAO.edit(post);
        return post;
    }

    public long delete(long id){
        postsDAO.delete(id);
        return id;
    }

    public List<Posts> getAllPostsByUserId(long id) throws Exception {
        if(postsDAO.findAllByUserId(id) == null){
            throw new PostNotFoundException();
        }
        return postsDAO.findAllByUserId(id);
    }

    public Posts getPostById(int id) {
        if(postsDAO.findById(id) == null){
            throw new PostNotFoundException();
        }
        return postsDAO.findById(id);
    }

    public List<Posts> getAllPosts() {
        if(postsDAO.findAll().isEmpty()){
            throw new PostNotFoundException();
        }
        return postsDAO.findAll();
    }

}
