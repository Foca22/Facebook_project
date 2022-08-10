package com.project.facebook.service.impl;

import com.project.facebook.exceptions.messages.ExceptionMessages;
import com.project.facebook.exceptions.post.PostNotFoundException;
import com.project.facebook.model.post.Post;
import com.project.facebook.repository.PostRepository;
import com.project.facebook.service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post createPost(Post createPostRequest) {
        return postRepository.save(createPostRequest);
    }

    @Override
    public Post getPost(Integer id) {
        return findPostById(id);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> getPostDescending() {
        return postRepository.findAll(Sort.by("id").descending());
    }

    private Post findPostById(Integer id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if(optionalPost.isEmpty()){
            throw new PostNotFoundException(ExceptionMessages.POST_NOT_FOUND.getErrorMessage(),
                    ExceptionMessages.POST_NOT_FOUND.getHttpStatusCode());
        }

        return optionalPost.get();
    }
}
