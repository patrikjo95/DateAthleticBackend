package com.dateathletic.backend.service;

import com.dateathletic.backend.domain.UserInfo;
import com.dateathletic.backend.dto.UpdateUserInfoDto;
import com.dateathletic.backend.repo.UserInfoRepository;
import com.dateathletic.backend.repo.UserInfoServiceRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

    @Service
    @RequiredArgsConstructor
    public class UserServiceInfo implements UserInfoServiceRepo {


        private final UserInfoRepository userInfoRepository;

        //public String findUserByfNameAndlName(String firstname, String lastname){
        //    return userInfoRepository.findUserByfNameAndlName(firstname, lastname);
        //}

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

        //public String findUserByGenderPreference(String genderpreference){
        //    return userInfoRepository.findUserByGenderPreference(genderpreference);
        //}

        public String findUserByCity(String city) {
            return userInfoRepository.findUserByCity(city);
        }

      @Override
        public void updateUserInfo(Long id, UpdateUserInfoDto dto) {

            UserInfo updatedUserInfo = userInfoRepository.findUserInfoById(id);

            updatedUserInfo.setFirstname(dto.firstname());
            updatedUserInfo.setLastname(dto.lastname());
            updatedUserInfo.setAge(dto.age());
            updatedUserInfo.setBio(dto.bio());
            updatedUserInfo.setGender(dto.gender());
            updatedUserInfo.setInterests(dto.interests());
            updatedUserInfo.setCity(dto.city());


            userInfoRepository.save(updatedUserInfo);

        }
    }



