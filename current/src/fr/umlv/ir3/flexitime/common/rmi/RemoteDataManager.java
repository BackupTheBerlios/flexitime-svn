/*
 * Created on 20 janv. 2005
 * by Pr�sad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



/**
 * Singleton used for communication with the server
 * 
 */
public class RemoteDataManager
{
    private static IDataManager manager;
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
    public static IDataManager getManager()
    {
        if(manager == null)
        {
            try
            {
                Registry r = LocateRegistry.getRegistry(ipServer);
                try
                {
                    manager = (IDataManager) r.lookup("manager");
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

