/*
 * Created on 26 déc. 2004
 * by Valère
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import fr.umlv.ir3.flexitime.common.data.IData;
import fr.umlv.ir3.flexitime.common.rmi.IDataListener;
import fr.umlv.ir3.flexitime.common.rmi.IDataManager;

/**
 * AbstractManager - abstract clas for all the managers
 * 
 * @version 0.1
 * @author FlexiTeam - Valère
 */
public abstract class AbstractManager implements IDataManager
{

    /**
     * list of IDataListener
     */
    private List listenerList = new ArrayList();
    private final Lock lock = new ReentrantLock();

    /**
     *  
     * adds a listener to the list
     * 
     * @param l listener to be added
     * @throws RemoteException if not reachable
     * 
     */
    public void addDataListener(IDataListener l) throws RemoteException
    {
        listenerList.add(l);
    }

    /**
     * Notifies all listeners that an event has occured
     * @param d Data on which event has occured
     * @param property type of the event 
     */
    protected void notifyListener(IData data, int property)
    {
        ThreadManager t = new ThreadManager(listenerList,data,property);
        t.start();
    }
    
    /**
     *  
     * removes a listener from the list
     *
     * @param l IDataListener to be removed
     * @throws RemoteException if not reachable
     * 
     */
    public void removeDataListener(IDataListener l) throws RemoteException
    {
        // FIXME Vérifier les références pour la suppression
        listenerList.remove(l);
    }
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @return
     * @throws InterruptedException
     * @throws InterruptedException
     * 
     * @author   FlexiTeam - Administrateur
     */
    public synchronized boolean lock() throws InterruptedException
    {
        if(lock.tryLock(10,TimeUnit.SECONDS)) return true;
        //if(lock.tryLock()) return true;
        return false;
    }
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * 
     * @author   FlexiTeam - Administrateur
     */
    public void unlock()
    {
        lock.unlock();       
    }
    
}