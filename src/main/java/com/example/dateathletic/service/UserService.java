package com.example.dateathletic.service;

import com.example.dateathletic.model.User;
import com.example.dateathletic.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepo repo;

    public void save(User userEntity){
        repo.save(userEntity);
    }
}
