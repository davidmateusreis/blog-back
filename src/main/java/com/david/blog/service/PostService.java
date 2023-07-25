package com.david.blog.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.david.blog.dao.PostDao;
import com.david.blog.entity.Post;

@Service
public class PostService {

    @Autowired
    private PostDao postDao;

    public Iterable<Post> listPost() {
        Sort sort = Sort.by("createdAt").descending();
        return postDao.findAll(sort);
    }

    public Iterable<Post> createPost(Post post) {
        postDao.save(post);
        return listPost();
    }

    public Iterable<Post> updatePost(Post post) {
        postDao.save(post);
        return listPost();
    }

    public Iterable<Post> deletePost(Long id) {
        postDao.deleteById(id);
        return listPost();
    }

    public Optional<Post> getPostById(Long id) {
        return postDao.findById(id);
    }
}
