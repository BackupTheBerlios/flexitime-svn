/*
 * Created on 14 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.GL.flexitime.server.core;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.umlv.ir3.GL.flexitime.client.event.MetierEvent;
import fr.umlv.ir3.GL.flexitime.client.listener.TeacherListener;
import fr.umlv.ir3.GL.flexitime.common.ressource.Teacher;
import fr.umlv.ir3.GL.flexitime.server.io.TeacherStorage;

/**
 * @author binou *  * TODO To change the template for this generated type comment go to * Window - Preferences - Java - Code Style - Code Templates
 */

public class TeacherCore extends UnicastRemoteObject implements ITeacherCore
{
	/**
	 * @throws RemoteException
	 */
	public TeacherCore() throws RemoteException
	{
		super();
	}

	/**
	 * 
	 * @uml.property name="io"
	 * @uml.associationEnd multiplicity="(0 1)"
	 */
	private TeacherStorage io = new TeacherStorage();

	private List listenerList = new ArrayList();
	
	
	
	//*********************************************************************************
	
	public List getTeachers() throws RemoteException
	{
		return io.getTeachers();
	}

	/**
	 * @param text1
	 * @param text2
	 * @param text3
	 * @return
	 */
	public Teacher createTeacher(String text1, String text2, String text3) throws RemoteException
	{
		Teacher t = io.createTeacher(text1,text2,text3);
		notifyListener(t,MetierEvent.ADDED);
		return t;
	}


	/**
	 * @param teacher
	 */
	public void deleteTeacher(Teacher teacher) throws RemoteException {
		io.deleteTeacher(teacher);
		notifyListener(teacher,MetierEvent.REMOVED);
	}

	//*****************************************************************************************
	
	public void addMetierListener(TeacherListener l) throws RemoteException
	{
		listenerList.add(l);
	}
	
	/**
	 * @param t
	 * @param added
	 */
	private void notifyListener(Teacher t, int property) throws RemoteException {
		for (Iterator iter = listenerList.iterator(); iter.hasNext();)
		{
			TeacherListener element = (TeacherListener) iter.next();
			element.teacherChanged(new MetierEvent(t, property));
		}
	}
	
	public String toString()
	{
		return io.toString();
	}

}
