/*
 * Created on 11 janv. 2005
 * by VF
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.tools;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.activity.ILesson;
import fr.umlv.ir3.flexitime.common.data.resources.IGroup;
import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;


/**
 * Statistics - gets the statistics of a teacher or a group 
 * 
 * @version 240
 * 
 * @author FlexiTeam - VF
 */
public class Statistics
{
    //-------------//
    // Champs      //
    //-------------//
    // clé = nom du cours
    // valeur = nombre d'heure
    private String courseName = null;
    private int nbHours = 0;
    // nom des groupes
    private List<String> groups = null;
    private boolean done = false;
    //--------------//
    // Constructeur //
    //--------------//
    /**
     * Constructor
     * 
     */
    private Statistics(){
        groups = new ArrayList<String>();
    }
    //-------------//
    // Méthodes    //
    //-------------//
    /** 
     * getCourseName -
     *
     * @return Returns the courses
     */
    public String getCourseName(){
        return courseName;
    }
    private void setCourse(String courseName){
        this.courseName = courseName;
    }
    /** 
     * getGroups - gets the list of the group
     *
     * @return Returns the groups
     */
    public List getGroups(){
        return groups;
    }
    private void addGroup(String group){
        groups.add(group);
    }
    /** 
     * getDone - Says if the statistics is done or not yet
     *
     * @return the state of statistics
     */
    public boolean getDone(){
        return done;
    }
    private void setDone(boolean bool){
        done = bool;
    }
    /** 
     * getNbHour - the number of hours
     *
     * @return the number of hours
     */
    public int getNbHours(){
        return nbHours;
    }
    private void setNbHours(int nb){
        this.nbHours = nb;
    }
    /** 
     * getStatTeacher - gets the Statistiques of a teacher<br>
     *
     * @param t the teacher
     * @return Returns the stats of the teacher
     */
    public static List getStatTeacher(ITeacher t){
        ArrayList<Statistics> list = new ArrayList<Statistics>();
        Iterator it = t.getSetBusy().iterator();
        while(it.hasNext()){
            list.add(getCourses((ILesson)it.next()));            
        }
        return list;
    }
    /** 
     * getStatGroup - gets the Statistiques of a group<br>
     *
     * @param g the group
     * @return Returns the stats of the group
     */
    public static List getStatGroup(IGroup g){
        ArrayList<Statistics> list = new ArrayList<Statistics>();
        Iterator it = g.getSetBusy().iterator();
        while(it.hasNext()){
            list.add(getCourses((ILesson)it.next()));            
        }
        return list;
    }
    private static Statistics getCourses(ILesson lesson){
        Statistics stat = new Statistics();

        if(lesson.getEndDate().compareTo(new Time(2004,2,2,2,2).getCal().getTime())<=0) stat.setDone(true);
        else stat.setDone(false);;
        stat.setCourse(lesson.getCourse().getName());
        stat.setNbHours(lesson.getCourse().getNbHours());
        List lg = lesson.getLstGroup();
        Iterator itlg = lg.iterator();
        while(itlg.hasNext()){
            IGroup res = (IGroup)itlg.next();
            stat.addGroup(res.getName());
        }
        return stat;
    }
    
    //****************
    // Un exemple
    //****************
    /** 
     * Description
     * Quel service est rendu par cette méthode
     *
     * @param args 
     */
    /*public static void main(String[] args){
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
    }*/
}

