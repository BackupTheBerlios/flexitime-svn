/*
 * Created on 13 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.io.storage;



import java.util.List;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.LockMode;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.resources.IGroup;


/**
 *  * Class that has the responsibility to persist IGroup in database
 * 
 * @version 0.1

 * 
 * @author FlexiTeam - Prâsad
 */
public class GroupStorage
{
    /**
     *  Saves a group in database
     * 
     * @param group IGroup to save 
     * @throws HibernateException 
     */
    public static void save(IGroup group) throws HibernateException
    {
        if (group.getIdData() != null)
        {
            update(group);
        }
        else
        {
            Session s = null;
            Transaction tx = null;
            try
            {
                s = HibernateUtil.currentSession();
                tx = s.beginTransaction();
                s.save(group);
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
     * Method to get all the groups
     * @param parent 
     * @return List of IGroup
     * @throws HibernateException 
     * 
     */
    public static List<IGroup> get(IClass parent) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        List<IGroup> l = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            l = s.find("FROM GroupImpl as g WHERE g.parentClass = ?",
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
     * Updates a group in database
     * @param group IGroup to update
     * @throws HibernateException 
     * 
     */
    public static void update(IGroup group) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            s.update(group);
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
     * Deletes a group from the database
     *
     * @param group IGroup to delete
     * @throws HibernateException 
     * 
     */
    public static void delete(IGroup group) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            s.delete(group);
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

