package com.example.demo.main;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class AdapterTopicSender {
	private String serverUrl = "tcp://47.100.9.160:61616";
    private String userName = "admin";
    private String password  = "admin";
    private String topicName = "topic.sylh";

    private TopicConnection connection;
    private Session session ;
    private Topic topic ;
    private MessageProducer msgProducer;
    
    private static AdapterTopicSender sender = new AdapterTopicSender();
    
    public AdapterTopicSender(){
    }
    
    public static AdapterTopicSender getInstance(){
      return sender;
    }
    
    
    public void createTopic(){
   
      try
      {
        TopicConnectionFactory factory = new ActiveMQConnectionFactory(serverUrl);
        connection = factory.createTopicConnection(userName,password);
        /* create the session */
        session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
   
        topic = session.createTopic(topicName);
        /* create the producer */
        msgProducer = session.createProducer(topic);

        msgProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
      }
      catch(Exception e)
      {
          e.printStackTrace();
      }
    }
  
     public void sendMessage(String message)
    {
      try
      {
  
        if (connection == null || session == null || topic == null)
        {
          createTopic();
        }
  
        if (topic != null)
        {
            TextMessage   msg = session.createTextMessage();
            msg.setText(message);
           /* publish message */
            msgProducer.send(msg);
          System.out.println("factory= send="+msgProducer);
            session.commit();
        }
      }
      catch (Exception e)
      {
        try
        {
          if (connection != null)
            connection.close();
          if (session == null)
            session.close();
          if (topic != null)
            topic = null;
        }
        catch (Exception ex)
        {
        }
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
        AdapterTopicSender sender =new AdapterTopicSender();
        for (int i = 0; i < 10; i++) {
            sender.sendMessage("sylh#154554643134");
        }

        System.out.println("send out");
    }

}
