/*
 * Created on 22 dec. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.richClient.io;

import java.rmi.RemoteException;

import javax.activation.*;
import javax.mail.*;
import javax.mail.internet.*;

import fr.umlv.ir3.flexitime.common.data.admin.IConfig;
import fr.umlv.ir3.flexitime.common.event.ConfigEvent;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;
import fr.umlv.ir3.flexitime.common.rmi.admin.AbstractConfigurationListener;

/**
 * DOCME
 * 
 * @version 320
 * @author FlexiTeam - Jérôme GUERS
 */
public class FlexiMail
{

    private static class CfgListener extends AbstractConfigurationListener{

        
        /**
         * Comment for <code>serialVersionUID</code>
         */
        private static final long serialVersionUID = 3256444698607760695L;

        /**
         * DOCME
         * @throws RemoteException
         */
        public CfgListener() throws RemoteException
        {
            super();
            // TODO Auto-generated constructor stub
        }

        /** 
         * @param event
         * @throws RemoteException 
         * 
         * @see fr.umlv.ir3.flexitime.common.rmi.admin.IConfigurationListener#ConfigurationChanged(fr.umlv.ir3.flexitime.common.event.ConfigEvent)
         */
        public void ConfigurationChanged(ConfigEvent event) throws RemoteException
        {
            System.err.println("event received");
            System.setProperty("mail.smtp.host", event.getConfig().getUriSMTPserver());
            session = Session.getDefaultInstance(System.getProperties());
            
        }
        
    }
    private static Session session;

    /**
     * DOCME
     * 
     * @param config
     */
    public static void setConfiguration(IConfig config)
    {
        try
        {
            // System.setProperty("mail.smtp.host", config.getUriSMTPserver());
            System.setProperty("mail.smtp.host", RemoteDataManager
                    .getConfigurationManager().get().getUriSMTPserver());
        }
        catch (RemoteException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (FlexiException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        session = Session.getDefaultInstance(System.getProperties());

    }

    static
    {
        try
        {
            // System.setProperty("mail.smtp.host", config.getUriSMTPserver());
            System.err.println(RemoteDataManager.getConfigurationManager()
                    .get().getUriSMTPserver());
            System.setProperty("mail.smtp.host", RemoteDataManager
                    .getConfigurationManager().get().getUriSMTPserver());
        }
        catch (RemoteException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (FlexiException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        session = Session.getDefaultInstance(System.getProperties());
        
        try
        {
            RemoteDataManager.getConfigurationManager().addConfigurationListener(new FlexiMail.CfgListener());
        }
        catch (RemoteException e1)
        {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    // Fonction d'envoie d'un message
    /**
     * DOCME
     * 
     * @param from
     * @param to
     * @param subject
     * @param body
     * @param files
     */
    public static void send(String from, String[] to, String subject,
            String body, String[] files)
    {
        // On cree l'entete du message
        Message msg;
        try
        {
            msg = createHeaderMessage(from, to, subject);

            // On cree le corps du message
            MimeBodyPart message_body = new MimeBodyPart();
            message_body.setContent(body, "text/plain");

            // On cree un message en partie multiple
            Multipart multipart_message = new MimeMultipart();

            // On ajoute enfin les deux partie: le corps et le fichier
            multipart_message.addBodyPart(message_body);
            // On attache le fichier desiré avec JAF
            if (files != null)
            {
                MimeBodyPart[] files_attachments = createAttachFile(files);
                for (int i = 0 ; i < files_attachments.length ; i++)
                    multipart_message.addBodyPart(files_attachments[i]);
            }

            // enfin on ajoute cette multi partie au message
            msg.setContent(multipart_message);

            // On envoie le message
            Transport.send(msg);
        }
        catch (AddressException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (MessagingException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Creation de l'entete du message
     * 
     * @param subject
     * @param from
     * @param to
     * @throws MessagingException
     * @throws AddressException
     */
    private static Message createHeaderMessage(String from, String[] to,
            String subject) throws AddressException, MessagingException
    {
        // Creation du message qui va contenir les informations du mail
        Message msg = new MimeMessage(session);

        // On positionne l'expediteur
        msg.setFrom(new InternetAddress(from));

        // On positionne les destinataires
        for (int i = 0 ; i < to.length ; i++)
        {
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(
                    to[i], false));
        }

        // On positionne le sujet du mail
        msg.setSubject(subject);

        return msg;
    }

    /**
     * Creation du fichier joint
     * 
     * @param files
     * @throws MessagingException
     */
    private static MimeBodyPart[] createAttachFile(String[] files)
            throws MessagingException
    {
        MimeBodyPart[] files_attachments = new MimeBodyPart[files.length];

        for (int i = 0 ; i < files.length ; i++)
        {
            DataSource file_data_source = new FileDataSource(files[i]);
            DataHandler file_data_handler = new DataHandler(file_data_source);
            files_attachments[i] = new MimeBodyPart();
            files_attachments[i].setDataHandler(file_data_handler);
            files_attachments[i].setFileName(files[i]);
        }
        return files_attachments;
    }
}
