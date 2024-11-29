package com.example.ecommerce_springboot.service;

import com.example.ecommerce_springboot.entity.User;
import com.example.ecommerce_springboot.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User addUser(User user);
    User updateUser(Long userId, User user);
    void deleteUser(Long userId);
    User getUserById(Long userId);
    List<User> getAllUsers();
    Optional<User> getUserByUsername(String username);
}

