package com.stp.controller;

import com.stp.model.Country;
import com.stp.model.User;
import com.stp.repository.CountryRepository;
import com.stp.repository.UserRepository;
import com.stp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public User login(@RequestBody User user){
        System.out.println(user);
        return userService.login(user.getLogin(), user.getPassword());
    }

    @PostMapping("/singup")
    public User singUp(@RequestBody User user){
        System.out.println(user);
        return userService.singUp(user.getLogin(), user.getPassword());
    }
}
