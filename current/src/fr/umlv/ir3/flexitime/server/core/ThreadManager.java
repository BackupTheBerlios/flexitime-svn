/*
 * Created on 13 janv. 2005
 * by Administrateur
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.rmi.IRemoteDataListener;

/**
 * ThreadManager
 * Thread launched to notify clients that an event has occured
 * 
 */
public class ThreadManager extends Thread
{

    private List<IRemoteDataListener> listenerList;
    private DataEvent           event;

    /**
     * DOCME
     * 
     * @param list
     * @param event
     */
    public ThreadManager(List<IRemoteDataListener> list, DataEvent event)
    {
        this.listenerList = list;
        this.event = event;

    }

    /**
     * DOCME Description Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     * 
     * @see java.lang.Runnable#run()
     */
    public void run()
    {
        ArrayList<IRemoteDataListener> toRemove = new ArrayList<IRemoteDataListener>();
            for (IRemoteDataListener element : listenerList)
            {
                
                try
                {
                    element.dataChanged(event);
                }
                catch (RemoteException e)
                {
                    // Listener not reachable
                    // Mark it to be removed
                    toRemove.add(element);
                }
            }

        if (!toRemove.isEmpty())
        {
            listenerList.removeAll(toRemove);
        }
        System.err.println("Exiting thread");
    }
}
