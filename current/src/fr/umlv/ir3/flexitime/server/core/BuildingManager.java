/*
 * Created on 13 d�c. 2004
 * by Val�re FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.List;

import net.sf.hibernate.HibernateException;

import fr.umlv.ir3.flexitime.common.data.IData;
import fr.umlv.ir3.flexitime.common.data.general.IBuilding;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.server.io.storage.BuildingStorage;

/**
 * DOCME  BuildingsManager -
 * 
 * @version 0.1
 * @author FlexiTeam - Val�re FOREL
 */
public class BuildingManager extends AbstractManager
{
    /** 
     * DOCME Description
     * Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     *
     * @param data
     * @throws RemoteException 
     * @throws HibernateException 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#save(fr.umlv.ir3.flexitime.common.data.IData)
     * @author   FlexiTeam - Administrateur
     */
    public boolean save(IData data) throws RemoteException, HibernateException
    {
        if(!(data instanceof IBuilding))return false;
        BuildingStorage.save((IBuilding) data);
        notifyListener(data,DataEvent.TYPE_ADDED);
        return true;
    }
    /** 
     * DOCME Description
     * Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     *
     * @return
     * @throws RemoteException 
     * @throws HibernateException 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#get()
     * @author   FlexiTeam - Administrateur
     */
    public List get(IData parent) throws RemoteException, HibernateException
    {
        return BuildingStorage.get();
    }
    /** 
     * DOCME Description
     * Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     *
     * @param data
     * @throws RemoteException 
     * @throws HibernateException 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#delete(fr.umlv.ir3.flexitime.common.data.IData)
     * @author   FlexiTeam - Administrateur
     */
    public boolean delete(IData data) throws RemoteException, HibernateException
    {
        if(!(data instanceof IBuilding))return false;
        BuildingStorage.delete((IBuilding) data);
        notifyListener(data, DataEvent.TYPE_REMOVED);
        return true;
    }
    /** 
     * DOCME Description
     * Quel service est rendu par cette m�thode
     * <code>exemple d'appel de la methode</code>
     *
     * @param data
     * @throws RemoteException 
     * @throws HibernateException 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#update(fr.umlv.ir3.flexitime.common.data.IData)
     * @author   FlexiTeam - Administrateur
     */
    public boolean update(IData data) throws RemoteException, HibernateException
    {
        if(!(data instanceof IBuilding)) return false;
        BuildingStorage.update((IBuilding) data);
        notifyListener(data,DataEvent.TYPE_CHANGED);
        return true;
    }

}