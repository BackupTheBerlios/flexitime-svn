/*
 * Created on 13 déc. 2004
 * by Valère FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.management;

import fr.umlv.ir3.flexitime.common.data.general.*;
import fr.umlv.ir3.flexitime.common.data.ressources.Room;


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
    /** 
     * getFloor - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @param building
     * @return 
     * 
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    Floor getFloor(String name, Building building);
    /** 
     * addFloor - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param floor
     * @param building 
     * 
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    void addFloor(Floor floor, Building building);
    /** 
     * removeFloor - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @param building
     * @return 
     * 
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    Floor removeFloor(String name, Building building);
    /** 
     * getRoom - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @param building
     * @param floor
     * @return 
     * 
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    Room getRoom(String name, Building building, Floor floor);
    /** 
     * addRoom - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param room
     * @param building
     * @param floor 
     * 
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    void addRoom(Room room, Building building, Floor floor);
    /** 
     * removeRoom - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @param building
     * @param floor
     * @return 
     * 
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    Room removeRoom(String name, Building building, Floor floor);
}
