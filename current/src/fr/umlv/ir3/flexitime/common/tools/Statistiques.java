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
import fr.umlv.ir3.flexitime.common.data.ressources.IGroup;
import fr.umlv.ir3.flexitime.common.data.ressources.ITeacher;
import fr.umlv.ir3.flexitime.common.data.ressources.impl.GroupImpl;
import fr.umlv.ir3.flexitime.common.data.ressources.impl.TeacherImpl;
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
public class Statistiques
{
    //-------------//
    // Champs      //
    //-------------//
    // clé = nom du cours
    // valeur = nombre d'heure
    private HashMap tCourses = null;
    // nom des groupes
    private List tGroups = null;
    //--------------//
    // Constructeur //
    //--------------//
    /**
     * DOCME
     * 
     */
    public Statistiques(){
        tCourses = new HashMap();
        tGroups = new ArrayList();
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
    public HashMap getCourses(){
        return tCourses;
    }
    /** 
     * DOCME Description
     * Quel service est rendu par cette méthode
     * <code>exemple d'appel de la methode</code>
     *
     * @return Returns the groups
     */
    public List getGroups(){
        return tGroups;
    }
    /** 
     * getStatTeacher - gets the Statistiques of a teacher<br>
     *
     * <code>Statistiques.getStatTeacher(t)</code>
     *
     * @param t the teacher
     * @return Returns the stats of the teacher
     */
    public static Statistiques getStatTeacher(ITeacher t){
        Statistiques stat = new Statistiques();
        Iterator it = t.getLstBusy().iterator();
        while(it.hasNext()){
            getCourses((ILesson)it.next(),stat);            
        }
        return stat;
    }
    /** 
     * getStatGroup - gets the Statistiques of a group<br>
     *
     * <code>Statistiques.getStatGroup(g)</code>
     *
     * @param g the group
     * @return Returns the stats of the group
     */
    public static Statistiques getStatGroup(IGroup g){
        Statistiques stat = new Statistiques();
        Iterator it = g.getLstBusy().iterator();
        while(it.hasNext()){
            getCourses((ILesson)it.next(),stat);            
        }
        return stat;
    }
    private static void getCourses(ILesson lesson, Statistiques stat){
        List l = lesson.getLstResource();
        Iterator itl = l.iterator();
        while(itl.hasNext()){
            IData res = (IData)itl.next();
            if(res instanceof ICourse){
                int nbHeure = 0;
                if(stat.getCourses().containsKey(res.getName())){
                    Integer integ = (Integer) stat.getCourses().get(res.getName());
                    nbHeure = integ.intValue()+((ICourse)res).getNbHours();
                    
                }else{
                    nbHeure = ((ICourse)res).getNbHours();
                }
                stat.getCourses().put(res.getName(),new Integer(nbHeure));
            }
            if(res instanceof IGroup){
                stat.getGroups().add(((IGroup)res).getName());
            }
        }
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
        FlexiColor col = null;
        CourseImpl c1 = new CourseImpl("cours1",1,4,col/*FlexiColor.getColor(FlexiColor.black)*/,new ArrayList(),1,"test");
        CourseImpl c2 = new CourseImpl("cours2",1,2,col/*FlexiColor.getColor(FlexiColor.black)*/,new ArrayList(),1,"test2");
        CourseImpl c3 = new CourseImpl("cours2",1,3,col/*FlexiColor.getColor(FlexiColor.black)*/,new ArrayList(),1,"test3");
        GroupImpl g = new GroupImpl("monGroup",new ArrayList(),50);
        TeacherImpl t = new TeacherImpl("revuz","dom",new ArrayList(),"toto");
        List lr = new ArrayList();
        lr.add(c1);
        lr.add(c2);
        lr.add(c3);
        lr.add(g);
        lr.add(t);
        LessonImpl li = new LessonImpl("ma lesson",new Date(),new Date());
        li.setLstResource(lr);
        List busy = new ArrayList();
        busy.add(li);
        TeacherImpl t2 = new TeacherImpl("revuz","dom",busy,"toto");
        GroupImpl g2 = new GroupImpl("monGroup",busy,50);
        
        Statistiques stat = Statistiques.getStatTeacher(t2);
        Set key = stat.getCourses().keySet();
        Iterator it = key.iterator();
        while(it.hasNext()){
            String title = (String)it.next();
            System.out.println(title+" - "+stat.getCourses().get(title));
        }
        Iterator it3 = stat.getGroups().iterator();
        while(it3.hasNext()){
            System.out.println(it3.next());
        }
        System.out.println("-----------------");
        
        Statistiques stat2 = Statistiques.getStatGroup(g2);
        Set key2 = stat2.getCourses().keySet();
        Iterator it2 = key2.iterator();
        while(it2.hasNext()){
            String title = (String)it2.next();
            System.out.println(title+" - "+stat2.getCourses().get(title));
        }
    }
}

