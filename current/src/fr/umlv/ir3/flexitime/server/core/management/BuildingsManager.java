/*
 * Created on 13 déc. 2004
 * by Valère FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.management;

import fr.umlv.ir3.flexitime.common.data.general.*;


/**
 * BuildingManager - DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Valère FOREL
 */
public interface BuildingsManager {
    /** 
     * getBuilding - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @return 
     * 
     * @author   FlexiTeam - Valère FOREL
     * @date     13 déc. 2004
     */
    Building getBuilding(String name);   
    /** 
     * addBuilding - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param building 
     * 
     * @author   FlexiTeam - Valère FOREL
     * @date     13 déc. 2004
     */
    void addBuilding(Building building);
    /** 
     * removeBuilding - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @return 
     * 
     * @author   FlexiTeam - Valère FOREL
     * @date     13 déc. 2004
     */
    Building removeBuilding(String name);

}
