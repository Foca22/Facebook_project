package com.project.facebook.controller.post;

import com.project.facebook.dto.post.PostDto;
import com.project.facebook.mapper.PostMapper;
import com.project.facebook.model.post.Post;
import com.project.facebook.model.users.Users;
import com.project.facebook.service.impl.PostServiceImpl;
import com.project.facebook.service.impl.UsersServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(value = "/post")
public class PostController {

    private PostServiceImpl postService;

    private PostMapper postMapper;

    private UsersServiceImpl usersService;

    @Autowired
    public PostController(PostServiceImpl postService, PostMapper postMapper, UsersServiceImpl usersService) {
        this.postService = postService;
        this.postMapper = postMapper;
        this.usersService = usersService;
    }

    @PostMapping()
    public PostDto createPost(@RequestBody PostDto createPost) {
        Users user = usersService.getUser(createPost.getUserId());
        Post post = postMapper.fromDtoToEntity(createPost, user);
        Post postToBeSaved = postService.createPost(post);

        return postMapper.fromEntityToDto(postToBeSaved);
    }

    @GetMapping("/{id}")
    public PostDto getPost(@PathVariable Integer id) {
        Post post = postService.getPost(id);
        return postMapper.fromEntityToDto(post);
    }

    @GetMapping
    public List<PostDto> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return postMapper.fromEntitiesToDtos(posts);

    }

    @GetMapping("/desc")
    public List<PostDto> getPostsDescending() {
        List<Post> postsDesc = postService.getPostDescending();
        return postMapper.fromEntitiesToDtos(postsDesc);
    }
}
