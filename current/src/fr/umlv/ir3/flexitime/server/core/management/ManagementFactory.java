/*
 * Created on 13 déc. 2004
 * by Valère FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.server.core.management;

import fr.umlv.ir3.flexitime.server.core.BuildingManager;
import fr.umlv.ir3.flexitime.server.core.ClassManager;
import fr.umlv.ir3.flexitime.server.core.CourseManager;
import fr.umlv.ir3.flexitime.server.core.DeviceManager;
import fr.umlv.ir3.flexitime.server.core.FloorManager;
import fr.umlv.ir3.flexitime.server.core.GroupManager;
import fr.umlv.ir3.flexitime.server.core.LessonManager;
import fr.umlv.ir3.flexitime.server.core.RoomManager;
import fr.umlv.ir3.flexitime.server.core.SubjectManager;
import fr.umlv.ir3.flexitime.server.core.SubjectsGroupManager;
import fr.umlv.ir3.flexitime.server.core.TeacherManager;
import fr.umlv.ir3.flexitime.server.core.TeachingStructureManager;
import fr.umlv.ir3.flexitime.server.core.TrackManager;

/**
 * ManagementFactory - Creates all the ressources needed
 * 
 * @version 0.1
 * @author FlexiTeam - Valère FOREL
 */
public class ManagementFactory
{
    private static BuildingManager buildingManager = new BuildingManager();
    private static ClassManager classManager = new ClassManager();
    private static CourseManager courseManager = new CourseManager();
    private static DeviceManager deviceManager = new DeviceManager();
    private static FloorManager floorManager = new FloorManager();
    private static GroupManager groupManager = new GroupManager();
    private static LessonManager lessonManager = new LessonManager();
    private static RoomManager roomManager = new RoomManager();
    private static SubjectManager subjectManager = new SubjectManager();
    private static SubjectsGroupManager subjectsGroupManager = new SubjectsGroupManager();
    private static TeacherManager teacherManager = new TeacherManager();
    private static TeachingStructureManager teachingStructureManager = new TeachingStructureManager();
    private static TrackManager trackManager = new TrackManager();

    public static BuildingManager getBuildingManager(){
        return buildingManager;
    }
    public static ClassManager getClassManager(){
        return classManager;
    }
    public static CourseManager getCourseManager(){
        return courseManager;
    }
    public static DeviceManager getDeviceManager(){
        return deviceManager;
    }
    public static FloorManager getFloorManager(){
        return floorManager;
    }
    public static GroupManager getGroupManager(){
        return groupManager;
    }
    public static LessonManager getLessonManager(){
        return lessonManager;
    }
    public static RoomManager getRoomManager(){
        return roomManager;
    }
    public static SubjectManager getSubjectManager(){
        return subjectManager;
    }
    public static SubjectsGroupManager getSubjectsGroupManager(){
        return subjectsGroupManager;
    }
    public static TeacherManager getTeacherManager(){
        return teacherManager;
    }
    public static TeachingStructureManager getTeachingStructureManager(){
        return teachingStructureManager;
    }
    public static TrackManager getTrackManager(){
        return trackManager;
    }




    
}