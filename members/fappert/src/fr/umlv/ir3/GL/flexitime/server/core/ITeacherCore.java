/*
 * Created on 15 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.GL.flexitime.server.core;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import fr.umlv.ir3.GL.flexitime.client.listener.TeacherListener;
import fr.umlv.ir3.GL.flexitime.common.ressource.Teacher;

/**
 * @author binou
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface ITeacherCore  extends Remote {

	public List getTeachers() throws RemoteException;

	public Teacher createTeacher(String text1, String text2,String text3) throws RemoteException;

	public void deleteTeacher(Teacher teacher) throws RemoteException;

	public void addMetierListener(TeacherListener l) throws RemoteException;
}