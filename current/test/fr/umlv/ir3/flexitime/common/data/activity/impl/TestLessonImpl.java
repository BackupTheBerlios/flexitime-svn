/*
 * Created on 5 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.activity.impl;

import java.util.*;

import junit.framework.TestCase;

import fr.umlv.ir3.flexitime.common.data.activity.ILesson;
import fr.umlv.ir3.flexitime.common.data.resources.*;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse;
import fr.umlv.ir3.flexitime.common.tools.Gap;

/**
 * Defines an unavailibility for a course in the TimeTable. Contains a list of
 * associated resources, a start and an end date and a name.
 * 
 * @version 240
 * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class TestLessonImpl extends TestCase
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3761686784278345271L;
    // ===========//
    // Champs //
    // ===========//
    private Set<IDevice>     setDevice;
    private Set<IRoom>       setRoom;
    private Set<ITeacher>    setTeacher;
    private Set<IGroup>      setGroup;
    private ICourse           course;
    private int               length;

    // =============//
    // Constructeurs//
    // =============//
    /**
     * Constructs an unavailibility for a course with just a name in parameter.
     * 
     */
    protected TestLessonImpl()
    {
        setDevice = new HashSet<IDevice>();
        setRoom = new HashSet<IRoom>();
        setTeacher = new HashSet<ITeacher>();
        setGroup = new HashSet<IGroup>();
    }
    
    

    // ======== //
    // Méthodes //
    // ======== //

    /**
     * Adds a resource to the list of resources contained by the lesson.
     * <code>addResource(resource)</code>
     * 
     * @param resource
     *            resource to add to the list.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#addResource(fr.umlv.ir3.flexitime.common.data.resources.IResource)
     */
    public void testAddResource()
    {
    }

    /**
     * Removes a resource of the list of resources contained by the lesson.
     * <code>removeResource(resource)</code>
     * 
     * @param resource
     *            resource to remove of the list.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#removeResource(fr.umlv.ir3.flexitime.common.data.resources.IResource)
     */
    public void testRemoveResource()
    {
    }

    /**
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#getSetTeacher()
     */
    public void testGetSetTeacher()
    {
    }

    /**
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#getSetDevice()
     */
    public void testGetSetDevice()
    {
    }

    /**
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#getSetRoom()
     */
    public void testGetSetRoom()
    {
    }

    /**
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#getSetGroup()
     */
    public void testGetSetGroup()
    {
    }

    /**
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#getCourse()
     */
    public void testGetCourse()
    {
    }

    /**
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#setSetTeacher(Set)
     */
    public void testSetSetTeacher()
    {

    }

    /**
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#setSetDevice(Set)
     */
    public void testSetSetDevice()
    {

    }

    /**
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#setSetRoom(Set)
     */
    public void testSetSetRoom()
    {
    }

    /**
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#setSetGroup(Set)
     */
    public void testSetSetGroup()
    {
    }

    /**
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#setCourse(ICourse)
     */
    public void testSetCourse()
    {
    }

    /**
     * Return length
     * 
     * @return Returns the length.
     */
    public void testGetLength()
    {
    }

    /**
     * Set length
     * 
     * @param length
     *            The length to set.
     */
    public void testSetLength()
    {
    }
    
    
    /** 
     * Get all the reources in a List
     * @return List of Iresource
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#getAllResources()
     */
    public void testGetAllResources()
    {

    }
}
