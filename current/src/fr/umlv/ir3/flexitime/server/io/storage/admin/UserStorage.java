/*
 * Created on 30 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.io.storage.admin;

import java.util.List;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import fr.umlv.ir3.flexitime.common.data.admin.IUser;
import fr.umlv.ir3.flexitime.server.io.storage.HibernateUtil;


/**
 * Class that has the responsibility to save, update or delete an user from database
 * 
 */
public class UserStorage
{

    /**
     * Saves an user in database
     * 
     * @param user IUser to save
     * @throws HibernateException 
     * 
     */
    public static void save(IUser user) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            s.saveOrUpdate(user);
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
     * Retrieves an user from database
     *
     * @param name name of the IUser
     * @return IUser corresponding to this name
     * @throws HibernateException 
     * 
     */
    public static IUser get(String name) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        List<IUser> l = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            l = s.find("FROM UserImpl u WHERE u.name = ?", name, Hibernate.STRING);
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
        if(l.size() == 0)
            return null;

        return l.iterator().next();
    }
    
    
    /**
     * Deletes an user from the database
     * @param user IUser to delete
     * @throws HibernateException 
     * 
     */
    public static void delete(IUser user) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            s.delete(user);
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
     * Retrieves all the users contained in database
     *
     * @return List of IUser
     * @throws HibernateException 
     * 
     */
    public static List<IUser> getAllUsers() throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        List<IUser> l = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            l = s.find("FROM UserImpl");
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
}

