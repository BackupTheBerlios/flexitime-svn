/*
 * Created on 13 d�c. 2004
 * by Val�re FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.List;
import fr.umlv.ir3.flexitime.common.data.general.Building;

/**
 * BuildingsManager -
 * 
 * @version 0.1
 * @author FlexiTeam - Val�re FOREL
 */
public class BuildingManager extends AbstractManager
{

    /**
     * DOCME
     * 
     * @throws RemoteException
     */
    protected BuildingManager() throws RemoteException
    {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * getDatas - DOCME Description Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     * 
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.server.core.AbstractManager#getDatas()
     * @author FlexiTeam - Val�re
     * @date 27 d�c. 2004
     */
    public List get() throws RemoteException
    {
        return null;
    }

    /**
     * createData - DOCME Description Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param building
     * @throws RemoteException
     * @author FlexiTeam - Val�re
     * @date 27 d�c. 2004
     */
    public void create(Building building) throws RemoteException
    {}

    /**
     * updateData - DOCME Description Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param building
     * @throws RemoteException
     * @author FlexiTeam - Val�re
     * @date 27 d�c. 2004
     */
    public void update(Building building) throws RemoteException
    {}

    /**
     * removeData - DOCME Description Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param building
     * @throws RemoteException
     * @author FlexiTeam - Val�re
     * @date 27 d�c. 2004
     */
    public void remove(Building building) throws RemoteException
    {}

    /**
     * lock - DOCME Description Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param building
     * @return
     * @throws RemoteException
     * @author FlexiTeam - Val�re
     * @date 27 d�c. 2004
     */
    public boolean lock(Building building) throws RemoteException
    {
        return false;
    }

    /**
     * unlock - DOCME Description Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param building
     * @return
     * @throws RemoteException
     * @author FlexiTeam - Val�re
     * @date 27 d�c. 2004
     */
    public boolean unlock(Building building) throws RemoteException
    {
        return false;
    }

}