package fr.umlv.ir3.GL.test.rmiVincent;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hello extends Remote
{
	public String hello() throws RemoteException;
}
