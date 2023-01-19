package com.dateathletic.backend.service;

import com.dateathletic.backend.repo.UserInfoRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInfoService {
    private final UserInfoRepository userInfoRepository;

    public String findUserByfNameAndlName(String firstname, String lastname){
        return userInfoRepository.findUserByfNameAndlName(firstname, lastname);
    }

    public String findUserByInterest(String interest){
        return userInfoRepository.findUserByInterest(interest);
    }

    public String findUserByDob(String dob){
        return userInfoRepository.findUserByDob(dob);
    }

    public String findUserByPreference_gender(String preference_gender){
        return userInfoRepository.findUserByPreference_gender(preference_gender);
    }

    public String findUserByCity(String city){
        return userInfoRepository.findUserByCity(city);
    }
}
