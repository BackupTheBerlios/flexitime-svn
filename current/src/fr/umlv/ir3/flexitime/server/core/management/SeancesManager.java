/*
 * Created on 13 d�c. 2004
 * by Val�re FOREL
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
 * explication suppl�mentaire si n�cessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * repr�sente, ...
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Val�re FOREL
 */
public interface SeancesManager {
    /** 
     * getSeance - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     * @param debut
     * @param heure
     * @param group
     *
     * @return 
     * 
     * @author   FlexiTeam - Val�re FOREL
     * @date     13 d�c. 2004
     */
    Seance getSeance(Date debut, Time heure, Groups group);
    /** 
     * addSeance - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     * @param seance
     *
     *  
     * 
     * @author   FlexiTeam - Val�re FOREL
     * @date     13 d�c. 2004
     */
    void addSeance(Seance seance);
    /** 
     * removeSeance - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     * @param debut
     * @param heure
     * @param group
     *
     * @return 
     * 
     * @author   FlexiTeam - Val�re FOREL
     * @date     13 d�c. 2004
     */
    Seance removeSeance(Date debut, Time heure, Groups group);

}
