package com.springboot.springbootannotations.services;

import com.springboot.springbootannotations.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
    List<User> getAllUsers();
    User updateUser(User user);
    void deleteUser(Long id);

}
