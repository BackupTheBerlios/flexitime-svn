/*
 * Created on 26 déc. 2004
 * by Valère
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.management.impl;

import fr.umlv.ir3.flexitime.common.data.Data;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.Course;
import fr.umlv.ir3.flexitime.common.rmi.ICourseManager;


/**
 * CourseManagerImpl - DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * 
 * @author FlexiTeam - Valère
 */
public class CourseManagerImpl implements ICourseManager{

    /** 
     * getCourse - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.ICourseManager#getCourse(java.lang.String)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public Course getCourse(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * saveCourse - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param course 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.ICourseManager#saveCourse(fr.umlv.ir3.flexitime.common.data.teachingStructure.Course)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public void saveCourse(Course course) {
        // TODO Auto-generated method stub
        
    }

    /** 
     * removeCourse - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.ICourseManager#removeCourse(java.lang.String)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public Course removeCourse(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * lockCourse - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param course
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.ICourseManager#lockCourse(fr.umlv.ir3.flexitime.common.data.teachingStructure.Course)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public boolean lockCourse(Course course) {
        // TODO Auto-generated method stub
        return false;
    }

    /** 
     * unlockCourse - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param course
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.ICourseManager#unlockCourse(fr.umlv.ir3.flexitime.common.data.teachingStructure.Course)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public boolean unlockCourse(Course course) {
        // TODO Auto-generated method stub
        return false;
    }

    /** 
     * getData - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.AbstractManager#getData()
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public Data getData() {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * saveData - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param data 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.AbstractManager#saveData(fr.umlv.ir3.flexitime.common.data.Data)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public void saveData(Data data) {
        // TODO Auto-generated method stub
        
    }

    /** 
     * removeData - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param data 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.AbstractManager#removeData(fr.umlv.ir3.flexitime.common.data.Data)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public void removeData(Data data) {
        // TODO Auto-generated method stub
        
    }

    /** 
     * lock - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param data
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.AbstractManager#lock(fr.umlv.ir3.flexitime.common.data.Data)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public boolean lock(Data data) {
        // TODO Auto-generated method stub
        return false;
    }

    /** 
     * unlock - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param data
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.AbstractManager#unlock(fr.umlv.ir3.flexitime.common.data.Data)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public boolean unlock(Data data) {
        // TODO Auto-generated method stub
        return false;
    }

}
