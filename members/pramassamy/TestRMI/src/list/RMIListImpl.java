/*
 * Created on 11 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package list;

import java.rmi.RemoteException;
import java.util.Hashtable;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 * @author Prâsad
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class RMIListImpl implements RMIList{

	public RMIListImpl() throws NamingException, JMSException
	{
		Hashtable properties = new Hashtable();
	    properties.put(Context.INITIAL_CONTEXT_FACTORY, 
	                   "org.exolab.jms.jndi.InitialContextFactory");
	    properties.put(Context.PROVIDER_URL, "rmi://10.25.42.2:1099/");

	    Context context = new InitialContext(properties);

	    TopicConnectionFactory factory = 
	        (TopicConnectionFactory) context.lookup("JmsTopicConnectionFactory");
	    
	    TopicConnection connection = factory.createTopicConnection();
	    
	    
	    connection.start();
	    
	    final TopicSession session = 
	        connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
	    
	    topic = session.createTopic(this.toString());
	    //context.rebind("test", topic);


	    
	    //Topic topic = (Topic) context.lookup("topic1");
	    
	    publisher = session.createPublisher(topic);
	    
	    listmodel.addListDataListener(new ListDataListener(){

			public void intervalAdded(ListDataEvent e){
				try {
					ObjectMessage message = session.createObjectMessage(e);
					//TextMessage message = session.createTextMessage("intervall added");
					publisher.publish(message);
				} catch (JMSException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}

			public void intervalRemoved(ListDataEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void contentsChanged(ListDataEvent e) {
				// TODO Auto-generated method stub
				
			}
	    	
	    });
	    
	}
	/* (non-Javadoc)
	 * @see list.RMIList#getModel()
	 */
	public MyListModel getModel() throws RemoteException {
		return listmodel;
	}

	MyListModel listmodel = new MyListModel();

	/* (non-Javadoc)
	 * @see list.RMIList#incr()
	 */
	public void incr() throws RemoteException {
		listmodel.incr();
		
	}

	/* (non-Javadoc)
	 * @see list.RMIList#addListDataListner(javax.swing.event.ListDataListener)
	 */
	public void addListDataListener(ListDataListener l) throws RemoteException {
		listmodel.addListDataListener(l);
		
	}
	
	public Topic getTopic(){
		return topic;
	}
	
	Topic topic;
	TopicPublisher publisher;
}
