package fr.umlv.ir3.GL.test.rmiVincent;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class Client
{
	public static void main(String[] args) throws Exception
	{
		// Par défaut, on cherche sur la machine locale
		String strServer = "localhost";

		////////////////////////////////////////////////////////////////////////////
		// Tant qu'on a pas notre modèle, on va redemander une adresse de
		// serveur
		NumberListModelRMI model = null;
		while( model == null )
		{
			try
			{
				Registry registry = LocateRegistry.getRegistry(strServer);
				model = (NumberListModelRMI) registry.lookup("ListModel");
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
		////////////////////////////////////////////////////////////////////////////

		// Une tite frame
		JFrame frame = new JFrame("RMI Model Client");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Nous englobons le modèle RMI dans un adapteur le transformant en
		// modèle normal
		JList list = new JList(new NumberListModelNoRMIAdapter(model));
		
		JScrollPane scroll = new JScrollPane(list);
		frame.setContentPane(scroll);

		frame.setSize(640, 480);
		frame.setVisible(true);
	}
}