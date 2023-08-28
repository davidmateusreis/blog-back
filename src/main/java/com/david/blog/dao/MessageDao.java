package com.david.blog.dao;

import org.springframework.data.repository.CrudRepository;

import com.david.blog.entity.Message;

public interface MessageDao extends CrudRepository<Message, Long> {

}
