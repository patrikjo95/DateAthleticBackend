package com.dateathletic.backend.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_info")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;

    private String lastname;

    private String age;

    private String bio;

    private String gender;

    private String interests;

    private String city;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
