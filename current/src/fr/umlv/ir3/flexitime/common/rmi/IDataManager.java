/*
 * Created on 4 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.Data;


/**
 * Interface for all Data managers
 * extends Remote to be called remotely
 * 
 * @version 1.0
 * @see java.rmi.Remote
 * 
 * @author FlexiTeam - Prâsad
 */
public interface IDataManager extends Remote
{
    /**
     * Adds a Data created by a client
     * Have to save Data and fire the add 
     * 
     * @param d Data to be added
     * @throws RemoteException if not reachable
     * 
     */
    public void add(Data d) throws RemoteException;
    
    /**
     *  
     * get all datas managed by this manager
     * 
     * @return all datas
     * 
     * @throws RemoteException if not reachable 
     * 
     */
    public List get() throws RemoteException; 
    
    /**
     * locks a data 
     * 
     * @param d data to lock
     * 
     * @return true if data can be locked, flase otherwise
     * 
     * @throws RemoteException if not reachable
     * 
     */
    public boolean lock(Data d) throws RemoteException;
    
    /**
     *  
     * removes a data
     * have to delete data from storage and inform clients
     * 
     * @param d Data to remove
     * @throws RemoteException if not reachable 
     * 
     */
    public void remove(Data d) throws RemoteException;
    
    /**
     *  
     * unlocks a data
     *
     * @param d Data to unlock
     * @throws RemoteException if not reachable 
     * 
     */
    public void unlock(Data d) throws RemoteException;
    
    /**
     *  
     * updates a data
     * have to store the object and informs clients
     *
     * @param d Data to be updated
     * @throws RemoteException if not reachable
     * 
     */
    public void update(Data d) throws RemoteException;
    
}

