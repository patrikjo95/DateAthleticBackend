package com.dateathletic.backend.service.userservice.uc;

import com.dateathletic.backend.domain.User;
import com.dateathletic.backend.dto.UpdateUserDto;

import java.util.List;
import java.util.Optional;

public interface UserServiceCrud {
    //CREATE
    void registerUser(User user);
    void processSwipes(List<User>users);

    //READ
    Optional<User>getUserById(Long id);
    Optional<User>getUserByUsername(String username);
    Optional<User> getUserByEmail(String email);
    List<User> getUsersWithIds(List<Long> ids);

    //UPDATE
    void updateUserInfoById(Long id, UpdateUserDto dto);

    //DELETE
    void deleteUser(User user);
}
