package fr.umlv.ir3.GL.test.rmiVincent;

import java.rmi.RemoteException;

/**
 * Cette classe est une surcouche à un NumberListModel afin de rendre cette
 * classe disponible sur le réseau pour passer les appels au NumberListModel
 * encapsulé.
 */
public class NumberListModelRMIAdapter implements NumberListModelRMI
{
	public int getSize() throws RemoteException
	{
		return m_model.getSize();	
	}

	public Object getElementAt(int nIndex) throws RemoteException
	{
		return m_model.getElementAt(nIndex);	
	}

	public void addListDataListener(ListDataListenerRMI l)
			throws RemoteException
	{
		m_model.addListDataListener(new ListDataListenerNoRMIAdapter(l));
	}

	public void removeListDataListener(ListDataListenerRMI l)
			throws RemoteException
	{
		m_model.removeListDataListener(new ListDataListenerNoRMIAdapter(l));
	}
	
	public NumberListModelRMIAdapter(NumberListModel model)
	{
		m_model = model;
	}
	
	NumberListModel m_model;
}