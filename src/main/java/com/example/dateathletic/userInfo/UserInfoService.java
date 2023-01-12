package com.example.dateathletic.userInfo;
import com.example.dateathletic.userInfo.UserInfo;
import com.example.dateathletic.userInfo.UserInfoRepo;
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
