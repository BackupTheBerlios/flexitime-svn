/*
 * Created on 13 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.server.io.storage;

import java.util.List;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.general.ITrack;

/**
 * Class that has the responsibility to persist IClass in database
 * 
 * @version 0.1
 * 
 * 
 * @author FlexiTeam - Prâsad
 */
public class ClassStorage
{

    /**
     * Saves a class in database
     * 
     * @param c
     *            IClass to save
     * @throws HibernateException
     */
    public static void save(IClass c) throws HibernateException
    {
        if (c.getIdData() != null)
        {
            update(c);
        }
        else
        {
            Session s = null;
            Transaction tx = null;
            try
            {
                s = HibernateUtil.currentSession();
                tx = s.beginTransaction();
                s.save(c);
                tx.commit();
            }
            catch (HibernateException e)
            {
                e.printStackTrace();
                if (tx != null) tx.rollback();
                throw e;
            }
            finally
            {
                HibernateUtil.closeSession();
            }
        }
    }

    /**
     * 
     * Method to get all the classes
     * 
     * @param parent
     * 
     * @return List of IClass
     * @throws HibernateException
     * 
     */
    public static List<IClass> get(ITrack parent) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        List<IClass> l = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            l = s.find("FROM ClassImpl as c WHERE c.parentTrack = ?",
                    parent.getIdData(), Hibernate.LONG);
            tx.commit();
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
            if (tx != null) tx.rollback();
            throw e;
        }
        finally
        {
            HibernateUtil.closeSession();
        }

        return l;
    }

    /**
     * 
     * Updates a class in database
     * 
     * @param c
     *            IClass to update
     * @throws HibernateException
     * 
     */
    public static void update(IClass c) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            s.update(c);
            tx.commit();
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
            if (tx != null) tx.rollback();
            throw e;
        }
        finally
        {
            HibernateUtil.closeSession();
        }
    }

    /**
     * 
     * Deletes a class from the database
     * 
     * @param c
     *            IClass to delete
     * @throws HibernateException
     * 
     */
    public static void delete(IClass c) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            s.delete(c);
            tx.commit();
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
            if (tx != null) tx.rollback();
            throw e;
        }
        finally
        {
            HibernateUtil.closeSession();
        }
    }
}
