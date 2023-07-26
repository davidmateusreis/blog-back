package com.david.blog.dao;

import org.springframework.data.repository.CrudRepository;

import com.david.blog.entity.Post;

public interface PostDao extends CrudRepository<Post, Long> {

}
