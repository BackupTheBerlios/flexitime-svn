/*
 * Created on 8 janv. 2005
 * by VF
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.tools;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
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
 * Gets the stats of a resources
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - VF
 */
public class FlexiStat
{	
    //----------//
    //	Champs  //
    //----------//
    private static Hashtable table;
    //-----------//
    // Méthodes  //
    //-----------//
    /** 
     * getStatTeacher - gets a HashTable<br>
     * keys - name of the course
     * values - nombre of hour
     * <code>FlexiStat.getStatTeacher(t)</code>
     *
     * @param t the teacher
     * @return Returns the stats of the teacher
     */
    public static Hashtable getStatTeacher(ITeacher t){
        table = new Hashtable();
        Iterator it = t.getLstBusy().iterator();
        while(it.hasNext()){
            getCourses((ILesson)it.next());            
        }
        return table;
    }
    /** 
     * getStatGroup - gets a HashTable<br>
     * keys - name of the course
     * values - nombre of hour
     * <code>FlexiStat.getStatGroup(g)</code>
     *
     * @param g the group
     * @return Returns the stats of the group
     */
    public static Hashtable getStatGroup(IGroup g){
        table = new Hashtable();
        Iterator it = g.getLstBusy().iterator();
        while(it.hasNext()){
            getCourses((ILesson)it.next());            
        }
        return table;
    }
    private static void getCourses(ILesson lesson){
        List l = lesson.getLstResource();
        Iterator itl = l.iterator();
        while(itl.hasNext()){
            IData res = (IData)itl.next();
            if(res.getClass().getSimpleName().equals("CourseImpl")){
                int nbHeure = 0;
                if(table.containsKey(res.getName())){
                    Integer integ = (Integer) table.get(res.getName());
                    nbHeure = integ.intValue()+((ICourse)res).getNbHours();
                    
                }else{
                    nbHeure = ((ICourse)res).getNbHours();
                }
                table.put(res.getName(),new Integer(nbHeure));
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
        CourseImpl c1 = new CourseImpl("cours1",1,4,0,new ArrayList());
        CourseImpl c2 = new CourseImpl("cours2",1,2,0,new ArrayList());
        CourseImpl c3 = new CourseImpl("cours2",1,3,0,new ArrayList());
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
        
        Hashtable tab = FlexiStat.getStatTeacher(t2);
        
        Enumeration enum = tab.keys();
        Enumeration enum2 = tab.elements();
        while(enum.hasMoreElements()){
            System.out.println(enum.nextElement()+" - "+enum2.nextElement());
        }
        
        Hashtable tab2 = FlexiStat.getStatGroup(g2);
        
        enum = tab2.keys();
        enum2 = tab2.elements();
        while(enum.hasMoreElements()){
            System.out.println(enum.nextElement()+" - "+enum2.nextElement());
        }
    }

}

