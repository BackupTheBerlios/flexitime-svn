package fr.umlv.ir3.GL.test.rmiBasic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;


/**
 * @author Ludo
 *
 */
public class HelloWorldServeur
{

	public static void main (String [] args) throws RemoteException, MalformedURLException
	{
		/*if (System.getSecurityManager() == null)
            System.setSecurityManager (new RMISecurityManager ());*/
		
		HelloWorldImpl hello = new HelloWorldImpl ();
      
        Naming.rebind ("hello", hello);
        
        System.out.println ("CONNECTE");
	}
}
