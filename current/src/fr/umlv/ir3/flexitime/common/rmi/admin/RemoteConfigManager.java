/*
* Created on 26 janv. 2005
* by Jérôme GUERS
* Copyright: GPL - UMLV(FR) - 2004/2005
*/
package fr.umlv.ir3.flexitime.common.rmi.admin;

import java.rmi.*;
import java.rmi.registry.*;

/**
* Singleton used for communication with the server<br>
* @deprecated
*/
public class RemoteConfigManager
{
   private static IConfigurationManager manager;
   private static String ipServer;

   /**
    * Sets the adress of Server 
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
   public static IConfigurationManager getManager()
   {
       if(manager == null)
       {
           try
           {
               Registry r = LocateRegistry.getRegistry(ipServer);
               try
               {
                   manager = (IConfigurationManager) r.lookup("ConfigManager");
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

