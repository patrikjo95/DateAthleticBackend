package com.dateathletic.backend.repo;

import com.dateathletic.backend.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    //String findUserByfNameAndlName(String firstname, String lastname);

    String findUserByFirstname(String firstname);

    String findUserByLastname(String lastname);

    String findUserByInterests(String interests);

    String findUserByDob(String dob);

    //String findUserByGenderPreference(String genderpreference);

    String findUserByCity(String city);

}
