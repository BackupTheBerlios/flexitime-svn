/*
 * Created on 5 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.activity.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.activity.ILesson;
import fr.umlv.ir3.flexitime.common.data.resources.IDevice;
import fr.umlv.ir3.flexitime.common.data.resources.IGroup;
import fr.umlv.ir3.flexitime.common.data.resources.IResource;
import fr.umlv.ir3.flexitime.common.data.resources.IRoom;
import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse;


/**
 * Defines an unavailibility for a course in the TimeTable.
 * Contains a list of associated resources, a start and an end date and a name.
 * 
 * @version 0.1
 * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson
 * 
 * @author FlexiTeam - Adrien BOUVET
 */
public class LessonImpl extends BusyImpl implements ILesson
{
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3761686784278345271L;
    //===========//
	//  Champs	 //
	//===========//
    private List lstDevice;
    private List lstRoom;
    private List lstTeacher;
    private List lstGroup;
    private ICourse course;
    
    //=============//
	//Constructeurs//
    //=============//
	/**
	 * Default constructor for a lesson's unavailibility. 
	 */
	protected LessonImpl()
	{}
    
	/**
	 * Constructs an unavailibility for a course with just a name in parameter. 
	 * 
	 * @param strName a string. 
	 */
	public LessonImpl(String strName)
	{
		super(strName);
		lstDevice = new ArrayList();
	    lstRoom = new ArrayList();
	    lstTeacher = new ArrayList();
	    lstGroup = new ArrayList();
	}
	
    /**
     * Constructs an unavailibility for a course. 
     * 
     * @param strName a string.
     * @param daStart the start date of the unavailibility.
     * @param daEnd the end date of the unavailibility.
     * @param _course ICourse associated with this Lesson
     * 
     */
    public LessonImpl(String strName, Date daStart, Date daEnd, ICourse _course)
    {
        super(strName,daStart,daEnd);
        lstDevice = new ArrayList();
	    lstRoom = new ArrayList();
	    lstTeacher = new ArrayList();
	    lstGroup = new ArrayList();
	    course = _course;
    }
    
    
    
    
    //===========//
    // M�thodes  //
	//===========//

    /** 
     * Adds a resource to the list of resources contained by the lesson.
     * <code>addResource(resource)</code>
     *
     * @param resource resource to add to the list.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#addResource(fr.umlv.ir3.flexitime.common.data.resources.IResource)
     */
    public void addResource(IResource resource)
    {
        if(resource instanceof IRoom)
        {
            lstRoom.add(resource);
        }
        else if(resource instanceof IDevice)
        {
            lstDevice.add(resource);
        }
        else if(resource instanceof IGroup)
        {
            lstGroup.add(resource);
        }
        else if(resource instanceof ITeacher)
        {
            lstTeacher.add(resource);
        }
        
    }

    /** 
     * Removes a resource of the list of resources contained by the lesson.
     * <code>removeResource(resource)</code>
     *
     * @param resource resource to remove of the list.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#removeResource(fr.umlv.ir3.flexitime.common.data.resources.IResource)
     */
    public void removeResource(IResource resource)
    {
        if(resource instanceof IRoom)
        {
            lstRoom.remove(resource);
        }
        else if(resource instanceof IDevice)
        {
            lstDevice.remove(resource);
        }
        else if(resource instanceof IGroup)
        {
            lstGroup.remove(resource);
        }
        else if(resource instanceof ITeacher)
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
    public void setLstTeacher(List lteacher)
    {
        lstTeacher = lteacher;
        
    }

    /** 
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#setLstDevice(List)
      */
    public void setLstDevice(List ldevice)
    {
        lstDevice = ldevice;
        
    }

    /** 
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#setLstRoom(List)
      */
    public void setLstRoom(List lroom)
    {
        lstRoom = lroom;
    }

    /** 
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#setLstGroup(List)
      */
    public void setLstGroup(List lgroup)
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

    
}

