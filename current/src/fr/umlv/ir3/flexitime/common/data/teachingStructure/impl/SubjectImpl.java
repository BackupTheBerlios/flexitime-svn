/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.teachingStructure.impl;

import java.util.ArrayList;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.impl.DataImpl;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup;


/**
 * Defines a subject, it containes courses.
 * 
 * @version 0.1
 * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject
 * 
 * @author FlexiTeam - Adrien BOUVET
 */
public class SubjectImpl extends DataImpl implements ISubject
{
    //===========//
	//  Champs	 //
	//===========//
    private List lstCourse;
    private ISubjectsGroup parentSubjectsGroup;
    
    
	//=============//
	//Constructeurs//
    //=============//
	/**
	 * Default constructor for a subject. 
	 */
	protected SubjectImpl()
	{}
	
	/**
	 * Constructs a subject with just a name in parameter.
	 * 
	 * @param name a string.
	 */
	public SubjectImpl(String name)
	{
		super(name);
		lstCourse = new ArrayList();
	}
	
	/**
	 * Constructs a subject with a name and the parent subjects' group in parameter.
	 * 
	 * @param name a string.
	 * @param subjectsGroup the parent subjects' group of this subject.
	 */
	public SubjectImpl(String name, SubjectsGroupImpl subjectsGroup)
	{
		super(name);
		this.parentSubjectsGroup = subjectsGroup;
	}
	
    /**
     * Constructs a subject.
     * 
     * @param name a string.
     * @param listCourses a list of courses.
     * @param subjectsGroup	the parent subjects' group of this subject. 
     */
    public SubjectImpl(String name, List listCourses, SubjectsGroupImpl subjectsGroup)
    {
        super(name);
        this.lstCourse = new ArrayList(listCourses);
        this.parentSubjectsGroup = subjectsGroup;
    }

    
    //===========//
    // Méthodes  //
	//===========//
    /** 
     * Returns the list of courses.
     * <code>List l = subject.getLstCourse()</code>
     *
     * @return the list of courses.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject#getLstCourse()
     * @author   FlexiTeam - Adrien BOUVET
     */
    public List getLstCourse()
    {
        return lstCourse;
    }

    /** 
     * Sets the list of courses.
     * <code>subject.setLstCourse(lstCourse)</code>
     *
     * @param lstCourse the list of courses.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject#setLstCourse(java.util.List)
     * @author   FlexiTeam - Adrien BOUVET
     */
    public void setLstCourse(List lstCourse)
    {
        this.lstCourse = new ArrayList(lstCourse);
    }

    /** 
     * Adds a course to the list.
     * <code>subject.addCourse(course)</code>
     *
     * @param course a course.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject#addCourse(fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse)
     * @author   FlexiTeam - Adrien BOUVET
     */
    public void addCourse(ICourse course)
    {
        lstCourse.add(course);
        course.setParentSubject(this);
    }

    /** 
     * Removes a course of the list.
     * <code>subject.removeCourse(course)</code>
     *
     * @param course a course.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject#removeCourse(fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse)
     * @author   FlexiTeam - Adrien BOUVET
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
	 * @see fr.umlv.ir3.flexitime.common.data.ISubject#getParentSubjectsGroup()
	 */
	public ISubjectsGroup getParentSubjectsGroup()
	{
		return parentSubjectsGroup;
	}


	/** 
	 * Sets the subjects' group to which the subject belongs.
	 * <code>subject.setParentSubjectsGroup(subjectsGroup)</code>
	 *
	 * @param subjectsGroup the subjects' group to which the subject belongs.
	 * 
	 * @see fr.umlv.ir3.flexitime.common.data.ISubject#setParentSubjectsGroup(ISubjectsGroup)
	 */
	public void setParentSubjectsGroup(ISubjectsGroup subjectsGroup)
	{
		this.parentSubjectsGroup = subjectsGroup;
	}
}

