/*
 * Created on 14 janv. 2005
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.rmi.admin;

import java.rmi.Remote;
import java.rmi.RemoteException;

import fr.umlv.ir3.flexitime.common.data.admin.IConfig;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;


/**
 * Represents the configuration of the server application 
 * 
 * @version 320
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public interface IConfigurationManager extends Remote
{
    /**
     * Load the configuration if it is the first time the configuration is
     * loaded or return th current config. <br>
     * The default file name used to load the configuration is
     * <code>flexiConfig.xml</code>. If the property
     * <code>fr.umlv.ir3.flexitime.configfile</code> is set, this value is
     * considered.
     * 
     * @return current configuration
     * @throws RemoteException 
     * @throws FlexiException 
     */
    public IConfig get() throws RemoteException, FlexiException;
    
    /**
     * DOCME
     * 
     * @param config 
     * @return if the configuration was well saved
     * @throws RemoteException 
     * @throws FlexiException 
     */
    public boolean save(IConfig config) throws RemoteException, FlexiException;

    /** 
     * DOCME
     * @throws FlexiException 
     * @throws RemoteException 
     */
    public void init() throws FlexiException, RemoteException;
    
    /**
     * Adds a ConfigurationListener 
     *
     * @param listener IConfigurationListener to add
     * @throws RemoteException 
     * 
     */
    public void addConfigurationListener(IConfigurationListener listener) throws RemoteException;
    
    /**
     * Removes a ConfigurationListener 
     *
     * @param listener IConfigurationListener to remove
     * @throws RemoteException 
     * 
     */
    public void removeConfigurationListener(IConfigurationListener listener) throws RemoteException;
}

