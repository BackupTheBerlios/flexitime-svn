/*
 * Created on 30 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.io.storage;

import java.rmi.RemoteException;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import fr.umlv.ir3.flexitime.common.data.DataFactory;
import fr.umlv.ir3.flexitime.common.data.admin.IUser;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;
import fr.umlv.ir3.flexitime.server.io.storage.admin.UserStorage;


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
public class TestUserStorage
{

    public static void main(String[] args) throws HibernateException, RemoteException, FlexiException
    {
        IUser u = DataFactory.createUser("a", "a");
        DataFactory.createUser("b", "b");
        DataFactory.createUser("c", "c");
        DataFactory.createUser("d", "d");
        DataFactory.createUser("fappert", "popopopo");
        DataFactory.createUser("valre", "popopopo");
        DataFactory.createUser("flexitime", "flexitim");
        
        //RemoteDataManager.getUserManager().save(u);
        
        //IUser u2 = RemoteDataManager.getUserManager().get("prasad");
        
        //System.out.println(u2.getName());
        
        //RemoteDataManager.getUserManager().removeUser(u2);
        //UserStorage.delete(u2);
        
    }
    
    public static void createUser(String name, String pass) throws FlexiException
    {
        IUser u = DataFactory.createUser(name, pass);
    }
}

