/*
 * Created on 20 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.rmi.admin;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



/**
 * Singleton used for communication with the server
 * @deprecated
 */
public class RemoteUserManager
{
    private static IUserManager manager;
    private static String ipServer = "localhost";

    /**
     * Sets the adress of Server 
     * @param ip IP or name of the server
     */
    public static void setIpServer(String ip)
    {
     ipServer = ip;   
    }
    
    /**
     *  
     * Getter for the remote IDataManager
     *
     * @return IDataManager
     * 
     */
    public static IUserManager getManager()
    {
        if(manager == null)
        {
            try
            {
                Registry r = LocateRegistry.getRegistry(ipServer);
                try
                {
                    manager = (IUserManager) r.lookup("usermanager");
                }
                catch (NotBoundException e1)
                {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
            catch (RemoteException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return manager;
    }
}

