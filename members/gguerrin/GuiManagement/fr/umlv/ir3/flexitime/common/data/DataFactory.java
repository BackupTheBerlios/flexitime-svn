/*
 * Created on 19 janv. 2005
 * by K-lit
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data;

import fr.umlv.ir3.flexitime.common.data.activity.*;
import fr.umlv.ir3.flexitime.common.data.activity.impl.*;
import fr.umlv.ir3.flexitime.common.data.general.*;
import fr.umlv.ir3.flexitime.common.data.general.impl.*;
import fr.umlv.ir3.flexitime.common.data.resources.*;
import fr.umlv.ir3.flexitime.common.data.resources.impl.*;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.*;
import fr.umlv.ir3.flexitime.common.tools.*;


/**
 * Create all datas from specific parameters. This class contains only statics
 * methods to create each types of datas.
 * 
 * @version 216
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class DataFactory
{
    // ======== //
    // Activity //
    // ======== //
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
     * @param l 
     * @return a new lesson
     */
    public static ILesson createLesson(Gap g, ICourse c, int l)
    {
        return new LessonImpl(g, c, l); 
    }
    
    /**
     * DOCME
     *
     * @param g
     * @param c
     * @param l 
     * @param t 
     * @param gr 
     * @return a new lesson
     */
    public static ILesson createLesson(Gap g, ICourse c, int l, ITeacher t, IGroup gr)
    {
        return new LessonImpl(g, c, l, t, gr); 
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
    
    // ======= //
    // General //
    // ======= //
    /**
     * Create a new Building with the given name
     *
     * @param name the name of the new building
     * @return a new Building naming <code>name</code> 
     */
    public static IBuilding createBuilding(String name)
    {
        return new BuildingImpl(name);
    }
    
     /**
     * Create a new class with the given name and add it to the parent Track 
     *
     * @param name the name of the class
     * @param parent the track to which this class belong
     * @return a new Class 
     */
    public static IClass createClass(String name, ITrack parent)
    {
        IClass class1 = new ClassImpl(name, parent);
        parent.addClass(class1);
        return class1;
    }
    
    /**
     * Create a new floor with the given name and add it to the parent building 
     *
     * @param name the name of the floor
     * @param parent the building to which this floor belong
     * @return a new Class 
     */
    public static IFloor createFloor(String name, IBuilding parent)
    {
        IFloor floor = new FloorImpl(name, parent);
        parent.addFloor(floor);
        return floor;
    }
    
    /**
     * Create a new Track with the given name 
     *
     * @param name the name of the track
     * @return a new Class 
     */
    public static ITrack createTrack(String name)
    {
        return new TrackImpl(name);
    }
    
    // ========= //
    // Resources //
    // ========= //
    /**
     * DOCME
     * 
     * @param name
     * @return a new device 
     */
    public static IDevice createDevice(String name)
    {
        return new DeviceImpl(name);
    }
    
    /**
     * DOCME
     * 
     * @param name
     * @param type 
     * @return a new device 
     */
    public static IDevice createDevice(String name, int type)
    {
        return new DeviceImpl(name, type);
    }

    /**
     * DOCME
     *
     * @param name
     * @param nbPerson 
     * @param parent 
     * @return a new group
     */
    public static IGroup createGroup(String name, int nbPerson, IClass parent)
    {
        IGroup group = new GroupImpl(name, nbPerson, parent);
        parent.addGroup(group);
        return group;
    }
    
    /**
     * DOCME
     *
     * @param name
     * @param type 
     * @param capacity 
     * @param floor 
     * @return a new room
     */
    public static IRoom createRoom(String name, int type, int capacity, IFloor floor)
    {
        IRoom room = new RoomImpl(name, type, capacity, floor);
        floor.addRoom(room);
        return room;
    }

    /**
     * DOCME
     *
     * @param name
     * @param firstName
     * @return a new teacher 
     */
    public static ITeacher createTeacher(String name, String firstName)
    {
        return new TeacherImpl(name, firstName);
    }
    
    /**
     * DOCME
     *
     * @param name
     * @param firstName
     * @param mail 
     * @return a new teacher 
     */
    public static ITeacher createTeacher(String name, String firstName, String mail)
    {
        return new TeacherImpl(name, firstName, mail);
    }
}

