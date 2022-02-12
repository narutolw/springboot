package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IDaoTest {

//    @Select("select count(1) from testtable")
    int queryDataCount();
}
