package com.example.movie.naver.dto;

import lombok.Data;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Data
public class SearchMovieReq {

    private String query = "";
    private int display = 10;
    private int start = 1;

//    private String sort = "random";

    private String genre ="";
    private String country ="";
    private String yearfrom="" ;
    private String yearto="";

    public MultiValueMap<String, String> toMultiValueMap(){
        var map = new LinkedMultiValueMap<String, String>();
        map.add("query",query);
        map.add("display",String.valueOf(display));
        map.add("start", String.valueOf(start));
        map.add("genre",genre);
        map.add("country",country);
        map.add("yearform",yearfrom);
        map.add("yearto",yearto);
        return map;
    }

}
