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
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup;

/**
 * Defines a subject, it containes courses.
 * 
 * @version 285
 * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class TestSubjectImpl extends TestCase
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3546637698719692343L;
    // ===========//
    // Champs //
    // ===========//
    private List<ICourse>     lstCourse;
    private ISubjectsGroup    parentSubjectsGroup;

    // =============//
    // Constructeurs//
    // =============//
    /**
     * Default constructor for a subject.
     */
    protected TestSubjectImpl()
    {
        lstCourse = new ArrayList<ICourse>();
    }

    
    // ======== //
    // Méthodes //
    // ======== //
    /**
     * Returns the list of courses. <code>List l = subject.getLstCourse()</code>
     * 
     * @return the list of courses.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject#getLstCourse()
     */
    public void testGetLstCourse()
    {;
    }

    /**
     * Sets the list of courses. <code>subject.setLstCourse(lstCourse)</code>
     * 
     * @param lstCourse
     *            the list of courses.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject#setLstCourse(java.util.List)
     */
    public void testSetLstCourse()
    {
    }

    /**
     * Adds a course to the list. <code>subject.addCourse(course)</code>
     * 
     * @param course
     *            a course.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject#addCourse(fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse)
     */
    public void testAddCourse()
    {
    }

    /**
     * Removes a course of the list. <code>subject.removeCourse(course)</code>
     * 
     * @param course
     *            a course.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject#removeCourse(fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse)
     */
    public void testRemoveCourse()
    {
    }

    /**
     * Returns the subjects' group to which the subject belongs.
     * <code>SubjectsGroupImpl s = subject.getParentSubjectsGroup()</code>
     * 
     * @return the subjects' group to which the subject belongs.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject#getParentSubjectsGroup()
     */
    public void testGetParentSubjectsGroup()
    {
    }

    /**
     * Sets the subjects' group to which the subject belongs.
     * <code>subject.setParentSubjectsGroup(subjectsGroup)</code>
     * 
     * @param subjectsGroup
     *            the subjects' group to which the subject belongs.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject#setParentSubjectsGroup(ISubjectsGroup)
     */
    public void testSetParentSubjectsGroup()
    {
    }
}
