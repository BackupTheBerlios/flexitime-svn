/*
 * Created on 5 janv. 2005
 * by Famille
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.tools;

import java.util.*;

import fr.umlv.ir3.flexitime.common.data.*;
import fr.umlv.ir3.flexitime.common.data.activity.*;
import fr.umlv.ir3.flexitime.common.data.general.*;
import fr.umlv.ir3.flexitime.common.data.resources.*;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.*;
import junit.framework.TestCase;


/**
 * DOCME
 * 
 * @version 240
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class TestStatistics extends TestCase {
    
    /**
     * DOCME
     */
    public void testGetStatTeacher()
    {
        //Liste de noms de profs
        String[] profName = new String[]{"Revuz","Forax","Calmejane"};
        //Liste de noms de groupe
        String[] groupName = new String[]{"Groupe1","Groupe2"};
        //Liste de noms de cours
        String[] coursName = new String[]{"Cours1","Cours2","Cours3"};
        //Liste de noms de lesson
        String[] lessonName = new String[]{"Cours Revuz","TD Forax","TD Calmejane"};
        
        //Creation des profs
        ITeacher t1 = DataFactory.createTeacher(profName[0], "prenom");
        ITeacher t2 = DataFactory.createTeacher(profName[1], "prenom");
        
        //Creation des groupes
        ITrack track = DataFactory.createTrack("IR");
        IClass class1 = DataFactory.createClass("IR3", track);
        IGroup g1 = DataFactory.createGroup(groupName[0], 22, class1);
        IGroup g2 = DataFactory.createGroup(groupName[1], 21, class1);
        
        //Creation des cours
        ITeachingStructure structure = DataFactory.createTeachingStructure("Struct", class1);
        ISubjectsGroup subjectsGroup = DataFactory.createSubjectsGroup("SI", structure);
        ISubject subject = DataFactory.createSubject("GL", subjectsGroup);
        ICourse c1 = DataFactory.createCourse("Projet", subject, ICourse.TP);
        ICourse c2 = DataFactory.createCourse("Cours", subject, ICourse.CM);
        
        //Initialisation de leur nombre d'heure
        c1.setNbHours(2);
        c2.setNbHours(2);
        
        //Creation des list de ressources
        Set<IResource> lr1 = new HashSet<IResource>();
        Set<IResource> lr2 = new HashSet<IResource>();
        Set<IResource> lr3 = new HashSet<IResource>();
        
        //Creation des liste de lessons
        ILesson li1 = DataFactory.createLesson(new Gap(), c1, 2);
        li1.addResource(t1);
        li1.addResource(g1);
        
       	ILesson li2 = DataFactory.createLesson(new Gap(), c2, 4);
        li1.addResource(t2);
        li1.addResource(g2);
       	
    	//Creation list des profs
    	List<ITeacher> lstProfs = new ArrayList<ITeacher>();
    	lstProfs.add(t1);
    	lstProfs.add(t2);
    
    	//On parcours la liste des profs
    	Iterator itLstProfs = lstProfs.iterator();
    	int iCptT = 0;
    	while(itLstProfs.hasNext()){
    	    ITeacher teacher = (ITeacher) itLstProfs.next();
    	    //On compare chaque nom de prof
    	    if(teacher.getName().compareTo(profName[iCptT])!=0)fail("Nom prof");
    	    List listStatProf = Statistics.getStatTeacher(teacher);
    	    //On parcours toutes les stat d'un prof
    	    Iterator itProf = listStatProf.iterator();
    	    while(itProf.hasNext()){
    	        Statistics stat = (Statistics) itProf.next(); 
    	        String groupe1 = (String)stat.getGroups().get(0);
    	        String groupe2 = (String)stat.getGroups().get(1);
    	        //On compare tous les groupes de la stat
    	        if(groupe1.compareTo(groupName[0])!=0)fail("Nom groupe");
    	        if(groupe2.compareTo(groupName[1])!=0)fail("Nom groupe");
    	        //On compare le nombre d'heure de tous les cours de la stat
    	        if(((Integer)(stat.getCoursesTodo().get(coursName[iCptT]))).compareTo(new Integer(2))!=0)fail();
        	}
    	    iCptT++;
    	}
    }
    
    /**
     * DOCME 
     */
    public void testGetStatGroup()
    {
        //Liste de noms de profs
        String[] profName = new String[]{"Revuz","Forax","Calmejane"};
        //Liste de noms de groupe
        String[] groupName = new String[]{"Groupe1","Groupe2"};
        //Liste de noms de cours
        String[] coursName = new String[]{"Cours1","Cours2","Cours3"};
        //Liste de noms de lesson
        String[] lessonName = new String[]{"Cours Revuz","TD Forax","TD Calmejane"};
        
        //Creation des profs
        ITeacher t1 = DataFactory.createTeacher(profName[0], "prenom");
        ITeacher t2 = DataFactory.createTeacher(profName[1], "prenom");
        
        //Creation des groupes
        ITrack track = DataFactory.createTrack("IR");
        IClass class1 = DataFactory.createClass("IR3", track);
        IGroup g1 = DataFactory.createGroup(groupName[0], 22, class1);
        IGroup g2 = DataFactory.createGroup(groupName[1], 21, class1);
        
        //Creation des cours
        ITeachingStructure structure = DataFactory.createTeachingStructure("Struct", class1);
        ISubjectsGroup subjectsGroup = DataFactory.createSubjectsGroup("SI", structure);
        ISubject subject = DataFactory.createSubject("GL", subjectsGroup);
        ICourse c1 = DataFactory.createCourse("Projet", subject, ICourse.TP);
        ICourse c2 = DataFactory.createCourse("Cours", subject, ICourse.CM);
        
        //Initialisation de leur nombre d'heure
        c1.setNbHours(2);
        c2.setNbHours(2);
        
        //Creation des list de ressources
        Set<IResource> lr1 = new HashSet<IResource>();
        Set<IResource> lr2 = new HashSet<IResource>();
        Set<IResource> lr3 = new HashSet<IResource>();
        
        //Creation des liste de lessons
        ILesson li1 = DataFactory.createLesson(new Gap(), c1, 2);
        li1.addResource(t1);
        li1.addResource(g1);
        
        ILesson li2 = DataFactory.createLesson(new Gap(), c2, 4);
        li1.addResource(t2);
        li1.addResource(g2);
        
     	//Creation list des groupes
    	List<IGroup> lstGroupes = new ArrayList<IGroup>();
    	lstGroupes.add(g1);
    	lstGroupes.add(g2);
    	
        Iterator itLstGroups = lstGroupes.iterator();
       int iCptGroup = 0;
        while(itLstGroups.hasNext())
        {
            IGroup groupe = (IGroup) itLstGroups.next();
            //On compare chaque nom de groupe
            if(groupe.getName().compareTo(groupName[iCptGroup])!=0)fail("Nom groupe");
            //On parcours ensuite les statistique de chaque groupe
            List listGroup = Statistics.getStatGroup(groupe);
            if(((Integer)(((Statistics)(listGroup.get(0))).getCoursesTodo().get(coursName[0]))).intValue() != 2)fail("Nom cours"); 
            iCptGroup++;
        }
    }
 
/*
    public static void main(String[] args){
        TeacherImpl t1 = new TeacherImpl("Revuz");
        TeacherImpl t2 = new TeacherImpl("Forax");
        TeacherImpl t3 = new TeacherImpl("CalmeJane");
        GroupImpl g1 = new GroupImpl("Groupe 1");
        GroupImpl g2 = new GroupImpl("Groupe 2");
        CourseImpl c1 = new CourseImpl("cours1");
        c1.setNbHours(2);
        CourseImpl c2 = new CourseImpl("cours2");
        c2.setNbHours(2);
        CourseImpl c3 = new CourseImpl("cours3");
        c3.setNbHours(2);
        LessonImpl li1 = new LessonImpl("Cours Revuz");
        li1.addResource(t1);
        li1.addResource(g1);
        li1.addResource(g2);
        li1.setCourse(c1);
        li1.setStartDate(new Date());
        li1.setEndDate(new Date());
        LessonImpl li2 = new LessonImpl("TD Forax");
        li2.addResource(t2);
        li2.addResource(g1);
        li2.setCourse(c2);
        li2.setStartDate(new Date());
        li2.setEndDate(new Date());
        LessonImpl li3 = new LessonImpl("TD Calmejane");
        li3.addResource(t3);
        li3.addResource(g2);
        li3.setCourse(c3);
        li3.setStartDate(new Date());
        li3.setEndDate(new Date());
        List<IBusy> busy1 = new ArrayList<IBusy>();
        busy1.add(li1);
        List<IBusy> busy2 = new ArrayList<IBusy>();
        busy2.add(li2);
        List<IBusy> busy3 = new ArrayList<IBusy>();
        busy3.add(li3);
        t1.setLstBusy(busy1);
        t2.setLstBusy(busy2);
        t3.setLstBusy(busy3);
        List<IBusy> busy4 = new ArrayList<IBusy>();
        busy4.add(li1);
        busy4.add(li2);
        List<IBusy> busy5 = new ArrayList<IBusy>();
        busy5.add(li1);
        busy5.add(li3);
        g1.setLstBusy(busy4);
        g2.setLstBusy(busy5);
        List<ITeacher> lstProfs = new ArrayList<ITeacher>();
        lstProfs.add(t1);
        lstProfs.add(t2);
        lstProfs.add(t3);
        List<IGroup> lstGroupes = new ArrayList<IGroup>();
        lstGroupes.add(g1);
        lstGroupes.add(g2);
        
        Iterator itLstProfs = lstProfs.iterator();
        while(itLstProfs.hasNext()){
            ITeacher teacher = (ITeacher) itLstProfs.next();
            System.out.println("---------------------------------");
            System.out.println("Statistiques du prof : "+teacher.getName());
            List listStatProf = Statistics.getStatTeacher(teacher);
            Iterator itProf = listStatProf.iterator();
            while(itProf.hasNext()){
                System.out.println("----");
                Statistics stat = (Statistics) itProf.next(); 
                System.out.println("Pour les groupes:");
                Iterator itGroup = stat.getGroups().iterator();
                while(itGroup.hasNext()){
                    System.out.println(itGroup.next());
                }
                System.out.println("Le cours est:");
                System.out.println(stat.getCourseName()+" : "+stat.getNbHours()+"h effectuées");
            }
        }
        Iterator itLstGroups = lstGroupes.iterator();
        while(itLstGroups.hasNext()){
            IGroup groupe = (IGroup) itLstGroups.next();
            System.out.println("---------------------------------");
            System.out.println("Statistiques du groupe : "+groupe.getName());
            List listGroup = Statistics.getStatGroup(groupe);
            Iterator itGroup = listGroup.iterator();
            while(itGroup.hasNext()){
                System.out.println("----");
                Statistics stat = (Statistics) itGroup.next(); 
                System.out.println("Le cours est:");
                System.out.println(stat.getCourseName()+" : "+stat.getNbHours()+"h effectuées");
            }
        }
    }
*/
}
