/*
 * Created on 15 déc. 2004
 * by Administrateur
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.management.impl;

import java.util.Date;

import fr.umlv.ir3.flexitime.common.data.activity.Busy;
import fr.umlv.ir3.flexitime.common.data.ressources.Resource;
import fr.umlv.ir3.flexitime.common.tools.Time;
import fr.umlv.ir3.flexitime.server.core.management.BusysManager;


/**
 * BusysManagerImpl - DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * 
 * @author FlexiTeam - Administrateur
 */
public class BusysManagerImpl implements BusysManager {

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
     * @see fr.umlv.ir3.flexitime.server.core.management.BusysManager#getBusy(java.util.Date, fr.umlv.ir3.flexitime.common.tools.Time, fr.umlv.ir3.flexitime.common.data.ressources.Resource)
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    public Busy getBusy(Date date, Time time, Resource r) {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * addBusy - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param busy 
     * 
     * @see fr.umlv.ir3.flexitime.server.core.management.BusysManager#addBusy(fr.umlv.ir3.flexitime.common.data.activity.Busy)
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    public void addBusy(Busy busy) {
    // TODO Auto-generated method stub

    }

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
     * @see fr.umlv.ir3.flexitime.server.core.management.BusysManager#removeBusy(java.util.Date, fr.umlv.ir3.flexitime.common.tools.Time, fr.umlv.ir3.flexitime.common.data.ressources.Resource)
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    public Busy removeBusy(Date date, Time time, Resource r) {
        // TODO Auto-generated method stub
        return null;
    }

}
