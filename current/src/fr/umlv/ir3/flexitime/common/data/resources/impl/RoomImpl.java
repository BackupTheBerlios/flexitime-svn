/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.resources.impl;

import java.util.Set;

import fr.umlv.ir3.flexitime.common.data.activity.IBusy;
import fr.umlv.ir3.flexitime.common.data.general.IFloor;
import fr.umlv.ir3.flexitime.common.data.resources.IRoom;

/**
 * Defines a room.
 * 
 * TYPE_MACHINE = 1; TYPE_COURS = 2; TYPE_TP = 3;
 * 
 * @version 240
 * @see fr.umlv.ir3.flexitime.common.data.resources.IRoom
 * @see fr.umlv.ir3.flexitime.common.data.resources.impl.ResourceImpl
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class RoomImpl extends ResourceImpl implements IRoom
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3256719568024974134L;
    // ===========//
    // Champs //
    // ===========//
    private int               type;
    private int               capacity;
    private IFloor            parentFloor;

    // =============//
    // Constructeurs//
    // =============//
    /**
     * Default constructor for a room.
     */
    protected RoomImpl()
    {}

    /**
     * Constructs a room with just a name in parameter.
     * 
     * @param name
     *            a string.
     */
    public RoomImpl(String name)
    {
        super(name);
    }

    /**
     * Constructs a room
     * 
     * @param name
     *            name of the room
     * @param type
     *            type of the room
     */
    public RoomImpl(String name, int type)
    {
        this(name);
        this.type = type;
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
     */
    public RoomImpl(String name, int type, int capacity)
    {
        this(name, type);
        this.capacity = capacity;
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
     */
    public RoomImpl(String name, int type, int capacity, IFloor floor)
    {
        this(name, type, capacity);
        this.parentFloor = floor;
    }

    /**
     * Constructs a room.
     * 
     * @param name
     *            a string.
     * @param type
     *            a type of room.
     * @param capacity
     *            the number maximum of students whom can sit in the room.
     * @param floor
     *            the parent floor of this room.
     * @param busies
     *            a list of unavailibilities
     */
    public RoomImpl(String name, int type, int capacity, IFloor floor,
            Set<IBusy> busies)
    {
        super(name, busies);
        this.type = type;
        this.capacity = capacity;
        this.parentFloor = floor;
    }

    // ===========//
    // Méthodes //
    // ===========//
    /**
     * Returns the type of the room. <code>Int i = room.getType()</code>
     * 
     * @return the type of the room.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.IRoom#getType()
     * @author FlexiTeam - Adrien BOUVET
     */
    public int getType()
    {
        return type;
    }

    /**
     * Sets the type of the room. <code>room.setType(type)</code>
     * 
     * @param iType
     *            the type of the room.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.IRoom#setType(int)
     * @author FlexiTeam - Adrien BOUVET
     */
    public void setType(int iType)
    {
        this.type = iType;
    }

    /**
     * Returns the capacity of the room. <code>Int c = room.getCapacity()</code>
     * 
     * @return the capacity of the room.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.IRoom#getCapacity()
     * @author FlexiTeam - Adrien BOUVET
     */
    public int getCapacity()
    {
        return capacity;
    }

    /**
     * Sets the capacity of the room. <code>room.setCapacity(capacity)</code>
     * 
     * @param capacity
     *            the capacity of the room.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.IRoom#setCapacity(int)
     * @author FlexiTeam - Adrien BOUVET
     */
    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

    /**
     * Returns the floor where the room is.
     * <code>String s = room.getFloor()</code>
     * 
     * @return the floor where the room is.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.IRoom#getFloor()
     * @author FlexiTeam - Adrien BOUVET
     */
    public IFloor getFloor()
    {
        return parentFloor;
    }

    /**
     * Sets the floor where the room is. <code>room.setFloor(floor)</code>
     * 
     * @param floor
     *            the floor where the room is.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.IRoom#setFloor(IFloor)
     * @author FlexiTeam - Adrien BOUVET
     */
    public void setFloor(IFloor floor)
    {
        this.parentFloor = floor;
    }
    
    /**
     * Test the equality of two rooms. Add a test to the equality of two
     * datas by comparing the parent Floor
     * 
     * @param obj
     *            other teacher to compare with
     * @return <code>true</code> if this object is the same as the obj
     *         argument; <code>false</code> otherwise.
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     * @see fr.umlv.ir3.flexitime.common.data.impl.DataImpl#equals(java.lang.Object)
     */
    public boolean equals(Object obj)
    {
        if (idData == null)
        {
            if (super.equals(obj))
                return parentFloor.equals( ( (IRoom) obj ).getFloor());
            return false;
        }
        return super.equals(obj);
    }
}
