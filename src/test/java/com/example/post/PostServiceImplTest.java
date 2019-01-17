package com.example.post;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostServiceImplTest {

    private int postId;
    private Post post;
    private List<Post> posts;

    @Mock
    private PostRepository postRepository;

    private PostServiceImpl postService;

    @BeforeEach
    void init() {
        postId = 1;
        post = new Post();
        posts = Collections.singletonList(post);

        postService = new PostServiceImpl(postRepository);
    }

    @Test
    void testFindAllPosts() {
        when(postRepository.findAll()).thenReturn(posts);

        List<Post> returnedPosts = postService.findAllPosts();

        assertEquals(posts, returnedPosts, "There was a problem retrieving the posts");
    }

    @Test
    void testFindPostByPostId() {
        when(postRepository.findById(postId)).thenReturn(Optional.of(post));

        Post returnedPost = postService.findPostByPostId(postId);

        assertEquals(post, returnedPost, "There was a problem retrieving the post");
    }

    @Test
    void testFindPostByPostId_postDoesNotExist_runtimeExceptionIsThrown() {
        when(postRepository.findById(postId)).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> postService.findPostByPostId(postId));
    }

}
