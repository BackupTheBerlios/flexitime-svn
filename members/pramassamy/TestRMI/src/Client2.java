import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JOptionPane;


/*
 * Created on 11 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author Prâsad
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Client2 {

	public static void main(String[] args) throws RemoteException{
		String strServer = "localhost";
		IgetRMI p = null;
		while( p == null )
		{
			try
			{
				Registry registry = LocateRegistry.getRegistry(strServer);
				//model = (NumberListModelRMI) registry.lookup("ListModel");
				p = (IgetRMI) registry.lookup("prof");
			}
			catch( Exception e )
			{
				e.printStackTrace();
				// Impossible de contacter le registre
				// On demande un nouveau serveur et on retente
				strServer = JOptionPane
						.showInputDialog("Connexion impossible !\n"
								+ "Entrez le nom du serveur");
			}
		}
		
		//p.setNom("TOTO");
		//p.setPrenom("tata");
		Professeur pr = p.getProf();
		
		
		System.out.println(pr.getNom());
		System.out.println(pr.getPrenom());
		System.out.println(pr.getMail().getMail());
	}
}
