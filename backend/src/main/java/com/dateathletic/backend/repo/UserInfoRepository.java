package com.dateathletic.backend.repo;

import com.dateathletic.backend.domain.User;
import com.dateathletic.backend.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    //String findUserByfNameAndlName(String firstname, String lastname);

    String findUserByFirstname(String firstname);

    String findUserByLastname(String lastname);

    String findUserByInterests(String interests);

    String findUserByDob(String dob);

    List<Optional<User>> findUserByGender(String genderpreference);

    String findUserByCity(String city);

}

