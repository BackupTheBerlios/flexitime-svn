/*
 * Created on 11 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package list;

import java.rmi.Remote;
import java.rmi.RemoteException;

import javax.jms.Topic;
import javax.swing.event.ListDataListener;

/**
 * @author Prâsad
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface RMIList extends Remote {
	public MyListModel getModel() throws RemoteException;
	public void incr() throws RemoteException;
	public void addListDataListener(ListDataListener l) throws RemoteException;
	public Topic getTopic() throws RemoteException;
}
