package com.example.demo.main;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @program: StudyActiveMq
 * @description: ${description}
 * @author: ls
 * @create: 2018-08-31 11:22
 */
public class TopicSend {
    public static void main(String[] args) throws JMSException, InterruptedException {
        try {

        }catch (Exception e){

        }
        // ConnectionFactory ：连接工厂，JMS 用它创建连接
        //61616是ActiveMQ默认端口
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnection.DEFAULT_USER,
                ActiveMQConnection.DEFAULT_PASSWORD,
                "tcp://47.100.9.160:61616");

        // Connection ：JMS 客户端到JMS Provider 的连接
        Connection connection =  connectionFactory.createConnection();

        connection.start();
        // Session： 一个发送或接收消息的线程
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // Destination ：消息的目的地;消息发送给谁.
        //Destination destination =  session.createQueue("my-queue");
        Destination destination = session.createTopic("STOCKS.myTopic"); //创建topic   myTopic
        // MessageProducer：消息发送者
        MessageProducer producer =  session.createProducer(destination);

        // 设置不持久化，可以更改
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

        for(int i=0;i<10;i++){
            //创建文本消息
            TextMessage message = session.createTextMessage("hello.I am producer, this is a test message"+i);
            //发送消息
            producer.send(message);
        }

        session.commit();
        session.close();
        connection.close();
    }



}
