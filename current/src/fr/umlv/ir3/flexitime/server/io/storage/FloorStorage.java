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

import fr.umlv.ir3.flexitime.common.data.general.IBuilding;
import fr.umlv.ir3.flexitime.common.data.general.IFloor;


/**
 * * Class that has the responsibility to persist IFloor in database
 * 
 * @version 0.1

 * 
 * @author FlexiTeam - Prâsad
 */
public class FloorStorage
{
    /**
     *  Saves a floor in database
     * 
     * @param floor IFloor to save 
     * @throws HibernateException 
     */
    public static void save(IFloor floor) throws HibernateException
    {
        if (floor.getIdData() != null)
        {
            update(floor);
        }
        else
        {
            Session s = null;
            Transaction tx = null;
            try
            {
                s = HibernateUtil.currentSession();
                tx = s.beginTransaction();
                s.save(floor);
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
     * Method to get all the floors
     * @param parent 
     * @return List of IFloor
     * @throws HibernateException 
     * 
     */
    public static List<IFloor> get(IBuilding parent) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        List<IFloor> l = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            l = s.find("FROM FloorImpl as f WHERE f.parentBuilding = ?", parent.getIdData(), Hibernate.LONG);
            
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
     * Updates a floor in database
     * @param floor IFloor to update
     * @throws HibernateException 
     * 
     */
    public static void update(IFloor floor) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            s.update(floor);
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
     * Deletes a floor from the database
     *
     * @param floor IFloor to delete
     * @throws HibernateException 
     * 
     */
    public static void delete(IFloor floor) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            s.delete(floor);
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

