package com.example.post;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostControllerTest {

    private int postId;
    private Post post;
    private List<Post> posts;

    @Mock
    private PostService postService;

    private PostController postController;

    @BeforeEach
    void init() {
        postId = 1;
        post = new Post();
        posts = Collections.emptyList();

        postController = new PostController(postService);
    }

    @Test
    void testFindAllPosts() {
        ResponseEntity<List<Post>> predictedResponse = new ResponseEntity<>(posts, HttpStatus.OK);
        when(postService.findAllPosts()).thenReturn(posts);

        ResponseEntity<List<Post>> actualResponse = postController.findAllPosts();

        assertEquals(predictedResponse, actualResponse, "The expected response was not returned");
    }

    @Test
    void testFindPostByPostId() {
        ResponseEntity<Post> predictedResponse = new ResponseEntity<>(post, HttpStatus.OK);
        when(postService.findPostByPostId(postId)).thenReturn(post);

        ResponseEntity<Post> actualResponse = postController.findPostByPostId(postId);

        assertEquals(predictedResponse, actualResponse, "The expected response was not returned");
    }

}
