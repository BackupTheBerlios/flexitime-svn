/*
 * Created on 13 d�c. 2004
 * by Val�re FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.ressources.Device;

/**
 * DevicesManager - Implements the interface DevicesManager
 * 
 * @version 0.1
 * @author FlexiTeam - Val�re FOREL
 */
public class DeviceManager extends AbstractManager
{

    /**
     * DOCME
     * 
     * @throws RemoteException
     */
    protected DeviceManager() throws RemoteException
    {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * get - DOCME Description Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     * 
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.server.core.AbstractManager#get()
     * @author FlexiTeam - Val�re
     * @date 27 d�c. 2004
     */
    public List get() throws RemoteException
    {
        return null;
    }

    /**
     * create - DOCME Description Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param device
     * @throws RemoteException
     * @author FlexiTeam - Val�re
     * @date 27 d�c. 2004
     */
    public void create(Device device) throws RemoteException
    {}

    /**
     * update - DOCME Description Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param device
     * @throws RemoteException
     * @author FlexiTeam - Val�re
     * @date 27 d�c. 2004
     */
    public void update(Device device) throws RemoteException
    {}

    /**
     * remove - DOCME Description Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param device
     * @throws RemoteException
     * @author FlexiTeam - Val�re
     * @date 27 d�c. 2004
     */
    public void remove(Device device) throws RemoteException
    {}

    /**
     * lock - DOCME Description Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param device
     * @return
     * @throws RemoteException
     * @author FlexiTeam - Val�re
     * @date 27 d�c. 2004
     */
    public boolean lock(Device device) throws RemoteException
    {
        return false;
    }

    /**
     * unlock - DOCME Description Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param device
     * @return
     * @throws RemoteException
     * @author FlexiTeam - Val�re
     * @date 27 d�c. 2004
     */
    public boolean unlock(Device device) throws RemoteException
    {
        return false;
    }
}