/*
 * Created on 5 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.activity.impl;

import java.util.*;

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
    protected LessonImpl()
    {
        setDevice = new HashSet<IDevice>();
        setRoom = new HashSet<IRoom>();
        setTeacher = new HashSet<ITeacher>();
        setGroup = new HashSet<IGroup>();
    }
    
    /**
     * Constructs an unavailibility for a course without group.
     * 
     * @param g
     *            the gap between the unavailibility.
     * @param _course
     *            ICourse associated with this Lesson
     * 
     */
    private LessonImpl(Gap g, ICourse _course)
    {
        super(g);
        setDevice = new HashSet<IDevice>();
        setRoom = new HashSet<IRoom>();
        setTeacher = new HashSet<ITeacher>();
        setGroup = new HashSet<IGroup>();
        
        course = _course;
    }
    
    /**
     * Constructs an unavailibility for a course.
     * 
     * @param g
     *            the gap between the unavailibility.
     * @param _course
     *            group list who learn this lesson
     * @param groups
     *            the group who learn this lesson            
     * 
     */
    public LessonImpl(Gap g, ICourse _course, List<IGroup> groups)
    {
        this(g, _course, groups, _course.getDefaultLength());
    }

    /**
     * Constructs an unavailibility for a course.
     * 
     * @param g
     *            the gap between the unavailibility.
     * @param _course
     *            ICourse associated with this Lesson
     * @param groups
     *            group list who learn this lesson            
     * @param l
     *            the length of the lesson
     * 
     */
    public LessonImpl(Gap g, ICourse _course, List<IGroup> groups, int l)
    {
        this(g, _course);
//        for (IGroup gElem : groups)
//            addResource(gElem);
        length = l;
    }
    
    /**
     * Constructs an unavailibility for a course.
     * 
     * @param g
     *            the gap between the unavailibility.
     * @param _course
     *            ICourse associated with this Lesson
     * @param groups
     *            group list who learn this lesson
     * @param defaultTeach
     *            the teacher who teach these lesson
     */
    public LessonImpl(Gap g, ICourse _course, List<IGroup> groups, ITeacher defaultTeach)
    {
        this(g, _course, groups, _course.getDefaultLength(), defaultTeach);
    }

    /**
     * Constructs an unavailibility for a course.
     * 
     * @param g
     *            the gap between the unavailibility.
     * @param _course
     *            ICourse associated with this Lesson
     * @param groups
     *            group list who learn this lesson
     * @param l
     *            the length of the lesson
     * @param defaultTeach
     *            the teacher who teach these lesson
     */
    public LessonImpl(Gap g, ICourse _course, List<IGroup> groups, int l , ITeacher defaultTeach)
    {
        this(g, _course, groups, l);
//        addResource(defaultTeach);
    }
    
    /**
     * Copy a lesson to create a new lesson.
     * 
     * @param lesson
     *            the unavaibility to copy
     */
    public LessonImpl(ILesson lesson)
    {
        this(lesson.getGap(), lesson.getCourse());
        length = lesson.getLength();
//        for (Iterator iter = lesson.getLstDevice().iterator() ; iter.hasNext() ;)
//            addResource((IDevice)iter.next());
//        
//        for (Iterator iter = lesson.getLstGroup().iterator() ; iter.hasNext() ;)
//            addResource((IGroup)iter.next());
//        
//        for (Iterator iter = lesson.getLstRoom().iterator() ; iter.hasNext() ;)
//            addResource((IRoom)iter.next());
//        
//        for (Iterator iter = lesson.getLstTeacher().iterator() ; iter.hasNext() ;)
//            addResource((ITeacher)iter.next());
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
    public boolean addResource(IResource resource)
    {
        boolean isIn = false;
        
        if (resource instanceof IRoom)
            isIn = setRoom.add((IRoom) resource);

        else if (resource instanceof IDevice)
            isIn = setDevice.add((IDevice) resource);

        else if (resource instanceof IGroup)
            isIn = setGroup.add((IGroup) resource);

        else if (resource instanceof ITeacher)
            isIn = setTeacher.add((ITeacher) resource);

        resource.addBusy(this);
        return isIn;
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
            setRoom.remove(resource);
        else if (resource instanceof IDevice)
           setDevice.remove(resource);
        else if (resource instanceof IGroup)
            setGroup.remove(resource);
        else if (resource instanceof ITeacher)
            setTeacher.remove(resource);
    }

    /**
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#getSetTeacher()
     */
    public Set<ITeacher> getSetTeacher()
    {
        return setTeacher;
    }

    /**
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#getSetDevice()
     */
    public Set<IDevice> getSetDevice()
    {
        return setDevice;
    }

    /**
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#getSetRoom()
     */
    public Set<IRoom> getSetRoom()
    {
        return setRoom;
    }

    /**
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#getSetGroup()
     */
    public Set<IGroup> getSetGroup()
    {
        return setGroup;
    }

    /**
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#getCourse()
     */
    public ICourse getCourse()
    {
        return course;
    }

    /**
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#setSetTeacher(Set)
     */
    public void setSetTeacher(Set<ITeacher> lteacher)
    {
        setTeacher = lteacher;

    }

    /**
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#setSetDevice(Set)
     */
    public void setSetDevice(Set<IDevice> ldevice)
    {
        setDevice = ldevice;

    }

    /**
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#setSetRoom(Set)
     */
    public void setSetRoom(Set<IRoom> lroom)
    {
        setRoom = lroom;
    }

    /**
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#setSetGroup(Set)
     */
    public void setSetGroup(Set<IGroup> lgroup)
    {
        setGroup = lgroup;
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
    
    
    /** 
     * Get all the reources in a List
     * @return List of Iresource
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#getAllResources()
     */
    public List<IResource> getAllResources()
    {
        List<IResource> l = new LinkedList<IResource>();
        
        for(IDevice d : setDevice)
            l.add(d);
        
        for(IGroup g : setGroup)
            l.add(g);
        
        for(IRoom r : setRoom)
            l.add(r);
        
        for(ITeacher t : setTeacher)
            l.add(t);
        
        return l;
    }
}
