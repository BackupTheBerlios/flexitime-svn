/*
 * Created on 12 d�c. 2004
 * by Guillaume GUERRIN
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.ressources;

/**
 * Group - DOCME Description
 * explication suppl�mentaire si n�cessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * repr�sente, ...
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface Group extends Resource {
	
    /** 
	 * getNbPerson - DOCME Description
	 * returns the number of persons of the group.
	 * 
	 *
	 * @return the number of persons of the group.
	 * 
	 * @author   FlexiTeam - Guillaume GUERRIN
	 * @date     12 d�c. 2004
	 */	
    int getNbPerson();
	  
    /** 
	 * setNbPerson - DOCME Description
	 * changes the number of persons of the group.
	 * 
	 * @param nbPerson the number of persons of the group.
	 * 
	 * @author   FlexiTeam - Guillaume GUERRIN
	 * @date     12 d�c. 2004
	 */ 	  
	void setNbPerson(int nbPerson);

}
