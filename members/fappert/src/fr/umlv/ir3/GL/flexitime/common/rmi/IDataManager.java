/*
 * Created on 23 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.GL.flexitime.common.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import fr.umlv.ir3.GL.flexitime.common.ressource.Teacher;

/**
 * @author binou
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface IDataManager extends Remote
{
	public List getDatas() throws RemoteException;

	public Teacher create(String text1, String text2,String text3) throws RemoteException;

	public void update(Teacher teacher) throws RemoteException;
	
	public void delete(Teacher teacher) throws RemoteException;

	public void addMetierListener(String string) throws RemoteException;
	
	void lock(Teacher t) throws RemoteException;
	
	void unlock(Teacher t) throws RemoteException;
	

}
