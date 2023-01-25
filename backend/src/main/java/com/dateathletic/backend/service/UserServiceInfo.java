package com.dateathletic.backend.service;

import com.dateathletic.backend.domain.UserInfo;
import com.dateathletic.backend.dto.UpdateUserInfoDto;
import com.dateathletic.backend.repo.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

    @Service
    @RequiredArgsConstructor
    public class UserServiceInfo {


        private final UserInfoRepository userInfoRepository;



        public String findUserByFirstname(String firstname) {
            return userInfoRepository.findUserByFirstname(firstname);
        }

        public String findUserByLastname(String lastname) {
            return userInfoRepository.findUserByLastname(lastname);
        }

        public String findUserByInterests(String interests) {
            return userInfoRepository.findUserByInterests(interests);
        }

        public String findUserByDob(String dob) {
            return userInfoRepository.findUserByDob(dob);
        }



        public String findUserByCity(String city) {
            return userInfoRepository.findUserByCity(city);
        }

        public void updateUserInfo(Long id, UpdateUserInfoDto dto) {

            UserInfo updatedUserInfo = userInfoRepository.findUserInfoById(id);

            updatedUserInfo.setFirstname(dto.firstname());
            updatedUserInfo.setLastname(dto.lastname());
            updatedUserInfo.setDob(dto.dob());
            updatedUserInfo.setBio(dto.bio());
            updatedUserInfo.setGender(dto.gender());
            updatedUserInfo.setInterests(dto.interests());
            updatedUserInfo.setCity(dto.city());


            userInfoRepository.save(updatedUserInfo);

        }
    }



