package com.example.movie.naver.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchImageRes {

    private String lastBuildDate;
    private int total;
    private int start;
    private int display;
    private List<SearchImageItem> items;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SearchImageItem {
        private String title;
        private String link;
        private String thumbnail;//썸네일
        private String sizeheight;//높이
        private String sizewidth;//넓이
    }
}