package fr.umlv.ir3.GL.test.rmiBasic;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


/**
 * @author Ludo
 *
 */
public class HelloWorldImpl extends UnicastRemoteObject implements HelloWorld
{
	/**
	 * @throws RemoteException
	 */
	protected HelloWorldImpl () throws RemoteException
	{
	}

	/* (non-Javadoc)
	 * @see HelloWorld#hello()
	 */
	public String hello () throws RemoteException
	{
		return "COUCOU";
	}

}
