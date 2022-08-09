package com.project.facebook.service.impl;

import com.project.facebook.exceptions.messages.ExceptionMessages;
import com.project.facebook.exceptions.user.UserNotFoundException;
import com.project.facebook.model.users.Users;
import com.project.facebook.repository.UsersRepository;
import com.project.facebook.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Autowired
    private UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public Users registerUser(Users registerUser) {
        return usersRepository.save(registerUser);
    }

    @Override
    public Users getUser(Integer id) {
        return findUserById(id);
    }

    @Override
    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    private Users findUserById(Integer id) throws UserNotFoundException {
        Optional<Users> optionalUser = usersRepository.findById(id);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException(ExceptionMessages.USER_NOT_FOUND.getErrorMessage(),
                    ExceptionMessages.USER_NOT_FOUND.getHttpStatusCode());
        }
        return optionalUser.get();
    }

}
