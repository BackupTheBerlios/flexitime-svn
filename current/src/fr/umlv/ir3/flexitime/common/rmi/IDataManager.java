/*
 * Created on 26 d�c. 2004
 * by Val�re
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.Data;

/**
 * AbstractManager - DOCME Description explication suppl�mentaire si n�cessaire
 * in english please... Que fait cette classe, qu'est-ce qu'elle repr�sente, ...
 * 
 * @version 0.1
 * @author FlexiTeam - Val�re
 */
public interface IDataManager extends Remote
{

    /**
     * getDatas - DOCME Description Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     * 
     * @return
     * @throws RemoteException
     * @author FlexiTeam - Val�re
     * @date 27 d�c. 2004
     */
    public List get() throws RemoteException;

    /**
     * createData - DOCME Description Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param data
     * @throws RemoteException
     * @author FlexiTeam - Val�re
     * @date 27 d�c. 2004
     */
    public void create(Data data) throws RemoteException;

    /**
     * updateData - DOCME Description Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param data
     * @throws RemoteException
     * @author FlexiTeam - Val�re
     * @date 27 d�c. 2004
     */
    public void update(Data data) throws RemoteException;

    /**
     * removeData - DOCME Description Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param data
     * @throws RemoteException
     * @author FlexiTeam - Val�re
     * @date 27 d�c. 2004
     */
    public void remove(Data data) throws RemoteException;

    /**
     * lock - DOCME Description Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param data
     * @return
     * @throws RemoteException
     * @author FlexiTeam - Val�re
     * @date 27 d�c. 2004
     */
    public boolean lock(Data data) throws RemoteException;

    /**
     * unlock - DOCME Description Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     * 
     * @param data
     * @return
     * @throws RemoteException
     * @author FlexiTeam - Val�re
     * @date 27 d�c. 2004
     */
    public boolean unlock(Data data) throws RemoteException;
}