/*
 * Created on 11 janv. 2005
 * by VF
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.tools;

import java.util.*;

import fr.umlv.ir3.flexitime.common.data.activity.ILesson;
import fr.umlv.ir3.flexitime.common.data.resources.*;



/**
 * Gets the statistics of a teacher or a group 
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
        Set lg = lesson.getSetGroup();
        Iterator itlg = lg.iterator();
        while(itlg.hasNext()){
            IGroup res = (IGroup)itlg.next();
            stat.addGroup(res.getName());
        }
        return stat;
    }
}

