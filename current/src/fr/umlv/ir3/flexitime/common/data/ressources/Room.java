/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.ressources;

/**
 * Represents a room which belong to a floor
 * 
 * @version 0.1
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface Room extends Resource
{

    //Definition des types
    public final static int TYPE_MACHINE = 1;
    public final static int TYPE_COURS   = 2;
    public final static int TYPE_TP      = 3;

    /**
     * Returns the type of the room.
     * 
     * @return the type of the room.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    int getType();

    /**
     * Changes the type of the room.
     * 
     * @param iType the type of the room.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void setType(int iType);

    /**
     * Returns the capacity of the room.
     * 
     * @return the capacity of the room.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    String getCapacity();

    /**
     * Changes the capacity of the room.
     * 
     * @param capacity the capacity of the room.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void setCapacity(String capacity);

}
