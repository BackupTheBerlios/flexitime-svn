/*
 * Created on 13 déc. 2004
 * by Valère FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.server.core.management;

import java.util.Date;

import fr.umlv.ir3.flexitime.common.data.activity.IBusy;
import fr.umlv.ir3.flexitime.common.data.activity.ILesson;
import fr.umlv.ir3.flexitime.common.data.general.*;
import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.resources.IDevice;
import fr.umlv.ir3.flexitime.common.data.resources.IGroup;
import fr.umlv.ir3.flexitime.common.data.resources.IResource;
import fr.umlv.ir3.flexitime.common.data.resources.IRoom;
import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;
import fr.umlv.ir3.flexitime.common.data.ressources.*;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.*;
import fr.umlv.ir3.flexitime.common.tools.Time;
import fr.umlv.ir3.flexitime.server.core.management.*;

/**
 * ManagementFactoryImpl - Implementation of the abstract class
 * ManagementFactory
 * 
 * @version 0.1
 * @author FlexiTeam - Valère FOREL
 */
public class ManagementFactoryImpl extends ManagementFactory
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
    public ITeacher createTeacher(String name)
    {
        return null;

    }

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
    public IRoom createRoom(String name, IFloor floor)
    {
        return null;
    }

    /**
     * createDevice - creates a device
     * <code>Device d = myFactory.createDevice("name")</code>
     * 
     * @param name name of the device
     * @return a Device
     * @author FlexiTeam - Valère FOREL
     * @date 13 déc. 2004
     */
    public IDevice createDevice(String name)
    {
        return null;
    }

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
    public IGroup createGroup(String name, IClass _class)
    {
        return null;
    }

    /**
     * createTrack - creates a Track
     * <code>Track t = myFactory.createTrack("name")</code>
     * 
     * @param name name of the track
     * @return a Track
     * @author FlexiTeam - Valère FOREL
     * @date 13 déc. 2004
     */
    public ITrack createTrack(String name)
    {
        return null;
    }

    /**
     * createClass - creates a Class
     * <code>Class c = myFactory.createClass("name", aTrack)</code>
     * 
     * @param name name of the class
     * @return a Class
     * @author FlexiTeam - Valère FOREL
     * @date 13 déc. 2004
     */
    public IClass createClass(String name)
    {
        return null;
    }

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
    public ISubjectsGroup createSubjectsGroup(String name, IClass _class)
    {
        return null;
    }

    /**
     * createSubject - creates a subject
     * <code>Subject s = myFactory.createSubject("name", aSubjectsGroup)</code>
     * 
     * @param name name of the subject
     * @param subjectsGroup group of subjects which the subject depends
     * @return a Subject
     * @author FlexiTeam - Valère FOREL
     * @date 13 déc. 2004
     */
    public ISubject createSubject(String name, ISubjectsGroup subjectsGroup)
    {
        return null;
    }

    /**
     * createCourse - create a course
     * <code>Cours c = myFactory.createCourse("name", aSubject)</code>
     * 
     * @param name name of the course
     * @param subject subject which the course depends
     * @return a Course
     * @author FlexiTeam - Valère FOREL
     * @date 13 déc. 2004
     */
    public ICourse createCourse(String name, ISubject subject)
    {
        return null;
    }

    /**
     * createBuilding - creates a building
     * <code>Building b = myFactory.createBuilding("name")</code>
     * 
     * @param name name of the building
     * @return a Building
     * @author FlexiTeam - Valère FOREL
     * @date 13 déc. 2004
     */
    public IBuilding createBuilding(String name)
    {
        return null;
    }

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
    public IFloor createFloor(String name, IBuilding building)
    {
        return null;
    }

    /**
     * createLesson - DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param date
     * @param time
     * @param resource
     * @return
     * @see fr.umlv.ir3.flexitime.server.core.management.ManagementFactory#createLesson(java.util.Date,
     *      fr.umlv.ir3.flexitime.common.tools.Time,
     *      fr.umlv.ir3.flexitime.common.data.ressources.Resource)
     * @author FlexiTeam - Administrateur
     * @date 15 déc. 2004
     */
    public ILesson createLesson(Date date, Time time, IResource resource)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * createBusy - DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param date
     * @param time
     * @param resource
     * @return
     * @see fr.umlv.ir3.flexitime.server.core.management.ManagementFactory#createBusy(java.util.Date,
     *      fr.umlv.ir3.flexitime.common.tools.Time,
     *      fr.umlv.ir3.flexitime.common.data.ressources.Resource)
     * @author FlexiTeam - Administrateur
     * @date 15 déc. 2004
     */
    public IBusy createBusy(Date date, Time time, IResource resource)
    {
        // TODO Auto-generated method stub
        return null;
    }

 
}