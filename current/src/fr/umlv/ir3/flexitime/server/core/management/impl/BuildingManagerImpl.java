/*
 * Created on 13 déc. 2004
 * by Valère FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.management.impl;

import fr.umlv.ir3.flexitime.common.data.Data;
import fr.umlv.ir3.flexitime.common.data.general.Building;
import fr.umlv.ir3.flexitime.common.rmi.IBuildingManager;





/**
 * BuildingsManagerImpl - Implements the interface BuildingManager
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Valère FOREL
 */
public class BuildingManagerImpl implements IBuildingManager {

    /** 
     * getBuilding - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IBuildingManager#getBuilding(java.lang.String)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public Building getBuilding(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * saveBuilding - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param building 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IBuildingManager#saveBuilding(fr.umlv.ir3.flexitime.common.data.general.Building)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public void saveBuilding(Building building) {
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
     * @see fr.umlv.ir3.flexitime.common.rmi.IBuildingManager#removeBuilding(java.lang.String)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public Building removeBuilding(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * lockBuilding - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param building
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IBuildingManager#lockBuilding(fr.umlv.ir3.flexitime.common.data.general.Building)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public boolean lockBuilding(Building building) {
        // TODO Auto-generated method stub
        return false;
    }

    /** 
     * unlockBuilding - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param building
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IBuildingManager#unlockBuilding(fr.umlv.ir3.flexitime.common.data.general.Building)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public boolean unlockBuilding(Building building) {
        // TODO Auto-generated method stub
        return false;
    }

    /** 
     * getData - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.AbstractManager#getData()
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public Data getData() {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * saveData - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param data 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.AbstractManager#saveData(fr.umlv.ir3.flexitime.common.data.Data)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public void saveData(Data data) {
        // TODO Auto-generated method stub
        
    }

    /** 
     * removeData - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param data 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.AbstractManager#removeData(fr.umlv.ir3.flexitime.common.data.Data)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public void removeData(Data data) {
        // TODO Auto-generated method stub
        
    }

    /** 
     * lock - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param data
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.AbstractManager#lock(fr.umlv.ir3.flexitime.common.data.Data)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public boolean lock(Data data) {
        // TODO Auto-generated method stub
        return false;
    }

    /** 
     * unlock - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param data
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.AbstractManager#unlock(fr.umlv.ir3.flexitime.common.data.Data)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public boolean unlock(Data data) {
        // TODO Auto-generated method stub
        return false;
    }


}
