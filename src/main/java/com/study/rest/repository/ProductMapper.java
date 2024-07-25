package com.study.rest.repository;

import com.study.rest.entity.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    int save(Product product); // 추상메소드 // 어디에 세이브 할건지 insert serelct는 전부 int로

}
