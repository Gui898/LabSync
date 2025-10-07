package com.labSync.LabSync.service;

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
        postsDAO.add(post);
        return post;
    }

    public Posts updatePost(Posts post){
        postsDAO.edit(post);
        return post;
    }

    public long delete(long id){
        postsDAO.delete(id);
        return id;
    }

    public Posts getPostById(int id) {
        return postsDAO.findById(id);
    }

    public List<Posts> getAllPosts() {
        return postsDAO.findAll();
    }

}
