/*
 * Created on 15 d�c. 2004
 * by Val�re FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.IData;

/**
 * TracksManagerImpl - implements the interface TracksManager
 * 
 * @version Verion ou r�vision SVN
 * @author FlexiTeam - Val�re FOREL
 */
public class TrackManager extends AbstractManager
{

    /** 
     * DOCME Description
     * Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     *
     * @param d
     * @throws RemoteException 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#add(fr.umlv.ir3.flexitime.common.data.Data)
      */
    public void add(IData d) throws RemoteException
    {
        // TODO Auto-generated method stub
        
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
      */
    public List get() throws RemoteException
    {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     *
     * @param d
     * @return
     * @throws RemoteException 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#lock(fr.umlv.ir3.flexitime.common.data.Data)
      */
    public boolean lock(IData d) throws RemoteException
    {
        // TODO Auto-generated method stub
        return false;
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     *
     * @param d
     * @throws RemoteException 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#remove(fr.umlv.ir3.flexitime.common.data.Data)
      */
    public void remove(IData d) throws RemoteException
    {
        // TODO Auto-generated method stub
        
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     *
     * @param d
     * @throws RemoteException 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#unlock(fr.umlv.ir3.flexitime.common.data.Data)
      */
    public void unlock(IData d) throws RemoteException
    {
        // TODO Auto-generated method stub
        
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     *
     * @param d
     * @throws RemoteException 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#update(fr.umlv.ir3.flexitime.common.data.Data)
      */
    public void update(IData d) throws RemoteException
    {
        // TODO Auto-generated method stub
        
    }

}