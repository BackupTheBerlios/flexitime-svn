/*
 * Created on 30 nov. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package bat;

/**
 * @author Prâsad
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Salle {
	private Long idSalle;
	private String nomSalle;
	private char typeSalle;
	private int nbplaces;
	
	private Etage parent;
	protected Salle(){
		
	}
	public Salle(String nomSalle, char typeSalle, int nbplaces){
		this.nomSalle = nomSalle;
		this.typeSalle = typeSalle;
		this.nbplaces = nbplaces;
		
	}
	/**
	 * @return Returns the idSalle.
	 */
	public Long getIdSalle() {
		return idSalle;
	}
	/**
	 * @param idSalle The idSalle to set.
	 */
	public void setIdSalle(Long idSalle) {
		this.idSalle = idSalle;
	}
	/**
	 * @return Returns the nbplaces.
	 */
	public int getNbplaces() {
		return nbplaces;
	}
	/**
	 * @param nbplaces The nbplaces to set.
	 */
	public void setNbplaces(int nbplaces) {
		this.nbplaces = nbplaces;
	}
	/**
	 * @return Returns the nomSalle.
	 */
	public String getNomSalle() {
		return nomSalle;
	}
	/**
	 * @param nomSalle The nomSalle to set.
	 */
	public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
	}
	/**
	 * @return Returns the parent.
	 */
	public Etage getParent() {
		return parent;
	}
	/**
	 * @param parent The parent to set.
	 */
	public void setParent(Etage parent) {
		this.parent = parent;
	}
	/**
	 * @return Returns the typeSalle.
	 */
	public char getTypeSalle() {
		return typeSalle;
	}
	/**
	 * @param typeSalle The typeSalle to set.
	 */
	public void setTypeSalle(char typeSalle) {
		this.typeSalle = typeSalle;
	}
}
