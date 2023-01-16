package com.example.dateathletic.user;

import com.example.dateathletic.user.User;
import com.example.dateathletic.user.UserRepo;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepo repo;

    public void save(User userEntity){
        repo.save(userEntity);
    }

    @PostConstruct
    public void initDB(){
        List<User> users = IntStream.rangeClosed(1,100)
                .mapToObj(i -> new User("User " + i))
                .collect(Collectors.toList());
            repo.saveAll(users);
    }

    public Optional<User> findUserByUsername(String username){
        return repo.findUserByUsername(username);
    }

    public List<User> findAllUsers(){
        return repo.findAll();
    }
}
