/*
 * Created on 19 janv. 2005
 * by K-lit
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data;

import java.awt.Color;
import java.rmi.RemoteException;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.activity.*;
import fr.umlv.ir3.flexitime.common.data.activity.impl.*;
import fr.umlv.ir3.flexitime.common.data.general.*;
import fr.umlv.ir3.flexitime.common.data.general.impl.*;
import fr.umlv.ir3.flexitime.common.data.resources.*;
import fr.umlv.ir3.flexitime.common.data.resources.impl.*;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.*;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.impl.*;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.tools.*;

/**
 * Create all datas from specific parameters. This class contains only statics
 * methods to create each types of datas.
 * 
 * @version 216
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class DataFactorySansRmi
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
     */
    public static IDeviceBusy createDeviceBusy(Gap g, IDevice parent) throws FlexiException
    {
        IDeviceBusy d = new DeviceBusyImpl(g);
        parent.addBusy(d);
//        try
//        {
//            d = RemoteDataManager.getManager().saveOrUpdateDeviceBusy(d, parent);
//        }
//        catch (RemoteException e)
//        {
//            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
//        }
        
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
     */
    public static IDeviceBusy createDeviceBusy(Gap g, IDevice parent, int reason) throws FlexiException
    {
        IDeviceBusy d = new DeviceBusyImpl(g, reason);
        parent.addBusy(d);
//        try
//        {
//            d = RemoteDataManager.getManager().saveOrUpdateDeviceBusy(d, parent);
//        }
//        catch (RemoteException e)
//        {
//            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
//        }
        
        return d;
    }

    /**
     * Copy a device busy to create a new device busy.
     * 
     * @param busy
     *            the unavaibility to copy
     * @return a new unavaibility for a device
     * @throws FlexiException 
     */
    public static IDeviceBusy createDeviceBusy(IDeviceBusy busy, IDevice parent) throws FlexiException
    {
        IDeviceBusy d = new DeviceBusyImpl(busy);
        parent.addBusy(d);
//        try
//        {
//            d = RemoteDataManager.getManager().saveOrUpdateDeviceBusy(d, parent);
//        }
//        catch (RemoteException e)
//        {
//            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
//        }
        return d;
    }

    /**
     * Constructs an unavailibility for a group between a gap without reason.
     * 
     * @param g gap of the unavaibulity
     * @return a new unavaibility for a group
     * @throws FlexiException 
     */
    public static IGroupBusy createGroupBusy(Gap g, IGroup parent) throws FlexiException
    {
        IGroupBusy group = new GroupBusyImpl(g);
        parent.addBusy(group);
//        try
//        {
//            group = RemoteDataManager.getManager().saveOrUpdateGroupBusy(group, parent);
//        }
//        catch (RemoteException e)
//        {
//            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
//        }
        
        return group;
    }

    /**
     * Constructs an unavailibility for a group between a gap for the reason specified.
     * 
     * @param g gap of the unavaibulity
     * @param reason reason of the unavaibility
     * @return a new unavaibility for a group
     * @throws FlexiException 
     */
    public static IGroupBusy createGroupBusy(Gap g, IGroup parent, int reason) throws FlexiException
    {
        IGroupBusy group = new GroupBusyImpl(g, reason);
        parent.addBusy(group);
//        try
//        {
//            group = RemoteDataManager.getManager().saveOrUpdateGroupBusy(group, parent);
//        }
//        catch (RemoteException e)
//        {
//            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
//        }
        return group;
    }
    
    /**
     * Copy a group busy to create a new group busy.
     * 
     * @param busy
     *            the unavaibility to copy
     * @return a new unavaibility for a group
     * @throws FlexiException 
     */
    public static IGroupBusy createGroupBusy(IGroupBusy busy, IGroup parent) throws FlexiException
    {
        IGroupBusy group = new GroupBusyImpl(busy);
        parent.addBusy(group);
//        try
//        {
//            group = RemoteDataManager.getManager().saveOrUpdateGroupBusy(group, parent);
//        }
//        catch (RemoteException e)
//        {
//            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
//        }
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
//        try
//        {
//            lesson = RemoteDataManager.getManager().saveOrUpdateLesson(lesson);
//        }
//        catch (RemoteException e)
//        {
//            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
//        }       
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
//        try
//        {
//            lesson = RemoteDataManager.getManager().saveOrUpdateLesson(lesson);
//        }
//        catch (RemoteException e)
//        {
//            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
//        }    
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
//        try
//        {
//            lesson = RemoteDataManager.getManager().saveOrUpdateLesson(lesson);
//        }
//        catch (RemoteException e)
//        {
//            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
//        }    
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
//        try
//        {
//            lesson = RemoteDataManager.getManager().saveOrUpdateLesson(lesson);
//        }
//        catch (RemoteException e)
//        {
//            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
//        }    
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
//        try
//        {
//            les = RemoteDataManager.getManager().saveOrUpdateLesson(les);
//        }
//        catch (RemoteException e)
//        {
//            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
//        }    
        return les;
    }

    /**
     * Constructs an unavailibility for a room without reason.
     * 
     * @param g
     *            the gap between the unavailibility.
     * @return a new unavaibility for a room
     * @throws FlexiException 
     */
    public static IRoomBusy createRoomBusy(Gap g, IRoom parent) throws FlexiException
    {
        IRoomBusy r = new RoomBusyImpl(g);
        parent.addBusy(r);
//        try
//        {
//            r = RemoteDataManager.getManager().saveOrUpdateRoomBusy(r, parent);
//        }
//        catch (RemoteException e)
//        {
//            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
//        }
        
        return r;
    }

    /**
     * Constructs an unavailibility for a room for the reason specified.
     * 
     * @param g
     *            the gap between the unavailibility.
     * @param reason
     *            an Integer representing the reason of the unavailibility.
     * @return a new unavaibility for a room
     */
    public static IRoomBusy createRoomBusy(Gap g, int reason)
    {
        return new RoomBusyImpl(g, reason);
    }

    /**
     * Copy a room busy to create a new room busy.
     * 
     * @param busy
     *            the unavaibility to copy
     * @return a new unavaibility for a device
     * @throws FlexiException 
     */
    public static IRoomBusy createRoomBusy(IRoomBusy busy, IRoom parent) throws FlexiException
    {
        IRoomBusy r = new RoomBusyImpl(busy);
        parent.addBusy(r);
//        try
//        {
//            r = RemoteDataManager.getManager().saveOrUpdateRoomBusy(r, parent);
//        }
//        catch (RemoteException e)
//        {
//            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
//        }
        return r;
    }
    
    /**
     * Constructs an unavailibility for a teacher without reason.
     * 
     * @param g
     *            the gap between the unavailibility.
     * @return a new unavaibility for a teacher
     * @throws FlexiException 
     */
    public static ITeacherBusy createTeacherBusy(Gap g, ITeacher parent) throws FlexiException
    {
        ITeacherBusy t = new TeacherBusyImpl(g);
        parent.addBusy(t);
//        try
//        {
//            t = RemoteDataManager.getManager().saveOrUpdateTeacherBusy(t, parent);
//        }
//        catch (RemoteException e)
//        {
//            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
//        }
        
        return t;
    }

    /**
     * Constructs an unavailibility for a teacher for the reason specified.
     * 
     * @param g
     *            the gap between the unavailibility.
     * @param reason
     *            an Integer representing the reason of the unavailibility.
     * @return a new unavaibility for a teacher
     * @throws FlexiException 
     */
    public static ITeacherBusy createTeacherBusy(Gap g, ITeacher parent, int reason) throws FlexiException
    {
        ITeacherBusy t = new TeacherBusyImpl(g, reason);
        parent.addBusy(t);
//        try
//        {
//            t = RemoteDataManager.getManager().saveOrUpdateTeacherBusy(t, parent);
//        }
//        catch (RemoteException e)
//        {
//            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
//        }
        
        return t;
    }
    
    /**
     * Copy a teacher busy to create a new teacher busy.
     * 
     * @param busy
     *            the unavaibility to copy
     * @return a new unavaibility for a device
     * @throws FlexiException 
     */
    public static ITeacherBusy createTeacherBusy(ITeacherBusy busy, ITeacher parent) throws FlexiException
    {
        ITeacherBusy t = new TeacherBusyImpl(busy);
        parent.addBusy(t);
//        try
//        {
//            t = RemoteDataManager.getManager().saveOrUpdateTeacherBusy(t, parent);
//        }
//        catch (RemoteException e)
//        {
//            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
//        }
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
//        
//        try
//        {
//            b = RemoteDataManager.getManager().saveOrUpdateBuilding(b);
//        }
//        catch (RemoteException e)
//        {
//            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
//        }
        
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
//        parent.addClass(class1);
//        
//        try
//        {
//            class1 = RemoteDataManager.getManager().saveOrUpdateClass(class1);
//        }
//        catch (RemoteException e)
//        {
//            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
//        }
        
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
        parent.addFloor(floor);
//        try
//        {
//            floor = RemoteDataManager.getManager().saveOrUpdateFloor(floor);
//        }
//        catch (RemoteException e)
//        {
//            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
//        }
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
//        try
//        {
//            temp = RemoteDataManager.getManager().saveOrUpdateTrack(temp);
//        }
//        catch (RemoteException e)
//        {
//            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
//        }
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
//        try
//        {
//            d = RemoteDataManager.getManager().saveOrUpdateDevice(d);
//        }
//        catch (RemoteException e)
//        {
//            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
//        }
        
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
//        try
//        {
//            d = RemoteDataManager.getManager().saveOrUpdateDevice(d);
//        }
//        catch (RemoteException e)
//        {
//            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
//        }
        
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
        parent.addGroup(group);
//        try
//        {
//            group = RemoteDataManager.getManager().saveOrUpdateGroup(group);
//        }
//        catch (RemoteException e)
//        {
//            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
//        }
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
        floor.addRoom(room);
//        try
//        {
//            room = RemoteDataManager.getManager().saveOrUpdateRoom(room);
//        }
//        catch (RemoteException e)
//        {
//            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
//        }    
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
//        try
//        {
//            t = RemoteDataManager.getManager().saveOrUpdateTeacher(t);
//        }
//        catch (RemoteException e)
//        {
//            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
//        }
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
//        try
//        {
//            t = RemoteDataManager.getManager().saveOrUpdateTeacher(t);
//        }
//        catch (RemoteException e)
//        {
//            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
//        }
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
        parent.addCourse(temp);
//        try
//        {
//            temp = RemoteDataManager.getManager().saveOrUpdateCourse(temp);
//        }
//        catch (RemoteException e)
//        {
//            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
//        }
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
        ICourse temp = new CourseImpl(name, parent, defaultLength, type,
                nbHours, color);
        parent.addCourse(temp);
//        try
//        {
//            temp = RemoteDataManager.getManager().saveOrUpdateCourse(temp);
//        }
//        catch (RemoteException e)
//        {
//            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
//        }
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
        ICourse temp = new CourseImpl(name, parent, defaultLength, type,
                nbHours, color, listTeachers);
        parent.addCourse(temp);
//        try
//        {
//            temp = RemoteDataManager.getManager().saveOrUpdateCourse(temp);
//        }
//        catch (RemoteException e)
//        {
//            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
//        }
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
        parent.addSubject(temp);
//        try
//        {
//            temp = RemoteDataManager.getManager().saveOrUpdateSubject(temp);
//        }
//        catch (RemoteException e)
//        {
//            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
//        }    
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
        parent.addSubjectsGroup(temp);
//        try
//        {
//            temp = RemoteDataManager.getManager().saveOrUpdateSubjectsGroup(temp);
//        }
//        catch (RemoteException e)
//        {
//            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
//        }    
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
        parent.setTeachingStructure(temp);
//        try
//        {
//            temp = RemoteDataManager.getManager().saveOrUpdateTeachingStructure(temp);
//        }
//        catch (RemoteException e)
//        {
//            throw new FlexiException(FlexiLanguage.getInstance().getText("unreachableServer"), e);
//        }
        return temp;
    }
}
