package com.rainboz.top.rainboz_top.dao;

import com.rainboz.top.rainboz_top.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
    @Delete({
        "delete from user",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer userId);

    @Insert({
        "insert into user (user_id, user_account, ",
        "user_password, user_phone, ",
        "user_sex, user_age, user_avatar, ",
        "gmt_create, gmt_modified)",
        "values (#{userId,jdbcType=INTEGER}, #{userAccount,jdbcType=CHAR}, ",
        "#{userPassword,jdbcType=CHAR}, #{userPhone,jdbcType=CHAR}, ",
        "#{userSex,jdbcType=CHAR}, #{userAge,jdbcType=TINYINT}, #{userAvatar,jdbcType=VARCHAR}, ",
        "#{gmtCreate,jdbcType=TIMESTAMP}, #{gmtModified,jdbcType=TIMESTAMP})"
    })
    int insert(User record);

    int insertSelective(User record);

    @Select({
        "select",
        "user_id, user_account, user_password, user_phone, user_sex, user_age, user_avatar, ",
        "gmt_create, gmt_modified",
        "from user",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    @ResultMap("com.rainboz.top.rainboz_top.dao.UserMapper.BaseResultMap")
    User selectByPrimaryKey(Integer userId);

    @Select({

            "select",
            "user_id, user_account, user_password, user_phone",
            "gmt_create, gmt_modified",
            "from user",
            "where user_account = #{userAccount,jdbcType=CHAR}"
    })
    User
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update user",
        "set user_account = #{userAccount,jdbcType=CHAR},",
          "user_password = #{userPassword,jdbcType=CHAR},",
          "user_phone = #{userPhone,jdbcType=CHAR},",
          "user_sex = #{userSex,jdbcType=CHAR},",
          "user_age = #{userAge,jdbcType=TINYINT},",
          "user_avatar = #{userAvatar,jdbcType=VARCHAR},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modified = #{gmtModified,jdbcType=TIMESTAMP}",
        "where user_id = #{userId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}