/*
 * Created on 25 nov. 2004
 *
 * To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package FlexiMailTest;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.internet.*;
import javax.mail.Session;
import javax.mail.*;
/**
 * @author Famille
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class FlexiMail {
	
	//Récupération des propriétés systeme
	Properties props = System.getProperties();
	Session session;
	Message msg;

	public FlexiMail(String smtpServer, String from, String to, String subject, String body, String fichier)
	{
		//On stock le nom du serveur SMTP
		props.put("mail.smtp.host",smtpServer);
	
		//On se connecte au serveur smtp
		session=Session.getDefaultInstance(props,null);
	
		//Creation du message qui va contenir les informations du mail
		msg=new MimeMessage(session);
		try{
		
			//On positionne l'expediteur
			msg.setFrom(new InternetAddress(from));
		
			//On positionne le destinataire
			msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to,false));
		
			//On positionne le sujet du mail
			msg.setSubject(subject);
		
			//On cree le corps du message
			MimeBodyPart message_body = new MimeBodyPart();
			message_body.setContent(body,"text/plain");
		
			//On attache le fichier desiré avec JAF
			DataSource file_data_source = new FileDataSource(fichier);
			DataHandler file_data_handler = new DataHandler(file_data_source);
			MimeBodyPart file_attachment = new MimeBodyPart();
			file_attachment.setDataHandler(file_data_handler);
			file_attachment.setFileName(fichier);

			// On cree un message en partie multiple
			Multipart multipart_message = new MimeMultipart();
		
			// On ajoute enfin les deux partie: le corps et le fichier
			multipart_message.addBodyPart(message_body);
			multipart_message.addBodyPart(file_attachment);
		
			// enfin on ajoute cette multi partie au message
			msg.setContent(multipart_message);
		}catch(Exception e){System.out.println("Echec à la création du message");
		}
	}

	public void send()
	{
		try{
			Transport.send(msg);
		}catch(Exception e){System.out.println("Echec à l'envoi");
		}
			System.out.println("OK message envoyé");
	}

	public static void main(String[] args)
	{
		FlexiMail mes = new  FlexiMail("smtp.free.fr","gguerrin@free.fr","gguerrin@free.fr","sujet","body","toto.txt");
		mes.send();
	}
}
