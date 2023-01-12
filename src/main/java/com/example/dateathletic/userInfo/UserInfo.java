package com.example.dateathletic.userInfo;

import com.example.dateathletic.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_info")
public class UserInfo {

    @Id
    @GeneratedValue
    private Long Id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;


}
