package com.dateathletic.backend.repo;

import com.dateathletic.backend.domain.Swipe;
import com.dateathletic.backend.domain.User;
import com.dateathletic.backend.dto.SwipeDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface SwipeRepository extends JpaRepository<Swipe, Long> {

    @Query(value = """
            SELECT (CASE WHEN COUNT(s) < 50 THEN true
            WHEN COUNT(s) = 50 AND (SELECT MAX(s.occurred_at) FROM Swipe s WHERE s.user.id = :userId AND s.cycle
            = (SELECT MAX(cycle) FROM Swipe WHERE user.id = :userId))
            < :timeAgo THEN true ELSE false END) FROM Swipe s WHERE s.user.id = :userId AND s.cycle
            = (SELECT MAX(cycle) FROM Swipe WHERE user.id = :userId)
            """)
    boolean canUserSwipe(@Param("userId") Long userId, @Param("timeAgo") Instant timeAgo);

    @Query(value = """
            SELECT 50 - COUNT(s) FROM Swipe s 
            WHERE s.user.id = :userId 
            AND s.cycle = (SELECT MAX(cycle) 
            FROM Swipe WHERE user.id = :userId)
            """)
    int findSwipesLeft(@Param("userId") Long userId);

    @Query("""
            SELECT u FROM User u
            WHERE u.id != :userId
            AND u.id NOT IN (SELECT m.friendId FROM Match m WHERE m.user.id = :userId)
            AND u.id NOT IN (SELECT s.swipedUserId FROM Swipe s WHERE s.user.id = :userId)
            ORDER BY RAND() LIMIT :limit
            """)
    List<User> findAvailableUsers(@Param("userId") Long userId, @Param("limit") int limit);

    @Query(name = "Swipe.hasThisUserBeenSwipedByThese", nativeQuery = true)
    List<SwipeDto> hasThisUserBeenSwipedByThese(Long userId, List<Long>userIds);
}
