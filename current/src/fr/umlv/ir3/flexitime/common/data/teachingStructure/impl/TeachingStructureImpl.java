/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.teachingStructure.impl;

import java.util.ArrayList;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.impl.DataImpl;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure;


/**
 * Defines a teaching structure, it contains subjects' groups.
 * 
 * @version 0.1
 * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure
 * 
 * @author FlexiTeam - Adrien BOUVET
 */
public class TeachingStructureImpl extends DataImpl implements ITeachingStructure
{
    //===========//
	//  Champs	 //
	//===========//
    private List listOfSubjectsGroups;
    
    
	//=============//
	//Constructeurs//
    //=============//
	/**
	 * Default constructor for a teaching structure. 
	 */
	protected TeachingStructureImpl()
	{}
	
	/**
	 * Constructs a teaching structure with just a name in parameter.
	 * 
	 * @param name a string.
	 */
	public TeachingStructureImpl(String name)
	{
		super(name);
	}
	
    /**
     * Constructs a teaching structure.
     * 
     * @param name a string.
     * @param listSubjectsGroup the list of subjects' groups.
     */
    public TeachingStructureImpl(String name, List listSubjectsGroup)
    {
        super(name);
        this.listOfSubjectsGroups = new ArrayList(listSubjectsGroup);
    }

    
    //===========//
    // Méthodes  //
	//===========//
    /** 
     * Returns the list of subjects' groups.
     * <code>List l = struct.getLstSubjectsGroup()</code>
     *
     * @return the list of subjects' groups.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure#getLstSubjectsGroup()
     * @author   FlexiTeam - Adrien BOUVET
     */
    public List getLstSubjectsGroup()
    {
        return listOfSubjectsGroups;
    }

    /** 
     * Sets the list of subjects' groups
     * <code>struct.setLstSubjectsGroup(lst)</code>
     *
     * @param lst the list of subjects' groups. 
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure#setLstSubjectsGroup(java.util.List)
     * @author   FlexiTeam - Adrien BOUVET
     */
    public void setLstSubjectsGroup(List lst)
    {
        listOfSubjectsGroups = new ArrayList(lst);
    }

    /** 
     * Adds a subjects' group to the list.
     * <code>struct.addSubjectsGroup(subjectsGroup)</code>
     *
     * @param subjectsGroup the subjects' group to add to the list.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure#addSubjectsGroup(fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup)
     * @author   FlexiTeam - Adrien BOUVET
     */
    public void addSubjectsGroup(ISubjectsGroup subjectsGroup)
    {
        listOfSubjectsGroups.add(subjectsGroup);
    }

    /** 
     * Removes a subjects' group of the list.
     * <code>struct.removeSubjectsGroup(subjectsGroup)</code>
     *
     * @param subjectsGroup the subjects' group to remove of the list.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure#removeSubjectsGroup(fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup)
     * @author   FlexiTeam - Adrien BOUVET
     */
    public void removeSubjectsGroup(ISubjectsGroup subjectsGroup)
    {
        listOfSubjectsGroups.remove(subjectsGroup);
    }
}

