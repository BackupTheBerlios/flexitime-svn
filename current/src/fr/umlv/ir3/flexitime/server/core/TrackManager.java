/*
 * Created on 15 déc. 2004
 * by Valère FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.List;

import net.sf.hibernate.HibernateException;

import fr.umlv.ir3.flexitime.common.data.IData;
import fr.umlv.ir3.flexitime.common.data.general.ITrack;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.server.io.storage.TrackStorage;

/**
 * TracksManagerImpl - implements the interface TracksManager
 * 
 * @version Verion ou révision SVN
 * @author FlexiTeam - Valère FOREL
 */
public class TrackManager extends AbstractManager
{
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
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
        if(!(data instanceof ITrack)) return false;
        TrackStorage.save((ITrack) data);
        notifyListener(data,DataEvent.TYPE_ADDED);
        return true;
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
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
        return TrackStorage.get();
    }
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
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
         if(!(data instanceof ITrack)) return false;
         TrackStorage.delete((ITrack) data); 
         notifyListener(data,DataEvent.TYPE_REMOVED);
         return true;
    }
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
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
        if(!(data instanceof ITrack)) return false;
        TrackStorage.update((ITrack) data);
        notifyListener(data,DataEvent.TYPE_CHANGED);
        return true;
    }
    
}