/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.general;

import java.util.List;

import fr.umlv.ir3.flexitime.common.data.IData;
import fr.umlv.ir3.flexitime.common.data.ressources.IRoom;

/**
 * Represents a floor with all parameters that it can have
 * 
 * @version 0.1
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface IFloor extends IData
{

    /**
     * Returns a list of rooms of a floor.
     * 
     * @return a list of floors of a floor.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    List getLstRoom();

    /**
     * Changes a list of rooms of a floor.
     * 
     * @param lstRoom the new list of floor.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void setLstRoom(List lstRoom);

    /**
     * Add a room in a floor
     * 
     * @param room the new Room added.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void addRoom(IRoom room);

    /**
     * Remove a room in a floor
     * 
     * @param room the Room removed
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void removeRoom(IRoom room);

}
