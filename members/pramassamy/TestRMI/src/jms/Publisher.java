/*
 * Created on 11 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package jms;

import java.util.Hashtable;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author Prâsad
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Publisher {

	public static void main(String[] args) throws NamingException, JMSException {
		Hashtable properties = new Hashtable();
	    properties.put(Context.INITIAL_CONTEXT_FACTORY, 
	                   "org.exolab.jms.jndi.InitialContextFactory");
	    properties.put(Context.PROVIDER_URL, "rmi://localhost:1099/");

	    Context context = new InitialContext(properties);

	    TopicConnectionFactory factory = 
	        (TopicConnectionFactory) context.lookup("JmsTopicConnectionFactory");
	    
	    TopicConnection connection = factory.createTopicConnection();
	    
	    connection.start();
	    
	    TopicSession session = 
	        connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
	    
	    Topic topic = (Topic) context.lookup("topic1");
	    
	    TopicPublisher publisher = session.createPublisher(topic);
	    TextMessage message = session.createTextMessage("Hello World!");
	    publisher.publish(message);
	    
	    TopicSubscriber subscriber = session.createSubscriber(topic);
	    TextMessage message2 = (TextMessage) subscriber.receive();
	    System.out.println("Received message: " + message2.getText());



	}
}
