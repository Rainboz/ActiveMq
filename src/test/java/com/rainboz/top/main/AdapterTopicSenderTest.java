package com.rainboz.top.main;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @program: StudyActiveMq
 * @description: ${description}
 * @author: ls
 * @create: 2018-08-31 15:25
 */
@EnableScheduling
public class AdapterTopicSenderTest {


    @org.junit.Test
    @Scheduled(fixedDelay=3000)
    public void sendMessage() throws Exception {
        AdapterTopicSender sender =new AdapterTopicSender();
        sender.sendMessage("sylh#154554643134");
        System.out.println("send out");
    }

}