/*
 * Created on 16 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package twowayRMI;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import twowayRMI.event.ITeacherListener;



/**
 * @author Prâsad
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface IRMIProf extends Remote{

	public List<Professeur> getAllProfs() throws RemoteException;
	
	public void saveProf(Professeur p) throws RemoteException;
	
	public void addMetierListener(ITeacherListener l) throws RemoteException;
}
