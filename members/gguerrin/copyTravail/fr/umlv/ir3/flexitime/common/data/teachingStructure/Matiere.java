/*
 * Created on 13 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.common.data.teachingStructure;

import java.util.List;

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface Matiere {

	/**
	 * returns the name of the matiere.
	 * @return the name of the matiere.
	 * 
	 * @uml.property name="name"
	 */
	String getName();

	/**
	 * changes the name of the matiere.
	 *  @param name the new name.
	 * 
	 * @uml.property name="name"
	 */
	void setName(String name);

	  
	  /** returns the list of cours .
	   * @return the list of cours.
	   */
	  List getLstCours();
	  
	  /** changes the list of cours.
	   *  @param lstCours the list of cours.
	   */
	  void setLstCours(List lstCours);
	  
	  /** add a cours in a matiere
	   * @param cours the cours added
	   */
	  void addCour(Cours cours);
	  
	  /** remove a cours of a matiere
	   *  @param cours the cours removed.
	   */
	  void removeCour(Cours cours);

}
