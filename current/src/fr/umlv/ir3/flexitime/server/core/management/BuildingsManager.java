/*
 * Created on 13 déc. 2004
 * by Valère FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.management;

import fr.umlv.ir3.flexitime.common.data.general.*;


/**
 * BuildingManager - Manages the buildings in a list
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Valère FOREL
 */
public interface BuildingsManager {
    /** 
     * getBuilding - get a building with its name
     * 
     *     <code>Building b = myBuildingManager.getBuilding("myBuilding")</code>
     *
     * @param name name of the building
     * @return a Building
     * 
     * @author   FlexiTeam - Valère FOREL
     * @date     13 déc. 2004
     */
    Building getBuilding(String name);   
    /** 
     * addBuilding - adds a building in the list
     * 
     *     <code>myBuildingManager.addBuilding(myBuilding)</code>
     *
     * @param building a building
     * 
     * @author   FlexiTeam - Valère FOREL
     * @date     13 déc. 2004
     */
    void addBuilding(Building building);
    /** 
     * removeBuilding - remove a building in the list
     * 
     *     <code>Building b = myBuildingManager.removeBuilding("myBuilding")</code>
     *
     * @param name name of the building
     * @return a building
     * 
     * @author   FlexiTeam - Valère FOREL
     * @date     13 déc. 2004
     */
    Building removeBuilding(String name);

}
