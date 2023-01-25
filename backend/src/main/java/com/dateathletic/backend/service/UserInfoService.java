package com.dateathletic.backend.service;

import com.dateathletic.backend.domain.User;
import com.dateathletic.backend.domain.UserInfo;
import com.dateathletic.backend.repo.UserInfoRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserInfoService {
    private final UserInfoRepository userInfoRepository;

    //public String findUserByfNameAndlName(String firstname, String lastname){
    //    return userInfoRepository.findUserByfNameAndlName(firstname, lastname);
    //}

    public String findUserByFirstname(String firstname){
        return userInfoRepository.findUserByFirstname(firstname);
    }

    public String findUserByLastname(String lastname){
        return userInfoRepository.findUserByLastname(lastname);
    }

    public String findUserByInterests(String interests){
        return userInfoRepository.findUserByInterests(interests);
    }

    public String findUserByDob(String dob){
        return userInfoRepository.findUserByDob(dob);
    }

    public List<Optional<User>> findUserByGender(String genderPreference){
        return userInfoRepository.findUserByGender(genderPreference);
    }

    public String findUserByCity(String city){
        return userInfoRepository.findUserByCity(city);
    }

    Pageable firstPageWithTwoElements = PageRequest.of(0, 2);}
