/*
 * Created on 13 déc. 2004
 * by Valère FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.management.impl;

import fr.umlv.ir3.flexitime.common.data.ressources.Teacher;
import fr.umlv.ir3.flexitime.common.rmi.ITeacherManager;




/**
 * TeachersManagerImpl - Implements the interface TeachersManager
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Valère FOREL
 */
public class TeacherManagerImpl implements ITeacherManager {

    /** 
     * getTeacher - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.ITeacherManager#getTeacher(java.lang.String)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public Teacher getTeacher(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * saveTeacher - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param teacher 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.ITeacherManager#saveTeacher(fr.umlv.ir3.flexitime.common.data.ressources.Teacher)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public void saveTeacher(Teacher teacher) {
        // TODO Auto-generated method stub
        
    }

    /** 
     * removeTeacher - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.ITeacherManager#removeTeacher(java.lang.String)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public Teacher removeTeacher(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * lockTeacher - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param teacher
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.ITeacherManager#lockTeacher(fr.umlv.ir3.flexitime.common.data.ressources.Teacher)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public boolean lockTeacher(Teacher teacher) {
        // TODO Auto-generated method stub
        return false;
    }

    /** 
     * unlockTeache - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param teacher
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.common.rmi.ITeacherManager#unlockTeache(fr.umlv.ir3.flexitime.common.data.ressources.Teacher)
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public boolean unlockTeache(Teacher teacher) {
        // TODO Auto-generated method stub
        return false;
    }

}
