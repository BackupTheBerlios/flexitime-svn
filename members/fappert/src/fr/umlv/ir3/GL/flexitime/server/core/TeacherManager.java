/*
 * Created on 14 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.GL.flexitime.server.core;

import java.rmi.RemoteException;
import java.util.List;


import fr.umlv.ir3.GL.flexitime.common.event.DataEvent;
import fr.umlv.ir3.GL.flexitime.common.ressource.Teacher;
import fr.umlv.ir3.GL.flexitime.server.io.TeacherStorage;

/**
 * @author binou *  * TODO To change the template for this generated type comment go to * Window - Preferences - Java - Code Style - Code Templates
 */

public class TeacherManager extends AbstractDataManager
{
	/**
	 * 
	 * @uml.property name="io"
	 * @uml.associationEnd multiplicity="(0 1)"
	 */
	private TeacherStorage io = new TeacherStorage();
	
	/**
	 * @throws RemoteException
	 */
	public TeacherManager() throws RemoteException
	{
		super();
	}


	/* (non-Javadoc)
	 * @see fr.umlv.ir3.GL.flexitime.server.core.AbstractDataManager#create(java.lang.String, java.lang.String, java.lang.String)
	 */
	public Teacher create(String text1, String text2, String text3) throws RemoteException {
		System.out.println("pwettt ou suis je ?");
		Teacher t = io.createTeacher(text1,text2,text3);
		notifyListener(t,DataEvent.ADDED);
		return t;
	}

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.GL.flexitime.server.core.AbstractDataManager#update(fr.umlv.ir3.GL.flexitime.common.ressource.Teacher)
	 */
	public void update(Teacher t) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.GL.flexitime.server.core.AbstractDataManager#delete(fr.umlv.ir3.GL.flexitime.common.ressource.Teacher)
	 */
	public void delete(Teacher t) throws RemoteException {
		io.deleteTeacher(t);
		notifyListener(t,DataEvent.REMOVED);
	}

	/* (non-Javadoc)
	 * @see fr.umlv.ir3.GL.flexitime.server.core.IDataManager#getDatas()
	 */
	public List getDatas() throws RemoteException {
		// TODO Auto-generated method stub
		return io.getTeachers();
	}

	
	public String toString()
	{
		return io.toString();
	}


}
