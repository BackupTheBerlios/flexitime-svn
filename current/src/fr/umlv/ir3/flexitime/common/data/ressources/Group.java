/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.ressources;

/**
 * Represents a group of studients who belong at the same Class
 * 
 * @version 0.1
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface Group extends Resource
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

}
