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

    @Column
    private String firstname;
@Column
    private String lastname;
@Column
    private String age;
@Column
    private String bio;
@Column
    private String gender;
     @Column
    private String interests;
@Column
    private String city;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
