/*
 * Created on 13 déc. 2004
 * by Valère FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.management.impl;

import java.util.Date;

import fr.umlv.ir3.flexitime.common.data.activity.*;
import fr.umlv.ir3.flexitime.common.data.ressources.*;
import fr.umlv.ir3.flexitime.common.tools.*;
import fr.umlv.ir3.flexitime.server.core.management.*;


/**
 * SeanceManagerImpl - Implements the interface SeancesManager
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Valère FOREL
 */
public class LessonManagerImpl implements LessonsManager {

    /** 
     * getLesson - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @return a Lesson
     * 
     * @see fr.umlv.ir3.flexitime.server.core.management.LessonsManager#getLesson(Date debut, Time heure, Group group)
     * @author   FlexiTeam - Administrateur
     * @date     13 déc. 2004
     */
    public Lesson getLesson(Date debut, Time heure, Group group) {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * addLesson - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param lesson 
     * 
     * @see fr.umlv.ir3.flexitime.server.core.management.LessonsManager#addLesson(fr.umlv.ir3.flexitime.common.data.activity.Lesson)
     * @author   FlexiTeam - Administrateur
     * @date     13 déc. 2004
     */
    public void addLesson(Lesson lesson) {
    // TODO Auto-generated method stub

    }

    /** 
     * removeSeance - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param debut
     * @param heure
     * @param group
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.server.core.management.LessonsManager#removeLesson(java.util.Date, fr.umlv.ir3.flexitime.common.tools.Time, fr.umlv.ir3.flexitime.common.data.ressources.Group)
     * @author   FlexiTeam - Administrateur
     * @date     13 déc. 2004
     */
    public Lesson removeLesson(Date debut, Time heure, Group group) {
        // TODO Auto-generated method stub
        return null;
    }

}
