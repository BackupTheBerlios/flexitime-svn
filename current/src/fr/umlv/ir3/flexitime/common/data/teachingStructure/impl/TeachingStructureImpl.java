/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.teachingStructure.impl;

import java.util.*;

import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.impl.DataImpl;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.*;

/**
 * Defines a teaching structure, it contains subjects' groups.
 * 
 * @version 245
 * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class TeachingStructureImpl extends DataImpl implements
        ITeachingStructure
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long    serialVersionUID = 3256721771226083378L;

    // ===========//
    // Champs //
    // ===========//
    private List<ISubjectsGroup> lstSubjectsGroup;
    private IClass               parentClass;

    // =============//
    // Constructeurs//
    // =============//
    /**
     * Default constructor for a teaching structure.
     */
    protected TeachingStructureImpl()
    {
        lstSubjectsGroup = new ArrayList<ISubjectsGroup>();
    }

    /**
     * Constructs a teaching structure with just a name in parameter.
     * 
     * @param name
     *            a string.
     * @param parent
     *            the class who have this Teaching Structure
     */
    public TeachingStructureImpl(String name, IClass parent)
    {
        super(name);
        parentClass = parent;
        lstSubjectsGroup = new ArrayList<ISubjectsGroup>();
    }

    // ======== //
    // Méthodes //
    // ======== //
    /**
     * Returns the list of subjects' groups.
     * <code>List l = struct.getLstSubjectsGroup()</code>
     * 
     * @return the list of subjects' groups.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure#getLstSubjectsGroup()
     */
    public List<ISubjectsGroup> getLstSubjectsGroup()
    {
        return lstSubjectsGroup;
    }

    /**
     * Sets the list of subjects' groups
     * <code>struct.setLstSubjectsGroup(lst)</code>
     * 
     * @param lst
     *            the list of subjects' groups.
     */
    public void setLstSubjectsGroup(List<ISubjectsGroup> lst)
    {
        lstSubjectsGroup = lst;
    }

    /**
     * Adds a subjects' group to the list.
     * <code>struct.addSubjectsGroup(subjectsGroup)</code>
     * 
     * @param subjectsGroup
     *            the subjects' group to add to the list.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure#addSubjectsGroup(fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup)
     */
    public void addSubjectsGroup(ISubjectsGroup subjectsGroup)
    {
        lstSubjectsGroup.add(subjectsGroup);
        subjectsGroup.setParentTeachStruct(this);
    }

    /**
     * Removes a subjects' group of the list.
     * <code>struct.removeSubjectsGroup(subjectsGroup)</code>
     * 
     * @param subjectsGroup
     *            the subjects' group to remove of the list.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure#removeSubjectsGroup(fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup)
     */
    public void removeSubjectsGroup(ISubjectsGroup subjectsGroup)
    {
        lstSubjectsGroup.remove(subjectsGroup);
    }

    /**
     * DOCME
     * 
     * @return the class who have this Teaching Structure
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure#getParentClass()
     */
    public IClass getParentClass()
    {
        return parentClass;
    }

    /**
     * DOCME
     * 
     * @param _class
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure#setParentClass(fr.umlv.ir3.flexitime.common.data.general.IClass)
     */
    public void setParentClass(IClass _class)
    {
        parentClass = _class;
    }
}
