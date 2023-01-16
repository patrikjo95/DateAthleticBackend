package com.dateathletic.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GuestApi
{
    @GetMapping("welcome")
    public String welcome(){
        return "welcome";
    }
}
