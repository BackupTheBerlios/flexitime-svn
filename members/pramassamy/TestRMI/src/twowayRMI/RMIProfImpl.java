/*
 * Created on 16 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package twowayRMI;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import tools.HibernateUtil;
import twowayRMI.event.MetierEvent;
import twowayRMI.event.ITeacherListener;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;

/**
 * @author Prâsad
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class RMIProfImpl implements IRMIProf{

	
	private HashMap<Long, Professeur> profs;
	private List<ITeacherListener> listenerList = new ArrayList<ITeacherListener>();
	
	public RMIProfImpl(){
		profs = new HashMap<Long, Professeur>();
		try {
			Session s = HibernateUtil.currentSession();
			Iterator itProf = s.iterate("from Professeur");
			
			while(itProf.hasNext())
			{
				Professeur p = (Professeur) itProf.next();
				System.out.println(p.getNom());
				profs.put(p.getIdProf(), p);
			}
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see twowayRMI.IRMIProf#getAllProfs()
	 */
	public List<Professeur> getAllProfs() throws RemoteException {
		return Arrays.asList(profs.values().toArray(new Professeur[profs.size()]));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see twowayRMI.IRMIProf#saveProf(twowayRMI.Professeur)
	 */
	public void saveProf(Professeur p) throws RemoteException {
		System.out.println(p);
		
		System.out.println(p.getNom());
		try {
			Session s = HibernateUtil.currentSession();
			s.saveOrUpdate(p);
			s.flush();
			HibernateUtil.closeSession();
			System.out.println(p.getIdProf());
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!profs.containsKey(p.getIdProf())){
			notifyListener(p,MetierEvent.ADDED);
		}
		else
		{
			notifyListener(p,MetierEvent.CHANGED);
		}
		profs.put(p.getIdProf(), p);
	
	}
	/* (non-Javadoc)
	 * @see twowayRMI.IRMIProf#addMetierListener(twowayRMI.event.TeacherListener)
	 */
	public void addMetierListener(ITeacherListener l) throws RemoteException {
		listenerList.add(l);
		
	}
	
	/**
	 * @param t
	 * @param added
	 */
	private void notifyListener(Professeur t, int property) throws RemoteException {
		ArrayList<ITeacherListener> toRemove = new ArrayList<ITeacherListener>();
		for (Iterator<ITeacherListener> iter = listenerList.iterator(); iter.hasNext();)
		{
			ITeacherListener element =  iter.next();
			try
			{
				element.teacherChanged(new MetierEvent(t, property));
			}
			catch(RemoteException e){
				System.err.println("Plus de listener");
				toRemove.add(element);
			}
		}
		if(toRemove.size()!=0)
			listenerList.removeAll(toRemove);
	}

}
