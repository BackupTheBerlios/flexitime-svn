/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.teachingStructure.impl;

import java.util.ArrayList;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject;


/**
 * Defines a subject, it containes courses.
 * 
 * @version 0.1
 * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject
 * 
 * @author FlexiTeam - Adrien BOUVET
 */
public class SubjectImpl implements ISubject
{
    //===========//
	//  Champs	 //
	//===========//
    private String strName;
    private List listOfCourses;
    
    
	//=============//
	//Constructeurs//
    //=============//
    /**
     * Constructs a subject.
     * 
     * @param name a string.
     * @param listCourses a list of courses.
     * 
     */
    public SubjectImpl(String name, List listCourses)
    {
        this.strName = name;
        this.listOfCourses = new ArrayList(listCourses);
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
        return listOfCourses;
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
        this.listOfCourses = new ArrayList(lstCourse);
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
        listOfCourses.add(course);
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
        listOfCourses.remove(course);
    }

    /** 
     * Returns the name of this subject.
     * <code>String s = subject.getName()</code>
     *
     * @return the name of this subject.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.IData#getName()
     * @author   FlexiTeam - Adrien BOUVET
     */
    public String getName()
    {
        return strName;
    }

    /** 
     * Sets the name of this subject.
     * <code>subject.setName(name)</code>
     *
     * @param name a string.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.IData#setName(java.lang.String)
     * @author   FlexiTeam - Adrien BOUVET
     */
    public void setName(String name)
    {
        this.strName = name;
    }

}

