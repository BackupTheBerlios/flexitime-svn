/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.resources;

import fr.umlv.ir3.flexitime.common.data.general.IFloor;

/**
 * Represents a room which belong to a floor
 * 
 * @version 245
 * @author FlexiTeam - Jérôme GUERS
 */
public interface IRoom extends IResource
{
    // Definition des types
    /**
     * Comment for <code>TYPE_MACHINE</code>
     */
    public final static int   TYPE_MACHINE     = 1;
    /**
     * Comment for <code>TYPE_COURS</code>
     */
    public final static int   TYPE_COURS       = 2;
    /**
     * Comment for <code>TYPE_TP</code>
     */
    public final static int   TYPE_TP          = 3;
    
    /**
     * Returns the type of the room.
     * 
     * @return the type of the room.
     */
    int getType();

    /**
     * Changes the type of the room.
     * 
     * @param iType the type of the room.
     */
    void setType(int iType);

    /**
     * Returns the capacity of the room.
     * 
     * @return the capacity of the room.
     */
    int getCapacity();

    /**
     * Changes the capacity of the room.
     * 
     * @param capacity the capacity of the room.
     */
    void setCapacity(int capacity);

	/**
	 * Returns the floor where the room is.
	 * 
	 * @return the floor where the room is.
	 */
	IFloor getFloor();

	/**
	 * Sets the floor where the room is.
	 * 
	 * @param floor the floor where the room is.
	 */
	void setFloor(IFloor floor);
}
