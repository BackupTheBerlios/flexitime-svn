/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.general.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.resources.IGroup;
import fr.umlv.ir3.flexitime.common.data.resources.impl.GroupImpl;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.impl.TeachingStructureImpl;


/**
 * Defines a class which contains groups.
 * 
 * @version 0.2
 * @see fr.umlv.ir3.flexitime.common.data.general.IClass
 * @see fr.umlv.ir3.flexitime.common.data.general.impl.TrackImpl
 * @see fr.umlv.ir3.flexitime.common.data.ressources.impl.GroupImpl
 * 
 * @author FlexiTeam - Adrien BOUVET
 */
public class ClassImpl implements IClass
{
    //===========//
    //   Champs  //
    //===========// 
    private String strName;
    private List listOfGroups;
    private ITeachingStructure teachStruct;
    private TrackImpl parentTrack;
    
    
    //==================//
    //   Constructeurs  //
    //==================//
	/**
	 * Default constructor for a class. 
	 */
	protected ClassImpl()
	{}
	
	/**
	 * Constructs a class with just a name in parameter.
	 * 
	 * @param name a string.
	 */
	public ClassImpl(String name)
	{
		this.strName = name;
		listOfGroups = new ArrayList();
	}
	
	/**
	 * Constructs a class with a name and the parent track in parameter.
	 * 
	 * @param name a string.
	 * @param track the parent track.
	 */
	public ClassImpl(String name, TrackImpl track)
	{
		this.strName = name;
		this.parentTrack = track;
		listOfGroups = new ArrayList();
	}
	
    /**
     * Constructs a class.
     * 
     * @param sName a string for the name of this class.
     * @param listOfGroups the list of groups in this class.
     * @param struct the teaching structure of this class.
	 * @param track the parent track.
     */
    public ClassImpl(String sName, List listOfGroups, ITeachingStructure struct, TrackImpl track)
    {
        this.strName = sName;
        this.listOfGroups = new ArrayList(listOfGroups);
        this.teachStruct = struct;
        this.parentTrack = track;
    }

    
    //=============//
    //   Méthodes  //
    //=============//
    /**
     * Calculates the number of persons and groups in this class.
     * <code>class.calculNbPersonAndNbGroup()</code>
     *
     */
    public int calculNbPerson()
    {
        int iNbPerson = 0;
        Iterator iter = listOfGroups.iterator();
        while(iter.hasNext())
        {
            GroupImpl gr = (GroupImpl)iter.next();
            iNbPerson += gr.getNbPerson(); 
        }
        return iNbPerson;
    }
    
    
    /** 
     * Returns the number of groups in this class.
     * <code>int nbGroup = class.getNbGroup()</code>
     *
     * @return the number of groups in this class.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.IClass#getNbGroup()
     */
    public int getNbGroup()
    {
        return listOfGroups.size();
    }

    /** 
     * Returns the number of persons in this class.
     * <code>int nbPerson = class.getNbPerson()</code>
     *
     * @return the number of persons in this class.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.IClass#getNbPerson()
     */
    public int getNbPerson()
    {
        return calculNbPerson();
    }

    /** 
     * Returns the teaching structure of this class.
     * <code>ITeachingStructure teachStruct = class.getTeachingStructure()</code>
     *
     * @return the teaching structure of this class.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.IClass#getTeachingStructure()
     */
    public ITeachingStructure getTeachingStructure()
    {
        return teachStruct;
    }

    /** 
     * Sets the teaching structure for this class.
     * <code>class.setTeachingStructure(struct)</code>
     *
     * @param struct a teaching structure.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.IClass#setTeachingStructure(fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure)
     */
    public void setTeachingStructure(ITeachingStructure struct)
    {
        teachStruct = new TeachingStructureImpl(struct.getName(), struct.getLstSubjectsGroup());
    }

    /** 
     * Returns the list of groups in this class.
     * <code>List list = class.getLstGroups()</code>
     *
     * @return the list of groups in this class.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.IClass#getLstGroups()
     */
    public List getLstGroups()
    {
        return listOfGroups;
    }

    /** 
     * Sets the list of groups for this class.
     * <code>class.setLstGroups(list)</code>
     *
     * @param lstGroup the original list of groups for this class. 
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.IClass#setLstGroups(java.util.List)
     */
    public void setLstGroups(List lstGroup)
    {
        listOfGroups = new ArrayList(lstGroup);
    }

    /** 
     * Adds a group in the list of groups for this class.
     * <code>class.addGroup(group)</code>
     *
     * @param group a group to add to the list.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.IClass#addGroup(fr.umlv.ir3.flexitime.common.data.ressources.IGroup)
     */
    public void addGroup(IGroup group)
    {
        listOfGroups.add(group);
    }

    /** 
     * Removes a group from the list of groups for this class.
     * <code>class.removeGroup(group)</code>
     *
     * @param group a group to remove of the list.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.IClass#removeGroup(fr.umlv.ir3.flexitime.common.data.ressources.IGroup)
     */
    public void removeGroup(IGroup group)
    {
        listOfGroups.remove(group);
    }
    
	/** 
	 * Returns the parent track of this class.
	 * <code>TrackImpl track = class.getParentTrack()</code>
	 *
	 * @return the parent track of this class.
	 * 
	 * @see fr.umlv.ir3.flexitime.common.general.IClass#getParentTrack()
	 */
	public TrackImpl getParentTrack()
	{
		return parentTrack;
	}

	/**
	 * Sets the parent track of this class.
	 * <code>class.getParentTrack(track)</code>
	 * 
	 * @param track the parent track of this class.
	 * 
	 * @see fr.umlv.ir3.flexitime.common.general.IClass#setParentTrack(fr.umlv.ir3.flexitime.common.data.general.impl.TrackImpl)
	 */
	public void setParentTrack(TrackImpl track)
	{
		this.parentTrack = track;
	}

    /** 
     * Returns the name of this class.
     * <code>String name = class.getName()</code>
     *
     * @return the name of this class.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.IData#getName()
     */
    public String getName()
    {
        return strName;
    }

    /** 
     * Sets the name of this class.
     * <code>class.setName(name)</code>
     *
     * @param name a string.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.IData#setName(java.lang.String)
     */
    public void setName(String name)
    {
        this.strName = name;
    }

}

