package com.labSync.LabSync.controller;

import com.labSync.LabSync.models.Posts;
import com.labSync.LabSync.service.PostsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class PostsController implements ProtocolMethods<Posts>{

    PostsService postsService;

    public PostsController(PostsService postsService) {
        this.postsService = postsService;
    }


    @Override
    @PostMapping
    public ResponseEntity<Posts> post(@RequestBody Posts post) {
        Posts newPost = postsService.addPost(post);
        return ResponseEntity.status(201).body(newPost);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        postsService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Posts> put(@PathVariable long id, @RequestBody Posts post) {
        post.setIdPost(id);
        Posts edited = postsService.updatePost(post);
        return ResponseEntity.ok(edited);
    }

    @Override
    @PatchMapping("/{id}")
    public ResponseEntity<Posts> patch(@PathVariable long id, @RequestBody Posts post) {
        post.setIdPost(id);
        Posts edited = postsService.updatePost(post);
        return ResponseEntity.ok(edited);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Posts> getById(@PathVariable long id) {
        return ResponseEntity.ok(postsService.getPostById(id));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<Posts>> getAllPostsByUserId(@PathVariable long id) throws Exception {
        return ResponseEntity.ok(postsService.getAllPostsByUserId(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Posts>> getAll() {
        return ResponseEntity.ok(postsService.getAllPosts());
    }

    @GetMapping("/popular")
    public ResponseEntity<List<Posts>> getPopular(){
        return ResponseEntity.ok(postsService.getPopular());
    }
}
