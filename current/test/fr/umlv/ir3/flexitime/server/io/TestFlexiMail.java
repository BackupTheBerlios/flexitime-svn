/*
 * Created on 2 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.server.io;

import junit.framework.TestCase;

/**
 * @author gguerrin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TestFlexiMail extends TestCase
{
    FlexiMail mes = new  FlexiMail("smtp.edudiant.umlv-univ.fr","vforel@free.fr","gguerrin@free.fr","sujet","body","toto.txt");
	
    public void testGetFichier(){
        if(!mes.getFichier().equals("toto.txt")) fail("getFichier : Nom de fichier erroné !");
	}
	public void testGetFrom(){
        if(!mes.getFrom().equals("vforel@free.fr")) fail("getFrom : Adresse source erronée !");
	}
	public void testGetTo(){
	    if(!mes.getTo().equals("gguerrin@free.fr")) fail("getTo : Address destination erronée !");
	}
	public void testGetSmtpServer(){
	    if(!mes.getSmtpServer().equals("smtp.edudiant.umlv-univ.fr")) fail("getSmtpServer : smtp erroné !");
	}
	public void testGetSubject(){
	    if(!mes.getSubject().equals("sujet")) fail("getSubject : Sujet erroné !");	
    }
	public void testSetFichier(){
        mes.setFichier("monFichier");
	    if(!mes.getFichier().equals("monFichier")) fail("setFichier : Nom de fichier erroné !");
	}
	public void testSetFrom(){
        mes.setFrom("fromMe");
	    if(!mes.getFrom().equals("fromMe")) fail("setFrom : Adresse source erronée !");
	}
	public void testSetTo(){
	    mes.setTo("toYou");
	    if(!mes.getTo().equals("toYou")) fail("setTo : Address destination erronée !");
	}
	public void testSetSmtpServer(){
	    mes.setSmtpServer("leServeurSMTP");
	    if(!mes.getSmtpServer().equals("leServeurSMTP")) fail("setSmtpServer : smtp erroné !");
	}
	public void testSetSubject(){
	    mes.setSubject("leSujet");
	    if(!mes.getSubject().equals("leSujet")) fail("Sujet erroné !");	
    }
}
