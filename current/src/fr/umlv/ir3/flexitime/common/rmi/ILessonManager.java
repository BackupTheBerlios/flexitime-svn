/*
 * Created on 23 d�c. 2004
 * by Guillaume GUERRIN
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.rmi;

import java.rmi.Remote;
import java.util.Date;

import fr.umlv.ir3.flexitime.common.data.activity.Lesson;
import fr.umlv.ir3.flexitime.common.data.ressources.Group;
import fr.umlv.ir3.flexitime.common.tools.Time;


/**
 * ILessonManager - DOCME Description
 * explication suppl�mentaire si n�cessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * repr�sente, ...
 * 
 * @version Verion ou r�vision SVN
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface ILessonManager extends Remote {
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
     * @author   FlexiTeam - Val�re FOREL
     * @date     13 d�c. 2004
     */
    Lesson getLesson(Date debut, Time heure, Group group);
    /** 
     * addLesson - adds a lesson in the list
     * 
     *     <code>myLessonsManager.addLesson(myLesson)</code>
     * 
     * @param lesson a Lesson to add
     * 
     * @author   FlexiTeam - Val�re FOREL
     * @date     13 d�c. 2004
     */
    void saveLesson(Lesson lesson);
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
     * @author   FlexiTeam - Val�re FOREL
     * @date     13 d�c. 2004
     */
    Lesson removeLesson(Date debut, Time heure, Group group);
    /** 
     * lockLesson - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param lesson
     * @return 
     * 
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    boolean lockLesson(Lesson lesson);
    /** 
     * unlockLesson - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param lesson
     * @return 
     * 
     * @author   FlexiTeam - Val�re
     * @date     26 d�c. 2004
     */
    boolean unlockLesson(Lesson lesson);
}
