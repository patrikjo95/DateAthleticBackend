package com.dateathletic.backend.repo;

import com.dateathletic.backend.domain.User;
import com.dateathletic.backend.domain.UserInfo;
import com.dateathletic.backend.dto.SignUpDto;
import com.dateathletic.backend.dto.UpdateUserDto;
import com.dateathletic.backend.dto.UpdateUserInfoDto;
import org.hibernate.sql.Update;

import java.util.Optional;

public interface UserServiceRepo {

    void registerUser(SignUpDto dto);

    Optional<User> findUserByUsername(String username);
    boolean existsByUsernameOrEmail(String username, String email);

    boolean existsByUsernameAndEmail(String username, String email);

    User findUserByEmail(String email);


  void updateUser(Long id, UpdateUserDto dto);

  void updateUserInfo(Long id, UpdateUserInfoDto dto);

}
