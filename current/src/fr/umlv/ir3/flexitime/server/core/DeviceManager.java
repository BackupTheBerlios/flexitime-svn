/*
 * Created on 13 d�c. 2004
 * by Val�re FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.IData;
import fr.umlv.ir3.flexitime.common.data.resources.IDevice;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse;
import fr.umlv.ir3.flexitime.server.io.storage.CourseStorage;
import fr.umlv.ir3.flexitime.server.io.storage.DeviceStorage;

/**
 * DevicesManager - Implements the interface DevicesManager
 * 
 * @version 0.1
 * @author FlexiTeam - Val�re FOREL
 */
public class DeviceManager extends AbstractManager
{

    /** 
     * DOCME Description
     * Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     *
     * @param data
     * @throws RemoteException 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#save(fr.umlv.ir3.flexitime.common.data.IData)
     * @author   FlexiTeam - Administrateur
     */
    public void save(IData data) throws RemoteException
    {
        if(data instanceof IDevice) DeviceStorage.save((IDevice) data);
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     *
     * @return
     * @throws RemoteException 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#get()
     * @author   FlexiTeam - Administrateur
     */
    public List get() throws RemoteException
    {
        return DeviceStorage.get();
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     *
     * @param data
     * @return
     * @throws RemoteException 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#lock(fr.umlv.ir3.flexitime.common.data.IData)
     * @author   FlexiTeam - Administrateur
     */
    public boolean lock(IData data) throws RemoteException
    {
        // TODO Auto-generated method stub
        return false;
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     *
     * @param data
     * @throws RemoteException 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#delete(fr.umlv.ir3.flexitime.common.data.IData)
     * @author   FlexiTeam - Administrateur
     */
    public void delete(IData data) throws RemoteException
    {
        if(data instanceof IDevice) DeviceStorage.delete((IDevice) data);
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     *
     * @param data
     * @throws RemoteException 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#unlock(fr.umlv.ir3.flexitime.common.data.IData)
     * @author   FlexiTeam - Administrateur
     */
    public void unlock(IData data) throws RemoteException
    {
        // TODO Auto-generated method stub
        
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     *
     * @param data
     * @throws RemoteException 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#update(fr.umlv.ir3.flexitime.common.data.IData)
     * @author   FlexiTeam - Administrateur
     */
    public void update(IData data) throws RemoteException
    {
        if(data instanceof IDevice) DeviceStorage.update((IDevice) data);
    }

}