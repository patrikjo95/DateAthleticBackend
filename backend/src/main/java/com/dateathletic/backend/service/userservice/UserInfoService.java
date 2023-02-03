package com.dateathletic.backend.service.userservice;

import com.dateathletic.backend.domain.User;
import com.dateathletic.backend.domain.UserInfo;
import com.dateathletic.backend.repo.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserInfoService {
    private final UserInfoRepository userInfoRepository;

    public Optional<UserInfo> getUserByFirstname(String firstname){
        return userInfoRepository.findUserByFirstname(firstname);
    }
    public Optional<UserInfo> getUserByLastname(String lastname){
        return userInfoRepository.findUserByLastname(lastname);
    }
    public String getUserByInterests(String interests){
        return userInfoRepository.findUserByInterests(interests);
    }
    public String getUserByDoB(String doB){
        return userInfoRepository.findUserByDoB(doB);
    }
    public List<Optional<User>> getUserByGender(String genderPreference){
        return userInfoRepository.findUserByGender(genderPreference);
    }
    public String getUserByCity(String city){
        return userInfoRepository.findUserByCity(city);
    }
    public Page<UserInfo> findAllByFirstname(String firstname, Pageable pageable){
        return userInfoRepository.findAllByFirstname(firstname, pageable);
    }
    public  Page<UserInfo> findAll(Pageable pageable){
        return userInfoRepository.findAll(pageable);
    }
    public Page<UserInfo> findAllByDoB(String doB, Pageable pageable){
        return userInfoRepository.findAllByDoB(doB, pageable);
    }
    public Page<UserInfo> findAllByLastname(String lastname, Pageable pageable){
        return userInfoRepository.findAllByLastname(lastname, pageable);
    }
    public Page<UserInfo> findAllByGender(String gender, Pageable pageable){
        return userInfoRepository.findAllByGender(gender, pageable);
    }
    public Page<UserInfo> findAllByGenderPreference(String genderPreference, Pageable pageable){
        return userInfoRepository.findAllByGenderPreference(genderPreference, pageable);
    }
    public Page<UserInfo> findAllByCity(String city, Pageable pageable){
        return userInfoRepository.findAllByCity(city, pageable);
    }
    public Page<UserInfo> findAllByInterests(String interests, Pageable pageable){
        return userInfoRepository.findAllByInterests(interests, pageable);
    }
}
