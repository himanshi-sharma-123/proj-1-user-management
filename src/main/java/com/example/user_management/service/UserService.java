package com.example.user_management.service;

import com.example.user_management.model.User;
import com.example.user_management.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;


    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

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

    public User register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return userRepo.save(user);
    }

    public String verify(String username, String password) {

        User user = userRepo.findByUsername(username);

        if (user == null) {
            return "User not found";
        }


        if(!user.equals(user.getUsername()) && !password.equals(user.getPassword())){
            return "Bad credentials";
        }else{
            return "Logged in successfully";
        }

        //        if (password.equals(user.getPassword())) {
//            return "Login successful!";
//        } else {
//            return "Invalid credentials";
//        }
    }
}
