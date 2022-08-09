package com.project.facebook.mapper;

import com.project.facebook.dto.users.UsersDto;
import com.project.facebook.model.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UsersMapper {

    private final PostMapper postMapper;

    @Autowired
    public UsersMapper(PostMapper postMapper){
        this.postMapper = postMapper;
    }

    public UsersDto fromEntityToDto(Users userEntity) {
        UsersDto userDto = new UsersDto();
        userDto.setId(userEntity.getId());
        userDto.setUserName(userEntity.getUserName());
        userDto.setPassword(userEntity.getPassword());
        userDto.setPostsSet(userDto.getPostsSet());
        return userDto;
    }

    public Set<UsersDto> fromEntitiesToDtosSet(Set<Users> usersEntitySet) {
        if (usersEntitySet.isEmpty()){
            return Collections.emptySet();
        }

        return usersEntitySet.stream()
                .map(userEntity -> fromEntityToDto(userEntity))
                .collect(Collectors.toSet());
    }

    public List<UsersDto> fromEntitiesToDtos(List<Users> usersEntitySet) {
        if (usersEntitySet.isEmpty()){
            return Collections.emptyList();
        }

        return usersEntitySet.stream()
                .map(userEntity -> fromEntityToDtoWithPosts(userEntity))
                .collect(Collectors.toList());
    }

    public UsersDto fromEntityToDtoWithPosts(Users userEntity) {
        UsersDto userDto = new UsersDto();
        userDto.setId(userEntity.getId());
        userDto.setUserName(userEntity.getUserName());
        userDto.setPassword(userEntity.getPassword());
        userDto.setPostsSet(postMapper.fromEntitiesToDtosSet(userEntity.getUserPosts()));
        return userDto;
    }

    public Users fromDtoToEntity(UsersDto userDto) {
        Users userEntity = new Users();
        userEntity.setId(userDto.getId());
        userEntity.setUserName(userDto.getUserName());
        userEntity.setPassword(userDto.getPassword());
        return userEntity;
    }

    public Set<Users> fromDtosToEntities(Set<UsersDto> usersDtoSet) {
        if(usersDtoSet.isEmpty()){
            return Collections.emptySet();
        }

        return usersDtoSet.stream()
                .map(usersDto -> fromDtoToEntity(usersDto))
                .collect(Collectors.toSet());
    }
}
