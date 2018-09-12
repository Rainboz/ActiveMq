package com.rainboz.top.rainboz_top.controller;

import com.rainboz.top.rainboz_top.dao.UserMapper;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @RequestMapping(value = "/login")
    public String Login(@RequestParam(required = true) String user_account,
                        @RequestParam(required = true) String password){

        if (userMapper.)
    }
}
