package com.example.post;

import java.util.List;

public interface PostService {

    List<Post> findAllPosts();

    Post findPostByPostId(int postId);

}
