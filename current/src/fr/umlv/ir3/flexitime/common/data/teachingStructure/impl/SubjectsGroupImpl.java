/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.teachingStructure.impl;

import java.util.ArrayList;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.impl.DataImpl;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure;


/**
 * Defines a subjects' group, it contains subjects.
 * 
 * @version 0.2
 * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup
 * 
 * @author FlexiTeam - Adrien BOUVET
 */
public class SubjectsGroupImpl extends DataImpl implements ISubjectsGroup
{
    //===========//
	//  Champs	 //
	//===========//
    private List listOfSubjects;
    private ITeachingStructure parentTeachStruct;
    
    
	//=============//
	//Constructeurs//
    //=============//
	/**
	 * Default constructor for a subjects' group. 
	 */
	protected SubjectsGroupImpl()
	{}
	
	/**
	 * Constructs a subjects' group with just a name in parameter.
	 * 
	 * @param name a string.
	 */
	public SubjectsGroupImpl(String name)
	{
		super(name);
	}
	
	/**
	 * Constructs a subjects' group with a name and the parent teaching structure in parameter.
	 * 
	 * @param name a string.
	 * @param struct the parent teaching structure of this subjects' group.
	 */
	public SubjectsGroupImpl(String name, TeachingStructureImpl struct)
	{
		super(name);
		this.parentTeachStruct = struct;
	}
	
    /**
     * Constructs a subjects' group.
     * 
     * @param name a string.
     * @param listSubjects a list of subjects.
     * @param teachStruct the parent teaching structure of this subjects' group. 
     */
    public SubjectsGroupImpl(String name, List listSubjects, TeachingStructureImpl teachStruct)
    {
        super(name);
        this.listOfSubjects = new ArrayList(listSubjects);
        this.parentTeachStruct = teachStruct;
    }

    
    //===========//
    // Méthodes  //
	//===========//
    /** 
     * Returns the list of subjects.
     * <code>List l = group.getLstSubject()</code>
     *
     * @return the list of subjects.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup#getLstSubject()
     */
    public List getLstSubject()
    {
        return listOfSubjects;
    }

    /** 
     * Sets the list of subjects.
     * <code>group.setLstSubject(lst)</code>
     *
     * @param lstSubject the list of subjects. 
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup#setLstSubject(java.util.List)
     */
    public void setLstSubject(List lstSubject)
    {
        this.listOfSubjects = new ArrayList(lstSubject);
    }

    /** 
     * Adds a subject to the list.
     * <code>group.addSubject(subject)</code>
     *
     * @param subject a subject to add to the list. 
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup#addSubject(fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject)
     */
    public void addSubject(ISubject subject)
    {
        listOfSubjects.add(subject);
    }

    /** 
     * Removes a subject of the list.
     * <code>group.removeSubject(subject)</code>
     *
     * @param subject a subject to remove of the list. 
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup#removeSubject(fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject)
     */
    public void removeSubject(ISubject subject)
    {
        listOfSubjects.remove(subject);
    }
    
	/** 
	 * Returns the teaching structure to which the subjects' group belongs.
	 * <code>TeachingStructureImpl s = group.getTeachStruct()</code>
	 *
	 * @return the teaching structure to which the subjects' group belongs.
	 * 
	 * @see fr.umlv.ir3.flexitime.common.data.ISubjectsGroup#getParentTeachStruct()
	 */
	public ITeachingStructure getParentTeachStruct()
	{
		return parentTeachStruct;
	}

	/** 
	 * Sets the teaching structure to which the subjects' group belongs.
	 * <code>group.setTeachStruct(struct)</code>
	 *
	 * @param struct the teaching structure to which the subjects' group belongs.
	 * 
	 * @see fr.umlv.ir3.flexitime.common.data.ISubjectsGroup#setParentTeachStruct(ITeachingStructure)
	 */
	public void setParentTeachStruct(ITeachingStructure struct)
	{
		this.parentTeachStruct = struct;		
	}

}

