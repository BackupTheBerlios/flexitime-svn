/*
 * Created on 12 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.common.data.ressources;

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface Groups extends Resources {
	
	/** returns the number of persons of the group.
	   * @return the number of persons of the group.
	   */
	  int getNbPerson();
	  
	  /** changes the number of persons of the group.
	   *  @param nbPerson the number of persons of the group.
	   */
	  void setNbPerson(int nbPerson);

}
