package com.mock.mock.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private  UserRepo userRepo;
    @GetMapping
    public List<User> fetchAllUsers(){
        return userRepo.findAll();
    }
}