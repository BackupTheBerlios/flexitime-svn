/*
 * Created on 23 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.GL.flexitime.server.core;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.umlv.ir3.GL.flexitime.common.event.DataEvent;
import fr.umlv.ir3.GL.flexitime.common.ressource.Teacher;
import fr.umlv.ir3.GL.flexitime.common.rmi.IDataManager;
import fr.umlv.ir3.GL.flexitime.common.rmi.ITeacherListener;

/**
 * @author binou
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public abstract class AbstractDataManager extends UnicastRemoteObject implements IDataManager
{
	private ITeacherListener l;
	
	/**
	 * @throws RemoteException
	 */
	protected AbstractDataManager() throws RemoteException {
		super();
	}
	private List listenerList = new ArrayList();
	
	public void addMetierListener(String naming_lookup) throws RemoteException
	{
		
		try {
			l = (ITeacherListener) Naming.lookup(naming_lookup);
			listenerList.add(l);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @param t
	 * @param added
	 */
	protected void notifyListener(Teacher t, int property) throws RemoteException {
		for (Iterator iter = listenerList.iterator(); iter.hasNext();)
		{
			ITeacherListener element = (ITeacherListener) iter.next();
			element.teacherChanged(new DataEvent(t, property));
		}
	}
	
	public void lock(Teacher t)
	{
		System.err.println("lock de : " + t.toString());
	}
	
	public void unlock(Teacher t)
	{
		System.err.println("unlock de : " + t.toString());
	}
	
	abstract public Teacher create(String text1, String text2,String text3) throws RemoteException;
	abstract public void update(Teacher t) throws RemoteException;
	abstract public void delete(Teacher t) throws RemoteException;


}
