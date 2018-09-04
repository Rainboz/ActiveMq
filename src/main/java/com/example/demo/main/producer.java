package com.example.demo.main;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * @program: StudyActiveMq
 * @description: ${description}
 * @author: ls
 * @create: 2018-08-29 18:18
 */
@Component
@EnableScheduling
public class Producer {
//    @Autowired
//    private JmsMessagingTemplate jmsMessagingTemplate;
//    @Autowired
//    private ActiveMQQueue queue;
//    @Autowired
//    private ActiveMQTopic topic;
//    private static int count= 0;
//    @Scheduled(fixedDelay=3000)
//    public void send(){
//        //this.jmsMessagingTemplate.convertAndSend(this.queue,"hi.activeMQ,index="+count);
//        this.jmsMessagingTemplate.convertAndSend(this.topic,"#sydx#100|11213|dasd,index="+count++);
//    }
}
