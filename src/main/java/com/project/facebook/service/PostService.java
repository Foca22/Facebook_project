package com.project.facebook.service;

import com.project.facebook.model.post.Post;

import java.util.List;
import java.util.Set;

public interface PostService {

    Post createPost (Post createPostRequest);

    Post getPost(Integer id);

    List<Post> getAllPosts();
}
