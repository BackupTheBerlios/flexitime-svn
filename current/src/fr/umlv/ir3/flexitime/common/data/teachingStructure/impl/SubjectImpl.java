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
 * Defines a subject, it containes courses.
 * 
 * @version 230
 * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class SubjectImpl extends DataImpl implements ISubject
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
    protected SubjectImpl()
    {
        lstCourse = new ArrayList<ICourse>();
    }

    /**
     * Constructs a subject with a name and the parent subjects' group in
     * parameter.
     * 
     * @param name
     *            a string.
     * @param subjectsGroup
     *            the parent subjects' group of this subject.
     */
    public SubjectImpl(String name, ISubjectsGroup subjectsGroup)
    {
        super(name);
        this.parentSubjectsGroup = subjectsGroup;
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
    public List<ICourse> getLstCourse()
    {
        return lstCourse;
    }

    /**
     * Sets the list of courses. <code>subject.setLstCourse(lstCourse)</code>
     * 
     * @param lstCourse
     *            the list of courses.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject#setLstCourse(java.util.List)
     */
    public void setLstCourse(List<ICourse> lstCourse)
    {
        this.lstCourse = lstCourse;
    }

    /**
     * Adds a course to the list. <code>subject.addCourse(course)</code>
     * 
     * @param course
     *            a course.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject#addCourse(fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse)
     */
    public void addCourse(ICourse course)
    {
        lstCourse.add(course);
        course.setParentSubject(this);
    }

    /**
     * Removes a course of the list. <code>subject.removeCourse(course)</code>
     * 
     * @param course
     *            a course.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject#removeCourse(fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse)
     */
    public void removeCourse(ICourse course)
    {
        lstCourse.remove(course);
    }

    /**
     * Returns the subjects' group to which the subject belongs.
     * <code>SubjectsGroupImpl s = subject.getParentSubjectsGroup()</code>
     * 
     * @return the subjects' group to which the subject belongs.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject#getParentSubjectsGroup()
     */
    public ISubjectsGroup getParentSubjectsGroup()
    {
        return parentSubjectsGroup;
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
    public void setParentSubjectsGroup(ISubjectsGroup subjectsGroup)
    {
        this.parentSubjectsGroup = subjectsGroup;
    }
}
