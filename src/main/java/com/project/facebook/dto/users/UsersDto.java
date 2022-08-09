package com.project.facebook.dto.users;

import com.project.facebook.dto.post.PostDto;
import com.project.facebook.model.post.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsersDto {

    private Integer id;

    private String userName;

    private String password;

    private Set<PostDto> postsSet = new HashSet<>();
}
