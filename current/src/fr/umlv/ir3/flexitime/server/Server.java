/*
 * Created on 22 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server;

import java.net.*;
import java.rmi.*;
import java.rmi.registry.*;

import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.IDataManager;
import fr.umlv.ir3.flexitime.common.rmi.admin.*;
import fr.umlv.ir3.flexitime.common.tools.FlexiLanguage;
import fr.umlv.ir3.flexitime.server.core.DataManagerImpl;
import fr.umlv.ir3.flexitime.server.core.admin.*;


/**
 * DOCME 
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
        try {
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        } catch (RemoteException e1) {
            System.err.println(FlexiLanguage.getInstance().getText("errRMI1"));
            System.exit(1);
        }
        
        try {
            IConfigurationManager cm = new ConfigurationManager();
            IDataManager dm = new DataManagerImpl();
            IUserManager um = new UserManager(cm.get());
            
            Naming.rebind("ConfigManager", cm);
            Naming.rebind("manager", dm);
            Naming.rebind("usermanager",um);

            System.out.println("Server running...");
        }
        catch (RemoteException e)
        {
            System.err.println(FlexiLanguage.getInstance().getText("errRMI2"));
            e.printStackTrace();
            System.exit(2);
        }
        catch (MalformedURLException e)
        {
            System.err.println(FlexiLanguage.getInstance().getText("errServer1"));
            System.exit(3);
        }
        catch (FlexiException e)
        {
            System.err.println(e.getMessage());
            System.exit(4);
        }
    }
}

