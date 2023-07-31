package com.david.blog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.blog.dao.PostDao;
import com.david.blog.entity.Post;

@Service
public class PostService {

    @Autowired
    private PostDao postDao;

    public Post addNewPost(Post post) {
        return postDao.save(post);
    }

    public List<Post> getAllPosts() {
        return (List<Post>) postDao.findAll();
    }

    public void deletePostDetails(Long postId) {
        postDao.deleteById(postId);
    }

    public Post getPostDetailsById(Long postId) {
        return postDao.findById(postId).get();
    }
}
