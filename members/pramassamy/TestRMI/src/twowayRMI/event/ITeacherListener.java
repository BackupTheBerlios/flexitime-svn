/*
 * Created on 14 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package twowayRMI.event;

import java.rmi.Remote;
import java.rmi.RemoteException;



/**
 * @author binou
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface ITeacherListener extends Remote 
{
	void teacherChanged(MetierEvent event) throws RemoteException; 
}
