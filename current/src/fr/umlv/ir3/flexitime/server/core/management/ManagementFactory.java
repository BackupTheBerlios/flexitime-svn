/*
 * Created on 13 déc. 2004
 * by Valère FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.server.core.management;

import java.util.Date;

import fr.umlv.ir3.flexitime.common.data.ressources.*;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.*;
import fr.umlv.ir3.flexitime.common.data.activity.IBusy;
import fr.umlv.ir3.flexitime.common.data.activity.ILesson;
import fr.umlv.ir3.flexitime.common.data.general.*;
import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.tools.Time;

/**
 * ManagementFactory - Creates all the ressources needed
 * 
 * @version 0.1
 * @author FlexiTeam - Valère FOREL
 */
public abstract class ManagementFactory
{

    /**
     * createTeacher - creates a teacher
     * <code>Teacher t = myFactory.createTeacher("name")</code>
     * 
     * @param name name of the teacher
     * @return a Teacher
     * @author FlexiTeam - Valère FOREL
     * @date 13 déc. 2004
     */
    public abstract ITeacher createTeacher(String name);

    /**
     * createRoom - creates a room
     * <code>Room r = myFactory.createRoom("name", aFloor)</code>
     * 
     * @param name name of the room
     * @param floor floor which the room depends
     * @return a Room
     * @author FlexiTeam - Valère FOREL
     * @date 13 déc. 2004
     */
    public abstract IRoom createRoom(String name, IFloor floor);

    /**
     * createDevice - creates a device
     * <code>Device d = myFactory.createDevice("name")</code>
     * 
     * @param name name of the device
     * @return a Device
     * @author FlexiTeam - Valère FOREL
     * @date 13 déc. 2004
     */
    public abstract IDevice createDevice(String name);

    /**
     * createGroup - creates a group
     * <code>Group g = myFactory.createGroup("name", aClass)</code>
     * 
     * @param name name of the group
     * @param _class class which the group depends
     * @return a Group
     * @author FlexiTeam - Valère FOREL
     * @date 13 déc. 2004
     */
    public abstract IGroup createGroup(String name, IClass _class);

    /**
     * createTrack - creates a Track
     * <code>Track t = myFactory.createTrack("name")</code>
     * 
     * @param name name of the track
     * @return a Track
     * @author FlexiTeam - Valère FOREL
     * @date 13 déc. 2004
     */
    public abstract ITrack createTrack(String name);

    /**
     * createClass - creates a Class
     * <code>Class c = myFactory.createClass("name", aTrack)</code>
     * 
     * @param name name of the class
     * @return a Class
     * @author FlexiTeam - Valère FOREL
     * @date 13 déc. 2004
     */
    public abstract IClass createClass(String name);

    /**
     * createSubjectsGroup - create a group of subjects
     * <code>SubjectsGroup b = myFactory.createBloc("name", aClass)</code>
     * 
     * @param name name of the group of subjects
     * @param _class class which the group of subjects depends
     * @return a SubjectsGroup
     * @author FlexiTeam - Valère FOREL
     * @date 13 déc. 2004
     */
    public abstract ISubjectsGroup createSubjectsGroup(String name, IClass _class);

    /**
     * createSubject - creates a subject
     * <code>Subject m = myFactory.createSubject("name", aSubjectsGroup)</code>
     * 
     * @param name name of the subject
     * @param subjectsGroup groups of subjects which the subject depends
     * @return a SubjectsGroup
     * @author FlexiTeam - Valère FOREL
     * @date 13 déc. 2004
     */
    public abstract ISubject createSubject(String name,
            ISubjectsGroup subjectsGroup);

    /**
     * createCourse - create a course
     * <code>Course c = myFactory.createCourse("name", aSubject)</code>
     * 
     * @param name name of the course
     * @param subject subject which the course depends
     * @return a Course
     * @author FlexiTeam - Valère FOREL
     * @date 13 déc. 2004
     */
    public abstract ICourse createCourse(String name, ISubject subject);

    /**
     * createBuilding - creates a building
     * <code>Building b = myFactory.createBuilding("name")</code>
     * 
     * @param name name of the building
     * @return a Building
     * @author FlexiTeam - Valère FOREL
     * @date 13 déc. 2004
     */
    public abstract IBuilding createBuilding(String name);

    /**
     * createFloor - creates a floor
     * <code>Floor f = myFactory.createFloor("name", aBuilding)</code>
     * 
     * @param name name of the floor
     * @param building building which the floor depends
     * @return a Floor
     * @author FlexiTeam - Valère FOREL
     * @date 13 déc. 2004
     */
    public abstract IFloor createFloor(String name, IBuilding building);

    /**
     * createLesson - creates a lesson
     * <code>Lesson l = myManagementFactory.createLesson(date,time,resource)</code>
     * 
     * @param date date of the lesson
     * @param time time of the lesson
     * @param resource resource which is plannified
     * @return a Lesson
     * @author FlexiTeam - Valère FOREL
     * @date 15 déc. 2004
     */
    public abstract ILesson createLesson(Date date, Time time, IResource resource);

    /**
     * createBusy - creates a unavaibility
     * <code>Busy b = myManagementFactory.createBusy(date,time,resource)</code>
     * 
     * @param date date of the unavaibility
     * @param time time of the unavaibility
     * @param resource resource which is plannified
     * @return a Busy
     * @author FlexiTeam - Administrateur
     * @date 15 déc. 2004
     */
    public abstract IBusy createBusy(Date date, Time time, IResource resource);

    /**
     * getFactory - get the ManagementFactory
     * <code>ManagementFactory mf = ManagementFactory.getFactory()</code>
     * 
     * @return a ManagementFactory
     * @author FlexiTeam - Valère FOREL
     * @date 13 déc. 2004
     */
    public static ManagementFactory getFactory()
    {
        return null;
    }

    /**
     * The ManagementFactory
     */
    public static ManagementFactory factory;
}