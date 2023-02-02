package com.dateathletic.backend.repo;

import com.dateathletic.backend.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByUsernameOrEmail(String username, String email);
    Optional<User> findUserByUsername(String username);
    Optional<User> findUserByEmail(String email);
    Page<User> findAllByUsername(String username, Pageable pageable);

    @Query(value = """
            SELECT u FROM User u WHERE u.id IN (:ids)
            """)
    List<User> getAllUsersWithIds(@Param(value = "ids") List<Long> ids);
}
