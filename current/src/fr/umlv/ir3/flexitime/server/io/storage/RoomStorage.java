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

import fr.umlv.ir3.flexitime.common.data.general.IFloor;
import fr.umlv.ir3.flexitime.common.data.resources.IRoom;


/**
 *  * Class that has the responsibility to persist IRoom in database
 * 
 * @version 0.1

 * 
 * @author FlexiTeam - Prâsad
 */
public class RoomStorage
{
    /**
     *  Saves a room in database
     * 
     * @param room IRoom to save 
     * @throws HibernateException 
     */
    public static void save(IRoom room)throws HibernateException
    {
        if (room.getIdData() != null)
        {
            update(room);
        }
        else
        {
            Session s = null;
            Transaction tx = null;
            try
            {
                s = HibernateUtil.currentSession();
                tx = s.beginTransaction();
                s.save(room);
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
     * Method to get all the rooms
     * @param parent 
     * @return List of IRoom
     * @throws HibernateException 
     * 
     */
    public static List get(IFloor parent) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        List l = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            l = s.find("FROM RoomImpl as r WHERE r.parentFloor = ?", parent.getIdData(), Hibernate.LONG);
            
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
     * Updates a room in database
     * @param room IRoom to update
     * @throws HibernateException 
     * 
     */
    public static void update(IRoom room)throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            s.update(room);
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
     * Deletes a room from the database
     *
     * @param room IRoom to delete
     * @throws HibernateException 
     * 
     */
    public static void delete(IRoom room)throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            s.delete(room);
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

