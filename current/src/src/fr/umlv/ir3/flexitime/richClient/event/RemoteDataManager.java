/*
 * Created on 20 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.event;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import fr.umlv.ir3.flexitime.common.rmi.IDataManager;


/**
 * DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * @see (si nécessaire)
 * 
 */
public class RemoteDataManager
{
    private static IDataManager manager;

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
                Registry r = LocateRegistry.getRegistry("localhost");
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

