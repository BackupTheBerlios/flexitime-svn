/*
 * Created on 29 nov. 2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package FlexiMailTest;
import java.net.*;
import java.util.Properties;
import java.io.*;
/**
 * @author Famille
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class MailToTest 
{
	
	  public static void main(String[] args) {
		try {
			Properties props = System.getProperties();
			props.put("mail.smtp.host","smtp.free.fr");
		  // Cr�ation d'un URL de sch�ma mailto
		  URL mailTo = new URL("mailto:gguerrin@free.fr");
		  // R�cup�ration du gestionnaire de connexion
		  URLConnection connection = mailTo.openConnection();
		  // Connexion explicite
		  //connection.connect();
		  // R�cup�ration du flot en �criture vers la ressource
		  PrintStream p = new PrintStream(connection.getOutputStream());
		  // �criture d'un champ d'en-t�te suivi du message
		  p.println("Subject: Essai\r\n\r\nBonjour !");
		  // Fermeture du flot entra�nant l'envoi du message
		  p.close();
		  System.out.println("Message envoy� !");
		} catch (IOException e) { e.printStackTrace(); 
		}
	}
}


