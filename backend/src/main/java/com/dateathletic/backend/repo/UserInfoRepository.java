package com.dateathletic.backend.repo;

import com.dateathletic.backend.domain.User;
import com.dateathletic.backend.domain.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {

    Optional<UserInfo> findUserByFirstname(String firstname);

    Optional<UserInfo> findUserByLastname(String lastname);
    String findUserByInterests(String interests);

    String findUserByDoB(String doB);

    List<Optional<User>> findUserByGender(String genderPreference);

    String findUserByCity(String city);

    Page<UserInfo> findAllByFirstname(String firstname, Pageable pageable);

    Page<UserInfo> findAllByDoB(String doB, Pageable pageable);

    Page<UserInfo> findAllByLastname(String lastname, Pageable pageable);

    Page<UserInfo> findAllByGender(String gender, Pageable pageable);

    Page<UserInfo> findAllByGenderPreference(String genderPreference, Pageable pageable);

    Page<UserInfo> findAllByCity(String city, Pageable pageable);

    Page<UserInfo> findAllByInterests(String interests, Pageable pageable);
}

