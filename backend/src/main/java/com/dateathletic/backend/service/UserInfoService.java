package com.dateathletic.backend.service;

import com.dateathletic.backend.repo.UserInfoRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

        //public String findUserByGenderPreference(String genderpreference){
        //    return userInfoRepository.findUserByGenderPreference(genderpreference);
        //}

        public String findUserByCity(String city){
            return userInfoRepository.findUserByCity(city);
        }
    }



