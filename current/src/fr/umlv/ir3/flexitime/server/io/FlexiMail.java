/*
 * 
 */
package fr.umlv.ir3.flexitime.server.io;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.internet.*;
import javax.mail.Session;
import javax.mail.*;

/**
 * 
 * DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * @see (si nécessaire)
 * 
 * @author FlexiTeam - Famille
 */
public class FlexiMail {
	
	
	private Properties props = System.getProperties(); //Récupération des propriétés systeme
	private Session session;
	private Message msg;
	private String smtpServer;
	private String from;
	private String to;
	private String subject;
	private String body;
	private String fichier;

	public FlexiMail()
	{
		
	}
	public FlexiMail(String smtpServer, String from, String to, String subject, String body, String fichier)
	{
		this.smtpServer = smtpServer ;
		this.from = from ;
		this.to = to;
		this.subject = subject ;
		this.body = body ;
		this.fichier = fichier ;
	}
	

	//Fonction d'envoie d'un message	
	public void send()
	{
		try
		{
			//On se connecte au serveur smtp
			connection2Smtp();
			
			//On cree l'entete du message
			createHeaderMessage();
			
			//On attache le fichier desiré avec JAF
			MimeBodyPart file_attachment = createAttachFile();
			
			//On cree le corps du message
			MimeBodyPart message_body = new MimeBodyPart();
			message_body.setContent(body,"text/plain");
			
			//On cree un message en partie multiple
			Multipart multipart_message = new MimeMultipart();
			
			//On ajoute enfin les deux partie: le corps et le fichier
			multipart_message.addBodyPart(message_body);
			multipart_message.addBodyPart(file_attachment);
			
			//enfin on ajoute cette multi partie au message
			msg.setContent(multipart_message);
			
			//On envoie le message
			Transport.send(msg);
			System.out.println("OK message envoyé");
		}
		catch(Exception e)
		{
			System.out.println("Echec à l'envoi");
		}
			
	}

	
	/**
	 * Connexion au serveur smtp
	 * @return
	 */
		private void connection2Smtp()
		{
		    props.put("mail.smtp.host",smtpServer);
		    session=Session.getDefaultInstance(props,null);
		}
	/**
	* Creation de l'entete du message
	* @return
	 * @throws MessagingException
	 * @throws AddressException
	 */
	private void createHeaderMessage() throws AddressException, MessagingException
	{
		//Creation du message qui va contenir les informations du mail
		msg=new MimeMessage(session);
		
		//On positionne l'expediteur
		msg.setFrom(new InternetAddress(from));
		
		//On positionne le destinataire
		msg.setRecipients(Message.RecipientType.TO,InternetAddress.parse(to,false));
		
		//On positionne le sujet du mail
		msg.setSubject(subject);
	}
	
	/**
	 * Creation du fichier joint
	 * @throws MessagingException
	 * 
	 */
	private MimeBodyPart createAttachFile() throws MessagingException
	{
		DataSource file_data_source = new FileDataSource(fichier);
		DataHandler file_data_handler = new DataHandler(file_data_source);
		MimeBodyPart file_attachment = new MimeBodyPart();
		file_attachment.setDataHandler(file_data_handler);
		file_attachment.setFileName(fichier);
		return(file_attachment);
	}
		
	/**
	 * @return Returns the fichier.
	 */
	public String getFichier() {
		return fichier;
	}
	/**
	 * @param fichier The fichier to set.
	 */
	public void setFichier(String fichier) {
		this.fichier = fichier;
	}
	/**
	 * @return Returns the from.
	 */
	public String getFrom() {
		return from;
	}
	/**
	 * @param from The from to set.
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	/**
	 * @return Returns the smtpServer.
	 */
	public String getSmtpServer() {
		return smtpServer;
	}
	/**
	 * @param smtpServer The smtpServer to set.
	 */
	public void setSmtpServer(String smtpServer) {
		this.smtpServer = smtpServer;
	}
	
	/**
	 * @return Returns the subject.
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject The subject to set.
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * @return Returns the to.
	 */
	public String getTo() {
		return to;
	}
	/**
	 * @param to The to to set.
	 */
	public void setTo(String to) {
		this.to = to;
	}
}
