/*
 * Created on 26 déc. 2004
 * by Valère
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.IData;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse;
import fr.umlv.ir3.flexitime.server.io.storage.CourseStorage;

/**
 * CourseManager - DOCME Description explication supplémentaire si
 * nécessaire in english please... Que fait cette classe, qu'est-ce qu'elle
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * @author FlexiTeam - Valère
 */
public class CourseManager extends AbstractManager
{

    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
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
        if(data instanceof ICourse) CourseStorage.save((ICourse) data);
        
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
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
        return CourseStorage.get();
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @param data
     * @return
     * @throws RemoteException 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#lock(fr.umlv.ir3.flexitime.common.data.IData)
     * @author   FlexiTeam - Administrateur
     */
    public boolean lock(IData data) throws RemoteException
    {
        // TODO Auto-generated method stub
        return false;
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
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
        if(data instanceof ICourse) CourseStorage.delete((ICourse) data);

        
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @param data
     * @throws RemoteException 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.IDataManager#unlock(fr.umlv.ir3.flexitime.common.data.IData)
     * @author   FlexiTeam - Administrateur
     */
    public void unlock(IData data) throws RemoteException
    {
        // TODO Auto-generated method stub
        
    }

    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
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
        if(data instanceof ICourse) CourseStorage.update((ICourse) data);

        
    }

}