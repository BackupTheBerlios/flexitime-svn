/*
 * Created on 19 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.tools;


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.DataFactorySansRmi;
import fr.umlv.ir3.flexitime.common.data.activity.ILesson;
import fr.umlv.ir3.flexitime.common.data.general.IBuilding;
import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.general.IFloor;
import fr.umlv.ir3.flexitime.common.data.general.ITrack;
import fr.umlv.ir3.flexitime.common.data.resources.IDevice;
import fr.umlv.ir3.flexitime.common.data.resources.IGroup;
import fr.umlv.ir3.flexitime.common.data.resources.IRoom;
import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;
import fr.umlv.ir3.flexitime.common.data.resources.impl.RoomImpl;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubjectsGroup;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ITeachingStructure;
import fr.umlv.ir3.flexitime.common.exception.FlexiException;
import fr.umlv.ir3.flexitime.common.tools.Gap;


/**
 * DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * 
 * @author FlexiTeam - binou
 */
public class MetierSimulatorSansRmi
{
    
    private static ITeacher midonnet;
    private static ITeacher revuz;
    private static ITeacher roussel;
    
    private static List teacherLst;
    
    private static IBuilding copernic;
    private static IBuilding lavoisier;
    private static IFloor premier;
    private static IFloor deuxiemme;
    private static IFloor troisieme;
    private static IRoom salleAuditorium;
    private static IRoom salle2027;
    private static IRoom salle2031;
    private static IRoom salle2017;
    private static IRoom salle3012;
    private static IDevice videoproj1;
    private static IDevice videoproj2;
    private static IDevice tv1;
    private static IDevice tv2;
    private static IDevice magneto1;
    private static IDevice magneto2;
    private static ITrack ir;
    private static ITrack mfpi;
    private static ITrack gm;
    private static IClass ir1;
    private static IClass ir2;
    private static IClass ir3;
    private static IClass mfpi1;
    private static IClass mfpi2;
    private static IClass mfpi3;
    private static IClass gm1;
    private static IClass gm2;
    private static IGroup ir1_grp1;
    private static IClass gm3;
    private static IGroup ir1_grp2;
    private static IGroup ir2_grp1;
    private static IGroup ir2_grp2;
    private static IGroup ir3_grp1;
    private static IGroup ir3_grp2;
    private static IGroup mfpi1_grp;
    private static IGroup mfpi2_grp;
    private static IGroup mfpi3_grp;
    private static IGroup gm1_grp1;
    private static IGroup gm1_grp2;
    private static IGroup gm1_grp3;
    private static IGroup gm2_grp1;
    private static IGroup gm2_grp2;
    private static IGroup gm3_grp1;
    private static ITeachingStructure ts_ir1;
    private static ITeachingStructure ts_ir2;
    private static ITeachingStructure ts_ir3;
    private static ITeachingStructure ts_gm1;
    private static ITeachingStructure ts_gm2;
    private static ITeachingStructure ts_gm3;
    private static ISubjectsGroup ir1_bloc1;
    private static ISubjectsGroup ir1_bloc2;
    private static ISubjectsGroup ir2_bloc1;
    private static ISubjectsGroup ir2_bloc2;
    private static ISubjectsGroup ir3_bloc1;
    private static ISubjectsGroup ir3_bloc2;
    private static ISubject ir3_bloc1_sub1;
    private static ISubject ir3_bloc1_sub2;
    private static ISubject ir3_bloc1_sub3;
    private static ISubject ir3_bloc2_sub1;
    private static ISubject ir3_bloc2_sub2;
    private static ISubject ir3_bloc2_sub3;
    private static ICourse j2ee_cours;
    private static ICourse j2ee_td;
    private static ICourse gl_cours;
    private static ICourse gl_td;
    private static ICourse corba_cours;
    private static ICourse corba_td;
    private static ILesson lesson1;
    private static ILesson lesson2;
    private static ILesson lesson3;
    private static ILesson lesson4;
    private static ILesson lesson5;
    private static ILesson lesson6;
    private static ILesson lesson7;
    private static ILesson lesson8;
    private static ILesson lesson9;



    public static void generate()
    {
        
        try
        {
            midonnet = DataFactorySansRmi.createTeacher("Midonnet","jeCpasSonPrenom","midonnet@univ-mlv.fr");

        revuz = DataFactorySansRmi.createTeacher("Revuz","Dominiqueuniquenique","revuz@univ-mlv.fr");
        roussel = DataFactorySansRmi.createTeacher("Roussel","Gilles","groussel@univ-mlv.fr");
        
        teacherLst = new ArrayList(3);
        teacherLst.add(midonnet);
        teacherLst.add(revuz);
        teacherLst.add(roussel);
        
        copernic = DataFactorySansRmi.createBuilding("Copernic");
        lavoisier = DataFactorySansRmi.createBuilding("Lavoisier");
        premier = DataFactorySansRmi.createFloor("1er etage", copernic);
        deuxiemme = DataFactorySansRmi.createFloor("2eme etage", copernic);
        troisieme = DataFactorySansRmi.createFloor("3eme etage", copernic);
        salleAuditorium = DataFactorySansRmi.createRoom("Auditorium", RoomImpl.TYPE_COURS, 200, premier);
        salle2027 = DataFactorySansRmi.createRoom("2027", RoomImpl.TYPE_MACHINE, 24, deuxiemme);
        salle2031 = DataFactorySansRmi.createRoom("2031", RoomImpl.TYPE_MACHINE, 24, deuxiemme);
        salle2017 = DataFactorySansRmi.createRoom("2017", RoomImpl.TYPE_COURS, 60, deuxiemme);
        salle3012 = DataFactorySansRmi.createRoom("3012", RoomImpl.TYPE_COURS, 70, troisieme);
        videoproj1 = DataFactorySansRmi.createDevice("VideoProj1", IDevice.VIDEOPROJECTOR);
        videoproj2 = DataFactorySansRmi.createDevice("VideoProj1", IDevice.VIDEOPROJECTOR);
        tv1 = DataFactorySansRmi.createDevice("TV1", IDevice.TV);
        tv2 = DataFactorySansRmi.createDevice("TV2", IDevice.TV);
        magneto1 = DataFactorySansRmi.createDevice("magneto1", IDevice.VIDEO_TAPE_RECORDER);
        magneto2 = DataFactorySansRmi.createDevice("magneto2", IDevice.VIDEO_TAPE_RECORDER);
        
        ir = DataFactorySansRmi.createTrack("Informatique & Réseaux");
        mfpi = DataFactorySansRmi.createTrack("Informatique & Réseaux");
        gm = DataFactorySansRmi.createTrack("Informatique & Réseaux");
        ir1 = DataFactorySansRmi.createClass("1ere année" , ir);
        ir2 = DataFactorySansRmi.createClass("2eme année" , ir);
        ir3 = DataFactorySansRmi.createClass("3eme année" , ir);
        
        mfpi1 = DataFactorySansRmi.createClass("1ere année" , mfpi);
        mfpi2 = DataFactorySansRmi.createClass("2eme année" , mfpi);
        mfpi3 = DataFactorySansRmi.createClass("3eme année" , mfpi);
        
        gm1 = DataFactorySansRmi.createClass("1ere année" , gm);
        gm2 = DataFactorySansRmi.createClass("2eme année" , gm);
        gm3 = DataFactorySansRmi.createClass("3eme année" , gm);
        
        ir1_grp1 = DataFactorySansRmi.createGroup("groupe 1" , 24 , ir1);
        ir1_grp2 = DataFactorySansRmi.createGroup("groupe 2" , 24 , ir1);
        ir2_grp1 = DataFactorySansRmi.createGroup("groupe 1" , 24 , ir2);
        ir2_grp2 = DataFactorySansRmi.createGroup("groupe 2" , 24 , ir2);
        ir3_grp1 = DataFactorySansRmi.createGroup("groupe 1" , 24 , ir3);
        ir3_grp2 = DataFactorySansRmi.createGroup("groupe 2" , 24 , ir3);
        mfpi1_grp = DataFactorySansRmi.createGroup("groupe 1" , 50 , mfpi1);
        mfpi2_grp = DataFactorySansRmi.createGroup("groupe 1" , 50 , mfpi2);
        mfpi3_grp = DataFactorySansRmi.createGroup("groupe 1" , 50 , mfpi3);
        gm1_grp1 = DataFactorySansRmi.createGroup("groupe 1" , 24 , gm1);
        gm1_grp2 = DataFactorySansRmi.createGroup("groupe 2" , 24 , gm1);
        gm1_grp3 = DataFactorySansRmi.createGroup("groupe 3" , 24 , gm1);
        gm2_grp1 = DataFactorySansRmi.createGroup("groupe 1" , 24 , gm2);
        gm2_grp2 = DataFactorySansRmi.createGroup("groupe 2" , 24 , gm2);
        gm3_grp1 = DataFactorySansRmi.createGroup("groupe 2" , 24 , gm3);
        
        
        ts_ir1 = DataFactorySansRmi.createTeachingStructure("ts ir 1", ir1);
        ts_ir2 = DataFactorySansRmi.createTeachingStructure("ts ir 1", ir2);
        ts_ir3 = DataFactorySansRmi.createTeachingStructure("ts ir 1", ir3);
        ts_gm1 = DataFactorySansRmi.createTeachingStructure("ts gm 1", gm1);
        ts_gm2 = DataFactorySansRmi.createTeachingStructure("ts gm 2", gm2);
        ts_gm3 = DataFactorySansRmi.createTeachingStructure("ts gm 3", gm3);
        
        
        ir1_bloc1 = DataFactorySansRmi.createSubjectsGroup("General", ts_ir1);
        ir1_bloc2 = DataFactorySansRmi.createSubjectsGroup("Math", ts_ir1);
        ir2_bloc1 = DataFactorySansRmi.createSubjectsGroup("General", ts_ir2);
        ir2_bloc2 = DataFactorySansRmi.createSubjectsGroup("developpement!!!", ts_ir2);
        ir3_bloc1 = DataFactorySansRmi.createSubjectsGroup("General", ts_ir3);
        ir3_bloc2 = DataFactorySansRmi.createSubjectsGroup("Rezo", ts_ir3);
        
        ir3_bloc1_sub1 = DataFactorySansRmi.createSubject("J2EE" , ir3_bloc1);
        ir3_bloc1_sub2 = DataFactorySansRmi.createSubject("GL" , ir3_bloc1);
        ir3_bloc1_sub3 = DataFactorySansRmi.createSubject("Exposé système" , ir3_bloc1);
        ir3_bloc2_sub1 = DataFactorySansRmi.createSubject("Corba" , ir3_bloc2);
        ir3_bloc2_sub2 = DataFactorySansRmi.createSubject("Modelisation des ReZo" , ir3_bloc2);
        ir3_bloc2_sub3 = DataFactorySansRmi.createSubject("Exposé ReZo" , ir3_bloc2);
        
        j2ee_cours = DataFactorySansRmi.createCourse("Cours J2EE", ir3_bloc1_sub1 , ICourse.CM, 120, 20 , Color.ORANGE, createList(roussel));
        j2ee_td = DataFactorySansRmi.createCourse("TD J2EE", ir3_bloc1_sub1 , ICourse.TD, 240, 20 , Color.ORANGE, createList(roussel));
        gl_cours = DataFactorySansRmi.createCourse("Cours GL", ir3_bloc1_sub2 , ICourse.CM, 120, 20 , Color.YELLOW, createList(revuz));
        gl_td = DataFactorySansRmi.createCourse("TD GL", ir3_bloc1_sub2 , ICourse.TD, 120, 20 , Color.YELLOW, createList(revuz));
        corba_cours = DataFactorySansRmi.createCourse("Cours Corba", ir3_bloc2_sub1 , ICourse.CM, 120, 20 , Color.CYAN, createList(midonnet));
        corba_td = DataFactorySansRmi.createCourse("TD Corba", ir3_bloc2_sub1 , ICourse.TD, 120, 20 , Color.BLUE, createList(midonnet));
        
        List<IGroup> groups_td = new ArrayList(1);
        groups_td.add(ir3_grp2);
        List<IGroup> groups_cm = new ArrayList(1);
        groups_cm.add(ir3_grp1);
        groups_cm.add(ir3_grp2);
        lesson3 = DataFactorySansRmi.createLesson(new Gap(2005,2,4,10,45,2005,2,4,12,45), gl_cours, groups_cm, revuz);
        lesson4 = DataFactorySansRmi.createLesson(new Gap(2005,2,4,16,0,2005,2,4,18,00), gl_td, groups_td, revuz);
        lesson7 = DataFactorySansRmi.createLesson(new Gap(2005,2,8,8,30,2005,2,8,10,30), j2ee_cours, groups_td, roussel);
        lesson8 = DataFactorySansRmi.createLesson(new Gap(2005,2,8,10,45,2005,2,8,12,45), corba_td, groups_td, roussel);
        lesson1 = DataFactorySansRmi.createLesson(new Gap(2005,2,10,8,30,2005,2,10,10,30), j2ee_cours, groups_cm);
        lesson2 = DataFactorySansRmi.createLesson(new Gap(2005,2,10,10,45,2005,2,10,12,45), corba_cours, groups_cm, midonnet);        
        lesson5 = DataFactorySansRmi.createLesson(new Gap(2005,2,11,8,30,2005,2,11,10,30), j2ee_cours, groups_td, roussel);
        lesson6 = DataFactorySansRmi.createLesson(new Gap(2005,2,11,13,45,2005,2,11,18,00), corba_td, groups_td, roussel);
        //lesson9 = DataFactorySansRmi.createLesson(new Gap(2005,2,14,8,30,2005,2,14,10,30), corba_td, groups_td, roussel);
        lesson9 = DataFactorySansRmi.createLesson(new Gap(2005,2,7,8,30,2005,2,7,10,30), corba_td, groups_td, roussel);
        
        lesson1.addResource(salle2017);
        lesson2.addResource(salle2017);
        lesson3.addResource(salle2017);
        lesson4.addResource(salle2027);
        lesson5.addResource(salle2027);
        
        ir3_grp2.addBusy(lesson1);
        ir3_grp2.addBusy(lesson2);
        ir3_grp2.addBusy(lesson3);
        ir3_grp2.addBusy(lesson4);
        ir3_grp2.addBusy(lesson5);
        ir3_grp2.addBusy(lesson6);
        ir3_grp2.addBusy(lesson7);
        ir3_grp2.addBusy(lesson8);
        ir3_grp2.addBusy(lesson9);
        
        roussel.addBusy(lesson1);
        midonnet.addBusy(lesson2);
        revuz.addBusy(lesson3);
        revuz.addBusy(lesson4);
        roussel.addBusy(lesson5);
        
        salle2017.addBusy(lesson1);
        salle2017.addBusy(lesson2);
        salle2017.addBusy(lesson3);
        salle2027.addBusy(lesson4);
        salle2027.addBusy(lesson5);
        
        
        }
        catch (FlexiException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

        
        
        
        
        // to be continued...
        
    }
    
    public static List createList(Object o)
    {
        ArrayList list = new ArrayList(3);
        list.add(o);
        return list;
    }
    
    public static IGroup getGroup2IR3()
    {
        generate();
        //System.out.println("Nb busy for ir3_grp2 = " +  ir3_grp2.getSetBusy().size());
        return ir3_grp2;
    }
    public static IRoom get2017()
    {
        generate();
        //System.out.println("Nb busy for ir3_grp2 = " +  ir3_grp2.getSetBusy().size());
        return salle2017;
    }
    
    public static List getTeacherListe()
    {
        generate();
        return teacherLst;
    }
    
    public static ITeacher getRoussel()
    {
        generate();
        return roussel;
    }
    
    public static List createTeacherList()
    {
        List lstTeacher = new ArrayList();
        
        try
        {
            midonnet = DataFactorySansRmi.createTeacher("Midonnet","jeCpasSonPrenom","midonnet@univ-mlv.fr");

            lstTeacher.add(midonnet);
            revuz = DataFactorySansRmi.createTeacher("Revuz","Dominiqueuniquenique","revuz@univ-mlv.fr");
            lstTeacher.add(revuz);
            roussel = DataFactorySansRmi.createTeacher("Roussel","Gilles","groussel@univ-mlv.fr");
            lstTeacher.add(roussel);
        }
        catch (FlexiException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return lstTeacher;
    }

    
    /** 
     * @return dsfsd
     */
    /*public static List<ILesson> getLessonsList()
    {
        List<ILesson> res = new ArrayList<ILesson>(3);
        res.add(DataFactorySansRmi.createLesson(new Gap(2005,1,3,8,30,2005,1,3,10,30) , new CourseImpl("Corba",null,120, 1,50,Color.YELLOW,null) , 120 )   );
        res.add(DataFactorySansRmi.createLesson(new Gap(2005,1,3,13,45,2005,1,3,15,45) , new CourseImpl("J2EE",null,120, 1,50,Color.MAGENTA,null) , 120    )   );
        res.add(DataFactorySansRmi.createLesson(new Gap(2005,1,3,16,00,2005,1,3,17,00) , new CourseImpl("MSI",null,60, 1,50,Color.GREEN,null), 60));
        
        res.add(DataFactorySansRmi.createLesson(new Gap(2005,1,4,8,30,2005,1,4,12,45) , new CourseImpl("J2EE",null,240, 1,50,Color.MAGENTA,null), 240));
        res.add(DataFactorySansRmi.createLesson(new Gap(2005,1,4,13,45,2005,1,4,15,45) , new CourseImpl("Corba",null,120, 1,50,Color.YELLOW,null), 120));
        res.add(DataFactorySansRmi.createLesson(new Gap(2005,1,4,16,00,2005,1,4,17,30) , new CourseImpl("MSI",null,12090, 1,50,Color.GREEN,null), 90));

        res.add(DataFactorySansRmi.createLesson(new Gap(2005,1,5,10,45,2005,1,5,12,45) , new CourseImpl("J2EE",null,120, 1,50,Color.MAGENTA,null), 120));
        res.add(DataFactorySansRmi.createLesson(new Gap(2005,1,5,13,30,2005,1,5,15,30) , new CourseImpl("Corba",null,120, 1,50,Color.YELLOW,null), 120));
        res.add(DataFactorySansRmi.createLesson(new Gap(2005,1,5,16,00,2005,1,5,18,00) , new CourseImpl("MSI",null,120, 1,50,Color.GREEN,null), 120));

        res.add(DataFactorySansRmi.createLesson(new Gap(2005,1,6,8,30,2005,1,6,10,30) , new CourseImpl("MSI",null,120, 1,50,Color.GREEN,null), 120));
        res.add(DataFactorySansRmi.createLesson(new Gap(2005,1,6,10,45,2005,1,6,12,45) , new CourseImpl("Corba",null,120, 1,50,Color.YELLOW,null), 120));
        res.add(DataFactorySansRmi.createLesson(new Gap(2005,1,6,13,45,2005,1,6,18,00) , new CourseImpl("J2EE",null,240, 1,50,Color.MAGENTA,null), 240));

        
        res.add(DataFactorySansRmi.createLesson(new Gap(2005,1,7,13,45,2005,1,7,15,45) , new CourseImpl("J2EE",null,120, 1,50,Color.MAGENTA,null), 120));
        res.add(DataFactorySansRmi.createLesson(new Gap(2005,1,7,16,00,2005,1,7,17,00) , new CourseImpl("Corba",null,60, 1,50,Color.YELLOW,null), 60));
        res.add(DataFactorySansRmi.createLesson(new Gap(2005,1,7,17,00,2005,1,7,18,00) , new CourseImpl("MSI",null,60, 1,50,Color.GREEN,null), 60));

        res.add(DataFactorySansRmi.createLesson(new Gap(2005,1,10,11,45,2005,1,10,12,45) , new CourseImpl("J2EE",null,60, 1,50,Color.MAGENTA,null), 60));
        res.add(DataFactorySansRmi.createLesson(new Gap(2005,1,10,13,45,2005,1,10,15,45) , new CourseImpl("Corba",null,120, 1,50,Color.YELLOW,null), 120));
        res.add(DataFactorySansRmi.createLesson(new Gap(2005,1,10,16,00,2005,1,10,18,00) , new CourseImpl("MSI",null,120, 1,50,Color.GREEN,null), 120));

        res.add(DataFactorySansRmi.createLesson(new Gap(2005,1,11,16,00,2005,1,11,18,00) , new CourseImpl("MSI",null,120, 1,50,Color.GREEN,null), 120));
        
        
        res.add(DataFactorySansRmi.createLesson(new Gap(2005,1,12,8,30,2005,1,12,10,30) , new CourseImpl("Corba",null,120, 1,50,Color.YELLOW,null), 120));
        res.add(DataFactorySansRmi.createLesson(new Gap(2005,1,12,13,45,2005,1,12,15,45) , new CourseImpl("J2EE",null,120, 1,50,Color.MAGENTA,null), 120));

        
        res.add(DataFactorySansRmi.createLesson(new Gap(2005,1,13,8,30,2005,1,13,10,30) , new CourseImpl("Corba",null,120, 1,50,Color.YELLOW,null), 120));
        res.add(DataFactorySansRmi.createLesson(new Gap(2005,1,13,13,45,2005,1,13,15,45) , new CourseImpl("J2EE",null,120, 1,50,Color.MAGENTA,null), 120));
        res.add(DataFactorySansRmi.createLesson(new Gap(2005,1,13,16,00,2005,1,13,17,00) , new CourseImpl("MSI",null,60, 1,50,Color.GREEN,null), 60));

        
        res.add(DataFactorySansRmi.createLesson(new Gap(2005,1,14,8,30,2005,1,14,10,30) , new CourseImpl("Corba",null,120, 1,50,Color.YELLOW,null), 120));
        
        
        res.add(DataFactorySansRmi.createLesson(new Gap(2005,1,19,8,30,2005,1,19,10,30) , new CourseImpl("J2EE",null,120, 1,50,Color.MAGENTA,null), 120));
        res.add(DataFactorySansRmi.createLesson(new Gap(2005,1,19,16,00,2005,1,3,17,00) , new CourseImpl("MSI",null,60, 1,50,Color.GREEN,null), 60));

        res.add(DataFactorySansRmi.createLesson(new Gap(2005,1,27,10,00,2005,1,19,12,00) , new CourseImpl("MSI",null,120, 1,50,Color.GREEN,null), 120));
        res.add(DataFactorySansRmi.createLesson(new Gap(2005,1,27,14,30,2005,1,19,17,30) , new CourseImpl("Corba",null,180, 1,50,Color.YELLOW,null), 180));
        res.add(DataFactorySansRmi.createLesson(new Gap(2005,1,28,10,45,2005,1,19,12,45) , new CourseImpl("J2EE",null,120, 1,50,Color.MAGENTA,null), 120));
        
        res.add(DataFactorySansRmi.createLesson(new Gap(2005,1,31,1,0,2005,1,19,18,05) , new CourseImpl("J2EE",null,120, 1,50,Color.CYAN,null), 120));

        
        return res;
    }*/
    
    
    /*public static List createTrackList()
    {
        //Construction des Track
        ITrack trackIR = DataFactorySansRmi.createTrack("IR");
        ITrack trackMF = DataFactorySansRmi.createTrack("MF");
        ITrack trackEI = DataFactorySansRmi.createTrack("EI");
        //Construction des class
        IClass classIR1 = DataFactorySansRmi.createClass("IR1",trackIR);
        IClass classIR2 = DataFactorySansRmi.createClass("IR2",trackIR);
        IClass classIR3 = DataFactorySansRmi.createClass("IR3",trackIR);
        IClass classMF1 = DataFactorySansRmi.createClass("MF1",trackMF);
        IClass classMF2 = DataFactorySansRmi.createClass("MF2",trackMF);
        IClass classMF3 = DataFactorySansRmi.createClass("MF3",trackMF);
        IClass classEI1 = DataFactorySansRmi.createClass("EI1",trackEI);
        IClass classEI2 = DataFactorySansRmi.createClass("EI2",trackEI);
        IClass classEI3 = DataFactorySansRmi.createClass("EI3",trackEI);
        
        //Construction des groupes
        //IR1
        IGroup groupIR11 = DataFactorySansRmi.createGroup("group1",10,classIR1);
        IGroup groupIR12 = DataFactorySansRmi.createGroup("group2",10,classIR1);
        //IR2
        IGroup groupIR21 = DataFactorySansRmi.createGroup("group1",10,classIR2);
        IGroup groupIR22 = DataFactorySansRmi.createGroup("group2",10,classIR2);
//      IR3
        IGroup groupIR31 = DataFactorySansRmi.createGroup("group1",10,classIR3);
        IGroup groupIR32 = DataFactorySansRmi.createGroup("group2",10,classIR3);
//      MF1
        IGroup groupMF11 = DataFactorySansRmi.createGroup("group1",10,classMF1);
        IGroup groupMF12 = DataFactorySansRmi.createGroup("group2",10,classMF1);
//      MF2
        IGroup groupMF21 = DataFactorySansRmi.createGroup("group1",10,classMF2);
        IGroup groupMF22 = DataFactorySansRmi.createGroup("group2",10,classMF2);
//      MF3
        IGroup groupMF31 = DataFactorySansRmi.createGroup("group1",10,classMF3);
        IGroup groupMF32 = DataFactorySansRmi.createGroup("group2",10,classMF3);
//      EI1
        IGroup groupEI11 = DataFactorySansRmi.createGroup("group1",10,classEI1);
        IGroup groupEI12 = DataFactorySansRmi.createGroup("group2",10,classEI1);
//      EI2
        IGroup groupEI21 = DataFactorySansRmi.createGroup("group1",10,classEI2);
        IGroup groupEI22 = DataFactorySansRmi.createGroup("group2",10,classEI2);
//      EI3
        IGroup groupEI31 = DataFactorySansRmi.createGroup("group1",10,classEI3);
        IGroup groupEI32 = DataFactorySansRmi.createGroup("group2",10,classEI3);

        List lstTrack = new ArrayList();
        lstTrack.add(trackIR);
        lstTrack.add(trackMF);
        lstTrack.add(trackEI);
        
        return lstTrack;
    }*/
    
    /*public static List createDeviceList()
    {
        List lstDevice = new ArrayList();
        //Construction des Devices videoproj type 0
        IDevice device = DataFactorySansRmi.createDevice("VideoIR1");
        device.setType(0);
        lstDevice.add(device);
        IDevice device1 = DataFactorySansRmi.createDevice("VideoIR2");
        device1.setType(0);
        lstDevice.add(device1);
        IDevice device2 = DataFactorySansRmi.createDevice("VideoIR3");
        device2.setType(0);
        lstDevice.add(device2);
        
        //Construction des Devices tele type 1
        IDevice device3 = DataFactorySansRmi.createDevice("TeleIR1");
        device3.setType(1);
        lstDevice.add(device3);
        IDevice device4 = DataFactorySansRmi.createDevice("TeleIR2");
        device4.setType(1);
        lstDevice.add(device4);
        IDevice device5 = DataFactorySansRmi.createDevice("TeleIR3");
        device5.setType(1);
        lstDevice.add(device5);
        
//      Construction des Devices magnétoscope type 2
        IDevice device6 = DataFactorySansRmi.createDevice("MagnetoIR1");
        device6.setType(2);
        lstDevice.add(device6);
        IDevice device7 = DataFactorySansRmi.createDevice("MagnetoIR2");
        device7.setType(2);
        lstDevice.add(device7);
        IDevice device8 = DataFactorySansRmi.createDevice("MagnetoIR3");
        device8.setType(2);
        lstDevice.add(device8);
        
        return lstDevice;
    }*/
    
    /*
    public static List createRoomList()
    {
        List lstBuilding = new ArrayList();
        //Construction des Batiments
        IBuilding buildingCop = DataFactorySansRmi.createBuilding("Copernic");
        IBuilding buildingRab = DataFactorySansRmi.createBuilding("Rabelais");
        IBuilding buildingDes = DataFactorySansRmi.createBuilding("Descartes");
        
//      Construction des Etage
        IFloor floorCop1 = DataFactorySansRmi.createFloor("Etage1",buildingCop);
        IFloor floorCop2 = DataFactorySansRmi.createFloor("Etage2",buildingCop);
        IFloor floorCop3 = DataFactorySansRmi.createFloor("Etage3",buildingCop);
        IFloor floorCop4 = DataFactorySansRmi.createFloor("Etage4",buildingCop);
        
        IFloor floorRab1 = DataFactorySansRmi.createFloor("Etage1",buildingRab);
        IFloor floorRab2 = DataFactorySansRmi.createFloor("Etage2",buildingRab);
        IFloor floorRab3 = DataFactorySansRmi.createFloor("Etage3",buildingRab);
        
        IFloor floorDes1 = DataFactorySansRmi.createFloor("Etage1",buildingDes);
        IFloor floorDes2 = DataFactorySansRmi.createFloor("Etage2",buildingDes);

        */
        /*//Construction des salles
        IRoom RoomCop11 = DataFactorySansRmi.createRoom("Salle Cop11",0,30,floorCop1);
        IRoom RoomCop12 = DataFactorySansRmi.createRoom("Salle Cop12",1,20,floorCop1);
        IRoom RoomCop13 = DataFactorySansRmi.createRoom("Salle Cop13",2,10,floorCop1);
        IRoom RoomCop14 = DataFactorySansRmi.createRoom("Salle Cop14",0,40,floorCop1);
        
        IRoom RoomCop21 = DataFactorySansRmi.createRoom("Salle Cop21",0,30,floorCop2);
        IRoom RoomCop22 = DataFactorySansRmi.createRoom("Salle Cop22",1,20,floorCop2);
        IRoom RoomCop23 = DataFactorySansRmi.createRoom("Salle Cop23",2,10,floorCop2);
        IRoom RoomCop24 = DataFactorySansRmi.createRoom("Salle Cop24",1,10,floorCop2);
        IRoom RoomCop25 = DataFactorySansRmi.createRoom("Salle Cop25",2,20,floorCop2);
        
        IRoom RoomCop31 = DataFactorySansRmi.createRoom("Salle Cop31",0,30,floorCop3);
        
        //2eme batiment
        IRoom RoomRab11 = DataFactorySansRmi.createRoom("Salle Rab11",0,30,floorRab1);
        IRoom RoomRab12 = DataFactorySansRmi.createRoom("Salle Rab12",1,20,floorRab1);
        IRoom RoomRab13 = DataFactorySansRmi.createRoom("Salle Rab13",2,10,floorRab1);
        IRoom RoomRab14 = DataFactorySansRmi.createRoom("Salle Rab14",0,40,floorRab1);
        
        IRoom RoomRab31 = DataFactorySansRmi.createRoom("Salle Rab31",0,30,floorRab3);
        IRoom RoomRab32 = DataFactorySansRmi.createRoom("Salle Rab32",1,20,floorRab3);
        IRoom RoomRab33 = DataFactorySansRmi.createRoom("Salle Rab33",2,10,floorRab3);
        IRoom RoomRab34 = DataFactorySansRmi.createRoom("Salle Rab34",1,10,floorRab3);
        IRoom RoomRab35 = DataFactorySansRmi.createRoom("Salle Rab35",2,20,floorRab3);
        
        IRoom RoomRab21 = DataFactorySansRmi.createRoom("Salle Rab21",0,30,floorRab2);
        
        //3eme batiment
        IRoom RoomDes21 = DataFactorySansRmi.createRoom("Salle Des21",0,30,floorDes2);
        IRoom RoomDes22 = DataFactorySansRmi.createRoom("Salle Des22",1,20,floorDes2);
        IRoom RoomDes23 = DataFactorySansRmi.createRoom("Salle Des23",2,10,floorDes2);
        IRoom RoomDes24 = DataFactorySansRmi.createRoom("Salle Des24",0,40,floorDes2);
        
        IRoom RoomDes11 = DataFactorySansRmi.createRoom("Salle Des11",0,30,floorDes1);
        IRoom RoomDes12 = DataFactorySansRmi.createRoom("Salle Des12",1,20,floorDes1);
        IRoom RoomDes13 = DataFactorySansRmi.createRoom("Salle Des13",2,10,floorDes1);
        IRoom RoomDes14 = DataFactorySansRmi.createRoom("Salle Des14",1,10,floorDes1);
        IRoom RoomDes15 = DataFactorySansRmi.createRoom("Salle Des15",2,20,floorDes1);
        
        lstBuilding.add(buildingCop);
        lstBuilding.add(buildingRab);
        lstBuilding.add(buildingDes);
        return lstBuilding;
    }*/
    

}

