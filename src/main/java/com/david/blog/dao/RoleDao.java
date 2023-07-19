package com.david.blog.dao;

import org.springframework.data.repository.CrudRepository;

import com.david.blog.entity.Role;

public interface RoleDao extends CrudRepository<Role, String> {

}