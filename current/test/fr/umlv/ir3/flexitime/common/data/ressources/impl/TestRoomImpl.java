/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.ressources.impl;

import java.util.SortedSet;

import junit.framework.TestCase;

import fr.umlv.ir3.flexitime.common.data.activity.IBusy;
import fr.umlv.ir3.flexitime.common.data.general.IFloor;
import fr.umlv.ir3.flexitime.common.data.resources.IRoom;

/**
 * Defines a room.
 * 
 * TYPE_MACHINE = 1; TYPE_COURS = 2; TYPE_TP = 3;
 * 
 * @version 245
 * @see fr.umlv.ir3.flexitime.common.data.resources.IRoom
 * @see fr.umlv.ir3.flexitime.common.data.resources.impl.ResourceImpl
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class TestRoomImpl extends TestCase
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3256719568024974134L;
    // ====== //
    // Champs //
    // ====== //
    private int               type;
    private int               capacity;
    private IFloor            floor;

    
    // ===========//
    // Méthodes //
    // ===========//
    /**
     * Returns the type of the room. <code>Int i = room.getType()</code>
     * 
     * @return the type of the room.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.IRoom#getType()
     */
    public void testGetType()
    {
    }

    /**
     * Sets the type of the room. <code>room.setType(type)</code>
     * 
     * @param iType
     *            the type of the room.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.IRoom#setType(int)
     */
    public void testSetType()
    {
    }

    /**
     * Returns the capacity of the room. <code>Int c = room.getCapacity()</code>
     * 
     * @return the capacity of the room.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.IRoom#getCapacity()
     */
    public void testGetCapacity()
    {
    }

    /**
     * Sets the capacity of the room. <code>room.setCapacity(capacity)</code>
     * 
     * @param capacity
     *            the capacity of the room.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.IRoom#setCapacity(int)
     */
    public void testSetCapacity()
    {
    }

    /**
     * Returns the floor where the room is.
     * <code>String s = room.getFloor()</code>
     * 
     * @return the floor where the room is.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.IRoom#getFloor()
     */
    public void testGetFloor()
    {
    }

    /**
     * Sets the floor where the room is. <code>room.setFloor(floor)</code>
     * 
     * @param floor
     *            the floor where the room is.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.IRoom#setFloor(IFloor)
     */
    public void testSetFloor()
    {
    }
}
