/*
 * Created on 30 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.io.storage;

import java.util.List;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import fr.umlv.ir3.flexitime.common.data.activity.IBusy;
import fr.umlv.ir3.flexitime.common.data.activity.impl.BusyImpl;
import fr.umlv.ir3.flexitime.common.data.activity.impl.LessonImpl;


/**
 * Busy storage 
 */
public class BusyStorage
{
    /**
     *  
     * @param busy
     * @throws HibernateException 
     * 
     */
    public static void save(IBusy busy) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            s.saveOrUpdate(busy);
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
    
    public static List getGroupBusy(Long idGroup) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        List l = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            //Query q = s.createSQLQuery("select {lesson.*} from (lesson natural inner join busy) natural inner join resourcebusyset where idresource=37", new String[]{"lesson", "busy"}, new Class[]{LessonImpl.class, BusyImpl.class});
            //l =s.find("From BusyImpl b , ResourceImpl r WHERE b.idr.id = ?", idResource, Hibernate.LONG);
            Query q = s.createQuery("select l from LessonImpl l inner join l.setGroup g WHERE g.idData="+idGroup);
            l = q.list();
            //Query q1 = s.createQuery("select b from ")
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
    
    public static List getDeviceBusy(Long idDevice) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        List l = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            //Query q = s.createSQLQuery("select {lesson.*} from (lesson natural inner join busy) natural inner join resourcebusyset where idresource=37", new String[]{"lesson", "busy"}, new Class[]{LessonImpl.class, BusyImpl.class});
            //l =s.find("From BusyImpl b , ResourceImpl r WHERE b.idr.id = ?", idResource, Hibernate.LONG);
            Query q = s.createQuery("select l from LessonImpl l inner join l.setDevice g WHERE g.idData="+idDevice);
            l = q.list();
            //Query q1 = s.createQuery("select b from ")
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
    
    public static List getRoomBusy(Long idRoom) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        List l = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            //Query q = s.createSQLQuery("select {lesson.*} from (lesson natural inner join busy) natural inner join resourcebusyset where idresource=37", new String[]{"lesson", "busy"}, new Class[]{LessonImpl.class, BusyImpl.class});
            //l =s.find("From BusyImpl b , ResourceImpl r WHERE b.idr.id = ?", idResource, Hibernate.LONG);
            Query q = s.createQuery("select l from LessonImpl l inner join l.setRoom g WHERE g.idData="+idRoom);
            l = q.list();
            //Query q1 = s.createQuery("select b from ")
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
    
    public static List getTeacherBusy(Long idTeacher) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        List l = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            //Query q = s.createSQLQuery("select {lesson.*} from (lesson natural inner join busy) natural inner join resourcebusyset where idresource=37", new String[]{"lesson", "busy"}, new Class[]{LessonImpl.class, BusyImpl.class});
            //l =s.find("From BusyImpl b , ResourceImpl r WHERE b.idr.id = ?", idResource, Hibernate.LONG);
            Query q = s.createQuery("select l from LessonImpl l inner join l.setTeacher g WHERE g.idData="+idTeacher);
            l = q.list();
            //Query q1 = s.createQuery("select b from ")
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
     * @param b
     * @throws HibernateException
     */
    public static void delete(IBusy b) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            s.delete(b);
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

