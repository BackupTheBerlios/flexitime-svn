/*
 * Created on 6 févr. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import fr.umlv.ir3.flexitime.common.event.DataEvent;


/**
 * Remote Data Listener
 * 
 * 
 */
public interface IRemoteDataListener extends Remote
{
    /**
     *  
     * Called when a data has changed 
     * @param event Data that has changed
     * 
     */
    public void dataChanged(DataEvent event) throws RemoteException;
}

