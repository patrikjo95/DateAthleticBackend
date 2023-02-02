package com.dateathletic.backend.service.swipeservice;

import com.dateathletic.backend.domain.Match;
import com.dateathletic.backend.domain.Swipe;
import com.dateathletic.backend.domain.User;
import com.dateathletic.backend.dto.CompletedSwipesData;
import com.dateathletic.backend.dto.CompletedSwipesDto;
import com.dateathletic.backend.dto.SwipeDto;
import com.dateathletic.backend.repo.SwipeRepository;
import com.dateathletic.backend.service.swipeservice.uc.SwipeInterface;
import com.dateathletic.backend.service.userservice.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

import static java.time.Instant.now;
import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
public class SwipeService implements SwipeInterface {
    private final SwipeRepository swipeRepository;
    private final UserService userService;
    @Override
    public boolean canUserSwipe(Long id, Instant timeAgo) {
        return swipeRepository.canUserSwipe(id, timeAgo);
    }
    @Override
    public int countAmountOfSwipes(Long id) {
        return swipeRepository.findSwipesLeft(id);
    }
    @Override
    public int swipesLeft(Long userid) {
        return swipeRepository.findSwipesLeft(userid);
    }

    @Override
    public List<User> getSwipes(Long id, Integer limit) {
        return swipeRepository.findAvailableUsers(id, limit);
    }

    @Override
    public List<SwipeDto> hasThisUserBeenSwipedOnByThese(Long userId, List<Long> userIds) {
       return swipeRepository.hasThisUserBeenSwipedByThese(userId, userIds);
    }
    @Override
    public void processSwipes(CompletedSwipesDto dto) {
        if(dto != null){
            List<Swipe>processedSwipes;
            long userId = dto.userId();
            User user = userService.getUserById(userId).get();
            int cycle = swipeRepository.findMaxCycleByUserId(userId);
            processedSwipes = dto.data().stream().map(
                    data -> {
                        Swipe swipe = new Swipe();
                        swipe.setCycle(cycle);
                        swipe.setOccurred_at(now());
                        swipe.setUser(user);
                        swipe.setSwipedUserId(data.swipedUserId());
                        swipe.setRightSwipe(data.match());

                        createMatch(userId, user, data);
                        return swipe;
                    }).collect(toList());

            swipeRepository.saveAll(processedSwipes);
        }
    }

    protected void createMatch(long userId, User user, CompletedSwipesData data) {
        if (data.match()){
            User newMatch = userService.getUserById(data.swipedUserId()).get();

            Match m1 = new Match();
            Match m2 = new Match();
            m1.setUser(user);
            m1.setMatchId(data.swipedUserId());
            m2.setUser(newMatch);
            m2.setMatchId(userId);

            user.getMatches().add(m1);
            newMatch.getMatches().add(m2);

            userService.processSwipes(List.of(user, newMatch));
        }
    }
}
