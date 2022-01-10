package com.example.movie.wishlist.service;

import com.example.movie.naver.NaverClient;
import com.example.movie.naver.dto.SearchImageReq;
import com.example.movie.naver.dto.SearchMovieReq;
import com.example.movie.wishlist.repository.WishListRepository;
import com.example.movie.wishlist.dto.WishListDto;
import com.example.movie.wishlist.entity.WishListEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WishListService {

    private final NaverClient naverClient;
    private final WishListRepository wishListRepository;

    public WishListDto search(String query){

        //영화 검색
        var searchMoiveReq = new SearchMovieReq();
        searchMoiveReq.setQuery(query);
        var searchMovieRes = naverClient.searchMovie(searchMoiveReq);

        if(searchMovieRes.getTotal()>0){
            var movieItem = searchMovieRes.getItems().stream().findFirst().get();
            var imageQuery = movieItem.getTitle().replaceAll("<[^>]*>","");
            var searchImageReq = new SearchImageReq();
            searchImageReq.setQuery(imageQuery);

            // 이미지 검색
            var searchImageRes = naverClient.searchImage(searchImageReq);

            if(searchImageRes.getTotal()>0){
                var imageItem = searchImageRes.getItems().stream().findFirst().get();

                // 결과를 리턴
                /*

    private String title;
    private String link;
    private String image;
    private String subtitle;

    private String pubDate;//제작년도
    private String director;//감독
    private String actor;//검색 결과 영화의 출연배우
    private int userRating;//검색 결과 영화에 대한 유저들의 평점

                 */
                var result = new WishListDto();
                result.setTitle(movieItem.getTitle());
                result.setLink(movieItem.getLink());
                result.setImage(movieItem.getImage());
                result.setSubtitle(movieItem.getSubtitle());
                result.setActor(movieItem.getActor());
                result.setDirector(movieItem.getDirector());
                result.setPubDate(movieItem.getPubDate());
                result.setUserRating((int) movieItem.getUserRating());


                return result;
            }
        }
        return new WishListDto();
    }

    public WishListDto add(WishListDto wishListDto) {
        var entity = dtoToEntity(wishListDto);
        var saveEntity = wishListRepository.save(entity);
        return entityToDto(saveEntity);
    }

    private WishListEntity dtoToEntity(WishListDto wishListDto){
        var entity = new WishListEntity();
        entity.setIndex(wishListDto.getIndex());
        entity.setTitle(wishListDto.getTitle());
        entity.setLink(wishListDto.getLink());
        entity.setImage(wishListDto.getImage());
        entity.setSubtitle(wishListDto.getSubtitle());
        entity.setHomePageLink(wishListDto.getHomePageLink());
        entity.setImageLink(wishListDto.getImageLink());
        entity.setViewCount(wishListDto.getViewCount());
        entity.setView(wishListDto.isView());
        entity.setPubDate(wishListDto.getPubDate());
        entity.setDirector(wishListDto.getDirector());
        entity.setActor(wishListDto.getActor());
        entity.setUserRating(wishListDto.getUserRating());

        return entity;
    }

    private WishListDto entityToDto(WishListEntity wishListEntity){
        var dto = new WishListDto();
        dto.setIndex(wishListEntity.getIndex());
        dto.setTitle(wishListEntity.getTitle());
        dto.setLink(wishListEntity.getLink());
        dto.setImage(wishListEntity.getImage());
        dto.setSubtitle(wishListEntity.getSubtitle());
        dto.setHomePageLink(wishListEntity.getHomePageLink());
        dto.setImageLink(wishListEntity.getImageLink());
        dto.setView(wishListEntity.isView());
        dto.setViewCount(wishListEntity.getViewCount());
        dto.setPubDate(wishListEntity.getPubDate());
        dto.setDirector(wishListEntity.getDirector());
        dto.setActor(wishListEntity.getActor());
        dto.setUserRating(wishListEntity.getUserRating());

        return dto;
    }

    public List<WishListDto> findAll() {
        return wishListRepository.findAll()
                .stream()
                .map(it -> entityToDto(it))
                .collect(Collectors.toList());
    }

    public void delete(int index) {

        wishListRepository.deleteById(index);
    }

    public void addVisit(int index){
        var wishItem = wishListRepository.findById(index);
        if(wishItem.isPresent()){
            var item = wishItem.get();
            item.setView(true);
            item.setViewCount(item.getViewCount()+1);
        }
    }
}
