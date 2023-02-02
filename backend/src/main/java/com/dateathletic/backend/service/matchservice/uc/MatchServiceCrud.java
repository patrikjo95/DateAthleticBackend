package com.dateathletic.backend.service.matchservice.uc;

import com.dateathletic.backend.domain.Match;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MatchServiceCrud{
    List<Match> getMatches(Long userId1, Long userId2);
    void deleteMatch(List<Match>match);

    Page<Match> findMyMatches(Long userId, Pageable pageable);
}
