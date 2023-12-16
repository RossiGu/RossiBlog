package com.blog.RossiBlog.servicies.implement;

import com.blog.RossiBlog.models.Blog;
import com.blog.RossiBlog.repositories.BlogRepository;
import com.blog.RossiBlog.servicies.BlogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogRepository blogRepository;


    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(UUID id) {
        return blogRepository.findById(id).get();
    }

    @Override
    public Blog save(Blog posts) {
        return blogRepository.save(posts);
    }
}
