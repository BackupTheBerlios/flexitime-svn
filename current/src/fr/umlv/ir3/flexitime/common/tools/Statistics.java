/*
 * Created on 11 janv. 2005
 * by Administrateur
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.tools;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import fr.umlv.ir3.flexitime.common.data.IData;
import fr.umlv.ir3.flexitime.common.data.activity.ILesson;
import fr.umlv.ir3.flexitime.common.data.activity.impl.LessonImpl;
import fr.umlv.ir3.flexitime.common.data.resources.IGroup;
import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;
import fr.umlv.ir3.flexitime.common.data.resources.impl.GroupImpl;
import fr.umlv.ir3.flexitime.common.data.resources.impl.TeacherImpl;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.impl.CourseImpl;


/**
 * DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * 
 * @author FlexiTeam - Administrateur
 */
public class Statistics
{
    //-------------//
    // Champs      //
    //-------------//
    // clé = nom du cours
    // valeur = nombre d'heure
    private HashMap coursesTodo = null;
    private HashMap coursesDone = null;
    // nom des groupes
    private List groups = null;
    //--------------//
    // Constructeur //
    //--------------//
    /**
     * Constructor
     * 
     */
    public Statistics(){
        coursesDone = new HashMap();
        coursesTodo = new HashMap();
        groups = new ArrayList();
    }
    //-------------//
    // Méthodes    //
    //-------------//
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @return Returns the courses
     */
    public HashMap getCoursesDone(){
        return coursesDone;
    }
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @return Returns the courses
     */
    public HashMap getCoursesTodo(){
        return coursesTodo;
    }
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @return Returns the groups
     */
    public List getGroups(){
        return groups;
    }
    /** 
     * getStatTeacher - gets the Statistiques of a teacher<br>
     *
     * <code>Statistiques.getStatTeacher(t)</code>
     *
     * @param t the teacher
     * @return Returns the stats of the teacher
     */
    public static List getStatTeacher(ITeacher t){
        ArrayList list = new ArrayList();
        Iterator it = t.getLstBusy().iterator();
        while(it.hasNext()){
            list.add(getCourses((ILesson)it.next()));            
        }
        return list;
    }
    /** 
     * getStatGroup - gets the Statistiques of a group<br>
     *
     * <code>Statistiques.getStatGroup(g)</code>
     *
     * @param g the group
     * @return Returns the stats of the group
     */
    public static List getStatGroup(IGroup g){
        ArrayList list = new ArrayList();
        Iterator it = g.getLstBusy().iterator();
        while(it.hasNext()){
            list.add(getCourses((ILesson)it.next()));            
        }
        return list;
    }
    private static Statistics getCourses(ILesson lesson){
        Statistics stat = new Statistics();
        boolean isDone = false;
        if(lesson.getEndDate().compareTo(new Time(2004,2,2,2,2).getCal().getTime())<=0) isDone = true;
        else isDone = false;
        List l = lesson.getLstResource();
        Iterator itl = l.iterator();
        while(itl.hasNext()){
            IData res = (IData)itl.next();
            if(res instanceof ICourse){
                int nbHeure = ((ICourse)res).getNbHours();
            	if(isDone == true) stat.getCoursesDone().put(res.getName(),new Integer(nbHeure));
                else stat.getCoursesTodo().put(res.getName(),new Integer(nbHeure));
            }
            if(res instanceof IGroup){
                stat.getGroups().add(((IGroup)res).getName());
            }
        }
        return stat;
    }
    
    //****************
    // Un exemple
    //****************
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @param args 
     */
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
        List lr1 = new ArrayList();
        List lr2 = new ArrayList();
        List lr3 = new ArrayList();
        lr1.add(t1);
        lr1.add(g1);
        lr1.add(g2);
        lr1.add(c1);
        lr2.add(t2);
        lr2.add(g1);
        lr2.add(c2);
        lr3.add(t3);
        lr3.add(g2);
        lr3.add(c3);
        LessonImpl li1 = new LessonImpl("Cours Revuz",new Date(),new Date());
        li1.setLstResource(lr1);
        LessonImpl li2 = new LessonImpl("TD Forax",new Date(),new Date());
        li2.setLstResource(lr2);
        LessonImpl li3 = new LessonImpl("TD Calmejane",new Date(),new Date());
        li3.setLstResource(lr3);
        List busy1 = new ArrayList();
        busy1.add(li1);
        List busy2 = new ArrayList();
        busy2.add(li2);
        List busy3 = new ArrayList();
        busy3.add(li3);
        t1.setLstBusy(busy1);
        t2.setLstBusy(busy2);
        t3.setLstBusy(busy3);
        List busy4 = new ArrayList();
        busy4.add(li1);
        busy4.add(li2);
        List busy5 = new ArrayList();
        busy5.add(li1);
        busy5.add(li3);
        g1.setLstBusy(busy4);
        g2.setLstBusy(busy5);
        List lstProfs = new ArrayList();
        lstProfs.add(t1);
        lstProfs.add(t2);
        lstProfs.add(t3);
        List lstGroupes = new ArrayList();
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
		        System.out.println("Les cours sont:");
		        Set keyDone = stat.getCoursesDone().keySet();
	            Set keyTodo = stat.getCoursesTodo().keySet();
		        Iterator itDone = keyDone.iterator();
		        Iterator itTodo = keyTodo.iterator();
		        while(itDone.hasNext()){
		            String title = (String)itDone.next();
		            System.out.println(title+" : "+stat.getCoursesDone().get(title)+"h effectuées");
		        }
		        while(itTodo.hasNext()){
		            String title = (String)itTodo.next();
		            System.out.println(title+" : "+stat.getCoursesTodo().get(title)+"h non effectuées");
		        }
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
	            System.out.println("Les cours sont:");
	            Set keyDone = stat.getCoursesDone().keySet();
	            Set keyTodo = stat.getCoursesTodo().keySet();
		        Iterator itDone = keyDone.iterator();
		        Iterator itTodo = keyTodo.iterator();
		        while(itDone.hasNext()){
		            String title = (String)itDone.next();
		            System.out.println(title+" : "+stat.getCoursesDone().get(title)+"h effectuées");
		        }
		        while(itTodo.hasNext()){
		            String title = (String)itTodo.next();
		            System.out.println(title+" : "+stat.getCoursesTodo().get(title)+"h non effectuées");
		        }
	        }
        }
    }
}

