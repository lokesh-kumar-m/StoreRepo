package com.example.store.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.store.Repository.services.UserRepositoryService;
import com.example.store.security.JwtResponse;

@RestController
public class UserController {
    private UserRepositoryService userServices;
    private JwtResponse jwtResponse;
    public UserController(UserRepositoryService userServices, JwtResponse jwtResponse) {
        this.userServices = userServices;
        this.jwtResponse = jwtResponse;
    }
    
    @PostMapping("/users/register")
    public ResponseEntity<String> getRegisterUser(@RequestBody RegisterUserDto registerUser) {
        // logger.info("********lome testing*******");
        if (userServices.existingUser(registerUser.getUsername())) {
            return new ResponseEntity<>("User Exists please login", HttpStatus.BAD_REQUEST);
        }
        String response=userServices.addNewUser(registerUser.getUsername(), registerUser.getPassword());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping("/users/login")
    public ResponseEntity<String> getUserDetails(@RequestBody RegisterUserDto userRegistry){
        String response;
        response=userServices.isAuthenticUser(userRegistry.getUsername(), userRegistry.getPassword());
        if(response.equals("success")){
            String token=jwtResponse.getJwtToken(userRegistry.getUsername());
            return new ResponseEntity<>(token,HttpStatus.OK);
        }
        return new ResponseEntity<String>(response, HttpStatus.BAD_REQUEST);
    }
}
