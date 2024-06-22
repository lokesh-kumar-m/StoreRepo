package com.example.store.Repository.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.store.Repository.UserRepository;
import com.example.store.model.UserEntity;

@Service
public class UserRepositoryService {
    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;

    public UserRepositoryService(UserRepository userRepo, PasswordEncoder passwordEncoder){
        this.userRepo=userRepo;
        this.passwordEncoder=passwordEncoder;
    }
    public String addNewUser(String name, String pwd){
        UserEntity user=new UserEntity();
        user.setUserName(name);
        user.setPassword(passwordEncoder.encode(pwd));
        userRepo.save(user);
        return "Created"+name;
    }
    public boolean existingUser(String name){
        return userRepo.existsByUserName(name);
    }
    public String isAuthenticUser(String username, String password){
        if(existingUser(username)){
            UserEntity user=userRepo.findByUserName(username).get();
            boolean isValidName=user.getUserName().equalsIgnoreCase(username);
            boolean isValidPassword=passwordEncoder.matches(password,user.getPassword());
            if(isValidName && isValidPassword){
                return "success";
            }
            return "Invalid password!";
        }
        return "user not found! Please Register";
    }
}
