/*
 * Created on 14 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.GL.flexitime.client.model;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.AbstractListModel;


import fr.umlv.ir3.GL.flexitime.common.event.DataEvent;
import fr.umlv.ir3.GL.flexitime.common.ressource.Teacher;
import fr.umlv.ir3.GL.flexitime.common.rmi.IDataManager;
import fr.umlv.ir3.GL.flexitime.common.rmi.ITeacherListener;


/**
 * @author binou *  * TODO To change the template for this generated type comment go to * Window - Preferences - Java - Code Style - Code Templates
 */

public class TeacherListModel extends AbstractListModel {

	
	private class TeacherListener implements ITeacherListener, Serializable{
	
		public void teacherChanged(DataEvent event)
		{
			System.out.println("TeacherListModel:teacherChanged()");
			if(! (event.getObject() instanceof Teacher))
					return;
			switch(event.getType())
			{
				case DataEvent.ADDED :
				{
					System.out.println("Notification d'ajout !");
					System.out.println(metier.toString());
					Teacher t = (Teacher)event.getObject();
					System.out.println("event.getObject() => " + t);
					printList();	
					list.add(t);
					printList();
					fireIntervalAdded(this,0,list.size());
					break;
				}
				case DataEvent.REMOVED :
				{
					System.out.println("Notification de suppression !");
					System.out.println(metier.toString());
					Teacher t = (Teacher)event.getObject();
					System.out.println("event.getObject() => " + t);
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


	/**
	 * 
	 * @uml.property name="metier"
	 * @uml.associationEnd multiplicity="(0 1)"
	 */
	private IDataManager metier;

	private List list;
	
	/**
	 * @param metier
	 */
	public TeacherListModel() {
		super();
		System.out.println("TeacherListModel:TeacherListModel()");
		try {
			this.metier = (IDataManager) Naming.lookup("rmi://127.0.0.1/TeacherManager");
			list = new ArrayList(metier.getDatas());
			
			TeacherListener listen = new TeacherListener();
			//UnicastRemoteObject.exportObject(listen, 0);
			metier.addMetierListener(listen);
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
		//System.out.println("TeacherListModel:getElementAt()");
		return ((Teacher)list.get(i)).getFirstName() + " " + ((Teacher)list.get(i)).getSurName();
	}

	/**
	 * @param text1
	 * @param text2
	 * @param text3
	 */
	public void add(String text1, String text2, String text3) {
		System.out.println("TeacherListModel:add()");
		try {
			Teacher t = metier.create(text1,text2,text3);
			System.out.println("TeacherListModel:add(,,);");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param selectedIndex
	 */
	public void remove(int i) {
		System.out.println("TeacherListModel:remove()");
		try {
			metier.delete((Teacher)list.get(i));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
	private void printList()
	{
		System.out.print("[");
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Teacher element = (Teacher) iter.next();
			System.out.print(";" + element);
		}
		System.out.println("]");
	}

}
