/*
 * Created on 16 d�c. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package twowayRMI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author Pr�sad
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Server {

	public static void main(String[] args) throws RemoteException {
		RMIProfImpl profImpl = new RMIProfImpl();
		IRMIProf rmiProf = (IRMIProf) UnicastRemoteObject.exportObject(profImpl, 0);
		
//		 Création du registre, ça nous évitera de le lancer à côté
		Registry registry = LocateRegistry
				.createRegistry(Registry.REGISTRY_PORT);

		
		registry.rebind("Profs", rmiProf);
		//Naming.rebind("ListModel", model);
		
		final JFrame f = new JFrame("Serveur Prof");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton b = new JButton("Quitter");
		
		b.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				f.dispose();
				System.exit(0);
			}
			
		});
		
		f.setContentPane(b);
		f.pack();
		f.setVisible(true);
		
	}
}
