package com.dateathletic.backend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;
import static java.util.List.of;

@Entity
@Table(name = "user_images")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileImg {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String mainImg;
    private String url1;
    private String url2;
    private String url3;
    private String url4;
    private String url5;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public List<String> getImagePaths(){
        return of(mainImg, url1, url2, url3, url4, url5);
    }
}
