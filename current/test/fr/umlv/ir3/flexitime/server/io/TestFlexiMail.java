/*
 * Created on 2 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.server.io;

/**
 * @author gguerrin
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class TestFlexiMail 
{
	public static void main(String[] args)
	{
		FlexiMail mes = new  FlexiMail("smtp.edudiant.umlv-univ.fr","gguerrin@free.fr","gguerrin@free.fr","sujet","body","toto.txt");
		mes.send();
	}
}
