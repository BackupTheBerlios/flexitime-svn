/*
 * Created on 28 nov. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author Pr�sad
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */


package fr.umlv.ir3.flexitime.server.io.storage;
import net.sf.hibernate.*;
import net.sf.hibernate.cfg.*;

/**
 * DOCME Description
 * explication suppl�mentaire si n�cessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * repr�sente, ...
 * 
 * @version Verion ou r�vision SVN
 * 
 * @author FlexiTeam - Pr�sad
 */
public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		try {
			// Cr�e la SessionFactory
			Configuration cfg = new Configuration();
			//.addFile("video.hbm.xml");
			
		//cfg.setProperty("hibernate.show_sql", "true");
		
		sessionFactory = cfg.configure().buildSessionFactory();
			//sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (HibernateException ex) {
			throw new RuntimeException("Probl�me de configuration : "
					+ ex.getMessage(), ex);
		}
	}

	private static final ThreadLocal session = new ThreadLocal();

	/**
	 *  
	 * Get current Hibernate Session
	 * @return Hibernate Session
	 * @throws HibernateException 
	 * 
	 */
	public static Session currentSession() throws HibernateException {
		Session s = (Session) session.get();
		// Ouvre une nouvelle Session, si ce Thread n'en a aucune
		if (s == null) {
			s = sessionFactory.openSession();
			session.set(s);
		}
		return s;
	}

	/**
	 *  
	 * Closes current Session.
	 * To always do after manipulating data with Hibernate
	 *
	 * @throws HibernateException 
	 * 
	 */
	public static void closeSession() throws HibernateException {
		Session s = (Session) session.get();
		session.set(null);
		if (s != null)
			s.close();
	}
}