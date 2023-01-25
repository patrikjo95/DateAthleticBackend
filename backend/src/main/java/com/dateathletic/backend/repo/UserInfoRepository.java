package com.dateathletic.backend.repo;

import com.dateathletic.backend.domain.User;
import com.dateathletic.backend.domain.UserInfo;
import com.dateathletic.backend.dto.UpdateUserInfoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    String findUserByFirstname(String firstname);

    String findUserByLastname(String lastname);

    String findUserByInterests(String interests);

    String findUserByDob(String dob);

    String findUserByCity(String city);

    UserInfo findUserInfoById(Long id);

}
