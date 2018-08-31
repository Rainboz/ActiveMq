package com.example.demo.main;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @program: StudyActiveMq
 * @description: ${description}
 * @author: ls
 * @create: 2018-08-31 15:08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class producerTest {
    @org.junit.Test
    public void send() throws Exception {
//        Producer send = new Producer();
//        send.send();
        System.out.println("send out");
    }

}