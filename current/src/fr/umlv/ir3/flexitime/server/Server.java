/*
 * Created on 22 janv. 2005
 * by Pr�sad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import fr.umlv.ir3.flexitime.common.data.admin.IConfig;
import fr.umlv.ir3.flexitime.common.data.admin.impl.ConfigImpl;
import fr.umlv.ir3.flexitime.common.rmi.IDataManager;
import fr.umlv.ir3.flexitime.common.rmi.admin.IUserManager;
import fr.umlv.ir3.flexitime.server.core.DataManagerImpl;
import fr.umlv.ir3.flexitime.server.core.admin.ConfigurationManager;
import fr.umlv.ir3.flexitime.server.core.admin.UserManager;


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
        IConfig ic = null;
        try
        {
            ic = new ConfigurationManager().get();
            //ic.setUriServerLDAP("ldapetud.univ-mlv.fr");
            //ic.setPathGroupLDAP("ou=Groups,ou=Etudiant,dc=univ-mlv,dc=fr");
            //ic.setPathUserLDAP("ou=Users,ou=Etudiant,dc=univ-mlv,dc=fr");
            
        }
        catch (SAXException e1)
        {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        catch (ParserConfigurationException e1)
        {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        catch (IOException e1)
        {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        
        IUserManager u = new UserManager(ic);
        
        try
        {
            Naming.rebind("manager", m);
            Naming.rebind("usermanager",u);
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

