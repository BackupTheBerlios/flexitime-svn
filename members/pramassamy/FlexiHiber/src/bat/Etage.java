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
public class Etage {
	private Long idEtage;
	private String nomEtage;
	private Set salles;
	
	private Batiment parent;
	
	protected Etage(){
		
	}
	
	
	public Etage(String nomEtage){
		this.nomEtage = nomEtage;
		salles = new HashSet();
		
	}
	/**
	 * @return Returns the idEtage.
	 */
	public Long getIdEtage() {
		return idEtage;
	}
	/**
	 * @param idEtage The idEtage to set.
	 */
	public void setIdEtage(Long idEtage) {
		this.idEtage = idEtage;
	}
	/**
	 * @return Returns the nomEtage.
	 */
	public String getNomEtage() {
		return nomEtage;
	}
	/**
	 * @param nomEtage The nomEtage to set.
	 */
	public void setNomEtage(String nomEtage) {
		this.nomEtage = nomEtage;
	}
	/**
	 * @return Returns the parent.
	 */
	public Batiment getParent() {
		return parent;
	}
	/**
	 * @param parent The parent to set.
	 */
	public void setParent(Batiment parent) {
		this.parent = parent;
	}
	/**
	 * @return Returns the salles.
	 */
	public Set getSalles() {
		return salles;
	}
	/**
	 * @param salles The salles to set.
	 */
	public void setSalles(Set salles) {
		this.salles = salles;
	}
	
	public void addSalle(Salle s){
		salles.add(s);
		s.setParent(this);
	}
}
