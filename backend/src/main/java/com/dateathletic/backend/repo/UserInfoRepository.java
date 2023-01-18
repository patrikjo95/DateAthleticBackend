package com.dateathletic.backend.repo;

import com.dateathletic.backend.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    String findUserByfNameAndlName(String firstname, String lastname);

    String findUserByInterest(String interest);

    String findUserByAge(String dob);

    String findUserByPreference_gender(String preference_gender);

    String findUserByCity(String city);

}

