/*
 * Created on 31 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.rmi.admin;

import java.rmi.Remote;
import java.rmi.RemoteException;

import fr.umlv.ir3.flexitime.common.event.ConfigEvent;


/**
 * Base Interface for all Configuration Listener
 * 
 */
public interface IConfigurationListener extends Remote
{
    /**
     *
     * Notifies that configuration has changed
     * @param event 
     * @throws RemoteException 
     * 
     */
    public void ConfigurationChanged(ConfigEvent event) throws RemoteException;

}

