/*
 * Created on 23 déc. 2004
 * by Guillaume GUERRIN
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.rmi;

import java.rmi.Remote;

import fr.umlv.ir3.flexitime.common.data.ressources.Teacher;


/**
 * ITeacherManager - DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface ITeacherManager extends Remote {
    /** 
     * getTeacher - get a teacher with its name
     * 
     *     <code>Teacher t = myTeacherManager.getTeacher("name")</code>
     *
     * @param name name of the teacher
     * @return a Teacher
     * 
     * @author   FlexiTeam - Valère FOREL
     * @date     13 déc. 2004
     */
    Teacher getTeacher(String name);
    /** 
     * addTeacher - adds a teacher in the list
     * 
     *     <code>myTeacherManager.addTeacher(myTeacher)</code>
     *
     * @param teacher the teacher
     * 
     * @author   FlexiTeam - Valère FOREL
     * @date     13 déc. 2004
     */
    void saveTeacher(Teacher teacher);
    /** 
     * removeTeacher - remove a teacher in the list
     * 
     *     <code>Teacher t = myTeacherManager.removeTeacher("name")</code>
     *
     * @param name name of the teacher to remove
     * @return a Teacher
     * 
     * @author   FlexiTeam - Valère FOREL
     * @date     14 déc. 2004
     */
    Teacher removeTeacher(String name);
    /** 
     * lockTeacher - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param teacher
     * @return 
     * 
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    boolean lockTeacher(Teacher teacher);
    /** 
     * unlockTeache - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param teacher
     * @return 
     * 
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    boolean unlockTeache(Teacher teacher);
}
