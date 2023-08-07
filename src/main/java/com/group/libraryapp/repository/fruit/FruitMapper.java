package com.group.libraryapp.repository.fruit;

import com.group.libraryapp.controller.user.Fruit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface FruitMapper {

    @Select("SELECT * FROM fruit")
    List<Fruit> findAll();

    @Select("SELECT * FROM fruit WHERE name = #{name}")
    List<Fruit> findByName(@Param("name") String name);
}
