/*
 * Created on 8 déc. 2004
 */
package fr.umlv.ir3.flexitime.abouvet;


import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;


/**
 * @author diam
 */
public class Testouille {

    public static void main(String[] args) {
        System.out.println("hey !");
                
        //In order to use either of the JMS messaging styles, you must first create a JNDI Context:
        Hashtable properties = new Hashtable();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.exolab.jms.jndi.InitialContextFactory");
        properties.put(Context.PROVIDER_URL, "rmi://localhost:1099/");
        Context context = null;
        try {
            context = new InitialContext(properties);
        } catch (NamingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        
        // The message publisher and message subscriber need to look up a TopicConnectionFactory from JNDI, in order to create a TopicConnection and TopicSession.
        //OpenJMS is pre-configured with a TopicConnectionFactory named "JmsTopicConnectionFactory", which can be retrieved as follows:
        TopicConnectionFactory factory = null;
        try {
            factory = (TopicConnectionFactory) context.lookup("topic1");
        } catch (NamingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        
        
        //The TopicConnectionFactory can then be used to create a TopicConnection:
        TopicConnection connection = null;
        try {
            connection = factory.createTopicConnection();
        } catch (JMSException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }
        try {
            connection.start();
        } catch (JMSException e3) {
            // TODO Auto-generated catch block
            e3.printStackTrace();
        }
        
        
        
        //creating TopicSession
        TopicSession session = null;
        try {
            session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
        } catch (JMSException e4) {
            // TODO Auto-generated catch block
            e4.printStackTrace();
        }
        
        
        
        // The message publisher and message subscriber need to look up a Topic from JNDI in order to publish and subscribe to messages.
        // OpenJMS is pre-configured with a Topic named "topic1", which can be retrieved as follows:
        Topic topic = null;
        try {
            topic = (Topic) context.lookup("topic1");
        } catch (NamingException e5) {
            // TODO Auto-generated catch block
            e5.printStackTrace();
        }
        
     
        //Sending messages to a Topic        
        TopicPublisher publisher = null;
        try {
            publisher = session.createPublisher(topic);
        } catch (JMSException e6) {
            // TODO Auto-generated catch block
            e6.printStackTrace();
        }
        TextMessage message = null;
        try {
            message = session.createTextMessage("Hello World!");
        } catch (JMSException e7) {
            // TODO Auto-generated catch block
            e7.printStackTrace();
        }
        try {
            publisher.publish(message);
        } catch (JMSException e8) {
            // TODO Auto-generated catch block
            e8.printStackTrace();
        }  
        
        
        
        //The following example shows how to synchronously receive messages from a Topic:
        TopicSubscriber subscriber = null;
        try {
            subscriber = session.createSubscriber(topic);
        } catch (JMSException e9) {
            // TODO Auto-generated catch block
            e9.printStackTrace();
        }
        TextMessage messageRecu = null;
        try {
            messageRecu = (TextMessage) subscriber.receive();
        } catch (JMSException e10) {
            // TODO Auto-generated catch block
            e10.printStackTrace();
        }
        try {
            System.out.println("Received message: " + messageRecu.getText());
        } catch (JMSException e11) {
            // TODO Auto-generated catch block
            e11.printStackTrace();
        }
        
        
        
    }
}
