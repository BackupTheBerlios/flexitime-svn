/*
 * Created on 13 déc. 2004
 * by Valère FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.management.impl;

import fr.umlv.ir3.flexitime.common.data.general.*;
import fr.umlv.ir3.flexitime.common.data.ressources.Room;
import fr.umlv.ir3.flexitime.server.core.management.*;


/**
 * BuildingsManagerImpl - Implements the interface BuildingManager
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Valère FOREL
 */
public class BuildingsManagerImpl implements BuildingsManager {

    /** 
     * getBuilding - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name name of the building
     * @return a Building
     * 
     * @see fr.umlv.ir3.flexitime.server.core.management.BuildingsManager#getBuilding(java.lang.String)
     * @author   FlexiTeam - Administrateur
     * @date     13 déc. 2004
     */
    public Building getBuilding(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * addBuilding - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param building 
     * 
     * @see fr.umlv.ir3.flexitime.server.core.management.BuildingsManager#addBuilding(fr.umlv.ir3.flexitime.common.data.general.Building)
     * @author   FlexiTeam - Administrateur
     * @date     13 déc. 2004
     */
    public void addBuilding(Building building) {
        // TODO Auto-generated method stub
        
    }

    /** 
     * removeBuilding - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.server.core.management.BuildingsManager#removeBuilding(java.lang.String)
     * @author   FlexiTeam - Administrateur
     * @date     13 déc. 2004
     */
    public Building removeBuilding(String name) {
        // TODO Auto-generated method stub
        return null;
    }

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
     * @see fr.umlv.ir3.flexitime.server.core.management.BuildingsManager#getFloor(java.lang.String, fr.umlv.ir3.flexitime.common.data.general.Building)
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    public Floor getFloor(String name, Building building) {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * addFloor - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param floor
     * @param building 
     * 
     * @see fr.umlv.ir3.flexitime.server.core.management.BuildingsManager#addFloor(fr.umlv.ir3.flexitime.common.data.general.Floor, fr.umlv.ir3.flexitime.common.data.general.Building)
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    public void addFloor(Floor floor, Building building) {
        // TODO Auto-generated method stub
        
    }

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
     * @see fr.umlv.ir3.flexitime.server.core.management.BuildingsManager#removeFloor(java.lang.String, fr.umlv.ir3.flexitime.common.data.general.Building)
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    public Floor removeFloor(String name, Building building) {
        // TODO Auto-generated method stub
        return null;
    }

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
     * @see fr.umlv.ir3.flexitime.server.core.management.BuildingsManager#getRoom(java.lang.String, fr.umlv.ir3.flexitime.common.data.general.Building, fr.umlv.ir3.flexitime.common.data.general.Floor)
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    public Room getRoom(String name, Building building, Floor floor) {
        // TODO Auto-generated method stub
        return null;
    }

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
     * @see fr.umlv.ir3.flexitime.server.core.management.BuildingsManager#addRoom(fr.umlv.ir3.flexitime.common.data.ressources.Room, fr.umlv.ir3.flexitime.common.data.general.Building, fr.umlv.ir3.flexitime.common.data.general.Floor)
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    public void addRoom(Room room, Building building, Floor floor) {
        // TODO Auto-generated method stub
        
    }

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
     * @see fr.umlv.ir3.flexitime.server.core.management.BuildingsManager#removeRoom(java.lang.String, fr.umlv.ir3.flexitime.common.data.general.Building, fr.umlv.ir3.flexitime.common.data.general.Floor)
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    public Room removeRoom(String name, Building building, Floor floor) {
        // TODO Auto-generated method stub
        return null;
    }

}
