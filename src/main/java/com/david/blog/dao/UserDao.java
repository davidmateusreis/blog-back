package com.david.blog.dao;

import org.springframework.data.repository.CrudRepository;

import com.david.blog.entity.User;

public interface UserDao extends CrudRepository<User, String> {

}