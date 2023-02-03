package com.dateathletic.backend.dto;

import com.dateathletic.backend.domain.UserProfileImg;

public record ImageUrlDto(
        String mainImg,
        String url1,
        String url2,
        String url3,
        String url4,
        String url5
) {

    public static void mapToEntityImageUrl(ImageUrlDto dto, UserProfileImg entity){
        entity.setMainImg(dto.mainImg);
        entity.setUrl1(dto.url1);
        entity.setUrl2(dto.url2);
        entity.setUrl3(dto.url3);
        entity.setUrl4(dto.url4);
        entity.setUrl5(dto.url5);
    }
}
