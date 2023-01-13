package com.example.dateathletic.user.impl.user_matches;

import com.example.dateathletic.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
//Erkan
@Entity
@Data
@AllArgsConstructor
public class UserMatches {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

    private Long matchedId;
}