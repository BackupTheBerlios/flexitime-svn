package fr.umlv.ir3.GL.test.rmiVincent;

import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.swing.event.ListDataEvent;

/**
 * Cette interface est la même qu'un ListDataListener mais représente un objet
 * Remote pouvant circuler sur le réseau avec RMI
 */
public interface ListDataListenerRMI extends Remote
{
	public void intervalAdded(ListDataEvent e) throws RemoteException;

	public void intervalRemoved(ListDataEvent e) throws RemoteException;

	public void contentsChanged(ListDataEvent e) throws RemoteException;
}