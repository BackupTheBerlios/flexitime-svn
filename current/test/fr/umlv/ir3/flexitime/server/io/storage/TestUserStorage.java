/*
 * Created on 30 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.io.storage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import net.sf.hibernate.HibernateException;
import fr.umlv.ir3.flexitime.common.data.DataFactory;
import fr.umlv.ir3.flexitime.common.data.admin.IUser;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;


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
        if(RemoteDataManager.getManager() == null)
        {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Entrez l'adresse du serveur");
            String ip;
            try {
                ip = in.readLine();
                RemoteDataManager.setIpServer(ip);
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
        DataFactory.createUser("a", "a");
        DataFactory.createUser("q", "q");
        DataFactory.createUser("w", "w");
        DataFactory.createUser("d", "d");
        DataFactory.createUser("fappert", IUser.ADMIN);
        DataFactory.createUser("valre", "popopopo");
        DataFactory.createUser("flexitime", "flexitim");
        
            
//        Session s = HibernateUtil.currentSession();
//        List<IRoom> lr = s.find("FROM RoomImpl");
//        
//        for(IRoom r : lr)
//        {
//            System.out.println(r.getFloor());
//        }
//        
//        IGroup g = RemoteDataManager.getManager().getGroup();
//        
//        System.out.println(g.getName());
        
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

