/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.teachingStructure.impl;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.impl.DataImpl;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure;

/**
 * Defines a teaching structure, it contains subjects' groups.
 * 
 * @version 285
 * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class TestTeachingStructureImpl extends TestCase
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
    public void testGetLstSubjectsGroup()
    {
    }

    /**
     * Sets the list of subjects' groups
     * <code>struct.setLstSubjectsGroup(lst)</code>
     * 
     * @param lst
     *            the list of subjects' groups.
     */
    public void testSetLstSubjectsGroup()
    {
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
    public void testAddSubjectsGroup()
    {
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
    public void testRemoveSubjectsGroup()
    {
    }

    /**
     * DOCME
     * 
     * @return the class who have this Teaching Structure
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure#getParentClass()
     */
    public void testGetParentClass()
    {
    }

    /**
     * DOCME
     * 
     * @param _class
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure#setParentClass(fr.umlv.ir3.flexitime.common.data.general.IClass)
     */
    public void testSetParentClass()
    {
    }
}
