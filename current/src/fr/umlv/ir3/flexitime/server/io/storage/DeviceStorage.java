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
import fr.umlv.ir3.flexitime.common.data.resources.IDevice;


/**
  * Class that has the responsibility to persist IDevice in database
 * 
 * @version 0.1

 * 
 * @author FlexiTeam - Prâsad
 */
public class DeviceStorage
{
    /**
     *  Saves a device in database
     * 
     * @param device IDevice to save 
     * @throws HibernateException 
     */
    public static void save(IDevice device) throws HibernateException
    {
        if (device.getIdData() != null)
        {
            update(device);
        }
        else
        {
            Session s = null;
            Transaction tx = null;
            try
            {
                s = HibernateUtil.currentSession();
                tx = s.beginTransaction();
                s.save(device);
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
     * Method to get all the devices
     * @return List of IDevice
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
            l = s.find("FROM DeviceImpl");
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
     * Updates a device in database
     * @param device IDevice to update
     * @throws HibernateException 
     * 
     */
    public static void update(IDevice device) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            s.update(device);
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
     * Deletes a device from the database
     *
     * @param device IDevice to delete
     * 
     */
    public static void delete(IDevice device) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            s.delete(device);
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

