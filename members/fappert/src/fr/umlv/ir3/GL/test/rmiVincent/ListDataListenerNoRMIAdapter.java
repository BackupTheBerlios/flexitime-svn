package fr.umlv.ir3.GL.test.rmiVincent;

import java.rmi.RemoteException;

import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

/**
 * Cette classe est une surcouche à ListDataListenerRMI afin de permettre
 * d'utiliser cette classe avec une vue Swing. Sa responsabilité est de passer
 * les appels de la vue à l'objet RMI et de gérer les erreurs réseaux pouvant
 * survenir.
 */
public class ListDataListenerNoRMIAdapter implements ListDataListener
{
	public void intervalAdded(ListDataEvent e)
	{
		try
		{
			m_listener.intervalAdded(e);
		}
		catch( RemoteException e1 )
		{
			// Le listener ne fonctionne plus, on le retire
			ListModel model = (ListModel) e.getSource();
			model.removeListDataListener(this);
		}
	}

	public void intervalRemoved(ListDataEvent e)
	{
		try
		{
			m_listener.intervalRemoved(e);
		}
		catch( RemoteException e1 )
		{
			// Le listener ne fonctionne plus, on le retire
			ListModel model = (ListModel) e.getSource();
			model.removeListDataListener(this);
		}
	}

	public void contentsChanged(ListDataEvent e)
	{
		try
		{
			m_listener.contentsChanged(e);
		}
		catch( RemoteException e1 )
		{
			// Le listener ne fonctionne plus, on le retire
			ListModel model = (ListModel) e.getSource();
			model.removeListDataListener(this);
		}
	}

	public ListDataListenerNoRMIAdapter(ListDataListenerRMI l)
	{
		m_listener = l;
	}

	ListDataListenerRMI m_listener;
}