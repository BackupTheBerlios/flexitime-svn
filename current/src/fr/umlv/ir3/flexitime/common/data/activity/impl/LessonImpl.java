/*
 * Created on 5 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.activity.impl;

import java.util.*;
import java.util.List;

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
public class LessonImpl extends BusyImpl implements ILesson
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3761686784278345271L;
    // ===========//
    // Champs //
    // ===========//
    private List<IDevice>     lstDevice;
    private List<IRoom>       lstRoom;
    private List<ITeacher>    lstTeacher;
    private List<IGroup>      lstGroup;
    private ICourse           course;
    private int               length;

    // =============//
    // Constructeurs//
    // =============//
    /**
     * Constructs an unavailibility for a course with just a name in parameter.
     * 
     */
    protected LessonImpl()
    {
        lstDevice = new ArrayList<IDevice>();
        lstRoom = new ArrayList<IRoom>();
        lstTeacher = new ArrayList<ITeacher>();
        lstGroup = new ArrayList<IGroup>();
    }
    
    /**
     * Constructs an unavailibility for a course.
     * 
     * @param g
     *            the gap between the unavailibility.
     * @param _course
     *            ICourse associated with this Lesson
     * 
     */
    public LessonImpl(Gap g, ICourse _course)
    {
        this(g, _course, _course.getDefaultLength());
    }

    /**
     * Constructs an unavailibility for a course.
     * 
     * @param g
     *            the gap between the unavailibility.
     * @param _course
     *            ICourse associated with this Lesson
     * @param l
     *            the length of the lesson
     * 
     */
    public LessonImpl(Gap g, ICourse _course, int l)
    {
        super(g);
        lstDevice = new ArrayList<IDevice>();
        lstRoom = new ArrayList<IRoom>();
        lstTeacher = new ArrayList<ITeacher>();
        lstGroup = new ArrayList<IGroup>();

        course = _course;
        length = l;
    }
    
    /**
     * Constructs an unavailibility for a course.
     * 
     * @param g
     *            the gap between the unavailibility.
     * @param _course
     *            ICourse associated with this Lesson
     * @param defaultTeach
     *            the teacher who teach these lesson
     * @param group
     *            the group who learn this lesson
     */
    public LessonImpl(Gap g, ICourse _course, ITeacher defaultTeach,
            IGroup group)
    {
        this(g, _course, _course.getDefaultLength());
        lstTeacher.add(defaultTeach);
        lstGroup.add(group);
    }

    /**
     * Constructs an unavailibility for a course.
     * 
     * @param g
     *            the gap between the unavailibility.
     * @param _course
     *            ICourse associated with this Lesson
     * @param l
     *            the length of the lesson
     * @param defaultTeach
     *            the teacher who teach these lesson
     * @param group
     *            the group who learn this lesson
     */
    public LessonImpl(Gap g, ICourse _course, int l , ITeacher defaultTeach,
            IGroup group)
    {
        this(g, _course, l);
        lstTeacher.add(defaultTeach);
        lstGroup.add(group);
    }
    
    /**
     * Copy a lesson to create a new lesson.
     * 
     * @param lesson
     *            the unavaibility to copy
     */
    public LessonImpl(ILesson lesson)
    {
        this(lesson.getGap(), lesson.getCourse(), lesson.getLength());
        for (Iterator iter = lesson.getLstDevice().iterator() ; iter.hasNext() ;)
        {
            IDevice element = (IDevice) iter.next();
            lstDevice.add(element);           
        }
        
        for (Iterator iter = lesson.getLstGroup().iterator() ; iter.hasNext() ;)
        {
            IGroup element = (IGroup) iter.next();
            lstGroup.add(element);
        }
        
        for (Iterator iter = lesson.getLstRoom().iterator() ; iter.hasNext() ;)
        {
            IRoom element = (IRoom) iter.next();
            lstRoom.add(element);
        }
        for (Iterator iter = lesson.getLstTeacher().iterator() ; iter.hasNext() ;)
        {
            ITeacher element = (ITeacher) iter.next();
            lstTeacher.add(element);
        }
    }

    // ===========//
    // Méthodes //
    // ===========//

    /**
     * Adds a resource to the list of resources contained by the lesson.
     * <code>addResource(resource)</code>
     * 
     * @param resource
     *            resource to add to the list.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#addResource(fr.umlv.ir3.flexitime.common.data.resources.IResource)
     */
    public void addResource(IResource resource)
    {
        if (resource instanceof IRoom)
        {
            lstRoom.add((IRoom) resource);
        }
        else if (resource instanceof IDevice)
        {
            lstDevice.add((IDevice) resource);
        }
        else if (resource instanceof IGroup)
        {
            lstGroup.add((IGroup) resource);
        }
        else if (resource instanceof ITeacher)
        {
            lstTeacher.add((ITeacher) resource);
        }

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
    public void removeResource(IResource resource)
    {
        if (resource instanceof IRoom)
        {
            lstRoom.remove(resource);
        }
        else if (resource instanceof IDevice)
        {
            lstDevice.remove(resource);
        }
        else if (resource instanceof IGroup)
        {
            lstGroup.remove(resource);
        }
        else if (resource instanceof ITeacher)
        {
            lstTeacher.remove(resource);
        }
    }

    /**
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#getLstTeacher()
     */
    public List getLstTeacher()
    {
        return lstTeacher;
    }

    /**
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#getLstDevice()
     */
    public List getLstDevice()
    {
        return lstDevice;
    }

    /**
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#getLstRoom()
     */
    public List getLstRoom()
    {
        return lstRoom;
    }

    /**
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#getLstGroup()
     */
    public List getLstGroup()
    {
        return lstGroup;
    }

    /**
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#getCourse()
     */
    public ICourse getCourse()
    {
        return course;
    }

    /**
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#setLstTeacher(List)
     */
    public void setLstTeacher(List<ITeacher> lteacher)
    {
        lstTeacher = lteacher;

    }

    /**
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#setLstDevice(List)
     */
    public void setLstDevice(List<IDevice> ldevice)
    {
        lstDevice = ldevice;

    }

    /**
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#setLstRoom(List)
     */
    public void setLstRoom(List<IRoom> lroom)
    {
        lstRoom = lroom;
    }

    /**
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#setLstGroup(List)
     */
    public void setLstGroup(List<IGroup> lgroup)
    {
        lstGroup = lgroup;
    }

    /**
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#setCourse(ICourse)
     */
    public void setCourse(ICourse _course)
    {
        course = _course;
    }

    /**
     * Return length
     * 
     * @return Returns the length.
     */
    public int getLength()
    {
        return length;
    }

    /**
     * Set length
     * 
     * @param length
     *            The length to set.
     */
    public void setLength(int length)
    {
        this.length = length;
    }
}
