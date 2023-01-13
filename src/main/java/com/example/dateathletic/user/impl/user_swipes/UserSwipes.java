package com.example.dateathletic.user.impl.user_swipes;

import com.example.dateathletic.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//Erkan
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table
public class UserSwipes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long swiperId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "swiped_on_user")
    private Long swipedOnUser;

    @Column(name = "swiped_left")
    private Boolean swipedLeft;
}
