/*
 * Created on 29 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import fr.umlv.ir3.flexitime.common.data.activity.IBusy;
import fr.umlv.ir3.flexitime.common.data.activity.ILesson;
import fr.umlv.ir3.flexitime.common.data.activity.impl.LessonImpl;
import fr.umlv.ir3.flexitime.common.data.resources.IResource;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.server.io.storage.HibernateUtil;


/**
 * DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * @see (si nécessaire)
 * 
 */
public class TestStorage
{

    public static void main(String[] args) throws HibernateException, FlexiException
    {
        Session s = HibernateUtil.currentSession();
        //Transaction tx = s.beginTransaction();
        //List<IGroup> l = (List<IGroup>)s.find("from GroupImpl");
        
        
        //IGroup g = (IGroup) s.load(GroupImpl.class, new Long(36));
        ILesson l = (ILesson) s.load(LessonImpl.class, new Long(71));
        
        HibernateUtil.closeSession();
        
        for(IResource r : l.getAllResources())
        {
            System.out.println(r);
            for(IBusy b : r.getSetBusy())
                System.out.println("\t" + b);
        }
            
        
//        for(IBusy b : g.getSetBusy())
//            System.out.println(b);
        
//        for(IGroup g : l)
//        {
//            System.out.println(g.getName());
//        }
        
        
    }
}

