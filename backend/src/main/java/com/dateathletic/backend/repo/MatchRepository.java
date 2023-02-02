package com.dateathletic.backend.repo;

import com.dateathletic.backend.domain.Match;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long>, PagingAndSortingRepository<Match, Long> {
    @Query(value = """
            SELECT m FROM Match m WHERE m.user.id IN (:userId1, :userId2)
            AND m.matchId IN (:userId1, :userId2)
            """)
    List<Match> getMatch(Long userId1, Long userId2);

    @Query(value = """
            SELECT m FROM Match m WHERE matchId = :userId
            """)
    Page<Match> findUsersMatches(@Param("userId") Long userId, Pageable pageable);
}
