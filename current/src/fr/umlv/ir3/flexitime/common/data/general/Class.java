/*
 * Created on 12 d�c. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.general;

import java.util.List;

import fr.umlv.ir3.flexitime.common.data.Data;
import fr.umlv.ir3.flexitime.common.data.ressources.Group;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.TeachingStructure;

/**
 * Represents a Class with all parameters that it can have.
 * A Class is a list of groups that works on the same SubjectsGroups.
 * 
 * @version 0.1
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface Class extends Data
{

    /**
     * Returns the number of groups of a Class.
     * 
     * @return the number of groups of a Class.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    int getNbGroup();

    /**
     * Returns the number of person in a Class.
     * 
     * @return the number of person in a Class.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    int getNbPerson();

    /**
     * getTeachingStructure returns the teachingStructure of a Class.
     * 
     * @return the teachingStructure of a Class.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    TeachingStructure getTeachingStructure();

    /**
     * Changes the teachingStructure of a Class.
     * 
     * @param struc the new teachingStructure.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void setTeachingStructure(TeachingStructure struc);

    /**
     * Returns the list of groups of a Class.
     * 
     * @return the list of groups of a Class.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    List getLstGroups();

    /**
     * Changes the list of groups of a Class.
     * 
     * @param lstGroup the new list of groups of a Class.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void setLstGroups(List lstGroup);

    /**
     * Add a new group in the Class
     * 
     * @param group the group added
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void addGroup(Group group);

    /**
     * Remove a group from the Class
     * 
     * @param group the group removed
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void removeGroup(Group group);
}
