package com.blog.RossiBlog.controllers;


import com.blog.RossiBlog.dtos.PostDTO;
import com.blog.RossiBlog.models.Post;
import com.blog.RossiBlog.repositories.PostRepository;
import com.blog.RossiBlog.servicies.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class PostController {

    @Autowired
    PostService postService;


    @PostMapping("/posts")
    public ResponseEntity<Post> savePosts(@RequestBody @Valid PostDTO postDTO) {
        var post = new Post();
        BeanUtils.copyProperties(postDTO, post);
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.save(post));
    }

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.status(HttpStatus.OK).body(postService.findAll());
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<Object> getOnePosts(@PathVariable(value = "id") UUID id) {
        Optional<Post> postOptional = Optional.ofNullable(postService.findById(id));
        if (postOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(postOptional.get());
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<Object> updatePosts(@PathVariable(value="id") UUID id, @RequestBody @Valid PostDTO postDTO) {
        Optional<Post> postOptional = Optional.ofNullable(postService.findById(id));
        if(postOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post não encontrado!");
        }
        var post = postOptional.get();
        BeanUtils.copyProperties(postDTO, post);
        return ResponseEntity.status(HttpStatus.OK).body(postService.save(post));
    }

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<Object> deletePosts(@PathVariable(value = "id") UUID id) {
        Optional<Post> postOptional = Optional.ofNullable(postService.findById(id));
        if (postOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post não encontrada!");
        }
        postService.delete(postOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body("Post excluída com sucesso!");
    }

}
