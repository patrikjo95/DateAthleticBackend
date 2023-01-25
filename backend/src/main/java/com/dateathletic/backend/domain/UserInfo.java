package com.dateathletic.backend.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String firstname;

    private String lastname;

    private String dob;

    private String bio;

    private String gender;

    private String interests;

    private String city;

    private String genderPreferences;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;



}
