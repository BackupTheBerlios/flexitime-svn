/*
 * Created on 12 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package jms;

import java.util.Hashtable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
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
public class Consumer {

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
		TopicSubscriber subscriber = session.createSubscriber(topic);
		subscriber.setMessageListener(new MessageListener() {
	        public void onMessage(Message message) {
	            TextMessage text = (TextMessage) message;
	            try {
					System.out.println("Received message: " + text.getText());
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	    });

	    
	}
}
