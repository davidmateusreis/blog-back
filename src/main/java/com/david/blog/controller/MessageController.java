package com.david.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.david.blog.entity.Message;
import com.david.blog.service.MessageService;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/sendMessage")
    public Message send(@RequestBody Message message) {
        return messageService.sendMessage(message);
    }
}
