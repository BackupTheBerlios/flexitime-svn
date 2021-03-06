/*
 * Created on 19 janv. 2005
 * by K-lit
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data;

import java.awt.Color;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.activity.IDeviceBusy;
import fr.umlv.ir3.flexitime.common.data.activity.IGroupBusy;
import fr.umlv.ir3.flexitime.common.data.activity.ILesson;
import fr.umlv.ir3.flexitime.common.data.activity.IRoomBusy;
import fr.umlv.ir3.flexitime.common.data.activity.ITeacherBusy;
import fr.umlv.ir3.flexitime.common.data.activity.impl.DeviceBusyImpl;
import fr.umlv.ir3.flexitime.common.data.activity.impl.GroupBusyImpl;
import fr.umlv.ir3.flexitime.common.data.activity.impl.LessonImpl;
import fr.umlv.ir3.flexitime.common.data.activity.impl.RoomBusyImpl;
import fr.umlv.ir3.flexitime.common.data.activity.impl.TeacherBusyImpl;
import fr.umlv.ir3.flexitime.common.data.admin.IPreferences;
import fr.umlv.ir3.flexitime.common.data.admin.IUser;
import fr.umlv.ir3.flexitime.common.data.admin.impl.PreferencesImpl;
import fr.umlv.ir3.flexitime.common.data.admin.impl.UserImpl;
import fr.umlv.ir3.flexitime.common.data.general.IBuilding;
import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.general.IFloor;
import fr.umlv.ir3.flexitime.common.data.general.ITrack;
import fr.umlv.ir3.flexitime.common.data.general.impl.BuildingImpl;
import fr.umlv.ir3.flexitime.common.data.general.impl.ClassImpl;
import fr.umlv.ir3.flexitime.common.data.general.impl.FloorImpl;
import fr.umlv.ir3.flexitime.common.data.general.impl.TrackImpl;
import fr.umlv.ir3.flexitime.common.data.resources.IDevice;
import fr.umlv.ir3.flexitime.common.data.resources.IGroup;
import fr.umlv.ir3.flexitime.common.data.resources.IResource;
import fr.umlv.ir3.flexitime.common.data.resources.IRoom;
import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;
import fr.umlv.ir3.flexitime.common.data.resources.impl.DeviceImpl;
import fr.umlv.ir3.flexitime.common.data.resources.impl.GroupImpl;
import fr.umlv.ir3.flexitime.common.data.resources.impl.RoomImpl;
import fr.umlv.ir3.flexitime.common.data.resources.impl.TeacherImpl;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.impl.CourseImpl;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.impl.SubjectImpl;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.impl.SubjectsGroupImpl;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.impl.TeachingStructureImpl;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.LocalDataManager;
import fr.umlv.ir3.flexitime.common.tools.FlexiLanguage;
import fr.umlv.ir3.flexitime.common.tools.Gap;

/**
 * Create all datas from specific parameters. This class contains only statics
 * methods to create each types of datas.
 * 
 * @version 216
 * 
 * @author FlexiTeam - J�r�me GUERS
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
     * @param parent
     *              IDevice this Busy belongs to 
     * @return a new unavaibility for a device
     * @throws FlexiException 
     */
    public static IDeviceBusy createDeviceBusy(Gap g, IDevice parent) throws FlexiException
    {
        IDeviceBusy d = new DeviceBusyImpl(g);
        
            d = (IDeviceBusy)LocalDataManager.getManager().saveOrUpdateResourceBusy(d, parent);
        parent.addBusy(d);
        return d;
    }
    
    /**
     * Create an unavaibility for a device during a Gap without reason
     * 
     * @param g
     *            the gap of the unavaibility
     * @param parent
     *              IDevice this Busy belongs to
     * @param comment
     *            description of the unaivaibility
     * @return a new unavaibility for a device
     * @throws FlexiException 
     */
    public static IDeviceBusy createDeviceBusy(Gap g, IDevice parent, String comment) throws FlexiException
    {
        IDeviceBusy d = new DeviceBusyImpl(g, comment);
            d = (IDeviceBusy)LocalDataManager.getManager().saveOrUpdateResourceBusy(d, parent);
        parent.addBusy(d);
        return d;
    }

    /**
     * Create an unavaibility for a device during a Gap for the specified reason
     * 
     * @param g
     *            the gap of the unavaibility
     * @param parent 
     *            IDevice this Busy belongs to
     * @param reason
     *            the reason if the unavaibility
     * @return a new unavaibility for a device
     * @throws FlexiException 
     */
    public static IDeviceBusy createDeviceBusy(Gap g, IDevice parent, int reason) throws FlexiException
    {
        IDeviceBusy d = new DeviceBusyImpl(g, reason);

            d = (IDeviceBusy)LocalDataManager.getManager().saveOrUpdateResourceBusy(d, parent);
        parent.addBusy(d);
        return d;
    }
    
    /**
     * Create an unavaibility for a device during a Gap for the specified reason
     * 
     * @param g
     *            the gap of the unavaibility
     * @param parent 
     *            IDevice this Busy belongs to
     * @param reason
     *            the reason if the unavaibility
     * @param comment
     *            description of the unaivaibility
     * @return a new unavaibility for a device
     * @throws FlexiException 
     */
    public static IDeviceBusy createDeviceBusy(Gap g, IDevice parent, int reason, String comment) throws FlexiException
    {
        IDeviceBusy d = new DeviceBusyImpl(g, reason, comment);
            d = (IDeviceBusy)LocalDataManager.getManager().saveOrUpdateResourceBusy(d, parent);
        parent.addBusy(d);
        return d;
    }

    /**
     * Copy a device busy to create a new device busy.
     * 
     * @param busy
     *            the unavaibility to copy
     * @param parent 
     * @return a new unavaibility for a device
     * @throws FlexiException 
     */
    public static IDeviceBusy createDeviceBusy(IDeviceBusy busy, IDevice parent) throws FlexiException
    {
        IDeviceBusy d = new DeviceBusyImpl(busy);
            d = (IDeviceBusy)LocalDataManager.getManager().saveOrUpdateResourceBusy(d, parent);
        parent.addBusy(d);
        return d;
    }

    /**
     * Constructs an unavailibility for a group between a gap without reason.
     * 
     * @param g gap of the unavaibulity
     * @param parent 
     * @return a new unavaibility for a group
     * @throws FlexiException 
     */
    public static IGroupBusy createGroupBusy(Gap g, IGroup parent) throws FlexiException
    {
        IGroupBusy group = new GroupBusyImpl(g);
            group = (IGroupBusy)LocalDataManager.getManager().saveOrUpdateResourceBusy(group, parent);
        parent.addBusy(group);
        return group;
    }
    
    /**
     * Constructs an unavailibility for a group between a gap without reason.
     * 
     * @param g gap of the unavaibulity
     * @param comment
     *            description of the unaivaibility
     * @param parent 
     * @return a new unavaibility for a group
     * @throws FlexiException 
     */
    public static IGroupBusy createGroupBusy(Gap g, IGroup parent, String comment) throws FlexiException
    {
        IGroupBusy group = new GroupBusyImpl(g, comment);
        
            group = (IGroupBusy)LocalDataManager.getManager().saveOrUpdateResourceBusy(group, parent);
        parent.addBusy(group);
        return group;
    }

    /**
     * Constructs an unavailibility for a group between a gap for the reason specified.
     * 
     * @param g gap of the unavaibulity
     * @param parent 
     * @param reason reason of the unavaibility
     * @return a new unavaibility for a group
     * @throws FlexiException 
     */
    public static IGroupBusy createGroupBusy(Gap g, IGroup parent, int reason) throws FlexiException
    {
        IGroupBusy group = new GroupBusyImpl(g, reason);
            group = (IGroupBusy)LocalDataManager.getManager().saveOrUpdateResourceBusy(group, parent);
        parent.addBusy(group);
        return group;
    }
    
    /**
     * Constructs an unavailibility for a group between a gap for the reason specified.
     * 
     * @param g gap of the unavaibulity
     * @param parent 
     * @param reason reason of the unavaibility
     * @param comment
     *            description of the unaivaibility
     * @return a new unavaibility for a group
     * @throws FlexiException 
     */
    public static IGroupBusy createGroupBusy(Gap g, IGroup parent, int reason, String comment) throws FlexiException
    {
        IGroupBusy group = new GroupBusyImpl(g, reason, comment);
        
            group = (IGroupBusy)LocalDataManager.getManager().saveOrUpdateResourceBusy(group, parent);
        parent.addBusy(group);
        return group;
    }
    
    /**
     * Copy a group busy to create a new group busy.
     * 
     * @param busy
     *            the unavaibility to copy
     * @param parent 
     * @return a new unavaibility for a group
     * @throws FlexiException 
     */
    public static IGroupBusy createGroupBusy(IGroupBusy busy, IGroup parent) throws FlexiException
    {
        IGroupBusy group = new GroupBusyImpl(busy);
            group = (IGroupBusy)LocalDataManager.getManager().saveOrUpdateResourceBusy(group, parent);
        parent.addBusy(group);
        return group;
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
    public static ILesson createLesson(Gap g, ICourse c, List<IGroup> groups) throws FlexiException
    {
        ILesson lesson = new LessonImpl(g, c, groups);
        List<IResource> l = new LinkedList<IResource>();
        
        for(IResource elem : groups)
            l.add(elem);
        
            lesson = LocalDataManager.getManager().saveOrUpdateLesson(lesson, l);
        
        lesson.getSetGroup().clear();
        lesson.getSetDevice().clear();
        lesson.getSetRoom().clear();
        lesson.getSetTeacher().clear();
        
        for(IResource elem : l)
            lesson.addResource(elem);
        
        return lesson;
         
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
     * @param l
     *            the length of the lesson
     * @return a new lesson
     * @throws FlexiException 
     */
    public static ILesson createLesson(Gap g, ICourse c, List<IGroup> groups, int l) throws FlexiException
    {
        ILesson lesson = new LessonImpl(g, c, groups, l);
        List<IResource> lr = new LinkedList<IResource>();
        
        for(IResource elem : groups)
            lr.add(elem);
        
            lesson = LocalDataManager.getManager().saveOrUpdateLesson(lesson, lr);

        lesson.getSetGroup().clear();
        lesson.getSetDevice().clear();
        lesson.getSetRoom().clear();
        lesson.getSetTeacher().clear();
        
        for(IResource elem : lr)
            lesson.addResource(elem);
        
        return lesson;
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
     * @param t
     *            the teacher who teach these lesson
     * @return a new lesson
     * @throws FlexiException 
     */
    public static ILesson createLesson(Gap g, ICourse c, List<IGroup> groups, ITeacher t) throws FlexiException
    {
        ILesson lesson = new LessonImpl(g, c, groups, t);
        List<IResource> l = new LinkedList<IResource>();
        
        for(IResource elem : groups)
            l.add(elem);
        l.add(t);
        
            lesson = LocalDataManager.getManager().saveOrUpdateLesson(lesson, l);
        
        lesson.getSetGroup().clear();
        lesson.getSetDevice().clear();
        lesson.getSetRoom().clear();
        lesson.getSetTeacher().clear();
        
        for(IResource elem : l)
        {
            lesson.addResource(elem);
            //System.out.println(elem.getClass() +" " + elem.getSetBusy());
        }
        
        return lesson;
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
     * @param l
     *            the length of the lesson
     * @param t
     *            the teacher who teach these lesson
     * @return a new lesson
     * @throws FlexiException 
     */
    public static ILesson createLesson(Gap g, ICourse c, List<IGroup> groups, int l , ITeacher t) throws FlexiException
    {
        ILesson lesson = new LessonImpl(g, c, groups, l, t);
        List<IResource> lr = new LinkedList<IResource>();
        
        for(IResource elem : groups)
            lr.add(elem);
        lr.add(t);
        
            lesson = LocalDataManager.getManager().saveOrUpdateLesson(lesson, lr);

        lesson.getSetGroup().clear();
        lesson.getSetDevice().clear();
        lesson.getSetRoom().clear();
        lesson.getSetTeacher().clear();
        
        for(IResource elem : lr)
        {
            lesson.addResource(elem);
            //System.out.println(elem.getSetBusy());
        }
        
        return lesson;
    }
    
    /**
     * Copy a lesson to create a new lesson.
     * 
     * @param lesson
     *            the unavaibility to copy
     * @return a new lesson
     * @throws FlexiException 
     */
    public static ILesson createLesson(ILesson lesson) throws FlexiException
    {
        ILesson les = new LessonImpl(lesson);
        List<IResource> l = new LinkedList<IResource>();
        
        for(Iterator<IDevice> it = les.getSetDevice().iterator(); it.hasNext(); )
        {
            l.add(it.next());
        }
        for(Iterator<IGroup> it = les.getSetGroup().iterator(); it.hasNext(); )
        {
            l.add(it.next());
        }
        for(Iterator<IRoom> it = les.getSetRoom().iterator(); it.hasNext(); )
        {
            l.add(it.next());
        }
        for(Iterator<ITeacher> it = les.getSetTeacher().iterator(); it.hasNext(); )
        {
            l.add(it.next());
        }
        
            les = LocalDataManager.getManager().saveOrUpdateLesson(les, l);

        lesson.getSetGroup().clear();
        lesson.getSetDevice().clear();
        lesson.getSetRoom().clear();
        lesson.getSetTeacher().clear();
        
        for(IResource elem : l)
        {
            lesson.addResource(elem);
            System.out.println(elem.getClass() +" " + elem.getSetBusy());
        }
        
        return les;
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
    public static IRoomBusy createRoomBusy(Gap g, IRoom parent) throws FlexiException
    {
        IRoomBusy r = new RoomBusyImpl(g);

            r = (IRoomBusy)LocalDataManager.getManager().saveOrUpdateResourceBusy(r, parent);
        parent.addBusy(r);
        return r;
    }
    
    /**
     * Constructs an unavailibility for a room without reason.
     * 
     * @param g
     *            the gap between the unavailibility.
     * @param parent 
     * @param comment
     *            description of the unaivaibility
     * @return a new unavaibility for a room
     * @throws FlexiException 
     */
    public static IRoomBusy createRoomBusy(Gap g, IRoom parent, String comment) throws FlexiException
    {
        IRoomBusy r = new RoomBusyImpl(g, comment);
            r = (IRoomBusy)LocalDataManager.getManager().saveOrUpdateResourceBusy(r, parent);
        parent.addBusy(r);
        return r;
    }

    /**
     * Constructs an unavailibility for a room for the reason specified.
     * 
     * @param g
     *            the gap between the unavailibility.
     * @param parent 
     * @param reason
     *            an Integer representing the reason of the unavailibility.
     * @return a new unavaibility for a room
     * @throws FlexiException 
     */
    public static IRoomBusy createRoomBusy(Gap g, IRoom parent, int reason) throws FlexiException
    {
        IRoomBusy r = new RoomBusyImpl(g, reason);
            r = (IRoomBusy)LocalDataManager.getManager().saveOrUpdateResourceBusy(r, parent);
        parent.addBusy(r);
        return r;
    }
    
    /**
     * Constructs an unavailibility for a room for the reason specified.
     * 
     * @param g
     *            the gap between the unavailibility
     * @param parent 
     * @param reason
     *            an Integer representing the reason of the unavailibility
     * @param comment
     *            description of the unaivaibility
     * @return a new unavaibility for a room
     * @throws FlexiException 
     */
    public static IRoomBusy createRoomBusy(Gap g, IRoom parent, int reason, String comment) throws FlexiException
    {
        IRoomBusy r = new RoomBusyImpl(g, reason, comment);
            r = (IRoomBusy)LocalDataManager.getManager().saveOrUpdateResourceBusy(r, parent);
        parent.addBusy(r);
        return r;
    }

    /**
     * Copy a room busy to create a new room busy.
     * 
     * @param busy
     *            the unavaibility to copy
     * @param parent 
     * @return a new unavaibility for a device
     * @throws FlexiException 
     */
    public static IRoomBusy createRoomBusy(IRoomBusy busy, IRoom parent) throws FlexiException
    {
        IRoomBusy r = new RoomBusyImpl(busy);
            r = (IRoomBusy)LocalDataManager.getManager().saveOrUpdateResourceBusy(r, parent);
        parent.addBusy(r);
        return r;
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
    public static ITeacherBusy createTeacherBusy(Gap g, ITeacher parent) throws FlexiException
    {
        ITeacherBusy t = new TeacherBusyImpl(g);
            t = (ITeacherBusy)LocalDataManager.getManager().saveOrUpdateResourceBusy(t, parent);
        parent.addBusy(t);
        return t;
    }
    
    /**
     * Constructs an unavailibility for a teacher without reason.
     * 
     * @param g
     *            the gap between the unavailibility.
     * @param parent 
     * @param comment
     *            description of the unaivaibility 
     * @return a new unavaibility for a teacher
     * @throws FlexiException 
     */
    public static ITeacherBusy createTeacherBusy(Gap g, ITeacher parent, String comment) throws FlexiException
    {
        ITeacherBusy t = new TeacherBusyImpl(g, comment);
        
            t = (ITeacherBusy)LocalDataManager.getManager().saveOrUpdateResourceBusy(t, parent);
        parent.addBusy(t);
        
        return t;
    }

    /**
     * Constructs an unavailibility for a teacher for the reason specified.
     * 
     * @param g
     *            the gap between the unavailibility.
     * @param parent 
     * @param reason
     *            an Integer representing the reason of the unavailibility.
     * @return a new unavaibility for a teacher
     * @throws FlexiException 
     */
    public static ITeacherBusy createTeacherBusy(Gap g, ITeacher parent, int reason) throws FlexiException
    {
        ITeacherBusy t = new TeacherBusyImpl(g, reason);
            t = (ITeacherBusy)LocalDataManager.getManager().saveOrUpdateResourceBusy(t, parent);
        parent.addBusy(t);
        return t;
    }
    
    /**
     * Constructs an unavailibility for a teacher for the reason specified.
     * 
     * @param g
     *            the gap between the unavailibility.
     * @param parent 
     * @param reason
     *            an Integer representing the reason of the unavailibility.
     * @param comment
     *            description of the unaivaibility
     * @return a new unavaibility for a teacher
     * @throws FlexiException 
     */
    public static ITeacherBusy createTeacherBusy(Gap g, ITeacher parent, int reason, String comment) throws FlexiException
    {
        ITeacherBusy t = new TeacherBusyImpl(g, reason, comment);
            t = (ITeacherBusy)LocalDataManager.getManager().saveOrUpdateResourceBusy(t, parent);
        parent.addBusy(t);        
        return t;
    }
    
    /**
     * Copy a teacher busy to create a new teacher busy.
     * 
     * @param busy
     *            the unavaibility to copy
     * @param parent 
     * @return a new unavaibility for a device
     * @throws FlexiException 
     */
    public static ITeacherBusy createTeacherBusy(ITeacherBusy busy, ITeacher parent) throws FlexiException
    {
        ITeacherBusy t = new TeacherBusyImpl(busy);
            t = (ITeacherBusy)LocalDataManager.getManager().saveOrUpdateResourceBusy(t, parent);
        parent.addBusy(t);
        return t;
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
    public static IBuilding createBuilding(String name) throws FlexiException
    {
        IBuilding b = new BuildingImpl(name);
            b = LocalDataManager.getManager().saveOrUpdateBuilding(b);
        return b; 
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
    public static IClass createClass(String name, ITrack parent) throws FlexiException
    {
        IClass class1 = new ClassImpl(name, parent);
        
        
            class1 = LocalDataManager.getManager().saveOrUpdateClass(class1, parent);
        parent.addClass(class1);
        return class1;
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
    public static IFloor createFloor(String name, IBuilding parent) throws FlexiException
    {
        IFloor floor = new FloorImpl(name, parent);
        
            floor = LocalDataManager.getManager().saveOrUpdateFloor(floor, parent);
        parent.addFloor(floor);
        return floor;
    }

    /**
     * Create a new Track with the given name
     * 
     * @param name
     *            the name of the track
     * @return a new Class
     * @throws FlexiException 
     */
    public static ITrack createTrack(String name) throws FlexiException
    {
        ITrack temp = new TrackImpl(name);
            temp = LocalDataManager.getManager().saveOrUpdateTrack(temp);
        return temp;
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
    public static IDevice createDevice(String name) throws FlexiException
    {
        IDevice d = new DeviceImpl(name);
            d = LocalDataManager.getManager().saveOrUpdateDevice(d);
        
        return d;
    }

    /**
     * Constructs a device with just a name in parameter.
     * 
     * @param name
     *            a string.
     * @param type
     *            type of the device
     * @return a new device
     * @throws FlexiException 
     */
    public static IDevice createDevice(String name, int type) throws FlexiException
    {
        IDevice d = new DeviceImpl(name, type);
            d = LocalDataManager.getManager().saveOrUpdateDevice(d);
        return d;
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
    public static IGroup createGroup(String name, int nbPerson, IClass parent) throws FlexiException
    {
        IGroup group = new GroupImpl(name, nbPerson, parent);
        
            group = LocalDataManager.getManager().saveOrUpdateGroup(group, parent);
        parent.addGroup(group);
        return group;
    }

    /**
     * Constructs a room
     * 
     * @param name
     *            name of the room
     * @param type
     *            type of the room
     * @param capacity
     *            capacity of the room
     * @param floor
     *            the parent floor of this room
     * @return a new room
     * @throws FlexiException 
     */
    public static IRoom createRoom(String name, int type, int capacity,
            IFloor floor) throws FlexiException
    {
        IRoom room = new RoomImpl(name, type, capacity, floor);
        
            room = LocalDataManager.getManager().saveOrUpdateRoom(room, floor);
        floor.addRoom(room);
        return room;
    }

    /**
     * Constructs a teacher with just a name and a firstName in parameter.
     * 
     * @param name
     * @param firstName 
     * @return a new teacher
     * @throws FlexiException 
     */
    public static ITeacher createTeacher(String name, String firstName) throws FlexiException
    {
        ITeacher t = new TeacherImpl(name, firstName);
            t = LocalDataManager.getManager().saveOrUpdateTeacher(t);
        return t;
    }

    /**
     * Constructs a teacher.
     * 
     * @param name
     * @param firstName 
     * @param mail 
     * @return a new teacher
     * @throws FlexiException 
     */
    public static ITeacher createTeacher(String name, String firstName,
            String mail) throws FlexiException
    {
        ITeacher t = new TeacherImpl(name, firstName, mail);
            t = LocalDataManager.getManager().saveOrUpdateTeacher(t);
        return t;
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
    public static ICourse createCourse(String name, ISubject parent, int type) throws FlexiException
    {
        ICourse temp = new CourseImpl(name, parent, type);
        
            temp = LocalDataManager.getManager().saveOrUpdateCourse(temp, parent);
        parent.addCourse(temp);
        return temp;
    }

    /**
     * Constructs a course.
     * 
     * @param name
     *            a string.
     * @param type
     *            an int representing the type of the course.
     * @param nbHours
     *            the number of hours for this course.
     * @param color
     *            an int representing the color of the course.
     * @param defaultLength
     *            deault length of this course
     * @param parent
     *            the parent subject of this course.
     * @return a new Course all initilized
     * @throws FlexiException 
     * 
     */
    public static ICourse createCourse(String name, ISubject parent,
            int type, int defaultLength, int nbHours, Color color) throws FlexiException
    {
        ICourse temp = new CourseImpl(name, parent, type, defaultLength, 
                nbHours, color);
            temp = LocalDataManager.getManager().saveOrUpdateCourse(temp, parent);
        parent.addCourse(temp);
        return temp;
    }

    /**
     * Constructs a course.
     * 
     * @param name
     *            a string.
     * @param type
     *            an int representing the type of the course.
     * @param nbHours
     *            the number of hours for this course.
     * @param color
     *            an int representing the color of the course.
     * @param listTeachers
     *            a list of teachers.
     * @param defaultLength
     *            deault length of this course
     * @param parent
     *            the parent subject of this course.
     * @return a new Course all initilized
     * @throws FlexiException 
     * 
     */
    public static ICourse createCourse(String name, ISubject parent,
            int type, int defaultLength, int nbHours, Color color,
            List<ITeacher> listTeachers) throws FlexiException
    {
        ICourse temp = new CourseImpl(name, parent, type, defaultLength,
                nbHours, color, listTeachers);
            temp = LocalDataManager.getManager().saveOrUpdateCourse(temp, parent);
        parent.addCourse(temp);
        return temp;
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
    public static ISubject createSubject(String name, ISubjectsGroup parent) throws FlexiException
    {
        ISubject temp = new SubjectImpl(name, parent);
        
            temp = LocalDataManager.getManager().saveOrUpdateSubject(temp, parent);
        parent.addSubject(temp);
        return temp;
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
    public static ISubjectsGroup createSubjectsGroup(String name,
            ITeachingStructure parent) throws FlexiException
    {
        ISubjectsGroup temp = new SubjectsGroupImpl(name, parent);
        
            temp = LocalDataManager.getManager().saveOrUpdateSubjectsGroup(temp, parent);
        parent.addSubjectsGroup(temp);
        return temp;
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
    public static ITeachingStructure createTeachingStructure(String name,
            IClass parent) throws FlexiException
    {
        ITeachingStructure temp = new TeachingStructureImpl(name, parent);
        
            temp = LocalDataManager.getManager().saveOrUpdateTeachingStructure(temp, parent);
        parent.setTeachingStructure(temp);
        return temp;
    }
    
    // ===== //
    // Admin //
    // ===== //
    /** 
     * Create a new default user preferences
     *
     * @return default user preferences
     */
    public static IPreferences createPreferences()
    {
        IPreferences pref = new PreferencesImpl();
        // TODO sauvegarde hibernate
        return pref;
    }
    
    /** 
     * Create a new user preferences
     * @param height in pixel of gap
     * @param width in pixel of gap
     * @param length in minute of gap
     * @param week color used for the week header
     * @param day color used for the day
     * @param gap color used for the gap
     *
     * @return user preferences
     */
    public static IPreferences createPreferences(int height, int width, int length, Color week, Color day,
            Color gap)
    {
        IPreferences pref = new PreferencesImpl(height, width, length, week, day, gap);
        // TODO sauvegarde hibernate
        return pref;
    }

    /**
     * Create a new <em>ldap</em> user with default preferences 
     *
     * @param name
     * @return a new user 
     * @throws FlexiException 
     */
    public static IUser createUser(String name) throws FlexiException
    {
        IUser user = new UserImpl(name);
        try
        {
            user = LocalDataManager.getUserManager().save(user);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
        return user; 
    }
    
    /**
     * Create a new <em>ldap</em> user with default preferences 
     *
     * @param name
     * @param rigths User privileges
     * @return a new user 
     * @throws FlexiException 
     */
    public static IUser createUser(String name, int rigths) throws FlexiException
    {
        IUser user = new UserImpl(name, rigths);
        try
        {
            user = LocalDataManager.getUserManager().save(user);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
        return user; 
    }
    
    /**
     * Create a new <em>non-ldap</em> user with default preferences 
     *
     * @param name
     * @param pass
     * @return a new user 
     * @throws FlexiException 
     */
    public static IUser createUser(String name, String pass) throws FlexiException
    {
        IUser user = new UserImpl(name, pass);
        try
        {
            user = LocalDataManager.getUserManager().save(user);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
        return user; 
    }
    
    /**
     * Create a new <em>LDAP</em> user  
     *
     * @param name
     * @param pass 
     * @param rigths User privileges
     * @return a new user 
     * @throws FlexiException 
     */
    public static IUser createUser(String name, String pass, int rigths) throws FlexiException
    {
        IUser user = new UserImpl(name, pass, rigths);
        try
        {
            user = LocalDataManager.getUserManager().save(user);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
        return user; 
    }
    
    /**
     * Create a new <em>LDAP</em> user  
     *
     * @param name
     * @param pref User preferences
     * @return a new user 
     * @throws FlexiException 
     */
    public static IUser createUser(String name, IPreferences pref) throws FlexiException
    {
        IUser user = new UserImpl(name, pref);
        try
        {
            user = LocalDataManager.getUserManager().save(user);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
        return user; 
    }
    
    /**
     * Create a new <em>LDAP</em> user  
     *
     * @param name
     * @param rigths User privileges
     * @param pref User preferences
     * @return a new user 
     * @throws FlexiException 
     */
    public static IUser createUser(String name, int rigths, IPreferences pref) throws FlexiException
    {
        IUser user = new UserImpl(name, rigths, pref);
        try
        {
            user = LocalDataManager.getUserManager().save(user);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
        return user; 
    }
    
    /**
     * Create a new <em>non-LDAP</em> user 
     *
     * @param name
     * @param pass
     * @param pref User preferences
     * @return a new user 
     * @throws FlexiException 
     */
    public static IUser createUser(String name, String pass, IPreferences pref) throws FlexiException
    {
        IUser user = new UserImpl(name, pass, pref);
        try
        {
            user = LocalDataManager.getUserManager().save(user);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
        return user; 
    }
    
    /**
     * Create a new <em>non-LDAP</em> user 
     *
     * @param name
     * @param pass
     * @param rigths User privileges
     * @param pref User preferences
     * @return a new user 
     * @throws FlexiException 
     */
    public static IUser createUser(String name, String pass, int rigths, IPreferences pref) throws FlexiException
    {
        IUser user = new UserImpl(name, pass, rigths, pref);
        try
        {
            user = LocalDataManager.getUserManager().save(user);
        }
        catch (RemoteException e)
        {
            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
        }
        return user; 
    }
}
