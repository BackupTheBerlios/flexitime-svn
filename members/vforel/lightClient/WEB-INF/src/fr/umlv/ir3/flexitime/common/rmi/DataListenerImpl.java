/*
 * Created on 22 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


/**
 * Base implementation of IDataListener
 * 
 * All IDataListener implementation must extends this in order to be exposed via RMI
 * 
 */
public abstract class DataListenerImpl extends UnicastRemoteObject implements IDataListener
{
    /**
     * DOCME
     */
    protected DataListenerImpl() throws RemoteException
    {
        super();
    }
}

