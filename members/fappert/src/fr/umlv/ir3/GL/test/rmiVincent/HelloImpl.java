package fr.umlv.ir3.GL.test.rmiVincent;

import java.rmi.RemoteException;

public class HelloImpl implements Hello
{
	protected HelloImpl() throws RemoteException
	{
		super();
	}

	public String hello() throws RemoteException
	{
		return "Hello world !";
	}
}
