/*
 * Created on 8 janv. 2005
 * by Prâsad
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package TestHiber;

import java.awt.Color;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.sf.hibernate.Hibernate;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import fr.umlv.ir3.flexitime.common.data.activity.ILesson;
import fr.umlv.ir3.flexitime.common.data.activity.impl.LessonImpl;
import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.general.ITrack;
import fr.umlv.ir3.flexitime.common.data.general.impl.BuildingImpl;
import fr.umlv.ir3.flexitime.common.data.general.impl.ClassImpl;
import fr.umlv.ir3.flexitime.common.data.general.impl.FloorImpl;
import fr.umlv.ir3.flexitime.common.data.general.impl.TrackImpl;
import fr.umlv.ir3.flexitime.common.data.resources.IGroup;
import fr.umlv.ir3.flexitime.common.data.resources.IRoom;
import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;
import fr.umlv.ir3.flexitime.common.data.resources.impl.GroupImpl;
import fr.umlv.ir3.flexitime.common.data.resources.impl.RoomImpl;
import fr.umlv.ir3.flexitime.common.data.resources.impl.TeacherImpl;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.impl.CourseImpl;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.impl.SubjectImpl;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.impl.SubjectsGroupImpl;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.impl.TeachingStructureImpl;
import fr.umlv.ir3.flexitime.server.io.storage.HibernateUtil;
import fr.umlv.ir3.flexitime.server.io.storage.TeacherStorage;

/**
 * DOCME Description explication supplémentaire si nécessaire in english
 * please... Que fait cette classe, qu'est-ce qu'elle représente, ...
 * 
 * @version Verion ou révision SVN
 * @see (si nécessaire)
 * @author FlexiTeam - Prâsad
 */
public class Main
{

    public static void main(String[] args) throws HibernateException
    {
        //createTrack("MFPI");
        
        
        Session s = HibernateUtil.currentSession();
        ITrack t = (ITrack)s.find("FROM TrackImpl as t WHERE t.name = ?", "MFPI", Hibernate.STRING).iterator().next();
        HibernateUtil.closeSession();
        addClass(t);
        
        /*createTeacher("Midonnet", "Serge", "sm@univ-mlv.fr");
        createTeacher("Roussel", "Gilles", "roussel@univ-mlv.fr");
        createTeacher("Revuz", "Dominique", "dr@univ-mlv.fr");
        createTeacher("Duris", "Etienne", "duris@univ-mlv.fr");*/
        
        printTracks();
    }

    public static void createTrack(String nomTrack) throws HibernateException
    {
        Session s = HibernateUtil.currentSession();
        Transaction tx = s.beginTransaction();
        ITrack track = new TrackImpl(nomTrack);
        
        s.save(track);

        //s.flush();

        tx.commit();

        HibernateUtil.closeSession();

    }

    public static void createTeacher(String name, String firstname, String email)
    {
        ITeacher t = new TeacherImpl(name, firstname, Collections.EMPTY_LIST, email);
        
        
        try
        {
            TeacherStorage.save(t);
        }
        catch (HibernateException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void addLesson() throws HibernateException
    {
        Session s = HibernateUtil.currentSession();
        Calendar cal = Calendar.getInstance();
        cal.set(2005, 0, 12, 10, 45);
        Date sd = new Date(cal.getTimeInMillis());

        cal.set(Calendar.HOUR_OF_DAY, 12);

        Date ed = new Date(cal.getTimeInMillis());

        ILesson lesson = new LessonImpl("ATM", sd, ed, new CourseImpl("TD"));

        //Transaction tx = s.beginTransaction();
        //List gList = s.find("from GroupImpl as g where g.idClass = ?", new
        // Long(2), Hibernate.LONG);
        List gList = s.find("from GroupImpl");

        for (Iterator it = gList.iterator() ; it.hasNext() ;)
        {
            IGroup g = (IGroup) it.next();

            System.out.println(g.getName());

            System.out.println(g.getLstBusy().get(0));

        }

        //s.flush();

        //tx.commit();
        HibernateUtil.closeSession();
    }

    public static void addClass(ITrack track) throws HibernateException
    {
        Session s = HibernateUtil.currentSession();
        Transaction tx = s.beginTransaction();
        //ITrack track = (ITrack) s.find("FROM TrackImpl as t where t.idData = ?", trackToAddTo.getIdData(), Hibernate.LONG);

        IGroup g1 = new GroupImpl("Groupe 1", 20);
        IGroup g2 = new GroupImpl("Groupe 2", 21);

        IClass c = new ClassImpl(track.getName() + ((int)(Math.random()*100)));
        c.addGroup(g1);
        c.addGroup(g2);

        track.addClass(c);

        s.saveOrUpdate(track);
        //s.flush();

        tx.commit();
        HibernateUtil.closeSession();

    }

    public static void printTracks() throws HibernateException
    {
        Session s = HibernateUtil.currentSession();
        Iterator it = s.find("FROM TrackImpl").iterator();
        while (it.hasNext())
        {
            ITrack track = (ITrack) it.next();

            System.out.println(track.getName());

            Iterator itC = track.getLstClass().iterator();

            while (itC.hasNext())
            {
                IClass c = (IClass) itC.next();
                System.out.println("\t" + c.getName() + "::" + c.getNbGroup()
                        + "::" + c.getNbPerson());

                Iterator itG = c.getLstGroups().iterator();

                while (itG.hasNext())
                {
                    IGroup g = (IGroup) itG.next();

                    System.out.println("\t\t" + g.getName() + "::"
                            + g.getNbPerson());
                }
            }
        }

        HibernateUtil.closeSession();
    }

    public static void CreateBuilding() throws HibernateException
    {
        Session s = HibernateUtil.currentSession();
        Transaction tx = s.beginTransaction();
        //BuildingImpl b = new BuildingImpl("Copernic")
        RoomImpl r = new RoomImpl("2055", IRoom.TYPE_COURS, 50);
        BuildingImpl b = new BuildingImpl("Copernic");
        FloorImpl f = new FloorImpl("2ème étage");

        f.addRoom(r);

        b.addFloor(f);

        s.save(b);
        s.flush();

        System.out.println(b.getIdData());
        tx.commit();

        /*
         * FloorImpl f = (FloorImpl) s.load(FloorImpl.class, new Long(2));
         * f.addRoom(new RoomImpl("2027", IRoom.TYPE_MACHINE, 25)); s.save(f);
         * s.flush();
         */

        /*
         * FloorImpl f = new FloorImpl("1er étage", b, Collections.EMPTY_LIST);
         * RoomImpl r = new RoomImpl("1050", IRoom.TYPE_MACHINE, 25);
         * f.addRoom(r); b.addFloor(f); s.save(b); s.flush();
         */

        /*
         * Iterator it = b.getLstFloor().iterator(); while(it.hasNext()) {
         * IFloor floor = (IFloor) it.next();
         * System.out.println(floor.getName()); Iterator it1 =
         * floor.getLstRoom().iterator(); while(it1.hasNext()) { IRoom r =
         * (IRoom) it1.next(); System.out.println(r.getName() +
         * "\t"+r.getCapacity()); } }
         */

        HibernateUtil.closeSession();
    }

    public static void createTeachStruct() throws HibernateException
    {
        Session s = HibernateUtil.currentSession();
        Transaction tx = s.beginTransaction();
        ITeachingStructure ts = new TeachingStructureImpl("IR3");
        ISubjectsGroup bloc = new SubjectsGroupImpl("Programmation");
        ts.addSubjectsGroup(bloc);

        ISubject sub1 = new SubjectImpl("CORBA");
        bloc.addSubject(sub1);

        ICourse c11 = new CourseImpl("CM", 0, 2, Color.BLUE, 2);
        ICourse c12 = new CourseImpl("TD", 1, 2, Color.BLUE, 2);

        sub1.addCourse(c11);
        sub1.addCourse(c12);

        ITeacher teach1 = new TeacherImpl("Midonnet");
        ITeacher teach2 = new TeacherImpl("Roussel");

        c11.addTeacher(teach1);
        c11.addTeacher(teach2);

        c12.addTeacher(teach1);
        c12.addTeacher(teach2);

        s.save(ts);

        tx.commit();

        HibernateUtil.closeSession();

    }
}

