package com.david.blog.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.david.blog.entity.Post;

public interface PostDao extends CrudRepository<Post, Long> {

    public List<Post> findByPostTitleContainingIgnoreCaseOrPostContentContainingIgnoreCase(String key1,
            String key2);
}
