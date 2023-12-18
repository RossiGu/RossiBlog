package com.blog.RossiBlog.servicies.implement;


import com.blog.RossiBlog.models.Post;
import com.blog.RossiBlog.repositories.PostRepository;
import com.blog.RossiBlog.servicies.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;


    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findById(UUID id) {
        Optional<Post> obj = postRepository.findById(id);
        return obj.get();
    }

    public Post save(Post obj) {
        return postRepository.save(obj);
    }

    public void delete(UUID id) {
        findById(id);
        postRepository.deleteById(id);
    }

}