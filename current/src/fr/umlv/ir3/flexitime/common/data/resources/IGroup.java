/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.resources;

import fr.umlv.ir3.flexitime.common.data.general.impl.ClassImpl;

/**
 * Represents a group of studients who belong at the same Class
 * 
 * @version 0.2
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface IGroup extends IResource
{

    /**
     * Returns the number of persons of the group.
     * 
     * @return the number of persons of the group.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    int getNbPerson();

    /**
     * Changes the number of persons of the group.
     * 
     * @param nbPerson the number of persons of the group.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void setNbPerson(int nbPerson);
    
	/** 
	 * Returns the parent class of this group.
	 *
	 * @return the parent class of this group.
     * @author FlexiTeam - Adrien BOUVET
	 */
	public ClassImpl getParentClass();

	/** 
	 * Sets the parent class of this group.
	 *
	 * @param parentClass the parent class of this group.
     * @author FlexiTeam - Adrien BOUVET
	 */ 
	public void setParentClass(ClassImpl parentClass);

}
