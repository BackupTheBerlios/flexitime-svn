/*
 * Created on 11 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package list;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Hashtable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
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
import javax.naming.Reference;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;


/**
 * @author Prâsad
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ClientList {

	public static void main(String[] args) throws RemoteException, NamingException, JMSException {
		String strServer = "localhost";
		
		
		RMIList RMIlistModel = null;
		
		while( RMIlistModel == null )
		{
			try
			{
				Registry registry = LocateRegistry.getRegistry(strServer, 2000);
				//model = (NumberListModelRMI) registry.lookup("ListModel");
				RMIlistModel = (RMIList) registry.lookup("listmodel");
			}
			catch( Exception e )
			{
				// Impossible de contacter le registre
				// On demande un nouveau serveur et on retente
				strServer = JOptionPane
						.showInputDialog("Connexion impossible !\n"
								+ "Entrez le nom du serveur");
			}
		}
		final RMIList finalmodel = RMIlistModel;
		JFrame f = new JFrame("List");
		
		final MyListModel localmodel = RMIlistModel.getModel();
		
		final JTextArea text = new JTextArea();
		
		class SerializableListDataListener implements ListDataListener, Serializable{

			public void intervalAdded(ListDataEvent e) {
				System.out.println("Interval Added");
				//text.append("Interval Added");
				String tmp = text.getText();
				text.setText(tmp + "\n Interval Added");
				
			}

			public void intervalRemoved(ListDataEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void contentsChanged(ListDataEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		};
		
		RMIlistModel.addListDataListener(new SerializableListDataListener());
		
		
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
	    
	    Topic topic  = RMIlistModel.getTopic();
	    /*System.out.println(topicString);
	    Reference toto = (Reference) context.lookup("test");
	    
	    System.out.println(toto.get(0).getContent());
	    //return;
	    
	    Topic topic = (Topic) context.lookup("topic1");
	    */
	    final JList list = new JList(localmodel);
	    TopicSubscriber subscriber = session.createSubscriber(topic);
		subscriber.setMessageListener(new MessageListener() {
	        public void onMessage(Message message) {
	        	ObjectMessage o = (ObjectMessage) message;
	        	//localmodel.
	        	
	        	try {
	        		list.setModel(finalmodel.getModel());
					System.out.println(o.getObject());
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch(RemoteException e1){
					e1.printStackTrace();
				}
				/*TextMessage text = (TextMessage) message;
				try {
					System.out.println("Received message: " + text.getText());
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
	        }
	    });
		
		
		
		
		JScrollPane scroll = new JScrollPane(list);
		
		JPanel pan = new JPanel(new BorderLayout());
		
		pan.add(scroll, BorderLayout.CENTER);
		pan.add(text, BorderLayout.NORTH);
		
		JButton but = new JButton("ajout");
		
		but.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				try {
					finalmodel.incr();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		
		pan.add(but, BorderLayout.SOUTH);
		
		f.setContentPane(pan);
		f.setSize(640, 480);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setVisible(true);
	}
}
