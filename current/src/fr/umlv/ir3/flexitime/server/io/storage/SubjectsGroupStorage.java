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
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure;


/**
 *  * Class that has the responsibility to persist ISubjectsGroup in database
 * 
 * @version 0.1

 * 
 * @author FlexiTeam - Prâsad
 */
public class SubjectsGroupStorage
{
    /**
     *  Saves a subjectsGroup in database
     * 
     * @param subjectsGroup ISubjectsGroup to save 
     * @throws HibernateException 
     */
    public static void save(ISubjectsGroup subjectsGroup) throws HibernateException
    {
        if (subjectsGroup.getIdData() != null)
        {
            update(subjectsGroup);
        }
        else
        {
            Session s = null;
            Transaction tx = null;
            try
            {
                s = HibernateUtil.currentSession();
                tx = s.beginTransaction();
                s.save(subjectsGroup);
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
     * Method to get all the subjectsGroups
     * @param parent 
     * @return List of ISubjectsGroup
     * @throws HibernateException 
     * 
     */
    public static List<ISubjectsGroup> get(ITeachingStructure parent) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        List<ISubjectsGroup> l = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            l = s.find("FROM SubjectsGroupImpl as s WHERE s.parentTeachingStructure = ?", parent.getIdData(), Hibernate.LONG);
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
     * Updates a subjectsGroup in database
     * @param subjectsGroup ISubjectsGroup to update
     * @throws HibernateException 
     * 
     */
    public static void update(ISubjectsGroup subjectsGroup) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            s.update(subjectsGroup);
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
     * Deletes a subjectsGroup from the database
     *
     * @param subjectsGroup ISubjectsGroup to delete
     * @throws HibernateException 
     * 
     */
    public static void delete(ISubjectsGroup subjectsGroup) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            s.delete(subjectsGroup);
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

