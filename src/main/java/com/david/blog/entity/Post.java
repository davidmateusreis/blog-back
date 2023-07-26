package com.david.blog.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
public class Post {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long postId;
        private String postAuthor;
        private String postTitle;
        @Lob
        private String postContent;
        @CreationTimestamp
        private Date createdAt;
        @UpdateTimestamp
        private Date updatedAt;
        @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
        @JoinTable(name = "post_images", joinColumns = { @JoinColumn(name = "post_id") }, inverseJoinColumns = {
                        @JoinColumn(name = "image_id") })
        private Set<ImageModel> postImages;
}
