/*
 * Created on 22 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.rmi;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


/**
 * DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * @see (si nécessaire)
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

