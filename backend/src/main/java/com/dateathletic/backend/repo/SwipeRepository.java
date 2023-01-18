package com.dateathletic.backend.repo;

import com.dateathletic.backend.domain.Swipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwipeRepository extends JpaRepository<Swipe, Long> {
}
