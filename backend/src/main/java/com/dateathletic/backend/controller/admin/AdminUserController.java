package com.dateathletic.backend.controller.admin;

import com.dateathletic.backend.domain.User;
import com.dateathletic.backend.service.userservice.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("admin/")
public class AdminUserController {
    private final UserService service;

    // TODO: 2023-01-20 ban user
    // TODO: 2023-01-20 hantera permissions
    // TODO: 2023-01-20 give users their daily swipes << will be challening and and important aspect to this application

    @PostMapping("/delete/{username}")
    public void delete(@PathVariable String username){
        User user = service.findUserByUsername(username).get();
        service.deleteUser(user);
    }
}
