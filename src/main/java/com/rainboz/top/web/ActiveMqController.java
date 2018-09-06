package com.rainboz.top.web;

import com.rainboz.top.main.AdapterTopic;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: StudyActiveMq
 * @description: ${description}
 * @author: ls
 * @create: 2018-08-31 11:36
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/activemq")
public class ActiveMqController {
    @RequestMapping(value = "/senderMsg", produces = "application/json;charset=UTF-8")
    @CrossOrigin
    public @ResponseBody
    void sender(){
        try {
             AdapterTopic.getInstance().createTopic();
        }catch (Exception e){
            e.printStackTrace();

        }
    }
    @RequestMapping(value = "/hello", produces = "application/json;charset=UTF-8")
    @CrossOrigin
    public @ResponseBody
    String hello(){
        return "hello spring boot";
    }
}
