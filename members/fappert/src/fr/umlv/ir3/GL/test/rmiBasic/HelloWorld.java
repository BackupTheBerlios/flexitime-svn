package fr.umlv.ir3.GL.test.rmiBasic;

import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 * @author Ludo
 *
 */
public interface HelloWorld extends Remote
{
	/**
	 * 
	 */
	public String hello () throws RemoteException;

}
