package com.example.post;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post findPostByPostId(int postId) {
        Optional<Post> post = postRepository.findById(postId);
        return post.orElseThrow(() -> new RuntimeException("Post does not exist for ID: " + postId));
    }

}
