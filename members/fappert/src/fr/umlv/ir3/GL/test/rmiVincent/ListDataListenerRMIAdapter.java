package fr.umlv.ir3.GL.test.rmiVincent;

import java.rmi.RemoteException;

import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 * Cette classe est une surcouche à un ListDataListener afin de rendre cette
 * classe disponible sur le réseau pour passer les appels au ListDataListener
 * encapsulé.
 */
public class ListDataListenerRMIAdapter implements ListDataListenerRMI
{
	public void intervalAdded(ListDataEvent e) throws RemoteException
	{
		m_listener.intervalAdded(e);
	}

	public void intervalRemoved(ListDataEvent e) throws RemoteException
	{
		m_listener.intervalRemoved(e);
	}

	public void contentsChanged(ListDataEvent e) throws RemoteException
	{
		m_listener.contentsChanged(e);
	}

	public ListDataListenerRMIAdapter(ListDataListener l)
	{
		m_listener = l;
	}

	ListDataListener m_listener;
}