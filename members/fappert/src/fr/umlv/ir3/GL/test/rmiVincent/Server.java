package fr.umlv.ir3.GL.test.rmiVincent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Server
{
	public static void main(String[] args) throws RemoteException
	{
		// On instancie et exporte notre classe Hello 
		HelloImpl helloImpl = new HelloImpl();
		Hello hello = (Hello) UnicastRemoteObject.exportObject(helloImpl, 0);

		// On instancie et exporte notre modèle de liste
		// Pour le créer, il suffit de l'encapsuler dans notre adapteur RMI
		NumberListModelRMIAdapter modelImpl = new NumberListModelRMIAdapter(
				new NumberListModel());
		NumberListModelRMI model = (NumberListModelRMI) UnicastRemoteObject
				.exportObject(modelImpl, 0);

		// Création du registre, ça nous évitera de le lancer à côté
		Registry registry = LocateRegistry
				.createRegistry(Registry.REGISTRY_PORT);

		// On enregistre nos classes dans le registre
		registry.rebind("Hello", hello);
		registry.rebind("ListModel", model);

		// Une 'tite interface graphique pour fermer notre client proprement
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