/*
 * Created on 5 janv. 2005
 * by Famille
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.tools;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import fr.umlv.ir3.flexitime.common.data.activity.impl.LessonImpl;
import fr.umlv.ir3.flexitime.common.data.resources.IGroup;
import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;
import fr.umlv.ir3.flexitime.common.data.resources.impl.GroupImpl;
import fr.umlv.ir3.flexitime.common.data.resources.impl.TeacherImpl;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.impl.CourseImpl;
import junit.framework.TestCase;


/**
 * TestStatistiqueImpl - DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * @see (si nécessaire)
 * 
 * @author FlexiTeam - Famille
 */
public class TestStatistics extends TestCase {
    
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
        TeacherImpl t1 = new TeacherImpl(profName[0]);
        TeacherImpl t2 = new TeacherImpl(profName[1]);
        TeacherImpl t3 = new TeacherImpl(profName[2]);
        
        //Creation des groupes
        GroupImpl g1 = new GroupImpl(groupName[0]);
        GroupImpl g2 = new GroupImpl(groupName[1]);
        
        //Creation des cours
        CourseImpl c1 = new CourseImpl(coursName[0]);
        CourseImpl c2 = new CourseImpl(coursName[1]);
        CourseImpl c3 = new CourseImpl(coursName[2]);
        //Initialisation de leur nombre d'heure
        c1.setNbHours(2);
        c2.setNbHours(2);
        c3.setNbHours(2);
        
        //Creation des list de ressources
        List lr1 = new ArrayList();
        List lr2 = new ArrayList();
        List lr3 = new ArrayList();
        
        //Initialisation des list de ressources
        //liste1
        lr1.add(t1);
        lr1.add(g1);
        lr1.add(g2);
        lr1.add(c1);
        //liste2
        lr2.add(t2);
        lr2.add(g1);
        lr2.add(g2);
        lr2.add(c2);
        //liste3
        lr3.add(t3);
        lr3.add(g1);
        lr3.add(g2);
        lr3.add(c3);
        
        //Creation des liste de lessons
        LessonImpl li1 = new LessonImpl(lessonName[0],new Date(),new Date());
       	LessonImpl li2 = new LessonImpl(lessonName[0],new Date(),new Date());
       	LessonImpl li3 = new LessonImpl(lessonName[0],new Date(),new Date());
       	//Initialisation de celle ci avec les différntes liste de ressources
       	li1.setLstResource(lr1);
       	li2.setLstResource(lr2);
       	li3.setLstResource(lr3);
       	
       	//Creation des list de Lesson pour les professeurs
       	List busy1 = new ArrayList();
       	List busy2 = new ArrayList();
       	List busy3 = new ArrayList();
    	//Initialisation de celle ci avec les lessons
       	busy1.add(li1);
    	busy2.add(li2);
    	busy3.add(li3);
    	//Assignement des listes de lessons au prof 
    	t1.setLstBusy(busy1);
    	t2.setLstBusy(busy2);
    	t3.setLstBusy(busy3);
    	
    	//Creation des list de lessons pour les groups
    	List busy4 = new ArrayList();
    	List busy5 = new ArrayList();
    	//Initialisation de celle-ci
    	busy4.add(li1);
    	busy4.add(li2);
    	busy5.add(li1);
    	busy5.add(li3);
    	//Assignagnement aux groupes
    	g1.setLstBusy(busy4);
    	g2.setLstBusy(busy5);
    	
    	//Creation list des profs
    	List lstProfs = new ArrayList();
    	lstProfs.add(t1);
    	lstProfs.add(t2);
    	lstProfs.add(t3);
    	
   
    
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
        
//      Creation des profs
        TeacherImpl t1 = new TeacherImpl(profName[0]);
        TeacherImpl t2 = new TeacherImpl(profName[1]);
        TeacherImpl t3 = new TeacherImpl(profName[2]);
        
        //Creation des groupes
        GroupImpl g1 = new GroupImpl(groupName[0]);
        GroupImpl g2 = new GroupImpl(groupName[1]);
        
        //Creation des cours
        CourseImpl c1 = new CourseImpl(coursName[0]);
        CourseImpl c2 = new CourseImpl(coursName[1]);
        CourseImpl c3 = new CourseImpl(coursName[2]);
        //Initialisation de leur nombre d'heure
        c1.setNbHours(2);
        c2.setNbHours(2);
        c3.setNbHours(2);
        
        //      Creation des list de ressources
        List lr1 = new ArrayList();
        List lr2 = new ArrayList();
        List lr3 = new ArrayList();
        
        //Initialisation des list de ressources
        //liste1
        lr1.add(t1);
        lr1.add(g1);
        lr1.add(g2);
        lr1.add(c1);
        //liste2
        lr2.add(t2);
        lr2.add(g1);
        lr2.add(g2);
        lr2.add(c2);
        //liste3
        lr3.add(t3);
        lr3.add(g2);
        lr3.add(c3);
       
        //Creation des liste de lessons
        LessonImpl li1 = new LessonImpl(lessonName[0],new Date(),new Date());
       	LessonImpl li2 = new LessonImpl(lessonName[1],new Date(),new Date());
       	LessonImpl li3 = new LessonImpl(lessonName[2],new Date(),new Date());
       	//Initialisation de celle ci avec les différntes liste de ressources
       	li1.setLstResource(lr1);
       	li2.setLstResource(lr2);
       	li3.setLstResource(lr3);
        
       	

       	//Creation des list de lessons pour les groups
    	List busy4 = new ArrayList();
    	List busy5 = new ArrayList();
    	//Initialisation de celle-ci
    	busy4.add(li1);
    	busy4.add(li2);
    	busy5.add(li1);
    	busy5.add(li3);
    	//Assignagnement aux groupes
    	g1.setLstBusy(busy4);
    	g2.setLstBusy(busy5);
        
     	//Creation list des groupes
    	List lstGroupes = new ArrayList();
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

}
