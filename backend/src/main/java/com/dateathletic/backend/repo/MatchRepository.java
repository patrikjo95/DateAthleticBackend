package com.dateathletic.backend.repo;

import com.dateathletic.backend.domain.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MatchRepository extends JpaRepository<Match, Long> {
    @Query(value = """
            SELECT m FROM Match m WHERE m.user.id IN (:userId1, :userId2)
            AND m.matchId IN (:userId1, :userId2)
            """)
    public List<Match> getMatch(Long userId1, Long userId2);
}
