package com.example.movie.wishlist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WishListDto {//위시리스트

    private Integer index;
    private String title;
    private String link;
    private String image;
    private String subtitle;
    private String homePageLink;   // 홈페이지 주소
    private String imageLink;     //이미지 주소
    private boolean isView;//본 영화인지 체크여부
    private int viewCount;// 영화를 본 횟수
    private String pubDate;//제작년도
    private String director;//감독
    private String actor;//검색 결과 영화의 출연배우
    private Integer userRating;//검색 결과 영화에 대한 유저들의 평점


}
