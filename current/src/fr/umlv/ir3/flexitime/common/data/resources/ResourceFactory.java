/*
 * Created on 18 janv. 2005
 * by Jérôme GUERS
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.resources;

import java.util.List;

import fr.umlv.ir3.flexitime.common.data.activity.IBusy;
import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.general.IFloor;
import fr.umlv.ir3.flexitime.common.data.resources.impl.*;

/**
 * Create all resource objects from specific parameters. This class contains only statics
 * methods to create each types of admin objects.
 * 
 * @version 205
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class ResourceFactory
{
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
    public static IDevice createDevice(String name, String type)
    {
        return new DeviceImpl(name, type);
    }
    
    /**
     * DOCME
     * 
     * @param name
     * @param type 
     * @param list 
     * @return a new device 
     */
    public static IDevice createDevice(String name, String type, List<IBusy> list)
    {
        return new DeviceImpl(name, type, list);
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
     * @param nbPerson 
     * @param parent 
     * @param list 
     * @return a new group
     */
    public static IGroup createGroup(String name, int nbPerson, IClass parent, List<IBusy> list)
    {
        IGroup group = new GroupImpl(name, nbPerson, parent, list);
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
     * @param type 
     * @param capacity 
     * @param floor 
     * @param list 
     * @return a new room
     */
    public static IRoom createRoom(String name, int type, int capacity, IFloor floor, List<IBusy> list)
    {
        IRoom room = new RoomImpl(name, type, capacity, floor, list);
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

    /**
     * DOCME
     *
     * @param name
     * @param firstName
     * @param mail 
     * @param list 
     * @return a new teacher 
     */
    public static ITeacher createTeacher(String name, String firstName, String mail, List<IBusy> list)
    {
        return new TeacherImpl(name, firstName, mail, list);
    }
}

