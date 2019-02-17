package com.example.post;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/api/posts")
    public ResponseEntity<List<Post>> findAllPosts() {
        List<Post> posts = postService.findAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/api/posts/{post-id}")
    public ResponseEntity<Post> findPostByPostId(@PathVariable("post-id") int postId) {
        Post post = postService.findPostByPostId(postId);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

}
