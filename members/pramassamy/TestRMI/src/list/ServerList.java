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
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.jms.JMSException;
import javax.naming.NamingException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * @author Prâsad
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ServerList {

	public static void main(String[] args) throws RemoteException, NamingException, JMSException {
		RMIListImpl modelimpl = new RMIListImpl();
		
		RMIList rmiModel = (RMIList) UnicastRemoteObject.exportObject(modelimpl, 0);
		
		Registry registry = LocateRegistry.createRegistry(2000);
		//Registry registry = LocateRegistry.getRegistry();
		
		registry.rebind("listmodel", rmiModel);
		
		final JFrame frame = new JFrame("Serveur");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button = new JButton("Quitter");
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frame.dispose();
				System.exit(0);
			}
		});
		
		JList list = new JList(modelimpl.getModel());
		JScrollPane scroll = new JScrollPane(list);
		
		
		JPanel panel = new JPanel(new BorderLayout());
		panel.add(scroll, BorderLayout.CENTER);
		panel.add(button, BorderLayout.SOUTH);
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
		
		
	}
}
