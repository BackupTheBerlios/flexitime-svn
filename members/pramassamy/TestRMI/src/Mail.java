import java.io.Serializable;

/*
 * Created on 11 d�c. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author Pr�sad
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Mail implements Serializable{
	private String mail;
	
	public Mail()
	{
		mail="toto@chez.com";
	}
	
	public String getMail()
	{
		return mail;
	}
}
