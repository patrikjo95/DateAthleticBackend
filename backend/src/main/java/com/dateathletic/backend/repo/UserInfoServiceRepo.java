package com.dateathletic.backend.repo;

import com.dateathletic.backend.dto.UpdateUserInfoDto;

public interface UserInfoServiceRepo {

    void updateUserInfo(Long id, UpdateUserInfoDto dto);





}
