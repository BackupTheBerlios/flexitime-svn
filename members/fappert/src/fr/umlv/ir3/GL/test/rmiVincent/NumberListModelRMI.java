package fr.umlv.ir3.GL.test.rmiVincent;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Cette interface est la même qu'un NumberListModel mais représente un objet
 * Remote pouvant circuler sur le réseau avec RMI
 */
public interface NumberListModelRMI extends Remote
{
	public int getSize() throws RemoteException;

	public Object getElementAt(int nIndex) throws RemoteException;

	public void addListDataListener(ListDataListenerRMI l)
			throws RemoteException;

	public void removeListDataListener(ListDataListenerRMI l)
			throws RemoteException;
}