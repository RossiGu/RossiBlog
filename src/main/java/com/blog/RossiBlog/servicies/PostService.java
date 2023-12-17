package com.blog.RossiBlog.servicies;

import com.blog.RossiBlog.models.Blog;

import java.util.List;
import java.util.UUID;

public interface PostService {

    List<Blog> findAll();
    Blog findById(UUID id);
    Blog save(Blog posts);
}
