/*
 * Created on 13 déc. 2004
 * by Valère FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.management;

import java.util.*;

import fr.umlv.ir3.flexitime.common.data.activity.*;
import fr.umlv.ir3.flexitime.common.data.ressources.*;
import fr.umlv.ir3.flexitime.common.tools.*;


/**
 * SeancesManager - DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Valère FOREL
 */
public interface SeancesManager {
    /** 
     * getSeance - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     * @param debut
     * @param heure
     * @param group
     *
     * @return 
     * 
     * @author   FlexiTeam - Valère FOREL
     * @date     13 déc. 2004
     */
    Seance getSeance(Date debut, Time heure, Groups group);
    /** 
     * addSeance - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     * @param seance
     *
     *  
     * 
     * @author   FlexiTeam - Valère FOREL
     * @date     13 déc. 2004
     */
    void addSeance(Seance seance);
    /** 
     * removeSeance - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     * @param debut
     * @param heure
     * @param group
     *
     * @return 
     * 
     * @author   FlexiTeam - Valère FOREL
     * @date     13 déc. 2004
     */
    Seance removeSeance(Date debut, Time heure, Groups group);

}
