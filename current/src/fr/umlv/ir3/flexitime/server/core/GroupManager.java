/*
 * Created on 26 d�c. 2004
 * by Val�re
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.Data;

/**
 * GroupManagerImpl - DOCME Description explication suppl�mentaire si n�cessaire
 * in english please... Que fait cette classe, qu'est-ce qu'elle repr�sente, ...
 * 
 * @version Verion ou r�vision SVN
 * @author FlexiTeam - Val�re
 */
public class GroupManager extends AbstractManager
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
    public void add(Data d) throws RemoteException
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
    public boolean lock(Data d) throws RemoteException
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
    public void remove(Data d) throws RemoteException
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
    public void unlock(Data d) throws RemoteException
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
    public void update(Data d) throws RemoteException
    {
        // TODO Auto-generated method stub
        
    }
}