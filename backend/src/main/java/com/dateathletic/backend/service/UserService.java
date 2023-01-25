package com.dateathletic.backend.service;

import com.dateathletic.backend.domain.User;
import com.dateathletic.backend.domain.UserInfo;
import com.dateathletic.backend.dto.SignUpDto;
import com.dateathletic.backend.dto.UpdateUserDto;
import com.dateathletic.backend.repo.UserInfoRepository;
import com.dateathletic.backend.repo.UserRepository;
import com.dateathletic.backend.service.uc.UserServiceCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.dateathletic.backend.BackendApplication.USER_ROLE;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceCrud {


    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;


    public boolean existsByUsernameAndEmail(String username, String email){
        return userRepository.existsByUsernameOrEmail(username, email);
    }


    public User findUserByEmail(String email) {
       return userRepository.findUserByEmail(email);
    }





           @Override
    public void updateUser(Long id, UpdateUserDto dto) {

        User updatedUser = userRepository.findUserById(id);

        updatedUser.setUsername(dto.username());
        updatedUser.setEmail(dto.email());
        updatedUser.setPassword(passwordEncoder.encode(dto.password()));
        updatedUser.setRole(USER_ROLE);


      userRepository.save(updatedUser);
    }





    public Optional<User> findUserByUsername(String username){
        return userRepository.findUserByUsername(username);
    }


    public boolean existsByUsernameOrEmail(String username, String email) {
        return userRepository.existsByUsernameOrEmail(username, email);
    }

      @Override
    public void registerUser(SignUpDto dto){


        User user = new User();
        UserInfo userInfo = new UserInfo();

        user.setUsername(dto.username());
        user.setEmail(dto.email());
        user.setPassword(passwordEncoder.encode(dto.password()));
        user.setRole(USER_ROLE);

        userInfo.setFirstname(dto.firstname());
        userInfo.setLastname(dto.lastname());
        userInfo.setDob(dto.dob());
        userInfo.setCity(dto.city());
        userInfo.setBio(dto.bio());
        userInfo.setInterests(dto.interests());
        userInfo.setGender(dto.gender());

        user.setUserInfo(userInfo);
        userInfo.setUser(user);

        userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

}
