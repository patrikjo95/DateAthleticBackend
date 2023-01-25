package com.dateathletic.backend.service.uc;

import com.dateathletic.backend.domain.User;
import com.dateathletic.backend.dto.SignUpDto;
import com.dateathletic.backend.dto.UpdateUserDto;
import com.dateathletic.backend.dto.UpdateUserInfoDto;

import java.util.Optional;

public interface UserServiceCrud {
    void registerUser(SignUpDto dto);

    //READ
/*    Optional<User> getUserById(Long id);
    Optional<User>getUserByUsername(String username);*/

    //UPDATE

  void updateUser(Long id, UpdateUserDto dto);
    //DELETE
    void deleteUser(User user);

}
