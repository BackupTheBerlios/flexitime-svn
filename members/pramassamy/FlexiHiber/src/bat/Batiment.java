/*
 * Created on 30 nov. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package bat;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Prâsad
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Batiment {
	private Long idBat;
	private String nomBat;
	private Set etages;
	
	public Batiment(){
		
	}
	
	public Batiment(String nomBat){
		this.nomBat = nomBat;
		etages = new HashSet();
	}

	/**
	 * @return Returns the etages.
	 */
	public Set getEtages() {
		return etages;
	}
	/**
	 * @param etages The etages to set.
	 */
	public void setEtages(Set etages) {
		this.etages = etages;
	}
	/**
	 * @return Returns the idBat.
	 */
	public Long getIdBat() {
		return idBat;
	}
	/**
	 * @param idBat The idBat to set.
	 */
	public void setIdBat(Long idBat) {
		this.idBat = idBat;
	}
	/**
	 * @return Returns the nomBat.
	 */
	public String getNomBat() {
		return nomBat;
	}
	/**
	 * @param nomBat The nomBat to set.
	 */
	public void setNomBat(String nomBat) {
		this.nomBat = nomBat;
	}
	
	public void addEtage(Etage e){
		etages.add(e);
		e.setParent(this);
	}
}
