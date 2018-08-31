package com.example.demo.main;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @ClassNmae AdapterTopic
 * @Description TODO
 * @Author PWT
 * @Date 2018/8/30 9:10
 * @Version 1.0
 **/
public class AdapterTopic {

    private String serverUrl = "tcp://47.100.9.160:61616";
    private String userName = "admin";
    private String password  = "admin";
    private String topicName = "topic.sylh";

    private Connection connection ;
    private Session session ;
    private Destination topic ;
    private MessageConsumer msgConsumer;

    private static AdapterTopic sender = new AdapterTopic();

    public AdapterTopic(){
    }

    public static AdapterTopic getInstance(){
        return sender;
    }


    public void createTopic(){

        try
        {
            ConnectionFactory factory = new ActiveMQConnectionFactory(serverUrl);
            connection = factory.createConnection(userName,password);
            connection.start();
            /* create the session */
            session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);

            topic = session.createTopic(topicName);
            /* create the producer */
            msgConsumer = session.createConsumer(topic);

            msgConsumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message msg) {

                    try {

                        TextMessage message = (TextMessage)msg ;
                        String reciveMessage = message.getText();
                        System.out.println("收到消息:"+message.getText());
                        String testMessage = "sydx#000000011CD1-km-11#0";
                        session.commit();
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    public void setServerUrl(String serverUrl)
    {
        this.serverUrl = serverUrl;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setTopicName(String topicName)
    {
        this.topicName = topicName;
    }

    public static void main(String[] args) {
        AdapterTopic s =new AdapterTopic();
        s.createTopic();
        System.out.println("out");
    }

}
