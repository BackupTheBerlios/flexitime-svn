/*
 * Created on 17 janv. 2005
 * by Jérôme GUERS
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.activity;

import fr.umlv.ir3.flexitime.common.data.activity.impl.*;
import fr.umlv.ir3.flexitime.common.data.resources.*;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse;
import fr.umlv.ir3.flexitime.common.tools.Gap;

/**
 * Create all datas from specific parameters. This class contains only statics
 * methods to create each types of datas.
 * 
 * @version 201
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class BusyFactory
{

    /**
     * Create an unavaibility for a device during a Gap without reason
     * 
     * @param g
     *            the gap of the unavaibility
     * @return a new unavaibility for a device
     */
    public static IDeviceBusy createDeviceBusy(Gap g)
    {
        return new DeviceBusyImpl(g);
    }

    /**
     * Create an unavaibility for a device during a Gap for the specified reason
     * 
     * @param g
     *            the gap of the unavaibility
     * @param reason
     *            the reason if the unavaibility
     * @return a new unavaibility for a device
     */
    public static IDeviceBusy createDeviceBusy(Gap g, int reason)
    {
        return new DeviceBusyImpl(g, reason);
    }
    
    /**
     * DOCME 
     *
     * @param g
     * @return a new unavaibility for a group
     */
    public static IGroupBusy createGroupBusy(Gap g)
    {
        return new GroupBusyImpl(g);
    }

    /**
     * DOCME 
     *
     * @param g
     * @param reason 
     * @return a new unavaibility for a group
     */
    public static IGroupBusy createGroupBusy(Gap g, int reason)
    {
        return new GroupBusyImpl(g, reason);
    }
    
    /**
     * DOCME
     *
     * @param g
     * @param c
     * @return a new lesson
     */
    public static ILesson createLesson(Gap g, ICourse c)
    {
        return new LessonImpl(g, c); 
    }
    
    /**
     * DOCME
     *
     * @param g
     * @param c
     * @param t 
     * @param gr 
     * @return a new lesson
     */
    public static ILesson createLesson(Gap g, ICourse c, ITeacher t, IGroup gr)
    {
        return new LessonImpl(g, c, t, gr); 
    }
    
    /**
     * DOCME
     *
     * @param g
     * @return  a new unavaibility for a room
     */
    public static IRoomBusy createRoomBusy(Gap g)
    {
        return new RoomBusyImpl(g);
    }
    
    /**
     * DOCME
     *
     * @param g
     * @param reason 
     * @return a new unavaibility for a room
     */
    public static IRoomBusy createRoomBusy(Gap g, int reason)
    {
        return new RoomBusyImpl(g, reason);
    }
    
    /**
     * DOCME
     *
     * @param g
     * @return a new unavaibility for a teacher
     */
    public static ITeacherBusy createTeacherBusy(Gap g)
    {
        return new TeacherBusyImpl(g);
    }
    
    /**
     * DOCME
     *
     * @param g
     * @param reason 
     * @return a new unavaibility for a teacher
     */
    public static ITeacherBusy createTeacherBusy(Gap g, int reason)
    {
        return new TeacherBusyImpl(g, reason);
    }
}
