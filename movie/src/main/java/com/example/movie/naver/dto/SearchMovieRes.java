package com.example.movie.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchMovieRes {

    private int total;
    private String lastBuildDate;//검색 결과를 생성한 시간
    private List<SearchMovieItem> items;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SearchMovieItem{
        private String title;
        private String link;
        private String image;
        private String subtitle;
        private String pubDate;//제작년도
        private String director;//감독
        private String actor;//검색 결과 영화의 출연배우
        private float userRating;//검색 결과 영화에 대한 유저들의 평점
    }
}
