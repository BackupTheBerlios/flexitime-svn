/*
 * Created on 29 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core;

import java.rmi.RemoteException;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.LazyInitializationException;
import fr.umlv.ir3.flexitime.common.data.DataFactory;
import fr.umlv.ir3.flexitime.common.data.activity.IBusy;
import fr.umlv.ir3.flexitime.common.data.activity.IDeviceBusy;
import fr.umlv.ir3.flexitime.common.data.activity.ITeacherBusy;
import fr.umlv.ir3.flexitime.common.data.general.IBuilding;
import fr.umlv.ir3.flexitime.common.data.general.IFloor;
import fr.umlv.ir3.flexitime.common.data.resources.IDevice;
import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.RemoteDataManager;
import fr.umlv.ir3.flexitime.common.tools.Gap;


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

    public static void main(String[] args) throws HibernateException, FlexiException, RemoteException
    {
//        Session s = HibernateUtil.currentSession();
//        //Transaction tx = s.beginTransaction();
//        //List<IGroup> l = (List<IGroup>)s.find("from GroupImpl");
//        
//        
//        //IGroup g = (IGroup) s.load(GroupImpl.class, new Long(36));
//        ILesson l = (ILesson) s.load(LessonImpl.class, new Long(71));
//        
//        HibernateUtil.closeSession();
//        
//        for(IResource r : l.getAllResources())
//        {
//            System.out.println(r);
//            for(IBusy b : r.getSetBusy())
//                System.out.println("\t" + b);
//        }
           
        
//        ITeacher t = DataFactory.createTeacher("Ramassamy", "Prâsad", "pramassa@univ-mlv.fr");
//        
//        ITeacherBusy b = DataFactory.createTeacherBusy(new Gap(2005,1,3,8,30,2005,1,3,10,30), t);
//        
//        for(IBusy bb: t.getSetBusy())
//            System.out.println(bb.getComment());
//        
//        b.setComment("Toto");
//        
//        RemoteDataManager.getManager().saveOrUpdateResourceBusy(b, t);
//        
//        for(IBusy bb: t.getSetBusy())
//            System.out.println(bb.getComment());
//        
//        RemoteDataManager.getManager().deleteResourceBusy(b, t);
//        
//        for(IBusy bb: t.getSetBusy())
//            System.out.println(bb.getComment());
//        
//        IDevice d = DataFactory.createDevice("Ramassamy");
//        
//        IDeviceBusy bd = DataFactory.createDeviceBusy(new Gap(2005,1,3,8,30,2005,1,3,10,30), d);
//        
//        for(IBusy bb: d.getSetBusy())
//            System.out.println(bb.getComment());
//        
//        bd.setReason(1);
//        
//        RemoteDataManager.getManager().saveOrUpdateResourceBusy(bd, d);
//        
//        for(IBusy bb: d.getSetBusy())
//            System.out.println(bb.getComment());
//        
//        RemoteDataManager.getManager().deleteResourceBusy(bd, d);
//        
//        for(IBusy bb: t.getSetBusy())
//            System.out.println(bb.getComment());
        
//        for(IBusy b : g.getSetBusy())
//            System.out.println(b);
        
//        for(IGroup g : l)
//        {
//            System.out.println(g.getName());
//        }
        IBuilding b = RemoteDataManager.getManager().getBuildings().iterator().next();
        System.out.println(b);
        for(IFloor f : b.getLstFloor())
            System.out.println(f.getName());
        
    }
}

