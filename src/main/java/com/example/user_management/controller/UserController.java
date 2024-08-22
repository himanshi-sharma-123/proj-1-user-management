package com.example.user_management.controller;

import com.example.user_management.model.LoginRequest;
import com.example.user_management.model.User;
import com.example.user_management.repository.UserRepo;
import com.example.user_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(@RequestBody User user){
         return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        return userService.verify(loginRequest.getUsername(), loginRequest.getPassword());
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable int userId){
        return userService.getUserById(userId);
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }

    @PutMapping("/users")
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    @DeleteMapping("/users/{userId}")
    public void deleteUser(@PathVariable int userId){
         userService.deleteUser(userId);
    }

}
