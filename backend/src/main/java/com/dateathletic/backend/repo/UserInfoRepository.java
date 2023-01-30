package com.dateathletic.backend.repo;

import com.dateathletic.backend.domain.User;
import com.dateathletic.backend.domain.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    //String findUserByfNameAndlName(String firstname, String lastname);

    Optional<UserInfo> findUserByFirstname(String firstname);

    Optional<UserInfo> findUserByLastname(String lastname);
    String findUserByInterests(String interests);

    String findUserByDoB(String doB);

    List<Optional<User>> findUserByGender(String genderPreference);

    String findUserByCity(String city);

    //Page<UserInfo> findAllByFirstname(String firstname, Pageable pageable);

}

