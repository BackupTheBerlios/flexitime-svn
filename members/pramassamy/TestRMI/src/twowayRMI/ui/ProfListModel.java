/*
 * Created on 15 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package twowayRMI.ui;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.AbstractListModel;


import twowayRMI.IRMIProf;
import twowayRMI.Professeur;
import twowayRMI.event.MetierEvent;
import twowayRMI.event.ITeacherListener;

/**
 * @author Prâsad
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class ProfListModel extends AbstractListModel{

	private List<Professeur> profs;
	
	private class TeacherListener implements ITeacherListener, Serializable{

		/*
		 * (non-Javadoc)
		 * 
		 * @see twowayRMI.event.ITeacherListener#teacherChanged(twowayRMI.event.MetierEvent)
		 */
		public void teacherChanged(MetierEvent event) throws RemoteException {
			if(! (event.getObject() instanceof Professeur))
				return;
		switch(event.getType())
		{
			case MetierEvent.ADDED :
			{
				System.out.println("Notification d'ajout !");
				//System.out.println(metier.toString());
				Professeur t = (Professeur)event.getObject();
				profs.add(t);
				fireIntervalAdded(this,profs.size()-1,profs.size()-1);
				break;
			}
			case MetierEvent.REMOVED :
			{
				System.out.println("Notification de suppression !");
				//System.out.println(metier.toString());
				Professeur t = (Professeur)event.getObject();
				System.out.println("Professeur : " + t.toString());
				int i = 0;
				
				//boucle a la porc ... a changer
				/*
				 * Iterator iter = list.iterator(); Professeur element =
				 * (Professeur) iter.next(); while(element.compareTo(t) != 0 &&
				 * iter.hasNext()) { element = (Professeur)iter.next();
				 * System.out.print("["+element.compareTo(t)+"]"); i++; }
				 * System.out.println("\n("+i+")"); fireIntervalRemoved(t,i,i);
				 * list.remove(i);
				 */
				break;
			}
			case MetierEvent.CHANGED:
				System.out.println("Notification de changement ! ");
				Professeur p = (Professeur)event.getObject();
				System.out.println(p);
				int index = getIndexOfThisProf(p);
				System.out.println(index);
				if(index==-1)
					return;
				System.out.println(index);
				profs.set(index, p);
				fireContentsChanged(this, index, index);
				break;
		}
			
		}
		
	}
	
	private int getIndexOfThisProf(Professeur p)
	{
		Long id = p.getIdProf();
		Iterator it = profs.iterator();
		System.out.println("id to find: " + id);
		int index=0;
		while(it.hasNext()){
			Professeur tmp = (Professeur)it.next();
			System.out.println(tmp.getIdProf());
			if(tmp.getIdProf().equals(id))
				return index;
			index++;
		}
		
		return -1;
	}
	
	public ProfListModel(IRMIProf p){
		try {
			profs = new ArrayList<Professeur>(p.getAllProfs());
			TeacherListener listen = new TeacherListener();
			UnicastRemoteObject.exportObject(listen, 0);
			p.addMetierListener(listen);
		} catch (RemoteException e) {
			profs = new ArrayList<Professeur>();
			e.printStackTrace();
		}
	}
	
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.ListModel#getSize()
	 */
	public int getSize() {
		return profs.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.ListModel#getElementAt(int)
	 */
	public Object getElementAt(int index) {
		return profs.get(index).getNom();
	}
	
	public Professeur getAt(int index){
		return profs.get(index);
	}

}
