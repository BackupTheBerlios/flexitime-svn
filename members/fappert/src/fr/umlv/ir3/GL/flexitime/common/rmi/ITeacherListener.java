/*
 * Created on 26 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.GL.flexitime.common.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import fr.umlv.ir3.GL.flexitime.common.event.DataEvent;





/**
 * @author binou
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface ITeacherListener  extends Remote
{
	public void teacherChanged(DataEvent event) throws RemoteException;
}
