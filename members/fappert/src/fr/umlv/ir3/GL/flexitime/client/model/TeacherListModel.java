/*
 * Created on 14 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.GL.flexitime.client.model;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.AbstractListModel;

import fr.umlv.ir3.GL.flexitime.client.event.MetierEvent;
import fr.umlv.ir3.GL.flexitime.client.listener.TeacherListener;
import fr.umlv.ir3.GL.flexitime.common.ressource.Teacher;
import fr.umlv.ir3.GL.flexitime.server.core.ITeacherCore;

/**
 * @author binou *  * TODO To change the template for this generated type comment go to * Window - Preferences - Java - Code Style - Code Templates
 */

public class TeacherListModel extends AbstractListModel implements TeacherListener{

	/**
	 * 
	 * @uml.property name="metier"
	 * @uml.associationEnd multiplicity="(0 1)"
	 */
	private ITeacherCore metier;

	private List list;
	
	/**
	 * @param metier
	 */
	public TeacherListModel() {
		super();
		try {
			this.metier = (ITeacherCore) Naming.lookup("rmi://127.0.0.1/TeacherCore");
			list = new ArrayList(metier.getTeachers());
			metier.addMetierListener(this);
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
	
	public int getSize(){
		return list.size();
	}

	public Object getElementAt(int i) {
		return ((Teacher)list.get(i)).getFirstName() + " " + ((Teacher)list.get(i)).getSurName();
	}

	/**
	 * @param text1
	 * @param text2
	 * @param text3
	 */
	public void add(String text1, String text2, String text3) {
		try {
			Teacher t = metier.createTeacher(text1,text2,text3);
			//fireIntervalAdded(t,list.size()-1,list.size()-1);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param selectedIndex
	 */
	public void remove(int i) {
		try {
			metier.deleteTeacher((Teacher)list.get(i));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void teacherChanged(MetierEvent event)
	{
		if(! (event.getObject() instanceof Teacher))
				return;
		switch(event.getType())
		{
			case MetierEvent.ADDED :
			{
				System.out.println("Notification d'ajout !");
				System.out.println(metier.toString());
				Teacher t = (Teacher)event.getObject();
				list.add(t);
				fireIntervalAdded(this,list.size()-1,list.size()-1);
				break;
			}
			case MetierEvent.REMOVED :
			{
				System.out.println("Notification de suppression !");
				System.out.println(metier.toString());
				Teacher t = (Teacher)event.getObject();
				System.out.println("teacher : " + t.toString());
				int i = 0;
				
				//boucle a la porc ... a changer
				Iterator iter = list.iterator();
				Teacher element = (Teacher) iter.next();
				while(element.compareTo(t) != 0 && iter.hasNext()) {
					element = (Teacher)iter.next();
					System.out.print("["+element.compareTo(t)+"]");
					i++;
				}
				System.out.println("\n("+i+")");
				fireIntervalRemoved(t,i,i);
				list.remove(i);
				break;
			}
		}
	}

}
