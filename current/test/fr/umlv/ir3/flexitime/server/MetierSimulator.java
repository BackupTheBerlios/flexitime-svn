/*
 * Created on 19 janv. 2005
 * by binou
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server;


import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.DataFactory;
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
public class MetierSimulator
{
    
    private static ITeacher midonnet;
    private static ITeacher revuz;
    private static ITeacher roussel;
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
        midonnet = DataFactory.createTeacher("Midonnet","jeCpasSonPrenom","midonnet@univ-mlv.fr");
        revuz = DataFactory.createTeacher("Revuz","Dominiqueuniquenique","revuz@univ-mlv.fr");
        roussel = DataFactory.createTeacher("Roussel","Gilles","groussel@univ-mlv.fr");
        copernic = DataFactory.createBuilding("Copernic");
        lavoisier = DataFactory.createBuilding("Lavoisier");
        premier = DataFactory.createFloor("1er etage", copernic);
        deuxiemme = DataFactory.createFloor("2eme etage", copernic);
        troisieme = DataFactory.createFloor("3eme etage", copernic);
        salleAuditorium = DataFactory.createRoom("Auditorium", RoomImpl.TYPE_COURS, 200, premier);
        salle2027 = DataFactory.createRoom("2027", RoomImpl.TYPE_MACHINE, 24, deuxiemme);
        salle2031 = DataFactory.createRoom("2031", RoomImpl.TYPE_MACHINE, 24, deuxiemme);
        salle2017 = DataFactory.createRoom("2017", RoomImpl.TYPE_COURS, 60, deuxiemme);
        salle3012 = DataFactory.createRoom("3012", RoomImpl.TYPE_COURS, 70, troisieme);
        videoproj1 = DataFactory.createDevice("VideoProj1", IDevice.VIDEOPROJECTOR);
        videoproj2 = DataFactory.createDevice("VideoProj1", IDevice.VIDEOPROJECTOR);
        tv1 = DataFactory.createDevice("TV1", IDevice.TV);
        tv2 = DataFactory.createDevice("TV2", IDevice.TV);
        magneto1 = DataFactory.createDevice("magneto1", IDevice.VIDEO_TAPE_RECORDER);
        magneto2 = DataFactory.createDevice("magneto2", IDevice.VIDEO_TAPE_RECORDER);
        
        ir = DataFactory.createTrack("Informatique & Réseaux");
        mfpi = DataFactory.createTrack("Informatique & Réseaux");
        gm = DataFactory.createTrack("Informatique & Réseaux");
        ir1 = DataFactory.createClass("1ere année" , ir);
        ir2 = DataFactory.createClass("2eme année" , ir);
        ir3 = DataFactory.createClass("3eme année" , ir);
        
        mfpi1 = DataFactory.createClass("1ere année" , mfpi);
        mfpi2 = DataFactory.createClass("2eme année" , mfpi);
        mfpi3 = DataFactory.createClass("3eme année" , mfpi);
        
        gm1 = DataFactory.createClass("1ere année" , gm);
        gm2 = DataFactory.createClass("2eme année" , gm);
        gm3 = DataFactory.createClass("3eme année" , gm);
        
        ir1_grp1 = DataFactory.createGroup("groupe 1" , 24 , ir1);
        ir1_grp2 = DataFactory.createGroup("groupe 2" , 24 , ir1);
        ir2_grp1 = DataFactory.createGroup("groupe 1" , 24 , ir2);
        ir2_grp2 = DataFactory.createGroup("groupe 2" , 24 , ir2);
        ir3_grp1 = DataFactory.createGroup("groupe 1" , 24 , ir3);
        ir3_grp2 = DataFactory.createGroup("groupe 2" , 24 , ir3);
        mfpi1_grp = DataFactory.createGroup("groupe 1" , 50 , mfpi1);
        mfpi2_grp = DataFactory.createGroup("groupe 1" , 50 , mfpi2);
        mfpi3_grp = DataFactory.createGroup("groupe 1" , 50 , mfpi3);
        gm1_grp1 = DataFactory.createGroup("groupe 1" , 24 , gm1);
        gm1_grp2 = DataFactory.createGroup("groupe 2" , 24 , gm1);
        gm1_grp3 = DataFactory.createGroup("groupe 3" , 24 , gm1);
        gm2_grp1 = DataFactory.createGroup("groupe 1" , 24 , gm2);
        gm2_grp2 = DataFactory.createGroup("groupe 2" , 24 , gm2);
        gm3_grp1 = DataFactory.createGroup("groupe 2" , 24 , gm3);
        
        
        ts_ir1 = DataFactory.createTeachingStructure("ts ir 1", ir1);
        ts_ir2 = DataFactory.createTeachingStructure("ts ir 1", ir2);
        ts_ir3 = DataFactory.createTeachingStructure("ts ir 1", ir3);
        ts_gm1 = DataFactory.createTeachingStructure("ts gm 1", gm1);
        ts_gm2 = DataFactory.createTeachingStructure("ts gm 2", gm2);
        ts_gm3 = DataFactory.createTeachingStructure("ts gm 3", gm3);
        
        
        ir1_bloc1 = DataFactory.createSubjectsGroup("General", ts_ir1);
        ir1_bloc2 = DataFactory.createSubjectsGroup("Math", ts_ir1);
        ir2_bloc1 = DataFactory.createSubjectsGroup("General", ts_ir2);
        ir2_bloc2 = DataFactory.createSubjectsGroup("developpement!!!", ts_ir2);
        ir3_bloc1 = DataFactory.createSubjectsGroup("General", ts_ir3);
        ir3_bloc2 = DataFactory.createSubjectsGroup("Rezo", ts_ir3);
        
        ir3_bloc1_sub1 = DataFactory.createSubject("J2EE" , ir3_bloc1);
        ir3_bloc1_sub2 = DataFactory.createSubject("GL" , ir3_bloc1);
        ir3_bloc1_sub3 = DataFactory.createSubject("Exposé système" , ir3_bloc1);
        ir3_bloc2_sub1 = DataFactory.createSubject("Corba" , ir3_bloc2);
        ir3_bloc2_sub2 = DataFactory.createSubject("Modelisation des ReZo" , ir3_bloc2);
        ir3_bloc2_sub3 = DataFactory.createSubject("Exposé ReZo" , ir3_bloc2);
        
        j2ee_cours = DataFactory.createCourse("Cours J2EE", ir3_bloc1_sub1 , ICourse.CM, 120, 20 , Color.MAGENTA, createList(roussel));
        j2ee_td = DataFactory.createCourse("TD J2EE", ir3_bloc1_sub1 , ICourse.TD, 240, 20 , Color.MAGENTA, createList(roussel));
        gl_cours = DataFactory.createCourse("Cours GL", ir3_bloc1_sub2 , ICourse.CM, 120, 20 , Color.CYAN, createList(revuz));
        gl_td = DataFactory.createCourse("TD GL", ir3_bloc1_sub2 , ICourse.TD, 120, 20 , Color.BLUE, createList(revuz));
        corba_cours = DataFactory.createCourse("Cours Corba", ir3_bloc2_sub1 , ICourse.CM, 120, 20 , Color.CYAN, createList(midonnet));
        corba_td = DataFactory.createCourse("TD Corba", ir3_bloc2_sub1 , ICourse.TD, 120, 20 , Color.BLUE, createList(midonnet));
        
        List<IGroup> groups_td = new ArrayList(1);
        groups_td.add(ir3_grp2);
        List<IGroup> groups_cm = new ArrayList(1);
        groups_cm.add(ir3_grp1);
        groups_cm.add(ir3_grp2);
        lesson1 = DataFactory.createLesson(new Gap(2005,1,3,8,30,2005,1,3,10,30), j2ee_cours, groups_cm, roussel);
        lesson2 = DataFactory.createLesson(new Gap(2005,1,3,13,45,2005,1,3,15,45), corba_cours, groups_cm, midonnet);        
        lesson3 = DataFactory.createLesson(new Gap(2005,1,4,16,00,2005,1,4,18,00), gl_cours, groups_cm, revuz);
        lesson4 = DataFactory.createLesson(new Gap(2005,1,5,8,30,2005,1,5,10,30), gl_td, groups_td, revuz);
        lesson5 = DataFactory.createLesson(new Gap(2005,1,6,8,30,2005,1,6,10,30), corba_td, groups_td, roussel);
        lesson6 = DataFactory.createLesson(new Gap(2005,1,11,8,30,2005,1,11,10,30), corba_td, groups_td, roussel);
        lesson7 = DataFactory.createLesson(new Gap(2005,1,19,8,30,2005,1,19,10,30), corba_td, groups_td, roussel);
        lesson8 = DataFactory.createLesson(new Gap(2005,1,21,8,30,2005,1,21,10,30), corba_td, groups_td, roussel);
        lesson9 = DataFactory.createLesson(new Gap(2005,1,28,8,30,2005,1,28,10,30), corba_td, groups_td, roussel);
        
        lesson1.addResource(salle2017);
        lesson2.addResource(salle2017);
        lesson3.addResource(salle2017);
        lesson4.addResource(salle2027);
        lesson5.addResource(salle2027);
        
        /*ir3_grp2.addBusy(lesson1);
        ir3_grp2.addBusy(lesson2);
        ir3_grp2.addBusy(lesson3);
        ir3_grp2.addBusy(lesson4);
        ir3_grp2.addBusy(lesson5);
        
        roussel.addBusy(lesson1);
        midonnet.addBusy(lesson2);
        revuz.addBusy(lesson3);
        revuz.addBusy(lesson4);
        roussel.addBusy(lesson5);
        
        salle2017.addBusy(lesson1);
        salle2017.addBusy(lesson2);
        salle2017.addBusy(lesson3);
        salle2027.addBusy(lesson4);
        salle2027.addBusy(lesson5);*/
        

        
        
        
        
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
    
    
    
    /** 
     * @return dsfsd
     */
    /*public static List<ILesson> getLessonsList()
    {
        List<ILesson> res = new ArrayList<ILesson>(3);
        res.add(DataFactory.createLesson(new Gap(2005,1,3,8,30,2005,1,3,10,30) , new CourseImpl("Corba",null,120, 1,50,Color.YELLOW,null) , 120 )   );
        res.add(DataFactory.createLesson(new Gap(2005,1,3,13,45,2005,1,3,15,45) , new CourseImpl("J2EE",null,120, 1,50,Color.MAGENTA,null) , 120    )   );
        res.add(DataFactory.createLesson(new Gap(2005,1,3,16,00,2005,1,3,17,00) , new CourseImpl("MSI",null,60, 1,50,Color.GREEN,null), 60));
        
        res.add(DataFactory.createLesson(new Gap(2005,1,4,8,30,2005,1,4,12,45) , new CourseImpl("J2EE",null,240, 1,50,Color.MAGENTA,null), 240));
        res.add(DataFactory.createLesson(new Gap(2005,1,4,13,45,2005,1,4,15,45) , new CourseImpl("Corba",null,120, 1,50,Color.YELLOW,null), 120));
        res.add(DataFactory.createLesson(new Gap(2005,1,4,16,00,2005,1,4,17,30) , new CourseImpl("MSI",null,12090, 1,50,Color.GREEN,null), 90));

        res.add(DataFactory.createLesson(new Gap(2005,1,5,10,45,2005,1,5,12,45) , new CourseImpl("J2EE",null,120, 1,50,Color.MAGENTA,null), 120));
        res.add(DataFactory.createLesson(new Gap(2005,1,5,13,30,2005,1,5,15,30) , new CourseImpl("Corba",null,120, 1,50,Color.YELLOW,null), 120));
        res.add(DataFactory.createLesson(new Gap(2005,1,5,16,00,2005,1,5,18,00) , new CourseImpl("MSI",null,120, 1,50,Color.GREEN,null), 120));

        res.add(DataFactory.createLesson(new Gap(2005,1,6,8,30,2005,1,6,10,30) , new CourseImpl("MSI",null,120, 1,50,Color.GREEN,null), 120));
        res.add(DataFactory.createLesson(new Gap(2005,1,6,10,45,2005,1,6,12,45) , new CourseImpl("Corba",null,120, 1,50,Color.YELLOW,null), 120));
        res.add(DataFactory.createLesson(new Gap(2005,1,6,13,45,2005,1,6,18,00) , new CourseImpl("J2EE",null,240, 1,50,Color.MAGENTA,null), 240));

        
        res.add(DataFactory.createLesson(new Gap(2005,1,7,13,45,2005,1,7,15,45) , new CourseImpl("J2EE",null,120, 1,50,Color.MAGENTA,null), 120));
        res.add(DataFactory.createLesson(new Gap(2005,1,7,16,00,2005,1,7,17,00) , new CourseImpl("Corba",null,60, 1,50,Color.YELLOW,null), 60));
        res.add(DataFactory.createLesson(new Gap(2005,1,7,17,00,2005,1,7,18,00) , new CourseImpl("MSI",null,60, 1,50,Color.GREEN,null), 60));

        res.add(DataFactory.createLesson(new Gap(2005,1,10,11,45,2005,1,10,12,45) , new CourseImpl("J2EE",null,60, 1,50,Color.MAGENTA,null), 60));
        res.add(DataFactory.createLesson(new Gap(2005,1,10,13,45,2005,1,10,15,45) , new CourseImpl("Corba",null,120, 1,50,Color.YELLOW,null), 120));
        res.add(DataFactory.createLesson(new Gap(2005,1,10,16,00,2005,1,10,18,00) , new CourseImpl("MSI",null,120, 1,50,Color.GREEN,null), 120));

        res.add(DataFactory.createLesson(new Gap(2005,1,11,16,00,2005,1,11,18,00) , new CourseImpl("MSI",null,120, 1,50,Color.GREEN,null), 120));
        
        
        res.add(DataFactory.createLesson(new Gap(2005,1,12,8,30,2005,1,12,10,30) , new CourseImpl("Corba",null,120, 1,50,Color.YELLOW,null), 120));
        res.add(DataFactory.createLesson(new Gap(2005,1,12,13,45,2005,1,12,15,45) , new CourseImpl("J2EE",null,120, 1,50,Color.MAGENTA,null), 120));

        
        res.add(DataFactory.createLesson(new Gap(2005,1,13,8,30,2005,1,13,10,30) , new CourseImpl("Corba",null,120, 1,50,Color.YELLOW,null), 120));
        res.add(DataFactory.createLesson(new Gap(2005,1,13,13,45,2005,1,13,15,45) , new CourseImpl("J2EE",null,120, 1,50,Color.MAGENTA,null), 120));
        res.add(DataFactory.createLesson(new Gap(2005,1,13,16,00,2005,1,13,17,00) , new CourseImpl("MSI",null,60, 1,50,Color.GREEN,null), 60));

        
        res.add(DataFactory.createLesson(new Gap(2005,1,14,8,30,2005,1,14,10,30) , new CourseImpl("Corba",null,120, 1,50,Color.YELLOW,null), 120));
        
        
        res.add(DataFactory.createLesson(new Gap(2005,1,19,8,30,2005,1,19,10,30) , new CourseImpl("J2EE",null,120, 1,50,Color.MAGENTA,null), 120));
        res.add(DataFactory.createLesson(new Gap(2005,1,19,16,00,2005,1,3,17,00) , new CourseImpl("MSI",null,60, 1,50,Color.GREEN,null), 60));

        res.add(DataFactory.createLesson(new Gap(2005,1,27,10,00,2005,1,19,12,00) , new CourseImpl("MSI",null,120, 1,50,Color.GREEN,null), 120));
        res.add(DataFactory.createLesson(new Gap(2005,1,27,14,30,2005,1,19,17,30) , new CourseImpl("Corba",null,180, 1,50,Color.YELLOW,null), 180));
        res.add(DataFactory.createLesson(new Gap(2005,1,28,10,45,2005,1,19,12,45) , new CourseImpl("J2EE",null,120, 1,50,Color.MAGENTA,null), 120));
        
        res.add(DataFactory.createLesson(new Gap(2005,1,31,1,0,2005,1,19,18,05) , new CourseImpl("J2EE",null,120, 1,50,Color.CYAN,null), 120));

        
        return res;
    }*/
    
    
    public static List createTrackList()
    {
        //Construction des Track
        ITrack trackIR = DataFactory.createTrack("IR");
        ITrack trackMF = DataFactory.createTrack("MF");
        ITrack trackEI = DataFactory.createTrack("EI");
        //Construction des class
        IClass classIR1 = DataFactory.createClass("IR1",trackIR);
        IClass classIR2 = DataFactory.createClass("IR2",trackIR);
        IClass classIR3 = DataFactory.createClass("IR3",trackIR);
        IClass classMF1 = DataFactory.createClass("MF1",trackMF);
        IClass classMF2 = DataFactory.createClass("MF2",trackMF);
        IClass classMF3 = DataFactory.createClass("MF3",trackMF);
        IClass classEI1 = DataFactory.createClass("EI1",trackEI);
        IClass classEI2 = DataFactory.createClass("EI2",trackEI);
        IClass classEI3 = DataFactory.createClass("EI3",trackEI);
        
        //Construction des groupes
        //IR1
        IGroup groupIR11 = DataFactory.createGroup("group1",10,classIR1);
        IGroup groupIR12 = DataFactory.createGroup("group2",10,classIR1);
        //IR2
        IGroup groupIR21 = DataFactory.createGroup("group1",10,classIR2);
        IGroup groupIR22 = DataFactory.createGroup("group2",10,classIR2);
//      IR3
        IGroup groupIR31 = DataFactory.createGroup("group1",10,classIR3);
        IGroup groupIR32 = DataFactory.createGroup("group2",10,classIR3);
//      MF1
        IGroup groupMF11 = DataFactory.createGroup("group1",10,classMF1);
        IGroup groupMF12 = DataFactory.createGroup("group2",10,classMF1);
//      MF2
        IGroup groupMF21 = DataFactory.createGroup("group1",10,classMF2);
        IGroup groupMF22 = DataFactory.createGroup("group2",10,classMF2);
//      MF3
        IGroup groupMF31 = DataFactory.createGroup("group1",10,classMF3);
        IGroup groupMF32 = DataFactory.createGroup("group2",10,classMF3);
//      EI1
        IGroup groupEI11 = DataFactory.createGroup("group1",10,classEI1);
        IGroup groupEI12 = DataFactory.createGroup("group2",10,classEI1);
//      EI2
        IGroup groupEI21 = DataFactory.createGroup("group1",10,classEI2);
        IGroup groupEI22 = DataFactory.createGroup("group2",10,classEI2);
//      EI3
        IGroup groupEI31 = DataFactory.createGroup("group1",10,classEI3);
        IGroup groupEI32 = DataFactory.createGroup("group2",10,classEI3);

        List lstTrack = new ArrayList();
        lstTrack.add(trackIR);
        lstTrack.add(trackMF);
        lstTrack.add(trackEI);
        
        return lstTrack;
    }
    
    public static List createDeviceList()
    {
        List lstDevice = new ArrayList();
        //Construction des Devices videoproj type 0
        IDevice device = DataFactory.createDevice("VideoIR1");
        device.setType(0);
        lstDevice.add(device);
        IDevice device1 = DataFactory.createDevice("VideoIR2");
        device1.setType(0);
        lstDevice.add(device1);
        IDevice device2 = DataFactory.createDevice("VideoIR3");
        device2.setType(0);
        lstDevice.add(device2);
        
        //Construction des Devices tele type 1
        IDevice device3 = DataFactory.createDevice("TeleIR1");
        device3.setType(1);
        lstDevice.add(device3);
        IDevice device4 = DataFactory.createDevice("TeleIR2");
        device4.setType(1);
        lstDevice.add(device4);
        IDevice device5 = DataFactory.createDevice("TeleIR3");
        device5.setType(1);
        lstDevice.add(device5);
        
//      Construction des Devices magnétoscope type 2
        IDevice device6 = DataFactory.createDevice("MagnetoIR1");
        device6.setType(2);
        lstDevice.add(device6);
        IDevice device7 = DataFactory.createDevice("MagnetoIR2");
        device7.setType(2);
        lstDevice.add(device7);
        IDevice device8 = DataFactory.createDevice("MagnetoIR3");
        device8.setType(2);
        lstDevice.add(device8);
        
        return lstDevice;
    }
    
    
    public static List createRoomList()
    {
        List lstBuilding = new ArrayList();
        //Construction des Batiments
        IBuilding buildingCop = DataFactory.createBuilding("Copernic");
        IBuilding buildingRab = DataFactory.createBuilding("Rabelais");
        IBuilding buildingDes = DataFactory.createBuilding("Descartes");
        
//      Construction des Etage
        IFloor floorCop1 = DataFactory.createFloor("Etage1",buildingCop);
        IFloor floorCop2 = DataFactory.createFloor("Etage2",buildingCop);
        IFloor floorCop3 = DataFactory.createFloor("Etage3",buildingCop);
        IFloor floorCop4 = DataFactory.createFloor("Etage4",buildingCop);
        
        IFloor floorRab1 = DataFactory.createFloor("Etage1",buildingRab);
        IFloor floorRab2 = DataFactory.createFloor("Etage2",buildingRab);
        IFloor floorRab3 = DataFactory.createFloor("Etage3",buildingRab);
        
        IFloor floorDes1 = DataFactory.createFloor("Etage1",buildingDes);
        IFloor floorDes2 = DataFactory.createFloor("Etage2",buildingDes);

        
        /*//Construction des salles
        IRoom RoomCop11 = DataFactory.createRoom("Salle Cop11",0,30,floorCop1);
        IRoom RoomCop12 = DataFactory.createRoom("Salle Cop12",1,20,floorCop1);
        IRoom RoomCop13 = DataFactory.createRoom("Salle Cop13",2,10,floorCop1);
        IRoom RoomCop14 = DataFactory.createRoom("Salle Cop14",0,40,floorCop1);
        
        IRoom RoomCop21 = DataFactory.createRoom("Salle Cop21",0,30,floorCop2);
        IRoom RoomCop22 = DataFactory.createRoom("Salle Cop22",1,20,floorCop2);
        IRoom RoomCop23 = DataFactory.createRoom("Salle Cop23",2,10,floorCop2);
        IRoom RoomCop24 = DataFactory.createRoom("Salle Cop24",1,10,floorCop2);
        IRoom RoomCop25 = DataFactory.createRoom("Salle Cop25",2,20,floorCop2);
        
        IRoom RoomCop31 = DataFactory.createRoom("Salle Cop31",0,30,floorCop3);
        
        //2eme batiment
        IRoom RoomRab11 = DataFactory.createRoom("Salle Rab11",0,30,floorRab1);
        IRoom RoomRab12 = DataFactory.createRoom("Salle Rab12",1,20,floorRab1);
        IRoom RoomRab13 = DataFactory.createRoom("Salle Rab13",2,10,floorRab1);
        IRoom RoomRab14 = DataFactory.createRoom("Salle Rab14",0,40,floorRab1);
        
        IRoom RoomRab31 = DataFactory.createRoom("Salle Rab31",0,30,floorRab3);
        IRoom RoomRab32 = DataFactory.createRoom("Salle Rab32",1,20,floorRab3);
        IRoom RoomRab33 = DataFactory.createRoom("Salle Rab33",2,10,floorRab3);
        IRoom RoomRab34 = DataFactory.createRoom("Salle Rab34",1,10,floorRab3);
        IRoom RoomRab35 = DataFactory.createRoom("Salle Rab35",2,20,floorRab3);
        
        IRoom RoomRab21 = DataFactory.createRoom("Salle Rab21",0,30,floorRab2);
        
        //3eme batiment
        IRoom RoomDes21 = DataFactory.createRoom("Salle Des21",0,30,floorDes2);
        IRoom RoomDes22 = DataFactory.createRoom("Salle Des22",1,20,floorDes2);
        IRoom RoomDes23 = DataFactory.createRoom("Salle Des23",2,10,floorDes2);
        IRoom RoomDes24 = DataFactory.createRoom("Salle Des24",0,40,floorDes2);
        
        IRoom RoomDes11 = DataFactory.createRoom("Salle Des11",0,30,floorDes1);
        IRoom RoomDes12 = DataFactory.createRoom("Salle Des12",1,20,floorDes1);
        IRoom RoomDes13 = DataFactory.createRoom("Salle Des13",2,10,floorDes1);
        IRoom RoomDes14 = DataFactory.createRoom("Salle Des14",1,10,floorDes1);
        IRoom RoomDes15 = DataFactory.createRoom("Salle Des15",2,20,floorDes1);
        */
        lstBuilding.add(buildingCop);
        lstBuilding.add(buildingRab);
        lstBuilding.add(buildingDes);
        return lstBuilding;
    }
    
    public static List createTeacherList()
    {
        List lstTeacher = new ArrayList();
        
        midonnet = DataFactory.createTeacher("Midonnet","jeCpasSonPrenom","midonnet@univ-mlv.fr");
        lstTeacher.add(midonnet);
        revuz = DataFactory.createTeacher("Revuz","Dominiqueuniquenique","revuz@univ-mlv.fr");
        lstTeacher.add(revuz);
        roussel = DataFactory.createTeacher("Roussel","Gilles","groussel@univ-mlv.fr");
        lstTeacher.add(roussel);
        
        return lstTeacher;
    }

}

