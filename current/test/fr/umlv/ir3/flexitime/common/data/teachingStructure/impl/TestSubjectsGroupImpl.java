/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.teachingStructure.impl;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import fr.umlv.ir3.flexitime.common.data.impl.DataImpl;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure;

/**
 * Defines a subjects' group, it contains subjects.
 * 
 * @version 285
 * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class TestSubjectsGroupImpl extends TestCase
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
    public void testGetLstSubject()
    {
    }

    /**
     * Sets the list of subjects. <code>group.setLstSubject(lst)</code>
     * 
     * @param lstSubject
     *            the list of subjects.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup#setLstSubject(java.util.List)
     */
    public void testSetLstSubject()
    {
    }

    /**
     * Adds a subject to the list. <code>group.addSubject(subject)</code>
     * 
     * @param subject
     *            a subject to add to the list.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup#addSubject(fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject)
     */
    public void testAddSubject()
    {
    }

    /**
     * Removes a subject of the list. <code>group.removeSubject(subject)</code>
     * 
     * @param subject
     *            a subject to remove of the list.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup#removeSubject(fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject)
     */
    public void removeSubject()
    {
    }

    /**
     * Returns the teaching structure to which the subjects' group belongs.
     * <code>TeachingStructureImpl s = group.getTeachStruct()</code>
     * 
     * @return the teaching structure to which the subjects' group belongs.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup#getParentTeachStruct()
     */
    public void getParentTeachStruct()
    {
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
    public void setParentTeachStruct()
    {
    }
}
