/*
 * Created on 30 nov. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package Test;

import java.util.Iterator;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import tools.HibernateUtil;
import bat.Batiment;
import bat.Etage;
import bat.Salle;

/**
 * @author Prâsad
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
public class Main {

	public static void main(String[] args) throws HibernateException {
		Session s = HibernateUtil.currentSession();

		Transaction tx = s.beginTransaction();

		//Batiment Copernic = (Batiment) s.load(Batiment.class, new Long(1));
		Iterator itBat = s.iterate("from Batiment");
		while (itBat.hasNext()) {
			Batiment bat = (Batiment) itBat.next();
			System.out.println(bat.getNomBat());
			Iterator etageIt = bat.getEtages().iterator();
			while (etageIt.hasNext()) {
				Etage e = (Etage) etageIt.next();
				System.out.println("\t" + e.getNomEtage());

				Iterator salleIt = e.getSalles().iterator();
				while (salleIt.hasNext()) {
					Salle salle = (Salle) salleIt.next();
					System.out
							.println("\t\t" + salle.getNomSalle() + "\t"
									+ salle.getTypeSalle() + "\t"
									+ salle.getNbplaces());
				}
			}
		}
		tx.commit();

		HibernateUtil.closeSession();

	}
}