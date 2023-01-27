package com.dateathletic.backend.service.swipeservice;

import com.dateathletic.backend.domain.Swipe;
import com.dateathletic.backend.domain.User;
import com.dateathletic.backend.dto.SwipeDto;
import com.dateathletic.backend.repo.SwipeRepository;
import com.dateathletic.backend.service.swipeservice.uc.SwipeInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@AllArgsConstructor
public class SwipeService implements SwipeInterface {
    private final SwipeRepository repository;
    public void save(List<Swipe> swipeList){
        repository.saveAll(swipeList);
    }
    @Override
    public boolean canUserSwipe(Long id, Instant timeAgo) {
        return repository.canUserSwipe(id, timeAgo);
    }
    @Override
    public int countAmountOfSwipes(Long id) {
        return repository.findSwipesLeft(id);
    }
    @Override
    public int swipesLeft(Long userid) {
        return repository.findSwipesLeft(userid);
    }
    @Override
    public List<User> getSwipes(Long id, Integer limit) {
        return repository.findAvailableUsers(id, limit);
    }

    @Override
    public List<SwipeDto> hasThisUserBeenSwipedOnByThese(Long userId, List<Long> userIds) {
       return repository.hasThisUserBeenSwipedByThese(userId, userIds);
    }
}
