package com.example.dateathletic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class Controller {

    @Autowired
   private UserRepo userRepo;

    @PostMapping(value = "/save")
    public String createUser(){

    }



}
