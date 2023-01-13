package com.example.dateathletic.user.impl.userInfo;
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
