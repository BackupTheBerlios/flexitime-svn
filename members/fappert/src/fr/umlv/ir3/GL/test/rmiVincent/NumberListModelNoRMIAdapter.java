package fr.umlv.ir3.GL.test.rmiVincent;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import javax.swing.AbstractListModel;
import javax.swing.event.ListDataListener;

/**
 * Cette classe est une surcouche à NumberListModelRMI afin de permettre
 * d'utiliser cette classe avec une vue Swing. Sa responsabilité est de passer
 * les appels de la vue à l'objet RMI et de gérer les erreurs réseaux pouvant
 * survenir.
 */
public class NumberListModelNoRMIAdapter extends AbstractListModel
{
	public int getSize()
	{
		try
		{
			return m_model.getSize();
		}
		catch( RemoteException e )
		{
			return 0;
		}
	}

	public Object getElementAt(int index)
	{
		try
		{
			return m_model.getElementAt(index);
		}
		catch( RemoteException e )
		{
			return null;
		}
	}

	public void addListDataListener(ListDataListener l)
	{
		try
		{
			ListDataListenerRMI listener = new ListDataListenerRMIAdapter(l);
			UnicastRemoteObject.exportObject(listener, 0);
			m_model.addListDataListener(listener);
		}
		catch( RemoteException e )
		{
			e.printStackTrace();
		}
	}

	public void removeListDataListener(ListDataListener l)
	{
		try
		{
			ListDataListenerRMI listener = new ListDataListenerRMIAdapter(l);
			UnicastRemoteObject.exportObject(listener, 0);
			m_model.removeListDataListener(listener);
		}
		catch( RemoteException e )
		{
			e.printStackTrace();
		}
	}

	public NumberListModelNoRMIAdapter(NumberListModelRMI model)
	{
		m_model = model;
	}

	NumberListModelRMI m_model;
}