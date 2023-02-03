package com.dateathletic.backend.repo;

import com.dateathletic.backend.domain.UserProfileImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileImgRepository extends JpaRepository<UserProfileImg, Long> {
}
