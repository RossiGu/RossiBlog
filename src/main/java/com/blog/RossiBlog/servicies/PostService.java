package com.blog.RossiBlog.servicies;



import com.blog.RossiBlog.models.Post;

import java.util.List;

import java.util.UUID;

public interface PostService {

    List<Post> findAll();
    Post findById(UUID id);
    Post save(Post posts);
    void delete(UUID id);
}
