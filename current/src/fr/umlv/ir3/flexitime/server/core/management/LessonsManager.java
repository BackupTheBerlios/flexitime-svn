/*
 * Created on 13 déc. 2004
 * by Valère FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.management;

import java.util.*;

import fr.umlv.ir3.flexitime.common.data.activity.*;
import fr.umlv.ir3.flexitime.common.data.ressources.*;
import fr.umlv.ir3.flexitime.common.tools.Time;



/**
 * LessonsManager - Manages the Lessons in a list
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Valère FOREL
 */
public interface LessonsManager {
    /** 
     * getLesson - get a lesson with its name
     * 
     *     <code>Lesson c = myLessonsManager.getLesson(date,time,"name of group")</code>
     * 
     * @param debut the date of the lesson
     * @param heure the time of the lesson
     * @param group the groupe which the lesson depends
     * @return a Lesson
     * 
     * @author   FlexiTeam - Valère FOREL
     * @date     13 déc. 2004
     */
    Lesson getLesson(Date debut, Time heure, Group group);
    /** 
     * addLesson - adds a lesson in the list
     * 
     *     <code>myLessonsManager.addLesson(myLesson)</code>
     * 
     * @param lesson a Lesson to add
     * 
     * @author   FlexiTeam - Valère FOREL
     * @date     13 déc. 2004
     */
    void addLesson(Lesson lesson);
    /** 
     * removeLesson - remove a lesson in the list
     * 
     *     <code>Lesson s = myLessonsManager.removeLesson(date,time,"group")</code>
     * 
     * @param debut the date of the lesson
     * @param heure the time of the lesson
     * @param group the group which the lesson depends
     * @return a Lesson
     * 
     * @author   FlexiTeam - Valère FOREL
     * @date     13 déc. 2004
     */
    Lesson removeLesson(Date debut, Time heure, Group group);

}
