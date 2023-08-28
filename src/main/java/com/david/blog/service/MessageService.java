package com.david.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.david.blog.dao.MessageDao;
import com.david.blog.entity.Message;

@Service
public class MessageService {

    @Autowired
    private MessageDao messageDao;

    public Message sendMessage(Message message) {
        return messageDao.save(message);
    }
}