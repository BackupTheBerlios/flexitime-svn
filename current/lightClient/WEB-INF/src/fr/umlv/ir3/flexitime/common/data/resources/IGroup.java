/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.resources;

import fr.umlv.ir3.flexitime.common.data.general.IClass;

/**
 * Represents a group of studients who belong at the same Class
 * 
 * @version 245
 * @author FlexiTeam - Jérôme GUERS
 */
public interface IGroup extends IResource
{

    /**
     * Returns the number of persons of the group.
     * 
     * @return the number of persons of the group.
     */
    int getNbPerson();

    /**
     * Changes the number of persons of the group.
     * 
     * @param nbPerson the number of persons of the group.
     */
    void setNbPerson(int nbPerson);
    
	/** 
	 * Returns the parent class of this group.
	 *
	 * @return the parent class of this group.
	 */
	public IClass getParentClass();

	/** 
	 * Sets the parent class of this group.
	 *
	 * @param parentClass the parent class of this group.
	 */ 
	public void setParentClass(IClass parentClass);
}
