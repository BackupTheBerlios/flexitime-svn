/*
 * Created on 26 déc. 2004
 * by Valère
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.IData;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
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
    protected void notifyListener(IData d, int property)
    {
        ArrayList toRemove = new ArrayList();
        for (Iterator iter = listenerList.iterator() ; iter.hasNext() ;)
        {
            IDataListener element = (IDataListener) iter.next();
            try
            {
                element.dataChanged(new DataEvent(d, property));
            }
            catch (RemoteException e)
            {
                //Listener not reachable
                //Mark it to be removed
                toRemove.add(element);
            }
        }
        
        if(!toRemove.isEmpty()){
            listenerList.removeAll(toRemove);
        }
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

}