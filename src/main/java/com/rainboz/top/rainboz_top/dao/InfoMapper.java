package com.rainboz.top.rainboz_top.dao;

import com.rainboz.top.rainboz_top.entity.Info;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface InfoMapper {
    @Delete({
        "delete from info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into info (id, age, ",
        "name)",
        "values (#{id,jdbcType=INTEGER}, #{age,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR})"
    })
    int insert(Info record);

    int insertSelective(Info record);

    @Select({
        "select",
        "id, age, name",
        "from info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("com.rainboz.top.rainboz_top.dao.InfoMapper.BaseResultMap")
    Info selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Info record);

    @Update({
        "update info",
        "set age = #{age,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Info record);
}