/*
 * Created on 13 d�c. 2004
 * by Val�re FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.ressources.Teacher;

/**
 * TeachersManagerImpl - Implements the interface TeachersManager
 * 
 * @version 0.1
 * @author FlexiTeam - Val�re FOREL
 */
public class TeacherManager extends AbstractManager
{

    /**
     * DOCME
     * 
     * @throws RemoteException
     */
    protected TeacherManager() throws RemoteException
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
     * @param teacher
     * @throws RemoteException
     * @author FlexiTeam - Val�re
     * @date 27 d�c. 2004
     */
    public void create(Teacher teacher) throws RemoteException
    {}

    /**
     * update - DOCME Description Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param teacher
     * @throws RemoteException
     * @author FlexiTeam - Val�re
     * @date 27 d�c. 2004
     */
    public void update(Teacher teacher) throws RemoteException
    {}

    /**
     * remove - DOCME Description Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param teacher
     * @throws RemoteException
     * @author FlexiTeam - Val�re
     * @date 27 d�c. 2004
     */
    public void remove(Teacher teacher) throws RemoteException
    {}

    /**
     * lock - DOCME Description Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param teacher
     * @return
     * @throws RemoteException
     * @author FlexiTeam - Val�re
     * @date 27 d�c. 2004
     */
    public boolean lock(Teacher teacher) throws RemoteException
    {
        return false;
    }

    /**
     * unlock - DOCME Description Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param teacher
     * @return
     * @throws RemoteException
     * @author FlexiTeam - Val�re
     * @date 27 d�c. 2004
     */
    public boolean unlock(Teacher teacher) throws RemoteException
    {
        return false;
    }
}