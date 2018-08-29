package com.example.demo.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;

/**
 * @program: StudyActiveMq
 * @description: ${description}
 * @author: ls
 * @create: 2018-08-29 18:12
 */
@Configuration
public class MqConfig {
    @Bean
    public ActiveMQQueue queue(){
        return new ActiveMQQueue("mvp.queue");
    }
    @Bean
    public ActiveMQTopic topic(){
        return new ActiveMQTopic("mvp.topic");
    }
    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory("admin", "admin", "tcp://47.100.9.160:61616");
    }
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ActiveMQConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(connectionFactory);
        return bean;
    }
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerQueue(ActiveMQConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setConnectionFactory(connectionFactory);
        return bean;
    }
    @Bean
    public JmsMessagingTemplate jmsMessagingTemplate(ActiveMQConnectionFactory connectionFactory){
        return new JmsMessagingTemplate(connectionFactory);
    }
}
