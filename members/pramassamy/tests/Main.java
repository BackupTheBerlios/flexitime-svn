/*
 * Created on 20 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package tests;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Iterator;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.DataFactory;
import fr.umlv.ir3.flexitime.common.data.IData;
import fr.umlv.ir3.flexitime.common.data.activity.IBusy;
import fr.umlv.ir3.flexitime.common.data.activity.ILesson;
import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.general.ITrack;
import fr.umlv.ir3.flexitime.common.data.resources.IGroup;
import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure;
import fr.umlv.ir3.flexitime.common.event.DataEvent;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.rmi.DataListenerImpl;
import fr.umlv.ir3.flexitime.common.rmi.IDataListener;
import fr.umlv.ir3.flexitime.common.rmi.IDataManager;
import fr.umlv.ir3.flexitime.common.tools.Gap;
import fr.umlv.ir3.flexitime.richClient.event.RemoteDataManager;

/**
 * DOCME Description explication supplémentaire si nécessaire in english
 * please... Que fait cette classe, qu'est-ce qu'elle représente, ...
 * 
 * @version Verion ou révision SVN
 * @see (si nécessaire)
 */
public class Main
{

    public static void main(String[] args) throws RemoteException,
            FlexiException, MalformedURLException, NotBoundException
    {
//        class DataL implements IDataListener
//        {
//
//            /**
//             * Comment for <code>serialVersionUID</code>
//             */
//            private static final long serialVersionUID = 1L;
//
//            public DataL() throws RemoteException
//            {
//                super();
//            }
//            /** 
//             * DOCME Description
//             * Quel service est rendu par cette méthode
//             * <code>exemple d'appel de la methode</code>
//             *
//             * @param event
//             * @throws RemoteException 
//             * 
//             * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
//             */
//            public void dataChanged(DataEvent event) throws RemoteException
//            {
//                System.out.println("Track Changed");
//                System.out.println(event);
//                ITrack b = (ITrack) event.getSource();
//                System.out.println(b.getName() + " " + b);
//
//                System.out.println(event.getEventType());
//
//                for (int i = 0 ; i < event.getSubObjects().length ; i++)
//                    System.out.println(event.getSubObjects()[i]);
//
//                for (int i = 0 ; i < event.getSubIndicies().length ; i++)
//                    System.out.println(event.getSubIndicies()[i]);
//                
//            }
//            
//        }
//        
//        
//        
//       
//        RemoteDataManager.getManager().addDataListener(ITrack.class,
//                new DataListenerImpl() {
//
//                    /**
//                     * Comment for <code>serialVersionUID</code>
//                     */
//                    private static final long serialVersionUID = 3618986676190394419L;
//
//                    /**
//                     * DOCME Description Quel service est rendu par cette
//                     * méthode <code>exemple d'appel de la methode</code>
//                     * 
//                     * @param event
//                     * @throws RemoteException
//                     * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
//                     */
//                    public void dataChanged(DataEvent event)
//                            throws RemoteException
//                    {
//                        System.out.println("Track Changed");
//                        System.out.println(event);
//                        ITrack b = (ITrack) event.getSource();
//                        System.out.println(b.getName() + " " + b);
//
//                        System.out.println(event.getEventType());
//
//                        for (int i = 0 ; i < event.getSubObjects().length ; i++)
//                            System.out.println(event.getSubObjects()[i]);
//
//                        for (int i = 0 ; i < event.getSubIndicies().length ; i++)
//                            System.out.println(event.getSubIndicies()[i]);
//
//                    }
//                });
//
//        RemoteDataManager.getManager().addDataListener(IClass.class,
//                new DataListenerImpl() {
//
//                    /**
//                     * DOCME Description Quel service est rendu par cette
//                     * méthode <code>exemple d'appel de la methode</code>
//                     * 
//                     * @param event
//                     * @throws RemoteException
//                     * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
//                     */
//                    public void dataChanged(DataEvent event)
//                            throws RemoteException
//                    {
//                        System.out.println("Class Changed");
//                        System.out.println(event);
//                        IClass b = (IClass) event.getSource();
//                        System.out.println(b.getName() + " " + b);
//
//                        System.out.println(event.getEventType());
//
//                        for (int i = 0 ; i < event.getSubObjects().length ; i++)
//                            System.out.println(event.getSubObjects()[i]);
//
//                        for (int i = 0 ; i < event.getSubIndicies().length ; i++)
//                            System.out.println(event.getSubIndicies()[i]);
//
//                    }
//                });
//
//        RemoteDataManager.getManager().addDataListener(
//                ITeachingStructure.class, new DataListenerImpl() {
//
//                    /**
//                     * DOCME Description Quel service est rendu par cette
//                     * méthode <code>exemple d'appel de la methode</code>
//                     * 
//                     * @param event
//                     * @throws RemoteException
//                     * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
//                     */
//                    public void dataChanged(DataEvent event)
//                            throws RemoteException
//                    {
//                        System.out.println("TS Changed");
//                        System.out.println(event);
//                        ITeachingStructure b = (ITeachingStructure) event
//                                .getSource();
//                        System.out.println(b.getName() + " " + b);
//
//                        System.out.println(event.getEventType());
//
//                        for (int i = 0 ; i < event.getSubObjects().length ; i++)
//                            System.out.println(event.getSubObjects()[i]);
//
//                        for (int i = 0 ; i < event.getSubIndicies().length ; i++)
//                            System.out.println(event.getSubIndicies()[i]);
//
//                    }
//                });
//
//        RemoteDataManager.getManager().addDataListener(ISubjectsGroup.class,
//                new DataListenerImpl() {
//
//                    /**
//                     * DOCME Description Quel service est rendu par cette
//                     * méthode <code>exemple d'appel de la methode</code>
//                     * 
//                     * @param event
//                     * @throws RemoteException
//                     * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
//                     */
//                    public void dataChanged(DataEvent event)
//                            throws RemoteException
//                    {
//                        System.out.println("SG Changed");
//                        System.out.println(event);
//                        ISubjectsGroup b = (ISubjectsGroup) event.getSource();
//                        System.out.println(b.getName() + " " + b);
//
//                        System.out.println(event.getEventType());
//
//                        for (int i = 0 ; i < event.getSubObjects().length ; i++)
//                            System.out.println(event.getSubObjects()[i]);
//
//                        for (int i = 0 ; i < event.getSubIndicies().length ; i++)
//                            System.out.println(event.getSubIndicies()[i]);
//
//                    }
//                });
//
//        RemoteDataManager.getManager().addDataListener(ISubject.class,
//                new DataListenerImpl() {
//
//                    /**
//                     * DOCME Description Quel service est rendu par cette
//                     * méthode <code>exemple d'appel de la methode</code>
//                     * 
//                     * @param event
//                     * @throws RemoteException
//                     * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
//                     */
//                    public void dataChanged(DataEvent event)
//                            throws RemoteException
//                    {
//                        System.out.println("Subject Changed");
//                        System.out.println(event);
//                        ISubject b = (ISubject) event.getSource();
//                        System.out.println(b.getName() + " " + b);
//
//                        System.out.println(event.getEventType());
//
//                        for (int i = 0 ; i < event.getSubObjects().length ; i++)
//                            System.out.println(event.getSubObjects()[i]);
//
//                        for (int i = 0 ; i < event.getSubIndicies().length ; i++)
//                            System.out.println(event.getSubIndicies()[i]);
//
//                    }
//                });
//
//        RemoteDataManager.getManager().addDataListener(ITeacher.class,
//                new DataListenerImpl() {
//
//                    /**
//                     * DOCME Description Quel service est rendu par cette
//                     * méthode <code>exemple d'appel de la methode</code>
//                     * 
//                     * @param event
//                     * @throws RemoteException
//                     * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
//                     */
//                    public void dataChanged(DataEvent event)
//                            throws RemoteException
//                    {
//                        System.out.println("Teacher Changed");
//                        System.out.println(event);
//                        ITeacher b = (ITeacher) event.getSource();
//                        System.out.println(b.getName() + " " + b);
//
//                        System.out.println(event.getEventType());
//
//                        for (int i = 0 ; i < event.getSubObjects().length ; i++)
//                            System.out.println(event.getSubObjects()[i]);
//
//                        for (int i = 0 ; i < event.getSubIndicies().length ; i++)
//                            System.out.println(event.getSubIndicies()[i]);
//                    }
//                });
//        
//        RemoteDataManager.getManager().addDataListener(IGroup.class,
//                new DataListenerImpl() {
//
//                    /**
//                     * DOCME Description Quel service est rendu par cette
//                     * méthode <code>exemple d'appel de la methode</code>
//                     * 
//                     * @param event
//                     * @throws RemoteException
//                     * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
//                     */
//                    public void dataChanged(DataEvent event)
//                            throws RemoteException
//                    {
//                        System.out.println("Group Changed");
//                        System.out.println(event);
//                        IGroup b = (IGroup) event.getSource();
//                        System.out.println(b.getName() + " " + b);
//
//                        System.out.println(event.getEventType());
//
//                        for (int i = 0 ; i < event.getSubObjects().length ; i++)
//                            System.out.println(event.getSubObjects()[i]);
//
//                        for (int i = 0 ; i < event.getSubIndicies().length ; i++)
//                            System.out.println(event.getSubIndicies()[i]);
//
//                    }
//                });
//
//        ITrack b = DataFactory.createTrack("IR");
//        System.out.println(b.getIdData());
//        IClass f = DataFactory.createClass("IR1", b);
//        System.out.println(f.getName());
//        IClass f1 = DataFactory.createClass("IR2", b);
//        IGroup r = DataFactory.createGroup("Groupe 1", 23, f);
//        ITeachingStructure ts = DataFactory.createTeachingStructure("IR1", f);
//        ISubjectsGroup sg = DataFactory.createSubjectsGroup("Bloc 1", ts);
//        ISubject s = DataFactory.createSubject("Algo", sg);
//        ICourse c = DataFactory.createCourse("TD", s);
//        ICourse c1 = DataFactory.createCourse("Cours", s);
//
//        ITeacher teacher = DataFactory.createTeacher("Nicaud", "Cyril");
//        ITeacher teacher2 = DataFactory.createTeacher("Roussel", "Cyril");
//
//
//
//        Gap gap = new Gap(2005, 01, 21, 10, 45, 2005, 01, 21, 12, 45);
//        Gap gap1 = new Gap(2005, 01, 24, 10, 45, 2005, 01, 24, 12, 45);
//
//        //DataFactory.createTeacherBusy(gap1, 0, teacher);
//        //DataFactory.createGroupBusy(gap1, 0, r);
//
//        ILesson les = DataFactory.createLesson(gap, c, 2, teacher, r);
//        ILesson les2 = DataFactory.createLesson(gap1, c, 2, teacher, r);
//
//        System.out.println("POPOPO");

        IDataListener l = new DataListenerImpl(){
            
            /** 
             * DOCME Description
             * Quel service est rendu par cette méthode
             * <code>exemple d'appel de la methode</code>
             *
             * @param event
             * @throws RemoteException 
             * 
             * @see fr.umlv.ir3.flexitime.common.rmi.IDataListener#dataChanged(fr.umlv.ir3.flexitime.common.event.DataEvent)
             */
            public void dataChanged(DataEvent event) throws RemoteException
            {
                System.out.println(event);

            }
        };
        
        RemoteDataManager.getManager().addDataListener(ITeacher.class, l);

        ITeacher t = DataFactory.createTeacher("Roussel", "Gilles");
        
        //RemoteDataManager.getManager().removeDataListener(ITeacher.class, l);
        
        //ITeacher t1 = DataFactory.createTeacher("Roussel", "Gilles");
        
        Gap gap = new Gap(2005, 01, 21, 10, 45, 2005, 01, 21, 12, 45);
        Gap gap1 = new Gap(2005, 01, 24, 10, 45, 2005, 01, 24, 12, 45);
        
        DataFactory.createTeacherBusy(gap, t);
        DataFactory.createTeacherBusy(gap1, t);
        
        for(Iterator<IBusy> it = t.getSetBusy().iterator(); it.hasNext(); )
        {
            System.out.println(it.next().getStartDate());
        }
        
        ITeacher teacher = RemoteDataManager.getManager().getTeachers().get(0);
        
        System.out.println(teacher.getSetBusy());
        for(Iterator<IBusy> it = teacher.getSetBusy().iterator(); it.hasNext(); )
        {
            System.out.println(it.next().getStartDate());
        }
        
    }
}
