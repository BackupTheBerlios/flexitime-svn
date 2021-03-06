/*
 * Created on 13 janv. 2005
 * by Pr�sad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.io.storage;



import java.util.List;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import fr.umlv.ir3.flexitime.common.data.admin.IUser;
import fr.umlv.ir3.flexitime.common.data.admin.impl.UserImpl;
import fr.umlv.ir3.flexitime.common.data.general.ITrack;


/**
 *  * Class that has the responsibility to persist ITrack in database
 * 
 * @version 0.1

 * 
 * @author FlexiTeam - Pr�sad
 */
public class TrackStorage
{
    /**
     *  Saves a track in database
     * 
     * @param track ITrack to save 
     * @throws HibernateException 
     */
    public static void save(ITrack track) throws HibernateException
    {
        if (track.getIdData() != null)
        {
            update(track);
        }
        else
        {
            Session s = null;
            Transaction tx = null;
            try
            {
                s = HibernateUtil.currentSession();
                tx = s.beginTransaction();
                s.save(track);
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
     * Method to get all the tracks
     * @return List of ITrack
     * @throws HibernateException 
     * 
     */
    public static List<ITrack> get() throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        List<ITrack> l = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            l = s.find("FROM TrackImpl");
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
     * Updates a track in database
     * @param track ITrack to update
     * @throws HibernateException 
     * 
     */
    public static void update(ITrack track) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            s.update(track);
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
     * Deletes a track from the database
     *
     * @param track ITrack to delete
     * @throws HibernateException 
     * 
     */
    public static void delete(ITrack track) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            s.delete(track);
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
    
    public static List<ITrack> getTracks(IUser user) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        List<ITrack> l = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            Query q = s.createQuery("select t from TrackImpl t inner join t.setUser u where u.idData = "+user.getIdData());
            l = q.list();
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
    
    public static void main(String[] args) throws HibernateException
    {
        IUser u = new UserImpl("toto");
        u.setIdData(new Long(72));
        for(ITrack t : getTracks(u))
            System.out.println(t.getName());
    }
}

