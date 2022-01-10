package com.example.movie.naver;

import com.example.movie.naver.dto.SearchImageReq;
import com.example.movie.naver.dto.SearchMovieReq;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;


@SpringBootTest
public class NaverClientTest {

    @Autowired
    private NaverClient naverClient;

    @Test
    public void searchMovieTest(){

        var search = new SearchMovieReq();
        search.setQuery("지옥");

        var result = naverClient.searchMovie(search);
        System.out.println(result);
//        Assertions.assertNotNull(result.getItems().stream().findFirst().get().getDirector());
    }

    @Test
    public void searchImageTest(){
        var search = new SearchImageReq();
        search.setQuery("오징어게임");

        var result = naverClient.searchImage(search);
        System.out.println(result);
    }
}
