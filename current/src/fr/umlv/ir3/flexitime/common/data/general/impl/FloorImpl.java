/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.general.impl;

import java.util.*;

import fr.umlv.ir3.flexitime.common.data.general.*;
import fr.umlv.ir3.flexitime.common.data.impl.DataImpl;
import fr.umlv.ir3.flexitime.common.data.resources.IRoom;

/**
 * Defines a floor which contains rooms.
 * 
 * @version 245
 * @see fr.umlv.ir3.flexitime.common.data.general.IFloor
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class FloorImpl extends DataImpl implements IFloor
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3977585800848159025L;
    // ===========//
    // Champs //
    // ===========//
    private List<IRoom>       lstRoom;
    private IBuilding         parentBuilding;

    // ==================//
    // Constructeurs //
    // ==================//
    /**
     * Default constructor for a floor.
     */
    protected FloorImpl()
    {
        lstRoom = new ArrayList<IRoom>();
    }

    /**
     * Constructs a floor from a building with a name and his parent in
     * parameter.
     * 
     * @param name
     *            a string.
     * @param building
     *            the building parent of this floor.
     */
    public FloorImpl(String name, IBuilding building)
    {
        super(name);
        this.parentBuilding = building;
        lstRoom = new ArrayList<IRoom>();
    }

    /**
     * Constructs a floor from a building.
     * 
     * @param name
     *            a string.
     * @param listRooms
     *            a list of rooms for this floor.
     * @param building
     *            a string representing the name of the building where the floor
     *            is.
     */
    public FloorImpl(String name, IBuilding building, List<IRoom> listRooms)
    {
        super(name);
        this.lstRoom = listRooms;
        this.parentBuilding = building;
    }

    // ======== //
    // Méthodes //
    // ======== //
    /**
     * Returns the list of rooms at this floor.
     * <code>List l = floor.getLstRoom()</code>
     * 
     * @return the list of rooms;
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.IFloor#getLstRoom()
     */
    public List<IRoom> getLstRoom()
    {
        return lstRoom;
    }

    /**
     * Sets the list of rooms at this floor.
     * <code>floor.setLstRoom(lstRoom)</code>
     * 
     * @param lstRoom
     *            a list of rooms.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.IFloor#setLstRoom(java.util.List)
     */
    public void setLstRoom(List<IRoom> lstRoom)
    {
        this.lstRoom = lstRoom;
    }

    /**
     * Adds a room to the list. <code>floor.addRoom(room)</code>
     * 
     * @param room
     *            the room to add to the list.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.IFloor#addRoom(fr.umlv.ir3.flexitime.common.data.resources.IRoom)
     */
    public void addRoom(IRoom room)
    {
        lstRoom.add(room);
        room.setFloor(this);
    }

    /**
     * Removes a floor from the list. <code>floor.removeRoom(room)</code>
     * 
     * @param room
     *            the room to remove of the list.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.IFloor#removeRoom(fr.umlv.ir3.flexitime.common.data.resources.IRoom)
     */
    public void removeRoom(IRoom room)
    {
        lstRoom.remove(room);
    }

    /**
     * Returns the name of the building where the floor is.
     * <code>String s = floor.getBuilding()</code>
     * 
     * @return the name of the building where the floor is.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.IFloor#getParentBuilding()
     */
    public IBuilding getParentBuilding()
    {
        return parentBuilding;
    }

    /**
     * Sets the building where the floor is.
     * 
     * @param building
     *            the building where the floor is.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.IFloor#setParentBuilding(IBuilding)
     */
    public void setParentBuilding(IBuilding building)
    {
        this.parentBuilding = building;
    }

    /**
     * Test the equality of two floor.
     * <ul>
     * <li>The two objects must be instance of IFloor</li>
     * <li>If one floor has an ID, the other must have one, else there are not
     * equals.</li>
     * <li>If any floor has an ID, they must have the same name and the same parent building to be equals.
     * </li>
     * <li>Else, they must have the same ID.</li>
     * </ul>
     * 
     * @param obj
     *            other floor to compare with
     * @return <code>true</code> if this object is the same as the obj
     *         argument; <code>false</code> otherwise.
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj)
    {
        if (obj == null) return false;
        if (! ( obj instanceof IFloor )) return false;
        IFloor other = (IFloor) obj;
        if ( ( ( idData != null ) && ( other.getIdData() == null ) )
                || ( ( idData == null ) && ( other.getIdData() != null ) ))
            return false;
        
        if (idData == null)
        {
            if (this.getName().equals(other.getName()))
                return parentBuilding.equals(other.getParentBuilding());
            return false;
        }
        return ( idData == other.getIdData() );
    }
    
    /** 
     * Generated by the hashcode of the name.
     * 
     * @return hashcode of the floor 
     * 
     * @see java.lang.Object#hashCode()
     */
    public int hashCode()
    {
        return this.getName().hashCode();
    }
}
