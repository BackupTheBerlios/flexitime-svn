/*
 * Created on 23 d�c. 2004
 * by Guillaume GUERRIN
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.rmi;

import java.rmi.Remote;

import fr.umlv.ir3.flexitime.common.data.general.Building;


/**
 * IBuildingManager - DOCME Description
 * explication suppl�mentaire si n�cessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * repr�sente, ...
 * 
 * @version Verion ou r�vision SVN
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface IBuildingManager extends Remote, AbstractManager{
    /** 
     * getBuilding - get a building with its name
     * 
     *     <code>Building b = myBuildingManager.getBuilding("myBuilding")</code>
     *
     * @param name name of the building
     * @return a Building
     * 
     * @author   FlexiTeam - Val�re FOREL
     * @date     13 d�c. 2004
     */
    Building getBuilding(String name);   
    /** 
     * addBuilding - adds a building in the list
     * 
     *     <code>myBuildingManager.addBuilding(myBuilding)</code>
     *
     * @param building a building
     * 
     * @author   FlexiTeam - Val�re FOREL
     * @date     13 d�c. 2004
     */
    void saveBuilding(Building building);
    /** 
     * removeBuilding - remove a building in the list
     * 
     *     <code>Building b = myBuildingManager.removeBuilding("myBuilding")</code>
     *
     * @param name name of the building
     * @return a building
     * 
     * @author   FlexiTeam - Val�re FOREL
     * @date     13 d�c. 2004
     */
    Building removeBuilding(String name);

    /** 
     * lockBuilding - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param building
     * @return 
     * 
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    boolean lockBuilding(Building building);
    /** 
     * unlockBuilding - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param building
     * @return 
     * 
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    boolean unlockBuilding(Building building);
    
}
