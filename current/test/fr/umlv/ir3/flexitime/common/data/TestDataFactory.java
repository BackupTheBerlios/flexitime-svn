/*
 * Created on 19 janv. 2005
 * by K-lit
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data;

import java.awt.Color;
import java.rmi.RemoteException;
import java.util.*;

import junit.framework.TestCase;

import fr.umlv.ir3.flexitime.common.data.activity.*;
import fr.umlv.ir3.flexitime.common.data.activity.impl.*;
import fr.umlv.ir3.flexitime.common.data.admin.*;
import fr.umlv.ir3.flexitime.common.data.admin.impl.*;
import fr.umlv.ir3.flexitime.common.data.general.*;
import fr.umlv.ir3.flexitime.common.data.general.impl.*;
import fr.umlv.ir3.flexitime.common.data.resources.*;
import fr.umlv.ir3.flexitime.common.data.resources.impl.*;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.*;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.impl.*;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;
import fr.umlv.ir3.flexitime.common.tools.*;

/**
 * Create all datas from specific parameters. This class contains only statics
 * methods to create each types of datas.
 * 
 * @version 216
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class TestDataFactory extends TestCase
{

    // ======== //
    // Activity //
    // ======== //
    /**
     * Create an unavaibility for a device during a Gap without reason
     * 
     * @param g
     *            the gap of the unavaibility
     * @param parent
     *              IDevice this Busy belongs to 
     * @return a new unavaibility for a device
     * @throws FlexiException 
     */
    public void testCreateDeviceBusy()
    {
       
    }

    /**
     * Constructs an unavailibility for a group between a gap without reason.
     * 
     * @param g gap of the unavaibulity
     * @param parent 
     * @return a new unavaibility for a group
     * @throws FlexiException 
     */
    public void  createGroupBusy() throws FlexiException
    {
    }
    

    /**
     * Constructs an unavailibility for a course.
     * 
     * @param g
     *            the gap between the unavailibility.
     * @param c
     *            ICourse associated with this Lesson
     * @param groups
     *            group list who learn this lesson
     * @return a new lesson
     * @throws FlexiException 
     */
    public void createLesson() throws FlexiException
    {
    }


    /**
     * Constructs an unavailibility for a room without reason.
     * 
     * @param g
     *            the gap between the unavailibility.
     * @param parent 
     * @return a new unavaibility for a room
     * @throws FlexiException 
     */
    public void createRoomBusy() 
    {
    }
    
   
    
    /**
     * Constructs an unavailibility for a teacher without reason.
     * 
     * @param g
     *            the gap between the unavailibility.
     * @param parent 
     * @return a new unavaibility for a teacher
     * @throws FlexiException 
     */
    public void  createTeacherBusy() throws FlexiException
    {
    }
    
    

    // ======= //
    // General //
    // ======= //
    /**
     * Create a new Building with the given name
     * 
     * @param name
     *            the name of the new building
     * @return a new Building naming <code>name</code>
     * @throws FlexiException 
     */
    public void  createBuilding() throws FlexiException
    {
    }

    /**
     * Create a new class with the given name and add it to the parent Track
     * 
     * @param name
     *            the name of the class
     * @param parent
     *            the track to which this class belong
     * @return a new Class
     * @throws FlexiException 
     */
    public void  createClass() 
    {
    }

    /**
     * Create a new floor with the given name and add it to the parent building
     * 
     * @param name
     *            the name of the floor
     * @param parent
     *            the building to which this floor belong
     * @return a new Class
     * @throws FlexiException 
     */
    public void createFloor() 
    {
    }

    /**
     * Create a new Track with the given name
     * 
     * @param name
     *            the name of the track
     * @return a new Class
     * @throws FlexiException 
     */
    public void  createTrack()
    {
    }

    // ========= //
    // Resources //
    // ========= //
    /**
     * Constructs a device with just a name in parameter.
     * 
     * @param name
     *            a string.
     * @return a new device
     * @throws FlexiException 
     */
    public void  createDevice() throws FlexiException
    {
    }

    

    /**
     * Constructs a group with a name and a parent class in parameter.
     * 
     * @param name a string
     * @param nbPerson 
     * @param parent the parent class of this group
     * @return a new group
     * @throws FlexiException 
     */
    public void  createGroup()
    {
    }

    

    /**
     * Constructs a teacher with just a name and a firstName in parameter.
     * 
     * @param name
     * @param firstName 
     * @return a new teacher
     * @throws FlexiException 
     */
    public void  createTeacher() throws FlexiException
    {
    }


    // ======== //
    // Teaching //
    // ======== //
    /**
     * Constructs a course with a name and the parent subject in parameter.
     * 
     * @param name
     *            a string.
     * @param parent
     *            the parent subject of this course.
     * @param type
     *            type of the course
     * @return a new Course
     * @throws FlexiException 
     */
    public void  createCourse() 
    {
    }


    /**
     * Constructs a subject with a name and the parent subjects' group in
     * parameter.
     * 
     * @param name
     *            a string.
     * @param parent
     *            the parent subjects' group of this subject.
     * @return a new Subject
     * @throws FlexiException 
     */
    public void createSubject() throws FlexiException
    {
    }

    /**
     * Constructs a subjects' group with a name and the parent teaching
     * structure in parameter.
     * 
     * @param name
     *            a string.
     * @param parent
     *            the parent teaching structure of this subjects' group.
     * @return a new Subject Group
     * @throws FlexiException 
     */
    public void  createSubjectsGroup()
    {
    }

    /**
     * Constructs a teaching structure with just a name in parameter.
     * 
     * @param name
     *            a string.
     * @param parent
     *            the class who have this Teaching Structure
     * @return a new Teaching Structure
     * @throws FlexiException 
     */
    public void  createTeachingStructure()
    {
    }
    
    // ===== //
    // Admin //
    // ===== //
    /** 
     * Create a new default user preferences
     *
     * @return default user preferences
     */
    public void  createPreferences()
    {
    }
    
    

    /**
     * Create a new <em>ldap</em> user with default preferences 
     *
     * @param name
     * @return a new user 
     * @throws FlexiException 
     */
    public void  createUser()
    {
    }
}