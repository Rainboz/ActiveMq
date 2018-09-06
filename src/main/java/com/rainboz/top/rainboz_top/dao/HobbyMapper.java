package com.rainboz.top.rainboz_top.dao;

import com.rainboz.top.rainboz_top.entity.Hobby;

public interface HobbyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hobby record);

    int insertSelective(Hobby record);

    Hobby selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hobby record);

    int updateByPrimaryKey(Hobby record);
}