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

import fr.umlv.ir3.flexitime.common.data.general.IBuilding;

/**
 * Class that has the responsibility to persist IClass in database
 * 
 * @version 0.1
 * 
 * 
 * @author FlexiTeam - Prâsad
 */
public class BuildingStorage
{

    /**
     * Saves a building in database
     * 
     * @param building
     *            IBuilding to save
     * @throws HibernateException
     */
    public static void save(IBuilding building) throws HibernateException
    {
        if (building.getIdData() != null)
        {
            update(building);
        }
        else
        {
            Session s = null;
            Transaction tx = null;
            try
            {
                s = HibernateUtil.currentSession();
                tx = s.beginTransaction();
                s.save(building);
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
     * Method to get all the buildings
     * 
     * @return List of IBuilding
     * @throws HibernateException
     * 
     */
    public static List<IBuilding> get() throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        List<IBuilding> l = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            l = s.find("FROM BuildingImpl");
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
     * Updates a building in database
     * 
     * @param building
     *            Ibuilding to update
     * @throws HibernateException
     * 
     */
    public static void update(IBuilding building) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            s.update(building);
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
     * Deletes a building from the database
     * 
     * @param building
     *            IBuilding to delete
     * @throws HibernateException
     * 
     */
    public static void delete(IBuilding building) throws HibernateException
    {
        Session s = null;
        Transaction tx = null;
        try
        {
            s = HibernateUtil.currentSession();
            tx = s.beginTransaction();
            s.delete(building);
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
