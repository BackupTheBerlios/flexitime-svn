/*
 * Created on 20 janv. 2005
 * by Pr�sad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import fr.umlv.ir3.flexitime.common.rmi.admin.IConfigurationManager;
import fr.umlv.ir3.flexitime.common.rmi.admin.IUserManager;

/**
 * Singleton used for communication with the server
 */
public class RemoteDataManager
{

    private static IDataManager          manager;
    private static IUserManager          userManager;
    private static String                ipServer = "192.168.0.2";
    private static IConfigurationManager cfgManager;
    private static Registry              r;

    /**
     * Sets the adress of Server
     * 
     * @param ip IP or name of the server
     */
    public static void setIpServer(String ip)
    {
        ipServer = ip;
    }

    /**
     * Getter for the remote IDataManager
     * 
     * @return IDataManager
     */
    public static IDataManager getManager()
    {
        if (manager == null)
        {
            try
            {
                manager = (IDataManager) getRegistry().lookup("manager");

            }
            catch (NotBoundException e1)
            {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            catch (RemoteException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return manager;
    }

    public static IUserManager getUserManager()
    {
        if (userManager == null)
        {
            try
            {
                userManager = (IUserManager) getRegistry()
                        .lookup("usermanager");
            }
            catch (NotBoundException e1)
            {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            catch (RemoteException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return userManager;
    }

    public static IConfigurationManager getConfigurationManager()
    {
        if (cfgManager == null)
        {
            try
            {
                cfgManager = (IConfigurationManager) getRegistry().lookup(
                        "ConfigManager");
            }
            catch (NotBoundException e1)
            {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            catch (RemoteException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return cfgManager;
    }

    private static Registry getRegistry() throws RemoteException
    {
        if (r == null) r = LocateRegistry.getRegistry(ipServer);

        return r;
    }
}
