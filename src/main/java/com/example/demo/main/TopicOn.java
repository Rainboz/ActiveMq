package com.example.demo.main;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @program: StudyActiveMq
 * @description: ${description}
 * @author: ls
 * @create: 2018-08-31 11:24
 */
public class TopicOn {
    private static ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
            ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");

    public void run() {
        // Connection ：JMS 客户端到JMS Provider 的连接
        try {
            final Connection connection = connectionFactory.createConnection();

            connection.start();
            // Session： 一个发送或接收消息的线程
            final Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            // Destination ：消息的目的地;消息送谁那获取.
            // Destination destination = session.createQueue("my-queue");
            Destination destination = session.createTopic("STOCKS.myTopic"); // 创建topic
            // myTopic
            // 消费者，消息接收者
            MessageConsumer consumer1 = session.createConsumer(destination);

            consumer1.setMessageListener(new MessageListener() {

                public void onMessage(Message msg) {

                    try {

                        TextMessage message = (TextMessage) msg;
                        System.out.println("consumerOne收到消息： " + message.getText());
                        session.commit();
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }

                }
            });

            // 再来一个消费者，消息接收者
            MessageConsumer consumer2 = session.createConsumer(destination);

            consumer2.setMessageListener(new MessageListener() {
                public void onMessage(Message msg) {

                    try {

                        TextMessage message = (TextMessage) msg;
                        System.out.println("consumerTwo收到消息： " + message.getText());
                        session.commit();
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }

                }
            });
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        TopicOn topicOn =new TopicOn();
        topicOn.run();
    }
}
