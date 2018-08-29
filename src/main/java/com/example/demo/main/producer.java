package com.example.demo.main;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @program: StudyActiveMq
 * @description: ${description}
 * @author: ls
 * @create: 2018-08-29 18:18
 */
@Component
@EnableScheduling
public class producer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private ActiveMQQueue queue;
    @Autowired
    private ActiveMQTopic topic;
    private static int count= 0;
    @Scheduled(fixedDelay=3000)
    public void send(){
        this.jmsMessagingTemplate.convertAndSend(this.queue,"hi.activeMQ,index="+count);
        this.jmsMessagingTemplate.convertAndSend(this.topic,"hi,activeMQ( topic ),index="+count++);
    }
}
