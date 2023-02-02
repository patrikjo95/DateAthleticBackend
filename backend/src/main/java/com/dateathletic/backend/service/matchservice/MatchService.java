package com.dateathletic.backend.service.matchservice;

import com.dateathletic.backend.domain.Match;
import com.dateathletic.backend.repo.MatchRepository;
import com.dateathletic.backend.service.matchservice.uc.MatchServiceCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchService implements MatchServiceCrud {
    private final MatchRepository matchRepository;
    @Override
    public List<Match> getMatches(Long userId1, Long userId2) {
        return matchRepository.getMatch(userId1, userId2);
    }

    @Override
    public void deleteMatch(List<Match> match) {
        matchRepository.deleteAll(match);
    }
}
