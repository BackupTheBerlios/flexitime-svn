import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JButton;
import javax.swing.JFrame;

/*
 * Created on 11 d�c. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author Pr�sad
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Serveur {

	public static void main(String[] args) throws RemoteException, MalformedURLException {
		getRMI rmi = new getRMI();
		
		IgetRMI rmiProf = (IgetRMI)UnicastRemoteObject.exportObject(rmi, 0);
		
//		 Création du registre, ça nous évitera de le lancer à côté
		Registry registry = LocateRegistry
				.createRegistry(Registry.REGISTRY_PORT);

		// On enregistre nos classes dans le registre
		registry.rebind("prof", rmiProf);
		
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
		frame.setContentPane(button);
		frame.pack();
		frame.setVisible(true);
	}
}
