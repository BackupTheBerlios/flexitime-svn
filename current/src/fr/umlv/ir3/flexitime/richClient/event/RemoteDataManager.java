/*
 * Created on 20 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.richClient.event;

import fr.umlv.ir3.flexitime.common.rmi.IDataManager;
import fr.umlv.ir3.flexitime.server.core.DataManagerImpl;


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
    private static IDataManager manager = new DataManagerImpl();

    /**
     *  
     * Getter for the remote IDataManager
     *
     * @return IDataManager
     * 
     */
    public static IDataManager getManager()
    {
        return manager;
    }
}

