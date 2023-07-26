package com.david.blog.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.david.blog.entity.ImageModel;
import com.david.blog.entity.Post;
import com.david.blog.service.PostService;

@RestController
@RequestMapping
public class PostController {

    @Autowired
    private PostService postService;

    @PreAuthorize("hasRole('Admin')")
    @PostMapping(value = { "/addNewPost" }, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public Post addNew(@RequestPart("post") Post post, @RequestPart("imageFile") MultipartFile[] file) {

        try {
            Set<ImageModel> images = upladImage(file);
            post.setPostImages(images);
            return postService.addNewPost(post);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Set<ImageModel> upladImage(MultipartFile[] multipartFiles) throws IOException {
        Set<ImageModel> imageModels = new HashSet<>();

        for (MultipartFile file : multipartFiles) {
            ImageModel imageModel = new ImageModel(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes());
            imageModels.add(imageModel);
        }
        return imageModels;
    }
}
