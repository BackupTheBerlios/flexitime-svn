/*
 * Created on 15 d�c. 2004
 * by Administrateur
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.activity.Busy;

/**
 * BusysManagerImpl - DOCME Description explication suppl�mentaire si n�cessaire
 * in english please... Que fait cette classe, qu'est-ce qu'elle repr�sente, ...
 * 
 * @version Verion ou r�vision SVN
 * @author FlexiTeam - Administrateur
 */
public class BusyManager extends AbstractManager
{

    /**
     * DOCME
     * 
     * @throws RemoteException
     */
    protected BusyManager() throws RemoteException
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
     * @param busy
     * @throws RemoteException
     * @author FlexiTeam - Val�re
     * @date 27 d�c. 2004
     */
    public void create(Busy busy) throws RemoteException
    {}

    /**
     * update - DOCME Description Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param busy
     * @throws RemoteException
     * @author FlexiTeam - Val�re
     * @date 27 d�c. 2004
     */
    public void update(Busy busy) throws RemoteException
    {}

    /**
     * remove - DOCME Description Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param busy
     * @throws RemoteException
     * @author FlexiTeam - Val�re
     * @date 27 d�c. 2004
     */
    public void remove(Busy busy) throws RemoteException
    {}

    /**
     * lock - DOCME Description Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param busy
     * @return
     * @throws RemoteException
     * @author FlexiTeam - Val�re
     * @date 27 d�c. 2004
     */
    public boolean lock(Busy busy) throws RemoteException
    {
        return false;
    }

    /**
     * unlock - DOCME Description Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param busy
     * @return
     * @throws RemoteException
     * @author FlexiTeam - Val�re
     * @date 27 d�c. 2004
     */
    public boolean unlock(Busy busy) throws RemoteException
    {
        return false;
    }

}