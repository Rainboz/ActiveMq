package com.example.demo.web;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class Ak {
    //templates动态页面
    @GetMapping("/templates")
    String test(HttpServletRequest request) {
        //逻辑处理
        request.setAttribute("key", "hello world");
        return "/index";
    }
    //重定向至static下页面
    @GetMapping("/all")
    public String html() {
        return "redirect:/all.html";
    }
}
