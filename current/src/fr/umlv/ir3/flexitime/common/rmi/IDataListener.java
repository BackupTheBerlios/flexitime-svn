/*
 * Created on 27 déc. 2004
 * by Valère
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import fr.umlv.ir3.flexitime.common.event.DataEvent;

/**
 * Interface that all distant listeners have to implement
 * Extends Remote in order to be called remotely.
 * 
 * @version 1.0
 * @author FlexiTeam - Valère
 */
public interface IDataListener extends Remote
{

    /**
     *  
     * Called when a data has changed 
     * @param event Data that has changed
     * @throws RemoteException when method is not reachable through RMI
     * 
     */
    public void dataChanged(DataEvent event) throws RemoteException;
}