package com.rainboz.top.rainboz_top.controller;

import com.alibaba.fastjson.JSONObject;
import com.rainboz.top.rainboz_top.dao.UserMapper;
import com.rainboz.top.rainboz_top.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static com.rainboz.top.wechat.menu.MenuMain.toObject;

/**
 * @program: ${CLASS_NAME}
 * @description: 接口开发
 * @author: rainboz
 * @create: 2018-09-06 10:11
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/getAllUser", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public String User(){
        String json  = "{\"name\":\"zhb\",\"pwd\":\"123456\"}";
        JSONObject obj=toObject(json, JSONObject.class);

        return obj.toJSONString();
    }
    @GetMapping(value = "/select")
    public User selectByPrimaryKey(){
        return userMapper.selectByPrimaryKey(1);
    }
    @GetMapping(value = "/insert")
    public int insertSelective(){
        User user = new User();
        user.setName("zg");
        user.setPassword("2154212");
        return userMapper.insertSelective(user);
    }
    @GetMapping(value = "/update")
    public int updateByPrimaryKeySelective(){
        User user = new User();
        user.setId(3);
        user.setName("zdg");
        user.setPassword("asdasda");
        return userMapper.updateByPrimaryKeySelective(user);
    }
    @GetMapping(value = "/delete")
    public int deleteByPrimaryKey(){

        return userMapper.deleteByPrimaryKey(3);
    }

}
