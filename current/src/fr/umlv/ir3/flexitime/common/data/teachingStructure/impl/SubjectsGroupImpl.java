/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.teachingStructure.impl;

import java.util.*;

import fr.umlv.ir3.flexitime.common.data.impl.DataImpl;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.*;

/**
 * Defines a subjects' group, it contains subjects.
 * 
 * @version 245
 * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class SubjectsGroupImpl extends DataImpl implements ISubjectsGroup
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long  serialVersionUID = 3689355416107038776L;
    // ===========//
    // Champs //
    // ===========//
    private List<ISubject>     lstSubject;
    private ITeachingStructure parentTeachStruct;

    // =============//
    // Constructeurs//
    // =============//
    /**
     * Default constructor for a subjects' group.
     */
    protected SubjectsGroupImpl()
    {
        lstSubject = new ArrayList<ISubject>();
    }

    /**
     * Constructs a subjects' group with a name and the parent teaching
     * structure in parameter.
     * 
     * @param name
     *            a string.
     * @param struct
     *            the parent teaching structure of this subjects' group.
     */
    public SubjectsGroupImpl(String name, ITeachingStructure struct)
    {
        super(name);
        this.parentTeachStruct = struct;
        lstSubject = new ArrayList<ISubject>();
    }

    // ======== //
    // Méthodes //
    // ======== //
    /**
     * Returns the list of subjects. <code>List l = group.getLstSubject()</code>
     * 
     * @return the list of subjects.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup#getLstSubject()
     */
    public List<ISubject> getLstSubject()
    {
        return lstSubject;
    }

    /**
     * Sets the list of subjects. <code>group.setLstSubject(lst)</code>
     * 
     * @param lstSubject
     *            the list of subjects.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup#setLstSubject(java.util.List)
     */
    public void setLstSubject(List<ISubject> lstSubject)
    {
        this.lstSubject = lstSubject;
    }

    /**
     * Adds a subject to the list. <code>group.addSubject(subject)</code>
     * 
     * @param subject
     *            a subject to add to the list.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup#addSubject(fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject)
     */
    public void addSubject(ISubject subject)
    {
        lstSubject.add(subject);
        subject.setParentSubjectsGroup(this);
    }

    /**
     * Removes a subject of the list. <code>group.removeSubject(subject)</code>
     * 
     * @param subject
     *            a subject to remove of the list.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup#removeSubject(fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject)
     */
    public void removeSubject(ISubject subject)
    {
        lstSubject.remove(subject);
    }

    /**
     * Returns the teaching structure to which the subjects' group belongs.
     * <code>TeachingStructureImpl s = group.getTeachStruct()</code>
     * 
     * @return the teaching structure to which the subjects' group belongs.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup#getParentTeachStruct()
     */
    public ITeachingStructure getParentTeachStruct()
    {
        return parentTeachStruct;
    }

    /**
     * Sets the teaching structure to which the subjects' group belongs.
     * <code>group.setTeachStruct(struct)</code>
     * 
     * @param struct
     *            the teaching structure to which the subjects' group belongs.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup#setParentTeachStruct(ITeachingStructure)
     */
    public void setParentTeachStruct(ITeachingStructure struct)
    {
        this.parentTeachStruct = struct;
    }

    /**
     * Test the equality of two subject group.
     * 
     * @param obj
     *            other subject group to compare with
     * @return <code>true</code> if this object is the same as the obj
     *         argument; <code>false</code> otherwise.
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj)
    {
        if (obj == null) return false;
        if (! ( obj instanceof ISubjectsGroup )) return false;
        ISubjectsGroup other = (ISubjectsGroup) obj;
        if ( ( ( idData != null ) && ( other.getIdData() == null ) )
                || ( ( idData == null ) && ( other.getIdData() != null ) ))
            return false;
        if (idData == null)
        {
            if (this.getName().equals(other.getName()))
                return parentTeachStruct.equals(other.getParentTeachStruct());
            return false;
        }
        return ( idData == other.getIdData() );
    }

    /**
     * Generated by the hashcode of the name.
     * 
     * @return a class hashcode
     * 
     * @see java.lang.Object#hashCode()
     */
    public int hashCode()
    {
        return this.getName().hashCode();
    }
}
