package com.example.dateathletic.user;

import com.example.dateathletic.user.User;
import com.example.dateathletic.user.UserRepo;
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
