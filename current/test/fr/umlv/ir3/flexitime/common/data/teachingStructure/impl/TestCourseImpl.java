/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.teachingStructure.impl;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import fr.umlv.ir3.flexitime.common.data.impl.DataImpl;
import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject;

/**
 * Defines a course. It can be a CM, TD or TP. It containes a list of professors
 * associated to this course.
 * 
 * @version 245
 * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class TestCourseImpl extends TestCase
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3257852077735753267L;
    
    // ====== //
    // Champs //
    // ====== //
    private int               type;
    private int               nbHours;
    private Color             color;
    private List<ITeacher>    lstTeacher;
    private int               defaultLength;
    private ISubject          parentSubject;

    // ============= //
    // Constructeurs //
    // ============= //
    /**
     * Default constructor for a course.
     */
    protected TestCourseImpl()
    {
        lstTeacher = new ArrayList<ITeacher>();
    }

    

    // ===========//
    // Méthodes //
    // ===========//
    /**
     * Returns the type of the course. <code>Int i = course.getType()</code>
     * 
     * @return an int representing the type of the course.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse#getType()
     */
    public void testGetType()
    {
    }

    /**
     * Sets the type of course. <code>course.setType(type)</code>
     * 
     * @param type
     *            an int representing the type of course.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse#setType(int)
     */
    public void testSetType()
    {
    }

    /**
     * Returns the number of hours for this course.
     * <code>Int i = course.getNbHours()</code>
     * 
     * @return the number of hours for this course.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse#getNbHours()
     */
    public void testGetNbHours()
    {
    }

    /**
     * Sets the number of hours for this course.
     * <code>course.setNbHours(nbHours)</code>
     * 
     * @param nbHours
     *            the number of hours for this course.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse#setNbHours(int)
     */
    public void testSetNbHours()
    {
    }

    /**
     * Returns the default length of the course.
     * <code>Int i = course.getDefaultLength()</code>
     * 
     * @return the default length of the course.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse#getDefaultLength()
     */
    public void testGetDefaultLength()
    {
    }

    /**
     * Sets the default length of the course.
     * <code>course.setDefaultLength(hour)</code>
     * 
     * @param hour
     *            the default length.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse#setDefaultLength(int)
     */
    public void testSetDefaultLength()
    {
    }

    /**
     * Returns the color of the course. <code>Int i = course.getColor()</code>
     * 
     * @return the int representing the color of the course.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse#getColor()
     */
    public void testGetColor()
    {

    }

    /**
     * Sets the color of the course. <code>course.setColor(color)</code>
     * 
     * @param color
     *            a color represented by an int.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse#setColor(Color)
     */
    public void testSetColor()
    {
    }

    /**
     * Returns the list of teachers.
     * <code>List l = course.getLstTeacher()</code>
     * 
     * @return the list of teachers.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse#getLstTeacher()
     */
    public void testGetLstTeacher()
    {
    }

    /**
     * Sets the list of teachers. <code>exemple d'appel de la methode</code>
     * 
     * @param lstTeacher
     *            the list of teachers.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse#setLstTeacher(java.util.List)
     */
    public void testSetLstTeacher()
    {
    }

    /**
     * Adds a teacher to the list. <code>course.addTeacher(teacher)</code>
     * 
     * @param teacher
     *            a teacher.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse#addTeacher(fr.umlv.ir3.flexitime.common.data.resources.ITeacher)
     */
    public void testAddTeacher()
    {
    }

    /**
     * Removes a teacher of the list. <code>course.removeTeacher(teacher)</code>
     * 
     * @param teacher
     *            a teacher.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse#removeTeacher(fr.umlv.ir3.flexitime.common.data.resources.ITeacher)
     */
    public void testRemoveTeacher()
    {
    }

    /**
     * Returns the subject to which the course belongs.
     * <code>SubjectImpl s = course.getParentSubject()</code>
     * 
     * @return the subject to which the course belongs.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse#getParentSubject()
     */
    public void testGetParentSubject()
    {
;
    }

    /**
     * Sets the subject to which the course belongs.
     * <code>course.setParentSubject(subject)</code>
     * 
     * @param subject
     *            the subject to which the course belongs.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse#setParentSubject(fr.umlv.ir3.flexitime.common.data.teachingStructure.impl.SubjectImpl)
     */
    public void testSetParentSubject()
    {
    }
}
