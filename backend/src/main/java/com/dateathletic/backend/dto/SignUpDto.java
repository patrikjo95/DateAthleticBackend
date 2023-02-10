package com.dateathletic.backend.dto;

import com.dateathletic.backend.domain.User;
import com.dateathletic.backend.domain.UserInfo;
import com.dateathletic.backend.domain.UserProfileImg;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.dateathletic.backend.BackendApplication.USER_ROLE;
import static com.dateathletic.backend.dto.ImageUrlDto.mapToEntityImageUrl;

public record SignUpDto(
        @NonNull
        String username,
        @NonNull
        String email,
        @NonNull
        String password,
        @NonNull
        String firstname,
        @NonNull
        String lastname,
        @NonNull
        String doB,
        @NonNull
        String city,
        @Nullable
        String bio,
        @NonNull
        String interests,
        @NonNull
        String gender,
        @NonNull
        String genderPreference,
        @NonNull
        ImageUrlDto imageUrlsDto
) {
        public static void mapDtoToUser(SignUpDto dto, User user, PasswordEncoder passwordEncoder){
                UserInfo userInfo = new UserInfo();
                UserProfileImg userProfileImg = new UserProfileImg();

                user.setUsername(dto.username());
                user.setEmail(dto.email());
                user.setPassword(passwordEncoder.encode(dto.password()));
                user.setRole(USER_ROLE);

                userInfo.setFirstname(dto.firstname());
                userInfo.setLastname(dto.lastname());
                userInfo.setDoB(dto.doB());
                userInfo.setCity(dto.city());
                userInfo.setBio(dto.bio());
                userInfo.setInterests(dto.interests());
                userInfo.setGender(dto.gender());
                userInfo.setGenderPreference(dto.genderPreference);

                mapToEntityImageUrl(dto.imageUrlsDto(), userProfileImg);

                user.setProfileImg(userProfileImg);
                userProfileImg.setUser(user);

                user.setUserInfo(userInfo);
                userInfo.setUser(user);


        }
}
