/*
 * Created on 13 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.io.storage;



import java.util.List;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure;


/**
 *  * Class that has the responsibility to persist ITeachingStructure in database
 * 
 * @version 0.1

 * 
 * @author FlexiTeam - Prâsad
 */
public class TeachingStructureStorage
{
    /**
     *  Saves a teachingStructure in database
     * 
     * @param teachingStructure ITeachingStructure to save 
     * @throws HibernateException 
     */
    public static void save(ITeachingStructure teachingStructure) throws HibernateException
    {
        if (teachingStructure.getIdData() != null)
        {
            update(teachingStructure);
        }
        else
        {
            Session s = null;
            Transaction tx = null;
            try
            {
                s = HibernateUtil.currentSession();
                tx = s.beginTransaction();
                s.save(teachingStructure);
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
     * Method to get all the teaching structures
     * @return List of ITeachingStructure
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
            l = s.find("FROM TeachingStructureImpl");
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
     * Updates a teachingStructure in database
     * @param teachingStructure ITeachingStructure to update
     * @throws HibernateException 
     * 
     */
    public static void update(ITeachingStructure teachingStructure) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            s.update(teachingStructure);
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
     * Deletes a teachingStructure from the database
     *
     * @param teachingStructure ITeachingStructure to delete
     * @throws HibernateException 
     * 
     */
    public static void delete(ITeachingStructure teachingStructure) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            s.delete(teachingStructure);
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

