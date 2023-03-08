package com.amail.controllers;

import com.amail.models.Post;
import com.amail.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostRepository repository;

    @GetMapping("/api/posts")
    public List<Post>getAllPosts(){
        List<Post> postList = repository.findAll();
        return postList;
    }

    @GetMapping("/api/posts/{id}")
    public Post getPostById(@PathVariable Integer id){
        Post returnPost = repository.getById(id);
        return returnPost;
    }

    @GetMapping("/api/posts/recipient/{recipient}")
    public List <Post> getPostByRecipient(@PathVariable("recipient") String recipient) throws Exception {
        return repository.findAllPostsByRecipient(recipient );



    }

    @PostMapping("/api/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post createPost(@RequestBody Post post){
        repository.save(post);
        return post;
    }

    @DeleteMapping("/api/posts/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable Integer id){
        repository.deleteById(id);
    }
}
