package com.david.blog.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.david.blog.entity.Post;

public interface PostDao extends PagingAndSortingRepository<Post, Long> {

}
