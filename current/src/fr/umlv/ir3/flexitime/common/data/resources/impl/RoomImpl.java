/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.resources.impl;

import java.util.List;

import fr.umlv.ir3.flexitime.common.data.general.impl.FloorImpl;
import fr.umlv.ir3.flexitime.common.data.resources.IRoom;


/**
 * Defines a room.
 * 
 * TYPE_MACHINE = 1;
 * TYPE_COURS   = 2;
 * TYPE_TP      = 3;
 * 
 * @version 0.1
 * @see fr.umlv.ir3.flexitime.common.data.ressources.IRoom
 * @see fr.umlv.ir3.flexitime.common.data.ressources.impl.ResourceImpl
 * 
 * @author FlexiTeam - Adrien BOUVET
 */
public class RoomImpl extends ResourceImpl implements IRoom
{
    //===========//
	//  Champs	 //
	//===========//
    private int iType;
    private int iCapacity;
    private FloorImpl parentFloor; 
    
    
	//=============//
	//Constructeurs//
    //=============//
	/**
	 * Default constructor for a room. 
	 */
	protected RoomImpl()
	{}
	
	/**
	 * Constructs a room with just a name in parameter.
	 * 
	 * @param name a string.
	 */
	public RoomImpl(String name)
	{
		super(name);        
	}
	
	/**
	 * Constructs a room with a name and his parent in parameter.
	 * 
	 * @param name a string.
	 * @param floor the parent floor of this room.
	 * 
	 */
	public RoomImpl(String name, FloorImpl floor)
	{
		super(name);
		this.parentFloor = floor;        
	}
	
    /**
     * Constructs a room.
     * 
     * @param name a string.
     * @param listBusy a list of unavailibilities.
     * @param type a type of room.
     * @param capacity the number maximum of students whom can sit in the room.
	 * @param floor the parent floor of this room. 
     */
    public RoomImpl(String name, List listBusy, int type, int capacity, FloorImpl floor)
    {
        super(name, listBusy);
        this.iType = type;
        this.iCapacity = capacity;
        this.parentFloor = floor;        
    }

    
    //===========//
    // Méthodes  //
	//===========//
    /** 
     * Returns the type of the room.
     * <code>Int i = room.getType()</code>
     *
     * @return the type of the room.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.ressources.IRoom#getType()
     * @author   FlexiTeam - Adrien BOUVET
     */
    public int getType()
    {
        return iType;
    }

    /** 
     * Sets the type of the room.
     * <code>room.setType(iType)</code>
     *
     * @param iType the type of the room.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.ressources.IRoom#setType(int)
     * @author   FlexiTeam - Adrien BOUVET
     */
    public void setType(int iType)
    {
        this.iType = iType;
    }

    /** 
     * Returns the capacity of the room.
     * <code>Int c = room.getCapacity()</code>
     *
     * @return the capacity of the room.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.ressources.IRoom#getCapacity()
     * @author   FlexiTeam - Adrien BOUVET
     */
    public int getCapacity()
    {
        return iCapacity;
    }

    /** 
     * Sets the capacity of the room.
     * <code>room.setCapacity(capacity)</code>
     *
     * @param capacity the capacity of the room.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.ressources.IRoom#setCapacity(int)
     * @author   FlexiTeam - Adrien BOUVET
     */
    public void setCapacity(int capacity)
    {
        this.iCapacity = capacity;
    }
    
	/** 
	 * Returns the floor where the room is.
	 * <code>String s = room.getFloor()</code>
	 *
	 * @return the floor where the room is.
	 * 
	 * @see fr.umlv.ir3.flexitime.common.data.ressources.IRoom#getFloor()
	 * @author   FlexiTeam - Adrien BOUVET
	 */
	public FloorImpl getFloor()
	{
		return parentFloor;
	}

	/** 
	 * Sets the floor where the room is.
	 * <code>room.setFloor(floor)</code>
	 *
	 * @param floor the floor where the room is.
	 * 
	 * @see fr.umlv.ir3.flexitime.common.data.ressources.IRoom#setFloor(java.lang.String)
	 * @author   FlexiTeam - Adrien BOUVET
	 */
	public void setFloor(FloorImpl floor)
	{
		this.parentFloor = floor;
	}
}
