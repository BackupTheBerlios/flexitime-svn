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
public class FlexiMailClass {
	
	Properties props = System.getProperties();
	Session session;
	Message msg;
public FlexiMessage(String smtpServer, String from, String to, String subject, String body, String fichier)
{
	props.put("mail.smtp.host",smtpServer);
	session=Session.getDefaultInstance(props,null);
	msg=new MimeMessage(session);
	try{
		msg.setFrom(new InternetAddress(from));
		msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to,false));
		msg.setSubject(subject);
		MimeBodyPart message_body = new MimeBodyPart();
		message_body.setContent(body,"text/plain");
		DataSource file_data_source = new FileDataSource(fichier);
		DataHandler file_data_handler = new DataHandler(file_data_source);
		MimeBodyPart file_attachment = new MimeBodyPart();
		file_attachment.setDataHandler(file_data_handler);
		file_attachment.setFileName(fichier);

		// create the Multipart message
		Multipart multipart_message = new MimeMultipart();
		// add the two bodies to this multipart
		multipart_message.addBodyPart(message_body);
		multipart_message.addBodyPart(file_attachment);
		// set the content type of this message to indicate multipart
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
}

