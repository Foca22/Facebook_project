package com.project.facebook.controller.users;

import com.project.facebook.dto.users.UsersDto;
import com.project.facebook.mapper.UsersMapper;
import com.project.facebook.model.users.Users;
import com.project.facebook.service.impl.UsersServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

    private final UsersServiceImpl usersService;

    private final UsersMapper usersMapper;

    @Autowired
    public UsersController(UsersServiceImpl usersService, UsersMapper usersMapper) {
        this.usersService = usersService;
        this.usersMapper = usersMapper;
    }

    @PostMapping()
    public UsersDto registerUser(@RequestBody UsersDto registerUsersRequest) {
        Users user = usersMapper.fromDtoToEntity(registerUsersRequest);
        Users registerUser = usersService.registerUser(user);
        return usersMapper.fromEntityToDto(registerUser);
    }

    @GetMapping("/{id}")
    public UsersDto getUser(@PathVariable Integer id) {
        Users user = usersService.getUser(id);
        return usersMapper.fromEntityToDtoWithPosts(user);
    }

    @GetMapping()
    public List<UsersDto> getAllUsers(){
        List<Users> users = usersService.getAllUsers();
        return usersMapper.fromEntitiesToDtos(users);
    }
}
