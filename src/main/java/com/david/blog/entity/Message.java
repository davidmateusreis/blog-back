package com.david.blog.entity;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Data
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long messageId;
    @NotBlank(message = "This field may not be blank")
    private String messageAuthor;
    @Email
    @NotBlank(message = "This field may not be blank")
    private String messageEmail;
    @Lob
    @NotBlank(message = "This field may not be blank")
    private String messageContent;
    @CreationTimestamp
    private Instant messageCreatedAt;
}
