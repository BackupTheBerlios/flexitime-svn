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

import fr.umlv.ir3.flexitime.common.data.activity.ILesson;


/**
 *  * Class that has the responsibility to persist ILesson in database
 * 
 * @version 0.1

 * 
 * @author FlexiTeam - Prâsad
 */
public class LessonStorage
{
    /**
     *  Saves a lesson in database
     * 
     * @param lesson ILesson to save 
     * @throws HibernateException 
     */
    public static void save(ILesson lesson) throws HibernateException
    {
        if (lesson.getIdBusy() != null)
        {
            update(lesson);
        }
        else
        {
            Session s = null;
            Transaction tx = null;
            try
            {
                s = HibernateUtil.currentSession();
                tx = s.beginTransaction();
                s.save(lesson);
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
     * Method to get all the lessons
     * @return List of ILesson
     * @throws HibernateException 
     * 
     */
    public static List get() throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        List l = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            l = s.find("FROM LesssonImpl");
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
     * Updates a lesson in database
     * @param lesson ILesson to update
     * 
     */
    public static void update(ILesson lesson) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            s.update(lesson);
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
     * Deletes a lesson from the database
     *
     * @param lesson ILesson to delete
     * 
     */
    public static void delete(ILesson lesson) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            s.delete(lesson);
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

