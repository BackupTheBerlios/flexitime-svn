/*
 * Created on 15 déc. 2004
 * by Administrateur
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.management.impl;

import java.util.Date;

import fr.umlv.ir3.flexitime.common.data.Data;
import fr.umlv.ir3.flexitime.common.data.activity.Busy;
import fr.umlv.ir3.flexitime.common.data.ressources.Resource;
import fr.umlv.ir3.flexitime.common.rmi.IBusyManager;
import fr.umlv.ir3.flexitime.common.tools.Time;




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
public class BusyManagerImpl implements IBusyManager {

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
     * @see fr.umlv.ir3.flexitime.common.rmi.IBusyManager#getBusy(java.util.Date, fr.umlv.ir3.flexitime.common.tools.Time, fr.umlv.ir3.flexitime.common.data.ressources.Resource)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public Busy getBusy(Date date, Time time, Resource r) {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * saveBusy - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param busy 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IBusyManager#saveBusy(fr.umlv.ir3.flexitime.common.data.activity.Busy)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public void saveBusy(Busy busy) {
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
     * @see fr.umlv.ir3.flexitime.common.rmi.IBusyManager#removeBusy(java.util.Date, fr.umlv.ir3.flexitime.common.tools.Time, fr.umlv.ir3.flexitime.common.data.ressources.Resource)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public Busy removeBusy(Date date, Time time, Resource r) {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * lockBusy - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param busy
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IBusyManager#lockBusy(fr.umlv.ir3.flexitime.common.data.activity.Busy)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public boolean lockBusy(Busy busy) {
        // TODO Auto-generated method stub
        return false;
    }

    /** 
     * unlockBusy - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param busy
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IBusyManager#unlockBusy(fr.umlv.ir3.flexitime.common.data.activity.Busy)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public boolean unlockBusy(Busy busy) {
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
