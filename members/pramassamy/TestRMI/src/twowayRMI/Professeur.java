/*
 * Created on 15 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package twowayRMI;

import java.io.Serializable;

/**
 * @author Prâsad
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Professeur implements Serializable{
	private Long idProf=null;
	private String nom;
	private String prenom;
	private String mail;

	protected Professeur(){
		
	};
	
	public Professeur(String n, String p, String m){
		nom = n;
		prenom = p;
		mail = m;
	}
	
	/**
	 * @return Returns the mail.
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * @param mail The mail to set.
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	/**
	 * @return Returns the nom.
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom The nom to set.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * @return Returns the prenom.
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * @param prenom The prenom to set.
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * @return Returns the idProf.
	 */
	public Long getIdProf() {
		return idProf;
	}
	/**
	 * @param idProf The idProf to set.
	 */
	public void setIdProf(Long idProf) {
		this.idProf = idProf;
	}
}
