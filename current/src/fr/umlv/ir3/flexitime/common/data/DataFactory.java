/*
 * Created on 19 janv. 2005
 * by K-lit
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data;

import java.awt.Color;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.activity.*;
import fr.umlv.ir3.flexitime.common.data.activity.impl.*;
import fr.umlv.ir3.flexitime.common.data.general.*;
import fr.umlv.ir3.flexitime.common.data.general.impl.*;
import fr.umlv.ir3.flexitime.common.data.resources.*;
import fr.umlv.ir3.flexitime.common.data.resources.impl.*;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.*;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.impl.*;
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
     * Copy a device busy to create a new device busy.
     * 
     * @param busy
     *            the unavaibility to copy
     * @return a new unavaibility for a device
     */
    public static IDeviceBusy createDeviceBusy(IDeviceBusy busy)
    {
        return new DeviceBusyImpl(busy);
    }

    /**
     * Constructs an unavailibility for a group between a gap without reason.
     * 
     * @param g gap of the unavaibulity
     * @return a new unavaibility for a group
     */
    public static IGroupBusy createGroupBusy(Gap g)
    {
        return new GroupBusyImpl(g);
    }

    /**
     * Constructs an unavailibility for a group between a gap for the reason specified.
     * 
     * @param g gap of the unavaibulity
     * @param reason reason of the unavaibility
     * @return a new unavaibility for a group
     */
    public static IGroupBusy createGroupBusy(Gap g, int reason)
    {
        return new GroupBusyImpl(g, reason);
    }
    
    /**
     * Copy a group busy to create a new group busy.
     * 
     * @param busy
     *            the unavaibility to copy
     * @return a new unavaibility for a group
     */
    public static IGroupBusy createGroupBusy(IGroupBusy busy)
    {
        return new GroupBusyImpl(busy);
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
     */
    public static ILesson createLesson(Gap g, ICourse c, List<IGroup> groups)
    {
        ILesson lesson = new LessonImpl(g, c, groups);
        // Action manager        
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
     */
    public static ILesson createLesson(Gap g, ICourse c, List<IGroup> groups, int l)
    {
        ILesson lesson = new LessonImpl(g, c, groups, l);
        // Action manager
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
     */
    public static ILesson createLesson(Gap g, ICourse c, List<IGroup> groups, ITeacher t)
    {
        ILesson lesson = new LessonImpl(g, c, groups, t);
        // Action manager
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
     */
    public static ILesson createLesson(Gap g, ICourse c, List<IGroup> groups, int l , ITeacher t)
    {
        ILesson lesson = new LessonImpl(g, c, groups, l, t);
        // Action manager
        return lesson;
    }
    
    /**
     * Copy a lesson to create a new lesson.
     * 
     * @param lesson
     *            the unavaibility to copy
     * @return a new lesson
     */
    public static ILesson createLesson(ILesson lesson)
    {
        return new LessonImpl(lesson);
    }

    /**
     * Constructs an unavailibility for a room without reason.
     * 
     * @param g
     *            the gap between the unavailibility.
     * @return a new unavaibility for a room
     */
    public static IRoomBusy createRoomBusy(Gap g)
    {
        return new RoomBusyImpl(g);
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
     */
    public static IRoomBusy createRoomBusy(IRoomBusy busy)
    {
        return new RoomBusyImpl(busy);
    }
    
    /**
     * Constructs an unavailibility for a teacher without reason.
     * 
     * @param g
     *            the gap between the unavailibility.
     * @return a new unavaibility for a teacher
     */
    public static ITeacherBusy createTeacherBusy(Gap g)
    {
        return new TeacherBusyImpl(g);
    }

    /**
     * Constructs an unavailibility for a teacher for the reason specified.
     * 
     * @param g
     *            the gap between the unavailibility.
     * @param reason
     *            an Integer representing the reason of the unavailibility.
     * @return a new unavaibility for a teacher
     */
    public static ITeacherBusy createTeacherBusy(Gap g, int reason)
    {
        return new TeacherBusyImpl(g, reason);
    }
    
    /**
     * Copy a teacher busy to create a new teacher busy.
     * 
     * @param busy
     *            the unavaibility to copy
     * @return a new unavaibility for a device
     */
    public static ITeacherBusy createTeacherBusy(ITeacherBusy busy)
    {
        return new TeacherBusyImpl(busy);
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
     */
    public static IBuilding createBuilding(String name)
    {
        return new BuildingImpl(name);
    }

    /**
     * Create a new class with the given name and add it to the parent Track
     * 
     * @param name
     *            the name of the class
     * @param parent
     *            the track to which this class belong
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
     * @param name
     *            the name of the floor
     * @param parent
     *            the building to which this floor belong
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
     * @param name
     *            the name of the track
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
     * Constructs a device with just a name in parameter.
     * 
     * @param name
     *            a string.
     * @return a new device
     */
    public static IDevice createDevice(String name)
    {
        return new DeviceImpl(name);
    }

    /**
     * Constructs a device with just a name in parameter.
     * 
     * @param name
     *            a string.
     * @param type
     *            type of the device
     * @return a new device
     */
    public static IDevice createDevice(String name, int type)
    {
        return new DeviceImpl(name, type);
    }

    /**
     * Constructs a group with a name and a parent class in parameter.
     * 
     * @param name a string
     * @param nbPerson 
     * @param parent the parent class of this group
     * @return a new group
     */
    public static IGroup createGroup(String name, int nbPerson, IClass parent)
    {
        IGroup group = new GroupImpl(name, nbPerson, parent);
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
     */
    public static IRoom createRoom(String name, int type, int capacity,
            IFloor floor)
    {
        IRoom room = new RoomImpl(name, type, capacity, floor);
        floor.addRoom(room);
        return room;
    }

    /**
     * Constructs a teacher with just a name and a firstName in parameter.
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
     * Constructs a teacher.
     * 
     * @param name
     * @param firstName 
     * @param mail 
     * @return a new teacher
     */
    public static ITeacher createTeacher(String name, String firstName,
            String mail)
    {
        return new TeacherImpl(name, firstName, mail);
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
     */
    public static ICourse createCourse(String name, ISubject parent, int type)
    {
        ICourse temp = new CourseImpl(name, parent, type);
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
     * 
     */
    public static ICourse createCourse(String name, ISubject parent,
            int type, int defaultLength, int nbHours, Color color)
    {
        ICourse temp = new CourseImpl(name, parent, defaultLength, type,
                nbHours, color);
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
     * 
     */
    public static ICourse createCourse(String name, ISubject parent,
            int type, int defaultLength, int nbHours, Color color,
            List<ITeacher> listTeachers)
    {
        ICourse temp = new CourseImpl(name, parent, defaultLength, type,
                nbHours, color, listTeachers);
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
     */
    public static ISubject createSubject(String name, ISubjectsGroup parent)
    {
        ISubject temp = new SubjectImpl(name, parent);
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
     */
    public static ISubjectsGroup createSubjectsGroup(String name,
            ITeachingStructure parent)
    {
        ISubjectsGroup temp = new SubjectsGroupImpl(name, parent);
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
     */
    public static ITeachingStructure createTeachingStructure(String name,
            IClass parent)
    {
        ITeachingStructure temp = new TeachingStructureImpl(name, parent);
        parent.setTeachingStructure(temp);
        return temp;
    }
}
