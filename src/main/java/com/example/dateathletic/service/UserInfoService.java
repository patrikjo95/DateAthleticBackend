package com.example.dateathletic.service;
import com.example.dateathletic.model.UserInfo;
import com.example.dateathletic.repo.UserInfoRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserInfoService {
    private final UserInfoRepo repo;

    public void save(UserInfo userInfoEntity){
        repo.save(userInfoEntity);
    }
}
