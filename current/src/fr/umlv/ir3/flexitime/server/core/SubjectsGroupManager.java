/*
 * Created on 26 déc. 2004
 * by Valère
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.teachingStructure.SubjectsGroup;

/**
 * SubjectsGroupManagerImpl - DOCME Description explication supplémentaire si
 * nécessaire in english please... Que fait cette classe, qu'est-ce qu'elle
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * @author FlexiTeam - Valère
 */
public class SubjectsGroupManager extends AbstractManager
{

    /**
     * DOCME
     * 
     * @throws RemoteException
     */
    protected SubjectsGroupManager() throws RemoteException
    {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * get - DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @return
     * @throws RemoteException
     * @see fr.umlv.ir3.flexitime.server.core.AbstractManager#get()
     * @author FlexiTeam - Valère
     * @date 27 déc. 2004
     */
    public List get() throws RemoteException
    {
        return null;
    }

    /**
     * create - DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param subjectsGroup
     * @throws RemoteException
     * @author FlexiTeam - Valère
     * @date 27 déc. 2004
     */
    public void create(SubjectsGroup subjectsGroup) throws RemoteException
    {}

    /**
     * update - DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param subjectsGroup
     * @throws RemoteException
     * @author FlexiTeam - Valère
     * @date 27 déc. 2004
     */
    public void update(SubjectsGroup subjectsGroup) throws RemoteException
    {}

    /**
     * remove - DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param subjectsGroup
     * @throws RemoteException
     * @author FlexiTeam - Valère
     * @date 27 déc. 2004
     */
    public void remove(SubjectsGroup subjectsGroup) throws RemoteException
    {}

    /**
     * lock - DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param subjectsGroup
     * @return
     * @throws RemoteException
     * @author FlexiTeam - Valère
     * @date 27 déc. 2004
     */
    public boolean lock(SubjectsGroup subjectsGroup) throws RemoteException
    {
        return false;
    }

    /**
     * unlock - DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param subjectsGroup
     * @return
     * @throws RemoteException
     * @author FlexiTeam - Valère
     * @date 27 déc. 2004
     */
    public boolean unlock(SubjectsGroup subjectsGroup) throws RemoteException
    {
        return false;
    }
}