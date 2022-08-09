package com.project.facebook.mapper;

import com.project.facebook.dto.post.PostDto;
import com.project.facebook.model.post.Post;
import com.project.facebook.model.users.Users;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class PostMapper {

    public Post fromDtoToEntity(PostDto postDto, Users user) {
        Post postEntity = new Post();
        postEntity.setText(postDto.getText());
        postEntity.setUser(user);

        return postEntity;
    }

    public Set<Post> fromDtosToEntities(Set<PostDto> postDtosSet, Users user){
        if(postDtosSet.isEmpty()){
            return Collections.emptySet();
        }

        return postDtosSet.stream()
                .map(postDto -> fromDtoToEntity(postDto, user))
                .collect(Collectors.toSet());
    }

    public PostDto fromEntityToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        post.setText(post.getText());
        postDto.setUserId(post.getUser().getId());

        return postDto;
    }

    public List<PostDto> fromEntitiesToDtos(List<Post> postsEntitiesSet) {
        if (postsEntitiesSet.isEmpty()){
            return Collections.emptyList();
        }

        return postsEntitiesSet.stream()
                .map(postEntity -> fromEntityToDto(postEntity))
                .collect(Collectors.toList());
    }

    public Set<PostDto> fromEntitiesToDtosSet(Set<Post> postsEntitiesSet) {
        if (postsEntitiesSet.isEmpty()){
            return Collections.emptySet();
        }

        return postsEntitiesSet.stream()
                .map(postEntity -> fromEntityToDto(postEntity))
                .collect(Collectors.toSet());
    }
}
