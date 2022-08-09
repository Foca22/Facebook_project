package com.project.facebook.dto.post;

import com.project.facebook.model.users.Users;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private Integer id;

    private String text;

    private Integer userId;
}
