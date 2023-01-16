package com.example.dateathletic.user.controller;

import com.example.dateathletic.user.APIResponse;
import com.example.dateathletic.user.User;
import com.example.dateathletic.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/allUsers")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    private APIResponse<List<User>> getUsers(){
        List<User> allUsers = userService.findAllUsers();
        return new APIResponse<>(allUsers.size(), allUsers);
    }
}
