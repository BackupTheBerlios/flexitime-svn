/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.resources.impl;

import java.util.List;

import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.general.impl.ClassImpl;
import fr.umlv.ir3.flexitime.common.data.resources.IGroup;


/**
 * Defines a group.
 * 
 * @version 0.1
 * @see fr.umlv.ir3.flexitime.common.data.resources.IGroup
 * 
 * @author FlexiTeam - Adrien BOUVET
 */
public class GroupImpl extends ResourceImpl implements IGroup
{
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3904677193450663986L;
    //===========//
	//  Champs	 //
	//===========//
    private int nbPerson; 
    private IClass parentClass;
    
    
	//=============//
	//Constructeurs//
    //=============//
	/**
	 * Default constructor for a group. 
	 */
	protected GroupImpl()
	{}
	
	/**
	 * Constructs a group with just a name in parameter.
	 * 
	 * @param name a string.
	 */
	public GroupImpl(String name)
	{
		super(name);
	}
	
	/**
	 * Constructs a group with a name and a parent class in parameter.
	 * 
	 * @param name a string.
	 * @param parentClass the parent class of this group.
	 */
	public GroupImpl(String name, ClassImpl parentClass)
	{
		super(name);
		this.parentClass = parentClass;
	}
	
	/**
	 * Constructs a group with a name and a number of person
	 * @param name name of the group
	 * @param nbPerson number of person in this group
	 */
	public GroupImpl(String name, int nbPerson)
	{
	    super(name);
	    this.nbPerson = nbPerson;
	}
	
    /**
     * Constructs a group.
     * 
     * @param name a string.
     * @param listBusy a list of unavailibilities.
     * @param nbPerson the number of students in this group.
	 * @param parentClass the parent class of this group.
     */
    public GroupImpl(String name, List listBusy, int nbPerson, ClassImpl parentClass)
    {
        super(name, listBusy);
        this.nbPerson = nbPerson;
        this.parentClass = parentClass;
    }

    
    //===========//
    // Méthodes  //
	//===========//
    /** 
     * Returns the number of students in this group.
     * <code>Int i = group.getNbPerson()</code>
     *
     * @return the number of students in this group.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.IGroup#getNbPerson()
     */
    public int getNbPerson()
    {
        return nbPerson;
    }

    /** 
     * Sets the number of students in this group.
     * <code>group.setNbPerson(nbPerson)<code>
     *
     * @param nbPerson the number of students in this group.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.IGroup#setNbPerson(int)
     */
    public void setNbPerson(int nbPerson)
    {
        this.nbPerson = nbPerson;
    }
    
	/** 
	 * Returns the parent class of this group.
	 * <code>ClassImpl c = group.getParentClass()</code>
	 *
	 * @return the parent class of this group.
	 * 
	 * @see fr.umlv.ir3.flexitime.common.data.resources.IGroup#getParentClass()
	 */
	public IClass getParentClass()
	{
		return parentClass;
	}

	/** 
	 * Sets the parent class of this group.
	 * <code>group.setParentClass(class)<code>
	 *
	 * @param parentClass the parent class of this group.
	 * 
	 * @see fr.umlv.ir3.flexitime.common.data.resources.IGroup#setParentClass(IClass)
	 */ 
	public void setParentClass(IClass parentClass)
	{
		this.parentClass = parentClass;
	}
}
