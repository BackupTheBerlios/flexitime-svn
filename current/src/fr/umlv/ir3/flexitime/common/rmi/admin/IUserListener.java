/*
 * Created on 13 déc. 2004
 * by Valère FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.rmi.admin;

import java.rmi.Remote;
import java.rmi.RemoteException;

import fr.umlv.ir3.flexitime.common.data.admin.IUser;

/**
 * Base Interface for all User Listener
 * 
 * @version 0.1
 * @author FlexiTeam - Valère FOREL
 */
public interface IUserListener extends Remote
{

    /**
     * Listener used to poll a client in order to have his IUser
     * 
     * @return IUser connected to the client
     * @throws RemoteException 
     */
    public IUser getUser() throws RemoteException;

}