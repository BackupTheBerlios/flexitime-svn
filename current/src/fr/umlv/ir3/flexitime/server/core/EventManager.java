/*
 * Created on 20 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.server.core;

import java.util.concurrent.CopyOnWriteArrayList;

import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.rmi.IDataListener;
import fr.umlv.ir3.flexitime.common.rmi.IRemoteDataListener;

/**
 * Event Manager
 * Client listener register to this class to be notified of changes
 */
public class EventManager
{

    //private final ConcurrentHashMap<Class, List<IDataListener>> map = new ConcurrentHashMap<Class, List<IDataListener>>();
    private final CopyOnWriteArrayList<IRemoteDataListener> listenerlist = new CopyOnWriteArrayList<IRemoteDataListener>(); 

    /**
     * 
     * @param listener
     */
    public void addRemoteDataListener(IRemoteDataListener listener)
    {
        listenerlist.add(listener);
    }

    /**
     * 
     * @param listener
     */
    public void removeDataListener(IDataListener listener)
    {
        listenerlist.remove(listener);
    }

    /**
     * 
     * @param _class
     * @param event
     */
    public void fireDataChanged(DataEvent event)
    {
        ThreadManager t = new ThreadManager(listenerlist, event);
        t.start();

    }

}
