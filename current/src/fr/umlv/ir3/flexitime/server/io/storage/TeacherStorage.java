/*
 * Created on 13 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.server.io.storage;

import java.io.IOException;
import java.util.List;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;

/**
 * * Class that has the responsibility to persist ITeacher in database
 * 
 * @version 0.1
 * @author FlexiTeam - Prâsad
 */
public class TeacherStorage
{

    /**
     * Saves a teacher in database
     * 
     * @param teacher ITeacher to save
     * @throws HibernateException
     */
    public static void save(ITeacher teacher) throws HibernateException
    {
        //Si l'id su teacher n'est pas null, c'est qu'il existe
        //déjà dans la BDD
        if (teacher.getIdData() != null)
        {
            update(teacher);
        } else
        {
            Session s = null;
            Transaction tx = null;
            try
            {
                s = HibernateUtil.currentSession();
                tx = s.beginTransaction();
                s.save(teacher);
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
     * Method to get all the Teachers
     * 
     * @return List of ITeacher
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
            l = s.find("FROM TeacherImpl");
            tx.commit();
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
            if(tx != null)
                tx.rollback();
            throw e;
        }
        finally
        {
            HibernateUtil.closeSession();
        }
        
        return l;
    }

    /**
     * Updates a teacher in database
     * 
     * @param teacher ITeacher to update
     * @throws HibernateException
     */
    public static void update(ITeacher teacher) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            s.update(teacher);
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
     * Deletes a teacher from the database
     * 
     * @param teacher ITeacher to delete
     * @throws HibernateException
     */
    public static void delete(ITeacher teacher) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            s.delete(teacher);
            tx.commit();
        }
        catch (HibernateException e)
        {
            e.printStackTrace();
            if(tx != null)
                tx.rollback();
            throw e;
        }
        finally
        {
            HibernateUtil.closeSession();
        }
    }
}

