package com.example.user_management.service;

import com.example.user_management.model.User;
import com.example.user_management.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public User getUserById(int userId) {
        return userRepo.findById(userId).orElse(null);
    }

    public void addUser(User user) {
        userRepo.save(user);
    }

    public void updateUser(User user) {
        userRepo.save(user);
    }

    public void deleteUser(int userId) {
        userRepo.deleteById(userId);
    }
}
