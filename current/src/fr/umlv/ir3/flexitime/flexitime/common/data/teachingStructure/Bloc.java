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
public interface Bloc {

	/**
	 * returns the name of the bloc.
	 * @return the name of the bloc.
	 * 
	 * @uml.property name="name"
	 */
	String getName();

	/**
	 * changes the name of the bloc.
	 *  @param name the new name.
	 * 
	 * @uml.property name="name"
	 */
	void setName(String name);

	
	/** returns the list of Matiere of blocs .
	   * @return the list of Matiere of blocs.
	   */
	  List getLstMatiere();
	  
	  /** changes the list of Matiere of blocs.
	   *  @param lstMatiere the list of Matiere of blocs.
	   */
	  void setLstMatiere(List lstMatiere);
	  
	  /** add a matiere in a Bloc .
	   *  @param matiere a matiere
	   */
	  void addMatiere(Matiere matiere);
	  
	  /** remove a Matiere of a Bloc.
	   *  @param matiere a matiere
	   */
	  void removeMatiere(Matiere matiere);

}
