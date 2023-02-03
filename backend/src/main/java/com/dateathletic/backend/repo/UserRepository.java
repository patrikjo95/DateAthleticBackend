package com.dateathletic.backend.repo;

import com.dateathletic.backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByUsernameOrEmail(String username, String email);
    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByEmail(String email);
    @Query(value = """
            SELECT u FROM User u WHERE u.id IN (:ids)
            """)
    List<User> getAllUsersWithIds(@Param(value = "ids") List<Long> ids);
}

