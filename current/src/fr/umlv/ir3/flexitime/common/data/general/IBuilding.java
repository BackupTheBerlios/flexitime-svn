/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.general;

import java.util.List;

import fr.umlv.ir3.flexitime.common.data.IData;

/**
 * Represents a building with all parameters that it can
 * have
 * 
 * @version 0.1
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface IBuilding extends IData
{

    /**
     * Returns the number of floors of Building.
     * <code>int i = lbuilding.getNbFloor()</code>
     * 
     * @return the number of floors of Building.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    int getNbFloor();

    /**
     * Returns a list of floors of Building.
     * 
     * @return a list of floors of Building.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    List<IFloor> getLstFloor();

    /**
     * Changes a list of the floor of Building.
     * 
     * @param lstFloor the new list of floor.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void setLstFloor(List<IFloor> lstFloor);

    /**
     * Add a floor in Building.
     * 
     * @param floor the floor added.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void addFloor(IFloor floor);

    /**
     * Remove a floor in Building.
     * 
     * @param floor the floor removed.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void removeFloor(IFloor floor);
}
