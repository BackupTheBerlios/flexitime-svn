/*
 * Created on 15 déc. 2004
 * by Valère FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.management;

import fr.umlv.ir3.flexitime.common.data.general.*;
import fr.umlv.ir3.flexitime.common.data.general.Class;

import fr.umlv.ir3.flexitime.common.data.ressources.*;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.*;



/**
 * TracksManager - Manages the tracks of the program
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Valère FOREL
 */
public interface TracksManager {
    /** 
     * getTrack - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @return 
     * 
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    Track getTrack(String name);
    /** 
     * addTrack - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param track 
     * 
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    void addTrack(Track track);
    /** 
     * removeTrack - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @return 
     * 
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    Track removeTrack(String name);
    /** 
     * getClass - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @param track
     * @return 
     * 
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    Class getClass(String name, Track track);
    /** 
     * addClass - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param _class
     * @param track 
     * 
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    void addClass(Class _class, Track track);
    /** 
     * removeClass - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @param track
     * @return 
     * 
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    Class removeClass(String name, Track track);
    /** 
     * getGroup - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @param track
     * @param _class
     * @return 
     * 
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    Group getGroup(String name, Track track, Class _class);
    /** 
     * addGroup - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param group
     * @param track
     * @param _class 
     * 
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    void addGroup(Group group, Track track, Class _class);
    /** 
     * removeGroup - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @param track
     * @param _class
     * @return 
     * 
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    Group removeGroup(String name, Track track, Class _class);
    /** 
     * getSubjectsGroup - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @param track
     * @param _class
     * @return 
     * 
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    SubjectsGroup getSubjectsGroup(String name, Track track, Class _class);
    /** 
     * addSubjectsGroup - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param subjectsGroup
     * @param track
     * @param _class 
     * 
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    void addSubjectsGroup(SubjectsGroup subjectsGroup, Track track, Class _class);
    /** 
     * removeSubjectsGroup - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @param track
     * @param _class
     * @return 
     * 
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    Group removeSubjectsGroup(String name, Track track, Class _class);
    /** 
     * getSubject - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @param track
     * @param _class
     * @param subjectsGroup
     * @return 
     * 
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    Subject getSubject(String name, Track track, Class _class, SubjectsGroup subjectsGroup);
    /** 
     * addSubject - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param subject
     * @param track
     * @param _class
     * @param subjectsGroup 
     * 
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    void addSubject(Subject subject, Track track, Class _class, SubjectsGroup subjectsGroup);
    /** 
     * removeSubject - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @param track
     * @param _class
     * @param subjectsGroup
     * @return 
     * 
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    Group removeSubject(String name, Track track, Class _class, SubjectsGroup subjectsGroup);
    /** 
     * getCourse - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @param track
     * @param _class
     * @param subjectsGroup
     * @param subject
     * @return 
     * 
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    Course getCourse(String name, Track track, Class _class, SubjectsGroup subjectsGroup,Subject subject);
    /** 
     * addCourse - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param course
     * @param track
     * @param _class
     * @param subjectsGroup
     * @param subject 
     * 
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    void addCourse(Course course, Track track, Class _class, SubjectsGroup subjectsGroup,Subject subject);
    /** 
     * removeCourse - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @param track
     * @param _class
     * @param subjectsGroup
     * @param subject
     * @return 
     * 
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    Group removeCourse(String name, Track track, Class _class, SubjectsGroup subjectsGroup,Subject subject);
    
}
