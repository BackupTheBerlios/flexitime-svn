/*
 * Created on 13 janv. 2005
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.rmi.admin;

import java.rmi.*;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.admin.IUser;


/**
 * Represents the UserManager of the server
 * 
 * @version 320
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface IUserManager extends Remote
{
    /**
     * DOCME
     * @param name 
     * @param password 
     * @return true or false
     * @throws RemoteException 
     */
    public boolean ConnectToRich(String name, String password) throws RemoteException;
    /**
     * DOCME
     * @param name 
     * @param password 
     * @return true or false
     * @throws RemoteException 
     */
    public boolean ConnectToLight(String name, String password) throws RemoteException;
    /**
     * DOCME
     * @param name 
     * @return user corresponding to the loginName
     * @throws RemoteException 
     */
    public IUser get(String name) throws RemoteException;
    /**
     * DOCME
     * @param user 
     * @throws RemoteException 
     */
    public IUser save(IUser user) throws RemoteException;
    /**
     * DOCME
     * @param user 
     * @throws RemoteException 
     */
    public void removeUser(IUser user) throws RemoteException;
    /**
     * DOCME
     * @param name 
     * @param newPassword 
     * @throws RemoteException 
     */
    public void changeLocalPasswd(String name,String newPassword) throws RemoteException;
    /**
     * DOCME
     * @param login 
     * @return name of the user
     * @throws RemoteException 
     */
    public String getLongName(String login)throws RemoteException;
    
    /**
     *  
     * Method to notify the server that a user wants to disconnect
     *
     * @param user IUser that wants to disconnect
     * @throws RemoteException 
     * 
     */
    public void disconnect(IUser user) throws RemoteException;
    
    /**
     * adds a IUserListener 
     * @param u Iuser assciated to the listener
     * @param l IUserListener ro add
     * @throws RemoteException 
     * 
     */
    public void addUserListener(IUser u, IUserListener l) throws RemoteException;
    
    /**
     * Removes a IUserListener
     * @param u Iuser assciated to the listener 
     * @throws RemoteException 
     * 
     */
    public void removeUserListener(IUser u) throws RemoteException;
    
    public List<IUser> getAllUsers() throws RemoteException;
}


