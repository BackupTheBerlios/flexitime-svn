/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.general;

import java.util.List;

import fr.umlv.ir3.flexitime.common.data.IData;
import fr.umlv.ir3.flexitime.common.data.resources.IGroup;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure;

/**
 * Represents a Class with all parameters that it can have.<br>
 * A Class is a list of groups that works on the same SubjectsGroups.
 * 
 * @version 0.2
 * @see fr.umlv.ir3.flexitime.common.data.IData
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface IClass extends IData
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
    ITeachingStructure getTeachingStructure();

    /**
     * Changes the teachingStructure of a Class.
     * 
     * @param struc the new teachingStructure.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void setTeachingStructure(ITeachingStructure struc);

    /**
     * Returns the list of groups of a Class.
     * 
     * @return the list of groups of a Class.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    List<IGroup> getLstGroups();

    /**
     * Changes the list of groups of a Class.
     * 
     * @param lstGroup the new list of groups of a Class.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void setLstGroups(List<IGroup> lstGroup);

    /**
     * Add a new group in the Class
     * 
     * @param group the group added
     * @return false if group was not added
     * @author FlexiTeam - Guillaume GUERRIN
     */
    boolean addGroup(IGroup group);

    /**
     * Remove a group from the Class
     * 
     * @param group the group removed
     * @return false if group was not removed
     * @author FlexiTeam - Guillaume GUERRIN
     */
    boolean removeGroup(IGroup group);
    
	/** 
	 * Returns the parent track of this class.
	 *
	 * @return the parent track of this class.
	 */
	public ITrack getParentTrack();

	/**
	 * Sets the parent track of this class.
	 * 
	 * @param track the parent track of this class.
	 */
	public void setParentTrack(ITrack track);
    
    /**
     * Return nbSubGroup
     * @return Returns the nbSubGroup.
     */
    public int getNbSubGroup();
    
    /**
     * Set nbSubGroup
     * @param nbSubGroup The nbSubGroup to set.
     */
    public void setNbSubGroup(int nbSubGroup);
}
