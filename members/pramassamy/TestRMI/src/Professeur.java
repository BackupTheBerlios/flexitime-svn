import java.io.Serializable;
import java.rmi.RemoteException;

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
public class Professeur implements Serializable{

	private String nom;
	private String prenom;
	private Mail mail;
	
	public Professeur()
	{
		mail = new Mail();
	}
	/* (non-Javadoc)
	 * @see IProfesseur#getNom()
	 */
	public String getNom() {
		return nom;
	}

	/* (non-Javadoc)
	 * @see IProfesseur#getPrenom()
	 */
	public String getPrenom() {
		return prenom;
	}

	/* (non-Javadoc)
	 * @see IProfesseur#setNom(java.lang.String)
	 */
	public void setNom(String Nom) {
		nom = Nom;
	}

	/* (non-Javadoc)
	 * @see IProfesseur#setPrenom(java.lang.String)
	 */
	public void setPrenom(String Prenom) {
		prenom = Prenom;
	}

	/* (non-Javadoc)
	 * @see IProfesseur#getMail()
	 */
	public Mail getMail() throws RemoteException {
		return mail;
	}

}
