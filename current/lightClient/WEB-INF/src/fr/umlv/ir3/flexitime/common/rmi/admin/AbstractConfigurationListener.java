/*
 * Created on 31 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.rmi.admin;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


/**
 * Base Implementation of IConfigurationListener 
 */
public abstract class AbstractConfigurationListener extends UnicastRemoteObject
        implements IConfigurationListener
{

    /**
     * DOCME
     * @throws java.rmi.RemoteException
     */
    public AbstractConfigurationListener() throws RemoteException
    {
        super();
    }

}

