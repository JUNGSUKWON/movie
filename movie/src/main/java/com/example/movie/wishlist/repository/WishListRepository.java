package com.example.movie.wishlist.repository;

import com.example.movie.db.MemoryDbRepositoryAbstract;
import com.example.movie.wishlist.entity.WishListEntity;
import org.springframework.stereotype.Repository;

@Repository
public class WishListRepository extends MemoryDbRepositoryAbstract<WishListEntity> {
}