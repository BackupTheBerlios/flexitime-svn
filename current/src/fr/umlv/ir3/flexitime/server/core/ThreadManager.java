/*
 * Created on 13 janv. 2005
 * by Administrateur
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.IData;
import fr.umlv.ir3.flexitime.common.data.activity.ILesson;
import fr.umlv.ir3.flexitime.common.data.general.IBuilding;
import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.general.IFloor;
import fr.umlv.ir3.flexitime.common.data.general.ITrack;
import fr.umlv.ir3.flexitime.common.data.resources.IDevice;
import fr.umlv.ir3.flexitime.common.data.resources.IGroup;
import fr.umlv.ir3.flexitime.common.data.resources.IRoom;
import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.rmi.IDataManager;


/**
 * DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * @see (si nécessaire)
 * 
 * @author FlexiTeam - Administrateur
 */
public class ThreadManager extends Thread
{
    IData data;
    int property;
    ThreadManager(IData data, int property) {
        this.data = data;
        this.property = property;
    }

    public void run() {
        if(data instanceof IBuilding) BuildingManager.notifyListener(data,property);
        if(data instanceof IClass) ClassManager.notifyListener(data,property);
        if(data instanceof ICourse) CourseManager.notifyListener(data,property);
        if(data instanceof IDevice) DeviceManager.notifyListener(data,property);
        if(data instanceof IFloor) FloorManager.notifyListener(data,property);
        if(data instanceof IGroup) GroupManager.notifyListener(data,property);
        if(data instanceof ILesson) LessonManager.notifyListener(data,property);
        if(data instanceof IRoom) RoomManager.notifyListener(data,property);
        if(data instanceof ISubject) SubjectManager.notifyListener(data,property);
        if(data instanceof ISubjectsGroup) SubjectsGroupManager.notifyListener(data,property);
        if(data instanceof ITeacher) TeacherManager.notifyListener(data,property);
        if(data instanceof ITeachingStructure) TeachingStructureManager.notifyListener(data,property);
        if(data instanceof ITrack) TrackManager.notifyListener(data,property);
    }
}

