/*
 * Created on 13 d�c. 2004
 * by Val�re FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.management.impl;

import fr.umlv.ir3.flexitime.common.data.Data;
import fr.umlv.ir3.flexitime.common.data.ressources.Device;
import fr.umlv.ir3.flexitime.common.rmi.IDeviceManager;



/**
 * DevicesManager - Implements the interface DevicesManager
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Val�re FOREL
 */
public class DeviceManagerImpl implements IDeviceManager {

    /** 
     * getDevice - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDeviceManager#getDevice(java.lang.String)
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    public Device getDevice(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * saveDevice - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param device 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDeviceManager#saveDevice(fr.umlv.ir3.flexitime.common.data.ressources.Device)
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    public void saveDevice(Device device) {
        // TODO Auto-generated method stub
        
    }

    /** 
     * removeDevice - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDeviceManager#removeDevice(java.lang.String)
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    public Device removeDevice(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * lockDevice - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param device
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDeviceManager#lockDevice(fr.umlv.ir3.flexitime.common.data.ressources.Device)
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    public boolean lockDevice(Device device) {
        // TODO Auto-generated method stub
        return false;
    }

    /** 
     * unlockDevice - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param device
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDeviceManager#unlockDevice(fr.umlv.ir3.flexitime.common.data.ressources.Device)
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    public boolean unlockDevice(Device device) {
        // TODO Auto-generated method stub
        return false;
    }

    /** 
     * getData - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.AbstractManager#getData()
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    public Data getData() {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * saveData - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param data 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.AbstractManager#saveData(fr.umlv.ir3.flexitime.common.data.Data)
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    public void saveData(Data data) {
        // TODO Auto-generated method stub
        
    }

    /** 
     * removeData - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param data 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.AbstractManager#removeData(fr.umlv.ir3.flexitime.common.data.Data)
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    public void removeData(Data data) {
        // TODO Auto-generated method stub
        
    }

    /** 
     * lock - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param data
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.AbstractManager#lock(fr.umlv.ir3.flexitime.common.data.Data)
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    public boolean lock(Data data) {
        // TODO Auto-generated method stub
        return false;
    }

    /** 
     * unlock - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param data
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.AbstractManager#unlock(fr.umlv.ir3.flexitime.common.data.Data)
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    public boolean unlock(Data data) {
        // TODO Auto-generated method stub
        return false;
    }

}
