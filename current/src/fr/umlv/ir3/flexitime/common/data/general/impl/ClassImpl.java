/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.general.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.general.*;
import fr.umlv.ir3.flexitime.common.data.impl.DataImpl;
import fr.umlv.ir3.flexitime.common.data.resources.IGroup;
import fr.umlv.ir3.flexitime.common.data.resources.impl.GroupImpl;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure;

/**
 * Defines a class which contains groups.
 * 
 * @version 245
 * @see fr.umlv.ir3.flexitime.common.data.general.IClass
 * @see fr.umlv.ir3.flexitime.common.data.general.impl.TrackImpl
 * @see fr.umlv.ir3.flexitime.common.data.resources.impl.GroupImpl
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class ClassImpl extends DataImpl implements IClass
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long  serialVersionUID = 3257282513616711735L;
    // ===========//
    // Champs //
    // ===========//
    private List<IGroup>       lstGroups;
    private ITeachingStructure teachingStructure;
    private ITrack             parentTrack;
    private int                nbSubGroup;

    // ==================//
    // Constructeurs //
    // ==================//
    /**
     * Default constructor for a class.
     */
    protected ClassImpl()
    {
        lstGroups = new ArrayList<IGroup>();
    }

    /**
     * Constructs a class with a name and the parent track in parameter.
     * 
     * @param name
     *            a string.
     * @param track
     *            the parent track.
     */
    public ClassImpl(String name, ITrack track)
    {
        super(name);
        this.parentTrack = track;
        lstGroups = new ArrayList<IGroup>();
        nbSubGroup = 1;
    }

    /**
     * Constructs a class.
     * 
     * @param sName
     *            a string for the name of this class.
     * @param listOfGroups
     *            the list of groups in this class.
     * @param struct
     *            the teaching structure of this class.
     * @param track
     *            the parent track.
     * @param nbSubGroup 
     */
    public ClassImpl(String sName, ITrack track, int nbSubGroup, List<IGroup> listOfGroups,
            ITeachingStructure struct)
    {
        super(sName);
        this.nbSubGroup = nbSubGroup;
        this.lstGroups = listOfGroups;
        this.teachingStructure = struct;
        this.parentTrack = track;
    }

    // ======== //
    // Méthodes //
    // ======== //
    /**
     * Calculates the number of persons and groups in this class.
     * <code>class.calculNbPersonAndNbGroup()</code>
     * 
     * @return number of personn in this class
     * 
     */
    public int calculNbPerson()
    {
        int iNbPerson = 0;
        Iterator iter = lstGroups.iterator();
        while (iter.hasNext())
        {
            GroupImpl gr = (GroupImpl) iter.next();
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
        return lstGroups.size();
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
     * <code>ITeachingStructure teachingStructure = class.getTeachingStructure()</code>
     * 
     * @return the teaching structure of this class.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.IClass#getTeachingStructure()
     */
    public ITeachingStructure getTeachingStructure()
    {
        return teachingStructure;
    }

    /**
     * Sets the teaching structure for this class.
     * <code>class.setTeachingStructure(struct)</code>
     * 
     * @param struct
     *            a teaching structure.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.IClass#setTeachingStructure(fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure)
     */
    public void setTeachingStructure(ITeachingStructure struct)
    {
        teachingStructure = struct;
    }

    /**
     * Returns the list of groups in this class.
     * <code>List list = class.getLstGroups()</code>
     * 
     * @return the list of groups in this class.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.IClass#getLstGroups()
     */
    public List<IGroup> getLstGroups()
    {
        return lstGroups;
    }

    /**
     * Sets the list of groups for this class.
     * <code>class.setLstGroups(list)</code>
     * 
     * @param lstGroup
     *            the original list of groups for this class.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.IClass#setLstGroups(java.util.List)
     */
    public void setLstGroups(List<IGroup> lstGroup)
    {
        lstGroups = lstGroup;
    }

    /**
     * Adds a group in the list of groups for this class.
     * <code>class.addGroup(group)</code>
     * 
     * @param group
     *            a group to add to the list.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.IClass#addGroup(fr.umlv.ir3.flexitime.common.data.resources.IGroup)
     */
    public boolean addGroup(IGroup group)
    {
        group.setParentClass(this);
        return lstGroups.add(group);
    }

    /**
     * Removes a group from the list of groups for this class.
     * <code>class.removeGroup(group)</code>
     * 
     * @param group
     *            a group to remove of the list.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.IClass#removeGroup(fr.umlv.ir3.flexitime.common.data.resources.IGroup)
     */
    public boolean removeGroup(IGroup group)
    {
        return lstGroups.remove(group);
    }

    /**
     * Returns the parent track of this class.
     * <code>TrackImpl track = class.getParentTrack()</code>
     * 
     * @return the parent track of this class.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.IClass#getParentTrack()
     */
    public ITrack getParentTrack()
    {
        return parentTrack;
    }

    /**
     * Sets the parent track of this class.
     * <code>class.getParentTrack(track)</code>
     * 
     * @param track
     *            the parent track of this class.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.IClass#setParentTrack(fr.umlv.ir3.flexitime.common.data.general.ITrack)
     */
    public void setParentTrack(ITrack track)
    {
        this.parentTrack = track;
    }
    
    /**
     * Return nbSubGroup
     * @return Returns the nbSubGroup.
     */
    public int getNbSubGroup()
    {
        return nbSubGroup;
    }
    
    /**
     * Set nbSubGroup
     * @param nbSubGroup The nbSubGroup to set.
     */
    public void setNbSubGroup(int nbSubGroup)
    {
        this.nbSubGroup = nbSubGroup;
    }
}
