package com.dateathletic.backend.controller;

import com.dateathletic.backend.domain.User;
import com.dateathletic.backend.service.userservice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class testapi {

    private final UserService service;

    @PostMapping("/delete")
    public void delete(){
        User user = service.findUserByUsername("erkan").get();
        service.deleteUser(user);
    }
}
