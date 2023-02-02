package com.dateathletic.backend.domain;

import com.dateathletic.backend.dto.SwipeDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "user_swipes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SqlResultSetMapping(
        name="SwipeDtoMapping",
        classes={
                @ConstructorResult(
                        targetClass= SwipeDto.class,
                        columns={
                                @ColumnResult(name="swiper_id", type=Long.class),
                                @ColumnResult(name="swiped_right", type=Boolean.class)
                        }
                )
        }
)

@NamedNativeQuery(name = "Swipe.hasThisUserBeenSwipedByThese",
        query = "SELECT s.user_id as swiper_id, s.right_swipe as swiped_right " +
                "FROM user_swipes s WHERE s.swiped_user_id = :userId AND s.user_id IN :userIds",
        resultSetMapping = "SwipeDtoMapping"
)
public class Swipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Long swipedUserId;

    private boolean rightSwipe;

    private Instant occurred_at;
    private int cycle;
}
