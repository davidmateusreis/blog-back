package com.david.blog.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.david.blog.entity.Post;
import com.david.blog.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping
    public Iterable<Post> list() {
        return postService.listPost();
    }

    @PreAuthorize("hasRole('Admin')")
    @PostMapping
    public Iterable<Post> create(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @PreAuthorize("hasRole('Admin')")
    @PutMapping
    public Iterable<Post> update(@RequestBody Post post) {
        return postService.updatePost(post);
    }

    @PreAuthorize("hasRole('Admin')")
    @DeleteMapping("{id}")
    public Iterable<Post> delete(@PathVariable("id") Long id) {
        return postService.deletePost(id);
    }

    @PreAuthorize("hasRole('Admin')")
    @GetMapping("{id}")
    public Optional<Post> getById(@PathVariable("id") Long id) {
        return postService.getPostById(id);
    }
}
