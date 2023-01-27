package com.dateathletic.backend.controller.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("admin/")
public class AdminUserController {
    // TODO: 2023-01-20 remove user
    @GetMapping("hiadmin")
    public String admin(){
        return "admin bara";
    }
    // TODO: 2023-01-20 ban user
    // TODO: 2023-01-20 hantera permissions
    // TODO: 2023-01-20 give users their daily swipes << will be challening and and important aspect to this application
}
