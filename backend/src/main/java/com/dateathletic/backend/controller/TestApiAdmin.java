package com.dateathletic.backend.controller;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/")
@RolesAllowed({"ADMIN"})
public class TestApiAdmin {
    @GetMapping("admin")
    public String admin(){
        return "admin";
    }
}
