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

import fr.umlv.ir3.flexitime.common.rmi.IDataManager;
import fr.umlv.ir3.flexitime.server.core.DataManagerImpl;


/**
 * DOCME Description
 * explication suppl�mentaire si n�cessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * repr�sente, ...
 * 
 * @version Verion ou r�vision SVN
 * @see (si n�cessaire)
 * 
 */
public class Server
{

    /**
     * DOCME
     */
    public Server()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) throws RemoteException
    {
        Registry r = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        
        IDataManager m = new DataManagerImpl();
        
        try
        {
            Naming.rebind("manager", m);
        }
        catch (RemoteException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (MalformedURLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        System.out.println("Server running...");
        
    }
}

