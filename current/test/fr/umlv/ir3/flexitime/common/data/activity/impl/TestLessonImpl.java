/*
 * Created on 5 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.activity.impl;

import java.util.*;

import junit.framework.TestCase;

import fr.umlv.ir3.flexitime.common.data.activity.ILesson;
import fr.umlv.ir3.flexitime.common.data.general.impl.ClassImpl;
import fr.umlv.ir3.flexitime.common.data.general.impl.TrackImpl;
import fr.umlv.ir3.flexitime.common.data.resources.*;
import fr.umlv.ir3.flexitime.common.data.resources.impl.TeacherImpl;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.impl.CourseImpl;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.impl.SubjectImpl;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.impl.SubjectsGroupImpl;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.impl.TeachingStructureImpl;
import fr.umlv.ir3.flexitime.common.tools.Gap;

/**
 * Defines an unavailibility for a course in the TimeTable. Contains a list of
 * associated resources, a start and an end date and a name.
 * 
 * @version 240
 * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class TestLessonImpl extends TestCase
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3761686784278345271L;
    // ===========//
    // Champs //
    // ===========//
    private Set<IDevice>     setDevice = new HashSet();
    private Set<IRoom>       setRoom= new HashSet();
    private Set<ITeacher>    setTeacher= new HashSet();
    private Set<IGroup>      setGroup= new HashSet();
    private ICourse           course;
    private int               length;
    TrackImpl track = new TrackImpl("track");
    ClassImpl iClass = new ClassImpl("class",track);
    TeachingStructureImpl structure = new TeachingStructureImpl("struc",iClass);
     SubjectsGroupImpl subGroup = new SubjectsGroupImpl("subgroup",structure);
     SubjectImpl sub = new SubjectImpl("sub",subGroup);
     CourseImpl cour = new CourseImpl("cour",sub,1);
     LessonImpl lesson = new LessonImpl();
  
    
    

    // ======== //
    // Méthodes //
    // ======== //

    /**
     * Adds a resource to the list of resources contained by the lesson.
     * <code>addResource(resource)</code>
     * 
     * @param resource
     *            resource to add to the list.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#addResource(fr.umlv.ir3.flexitime.common.data.resources.IResource)
     */
    public void testAddResource()
    {

        lesson.addResource(new TeacherImpl("name","firstname"));
        if(lesson.getAllResources().size()!=1)fail("erreur de nombre");
        lesson.addResource(new TeacherImpl("name2","firstname2"));
        if(lesson.getAllResources().size()!=2)fail("erreur de nombre");
    }

    /**
     * Removes a resource of the list of resources contained by the lesson.
     * <code>removeResource(resource)</code>
     * 
     * @param resource
     *            resource to remove of the list.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#removeResource(fr.umlv.ir3.flexitime.common.data.resources.IResource)
     */
    public void testRemoveResource()
    {
        TeacherImpl teacher=new TeacherImpl("name","firstname");
        lesson.addResource(teacher);
        lesson.addResource(new TeacherImpl("name2","firstname2"));
        lesson.removeResource(teacher);
        if(lesson.getAllResources().size()!=1)fail("erreur de nombre");
    }

   

    /**
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#getSetDevice()
     */
    public void testGetSetDevice()
    {
        lesson.setSetDevice(setDevice);
        if(!lesson.getSetDevice().equals(setDevice))fail("erreur de set");
    }

    /**
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#getSetRoom()
     */
    public void testGetSetRoom()
    {
        lesson.setSetRoom(setRoom);
        if(!lesson.getSetRoom().equals(setRoom))fail("erreur de set");
    }

    /**
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#getSetGroup()
     */
    public void testGetSetGroup()
    {
        lesson.setSetGroup(setGroup);
        if(!lesson.getSetGroup().equals(setGroup))fail("erreur de set");
    }

    /**
     * @see fr.umlv.ir3.flexitime.common.data.activity.ILesson#getCourse()
     */
    public void testGetCourse()
    {
        cour.setIdData(new Long(0));
        lesson.setCourse(cour);
        if(!lesson.getCourse().equals(cour))fail("erreur de cour");
    }










 
}
