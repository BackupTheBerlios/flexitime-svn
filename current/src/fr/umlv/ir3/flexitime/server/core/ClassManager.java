/*
 * Created on 26 d�c. 2004
 * by Val�re
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.IData;
import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.server.io.storage.ClassStorage;

/**
 * ClassManager - DOCME Description explication suppl�mentaire si n�cessaire
 * in english please... Que fait cette classe, qu'est-ce qu'elle repr�sente, ...
 * 
 * @version Verion ou r�vision SVN
 * @author FlexiTeam - Val�re
 */
public class ClassManager extends AbstractManager
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
        if(data instanceof IClass) ClassStorage.save((IClass) data);
        notifyListener(data,DataEvent.TYPE_ADDED);  
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
        return ClassStorage.get();
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
        if(data instanceof IData) ClassStorage.delete((IClass) data);
        notifyListener(data,DataEvent.TYPE_REMOVED);
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
        if(data instanceof IData) ClassStorage.update((IClass) data);
        notifyListener(data,DataEvent.TYPE_CHANGED);
    }

}