package com.dateathletic.backend.service.matchservice.uc;

import com.dateathletic.backend.domain.Match;

import java.util.List;

public interface MatchServiceCrud {
    List<Match> getMatches(Long userId1, Long userId2);
    void deleteMatch(List<Match>match);

}
