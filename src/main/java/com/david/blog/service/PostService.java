package com.david.blog.service;

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
}
