/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.ressources;

/**
 * Group - DOCME Description
 *This interface represents a group of studients who belong at the same Class
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface Group extends Resource {
	
    /** 
	 * getNbPerson
	 * returns the number of persons of the group.
	 * 
	 *
	 * @return the number of persons of the group.
	 * 
	 * @author   FlexiTeam - Guillaume GUERRIN
	 * @date     12 déc. 2004
	 */	
    int getNbPerson();
	  
    /** 
	 * setNbPerson
	 * changes the number of persons of the group.
	 * 
	 * @param nbPerson the number of persons of the group.
	 * 
	 * @author   FlexiTeam - Guillaume GUERRIN
	 * @date     12 déc. 2004
	 */ 	  
	void setNbPerson(int nbPerson);

}
