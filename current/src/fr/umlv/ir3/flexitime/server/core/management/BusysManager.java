/*
 * Created on 15 déc. 2004
 * by Administrateur
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.management;

import java.util.Date;

import fr.umlv.ir3.flexitime.common.data.activity.Busy;
import fr.umlv.ir3.flexitime.common.data.ressources.Resource;
import fr.umlv.ir3.flexitime.common.tools.Time;



/**
 * BusysManager - Manages the unavailabilities of a teacher, room...
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Valère FOREL
 */
public interface BusysManager {
    /** 
     * getBusy - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param date
     * @param time
     * @param r
     * @return 
     * 
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    Busy getBusy(Date date, Time time, Resource r);
    /** 
     * addBusy - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param busy 
     * 
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    void addBusy(Busy busy);
    /** 
     * removeBusy - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param date
     * @param time
     * @param r
     * @return 
     * 
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    Busy removeBusy(Date date, Time time, Resource r);

}
