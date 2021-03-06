/*
 * Created on 22 janv. 2005
 * by Pr�sad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.IRemoteDataManager;
import fr.umlv.ir3.flexitime.common.rmi.admin.IConfigurationManager;
import fr.umlv.ir3.flexitime.common.rmi.admin.IUserManager;
import fr.umlv.ir3.flexitime.common.tools.FlexiLanguage;
import fr.umlv.ir3.flexitime.server.core.DataManagerImpl;
import fr.umlv.ir3.flexitime.server.core.admin.ConfigurationManager;
import fr.umlv.ir3.flexitime.server.core.admin.UserManager;

/**
 * Main Class for server
 * 
 * @version 300
 */
public class Server
{

    /**
     * DOCME
     * 
     * @param args
     */
    public static void main(String[] args)
    {
        try
        {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        }
        catch (RemoteException e1)
        {
            System.err.println(FlexiLanguage.getInstance().getText("errRMI1"));
            System.exit(1);
        }

        try
        {
            IConfigurationManager cm = new ConfigurationManager();
            cm.init();
            
            IRemoteDataManager dm = new DataManagerImpl();
            IUserManager um = new UserManager();
            
            Naming.rebind("ConfigManager", cm);
            Naming.rebind("manager", dm);
            Naming.rebind("usermanager", um);
            
            System.out.println("Server running...");
        }
        catch (RemoteException e)
        {
            System.err.println(FlexiLanguage.getInstance().getText("errRMI2"));
            System.exit(2);
        }
        catch (MalformedURLException e)
        {
            System.err.println(FlexiLanguage.getInstance()
                    .getText("errServer1"));
            System.exit(3);
        }
        catch (FlexiException e)
        {
            System.err.println(e.getMessage());
            System.exit(4);
        }
    }
}
