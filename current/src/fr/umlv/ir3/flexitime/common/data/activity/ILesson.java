/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.activity;

import java.util.List;
import java.util.Set;

import fr.umlv.ir3.flexitime.common.data.resources.IDevice;
import fr.umlv.ir3.flexitime.common.data.resources.IGroup;
import fr.umlv.ir3.flexitime.common.data.resources.IResource;
import fr.umlv.ir3.flexitime.common.data.resources.IRoom;
import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse;

/**
 * A lesson is an unavailabilities with different resources as teachers, devices
 * and groups
 * 
 * @version 220
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface ILesson extends IBusy
{

    /**
     * Add a Resource in a lesson .
     * 
     * @param resource
     *            the new Resource in a lesson.
     * @return TODO
     */
    boolean addResource(IResource resource);

    /**
     * Remove Resource in a lesson.
     * 
     * @param resource
     *            the new Resource in a lesson
     */
    void removeResource(IResource resource);

    /**
     * Getter for List of ITeacher
     * 
     * @return List of ITeacher
     */
    public Set<ITeacher> getSetTeacher();

    /**
     * Setter for List of ITeacher
     * 
     * @param lteacher
     *            List to set
     */
    public void setSetTeacher(Set<ITeacher> lteacher);

    /**
     * Getter for List of IDevice
     * 
     * @return List of IDevice
     */
    public Set<IDevice> getSetDevice();

    /**
     * Setter for List of IDevice
     * 
     * @param ldevice
     *            List to set
     */
    public void setSetDevice(Set<IDevice> ldevice);

    /**
     * Getter for List of IRoom
     * 
     * @return List of IRoom
     */
    public Set<IRoom> getSetRoom();

    /**
     * Setter for List of IGroup
     * 
     * @param lroom
     *            List to set
     */
    public void setSetRoom(Set<IRoom> lroom);

    /**
     * Getter for List of IGroup
     * 
     * @return List of IGroup
     */
    public Set<IGroup> getSetGroup();

    /**
     * Setter for List of IGroup
     * 
     * @param lgroup
     *            List to set
     */
    public void setSetGroup(Set<IGroup> lgroup);

    /**
     * Getter for ICourse contained in this Busy
     * 
     * @return ICourse
     */
    public ICourse getCourse();

    /**
     * Setter for ICourse
     * 
     * @param _course
     *            ICourse to set
     */
    public void setCourse(ICourse _course);

    /**
     * Return length
     * 
     * @return Returns the length.
     */
    public int getLength();

    /**
     * Set length
     * 
     * @param length
     *            The length to set.
     */
    public void setLength(int length);
    
    /**
     *  
     * Get all resources contained in this lesson
     *
     * @return List of IResource
     * 
     */
    public List<IResource> getAllResources();
    
}
