/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.activity;

import java.util.List;

import fr.umlv.ir3.flexitime.common.data.resources.IResource;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse;

/**
 * A lesson is an unavailabilities with different resources as teachers, devices and groups
 * 
 * @version 0.1
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface ILesson extends IBusy
{
    /**
     * Add a Resource in a lesson .
     * 
     * @param resource the new Resource in a lesson.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void addResource(IResource resource);

    /**
     * Remove Resource in a lesson.
     * 
     * @param resource the new Resource in a lesson
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void removeResource(IResource resource);
    
    public List getLstTeacher();
    public void setLstTeacher(List lteacher); 
    
    public List getLstDevice();
    public void setLstDevice(List ldevice);
    
    public List getLstRoom();
    public void setLstRoom(List lroom);
    
    public List getLstGroup();
    public void setLstGroup(List lgroup);
    
    public ICourse getCourse();
    public void setCourse(ICourse _course);
    

}
