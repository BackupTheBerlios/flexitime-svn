/*
 * Created on 13 déc. 2004
 * by Valère FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.management.impl;

import java.util.Date;

import fr.umlv.ir3.flexitime.common.data.activity.Lesson;
import fr.umlv.ir3.flexitime.common.data.ressources.Group;
import fr.umlv.ir3.flexitime.common.rmi.ILessonManager;
import fr.umlv.ir3.flexitime.common.tools.Time;




/**
 * SeanceManagerImpl - Implements the interface SeancesManager
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Valère FOREL
 */
public class LessonManagerImpl implements ILessonManager {

    /** 
     * getLesson - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param debut
     * @param heure
     * @param group
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.ILessonManager#getLesson(java.util.Date, fr.umlv.ir3.flexitime.common.tools.Time, fr.umlv.ir3.flexitime.common.data.ressources.Group)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public Lesson getLesson(Date debut, Time heure, Group group) {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * saveLesson - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param lesson 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.ILessonManager#saveLesson(fr.umlv.ir3.flexitime.common.data.activity.Lesson)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public void saveLesson(Lesson lesson) {
        // TODO Auto-generated method stub
        
    }

    /** 
     * removeLesson - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param debut
     * @param heure
     * @param group
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.ILessonManager#removeLesson(java.util.Date, fr.umlv.ir3.flexitime.common.tools.Time, fr.umlv.ir3.flexitime.common.data.ressources.Group)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public Lesson removeLesson(Date debut, Time heure, Group group) {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * lockLesson - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param lesson
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.ILessonManager#lockLesson(fr.umlv.ir3.flexitime.common.data.activity.Lesson)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public boolean lockLesson(Lesson lesson) {
        // TODO Auto-generated method stub
        return false;
    }

    /** 
     * unlockLesson - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param lesson
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.ILessonManager#unlockLesson(fr.umlv.ir3.flexitime.common.data.activity.Lesson)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public boolean unlockLesson(Lesson lesson) {
        // TODO Auto-generated method stub
        return false;
    }

}
