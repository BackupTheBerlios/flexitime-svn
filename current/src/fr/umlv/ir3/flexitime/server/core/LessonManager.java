/*
 * Created on 13 janv. 2005
 * by Administrateur
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.List;

import net.sf.hibernate.HibernateException;

import fr.umlv.ir3.flexitime.common.data.IData;
import fr.umlv.ir3.flexitime.common.data.activity.ILesson;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.server.io.storage.LessonStorage;


/**
 * DOCME Description
 * explication suppl�mentaire si n�cessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * repr�sente, ...
 * 
 * @version Verion ou r�vision SVN
 * 
 * @author FlexiTeam - Administrateur
 */
public class LessonManager extends AbstractManager
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
        if(!(data instanceof ILesson)) return false;
        LessonStorage.save((ILesson) data);
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
        return LessonStorage.get();
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
        if(!(data instanceof ILesson)) return false;
        LessonStorage.delete((ILesson) data);
        notifyListener(data,DataEvent.TYPE_REMOVED);
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
        if(!(data instanceof ILesson)) return false;
        LessonStorage.update((ILesson) data);
        notifyListener(data,DataEvent.TYPE_CHANGED);
        return true;
    }

}

