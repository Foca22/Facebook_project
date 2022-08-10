package com.project.facebook.repository;

import com.project.facebook.model.users.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsersRepository extends JpaRepository<Users, Integer> {

    Users findByUserName(String username);
}
