/*
 * Created on 28 nov. 2004
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.server.io.storage;

import fr.umlv.ir3.flexitime.common.data.admin.IConfig;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.tools.FlexiLanguage;
import net.sf.hibernate.*;
import net.sf.hibernate.cfg.*;

/**
 * Singleton of SessionFactory to get and close an Hibernate Session
 * 
 * @version 300
 * 
 * @author FlexiTeam - Prâsad
 */
public class HibernateUtil
{

    private static SessionFactory    sessionFactory;

    private static final ThreadLocal session = new ThreadLocal();

    /**
     * Set the URI of the database, the database name and the user and password
     * to connect to the database from the configuration
     * 
     * @param config
     *            database configuration to set
     * @throws FlexiException
     */
    public static void setConfiguration(IConfig config) throws FlexiException
    {
        Configuration cfg = null;
        try {
            cfg = new Configuration().configure();
            
            StringBuffer buffer = new StringBuffer();
            buffer.append(config.getUriServerData() + "/");
            buffer.append(config.getNameBase());
            
            cfg.setProperty("hibernate.connection.url", buffer.toString());
            cfg.setProperty("hibernate.connection.username", config.getUserBDD());
            cfg.setProperty("hibernate.connection.password", config.getPassBDD());

            sessionFactory = cfg.buildSessionFactory();
        } catch (HibernateException e) {
            throw new FlexiException(FlexiLanguage.getInstance().getText(
            "errHiber1")
            + e.getMessage(), e);
        }
    }

    /**
     * 
     * Get current Hibernate Session
     * 
     * @return Hibernate Session
     * @throws HibernateException
     * 
     */
    public static Session currentSession() throws HibernateException
    {
        Session s = (Session) session.get();
        // Ouvre une nouvelle Session, si ce Thread n'en a aucune
        if (s == null)
        {
            s = sessionFactory.openSession();
            session.set(s);
        }
        return s;
    }

    /**
     * 
     * Closes current Session. To always do after manipulating data with
     * Hibernate
     * 
     * @throws HibernateException
     * 
     */
    public static void closeSession() throws HibernateException
    {
        Session s = (Session) session.get();
        session.set(null);
        if (s != null) s.close();
    }
}
