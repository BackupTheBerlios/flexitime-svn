/*
 * Created on 15 déc. 2004
 * by Valère FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.management.impl;

import fr.umlv.ir3.flexitime.common.data.general.Class;
import fr.umlv.ir3.flexitime.common.data.general.Track;
import fr.umlv.ir3.flexitime.common.data.ressources.Group;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.Course;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.Subject;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.SubjectsGroup;
import fr.umlv.ir3.flexitime.server.core.management.TracksManager;


/**
 * TracksManagerImpl - implements the interface TracksManager
 * 
 * @version Verion ou révision SVN
 * 
 * @author FlexiTeam - Valère FOREL
 */
public class TracksManagerImpl implements TracksManager {

    /** 
     * getTrack - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.server.core.management.TracksManager#getTrack(java.lang.String)
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    public Track getTrack(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * addTrack - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param track 
     * 
     * @see fr.umlv.ir3.flexitime.server.core.management.TracksManager#addTrack(fr.umlv.ir3.flexitime.common.data.general.Track)
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    public void addTrack(Track track) {
    // TODO Auto-generated method stub

    }

    /** 
     * removeTrack - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @return 
     * 
     * @see fr.umlv.ir3.flexitime.server.core.management.TracksManager#removeTrack(java.lang.String)
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    public Track removeTrack(String name) {
        // TODO Auto-generated method stub
        return null;
    }

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
     * @see fr.umlv.ir3.flexitime.server.core.management.TracksManager#getClass(java.lang.String, fr.umlv.ir3.flexitime.common.data.general.Track)
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    public Class getClass(String name, Track track) {
        // TODO Auto-generated method stub
        return null;
    }

    /** 
     * addClass - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param _class
     * @param track 
     * 
     * @see fr.umlv.ir3.flexitime.server.core.management.TracksManager#addClass(fr.umlv.ir3.flexitime.common.data.general.Class, fr.umlv.ir3.flexitime.common.data.general.Track)
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    public void addClass(Class _class, Track track) {
        // TODO Auto-generated method stub
        
    }

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
     * @see fr.umlv.ir3.flexitime.server.core.management.TracksManager#removeClass(java.lang.String, fr.umlv.ir3.flexitime.common.data.general.Track)
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    public Class removeClass(String name, Track track) {
        // TODO Auto-generated method stub
        return null;
    }

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
     * @see fr.umlv.ir3.flexitime.server.core.management.TracksManager#getGroup(java.lang.String, fr.umlv.ir3.flexitime.common.data.general.Track, fr.umlv.ir3.flexitime.common.data.general.Class)
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    public Group getGroup(String name, Track track, Class _class) {
        // TODO Auto-generated method stub
        return null;
    }

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
     * @see fr.umlv.ir3.flexitime.server.core.management.TracksManager#addGroup(fr.umlv.ir3.flexitime.common.data.ressources.Group, fr.umlv.ir3.flexitime.common.data.general.Track, fr.umlv.ir3.flexitime.common.data.general.Class)
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    public void addGroup(Group group, Track track, Class _class) {
        // TODO Auto-generated method stub
        
    }

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
     * @see fr.umlv.ir3.flexitime.server.core.management.TracksManager#removeGroup(java.lang.String, fr.umlv.ir3.flexitime.common.data.general.Track, fr.umlv.ir3.flexitime.common.data.general.Class)
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    public Group removeGroup(String name, Track track, Class _class) {
        // TODO Auto-generated method stub
        return null;
    }

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
     * @see fr.umlv.ir3.flexitime.server.core.management.TracksManager#getSubjectsGroup(java.lang.String, fr.umlv.ir3.flexitime.common.data.general.Track, fr.umlv.ir3.flexitime.common.data.general.Class)
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    public SubjectsGroup getSubjectsGroup(String name, Track track, Class _class) {
        // TODO Auto-generated method stub
        return null;
    }

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
     * @see fr.umlv.ir3.flexitime.server.core.management.TracksManager#addSubjectsGroup(fr.umlv.ir3.flexitime.common.data.teachingStructure.SubjectsGroup, fr.umlv.ir3.flexitime.common.data.general.Track, fr.umlv.ir3.flexitime.common.data.general.Class)
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    public void addSubjectsGroup(SubjectsGroup subjectsGroup, Track track, Class _class) {
        // TODO Auto-generated method stub
        
    }

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
     * @see fr.umlv.ir3.flexitime.server.core.management.TracksManager#removeSubjectsGroup(java.lang.String, fr.umlv.ir3.flexitime.common.data.general.Track, fr.umlv.ir3.flexitime.common.data.general.Class)
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    public Group removeSubjectsGroup(String name, Track track, Class _class) {
        // TODO Auto-generated method stub
        return null;
    }

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
     * @see fr.umlv.ir3.flexitime.server.core.management.TracksManager#getSubject(java.lang.String, fr.umlv.ir3.flexitime.common.data.general.Track, fr.umlv.ir3.flexitime.common.data.general.Class, fr.umlv.ir3.flexitime.common.data.teachingStructure.SubjectsGroup)
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    public Subject getSubject(String name, Track track, Class _class, SubjectsGroup subjectsGroup) {
        // TODO Auto-generated method stub
        return null;
    }

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
     * @see fr.umlv.ir3.flexitime.server.core.management.TracksManager#addSubject(fr.umlv.ir3.flexitime.common.data.teachingStructure.Subject, fr.umlv.ir3.flexitime.common.data.general.Track, fr.umlv.ir3.flexitime.common.data.general.Class, fr.umlv.ir3.flexitime.common.data.teachingStructure.SubjectsGroup)
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    public void addSubject(Subject subject, Track track, Class _class, SubjectsGroup subjectsGroup) {
        // TODO Auto-generated method stub
        
    }

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
     * @see fr.umlv.ir3.flexitime.server.core.management.TracksManager#removeSubject(java.lang.String, fr.umlv.ir3.flexitime.common.data.general.Track, fr.umlv.ir3.flexitime.common.data.general.Class, fr.umlv.ir3.flexitime.common.data.teachingStructure.SubjectsGroup)
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    public Group removeSubject(String name, Track track, Class _class, SubjectsGroup subjectsGroup) {
        // TODO Auto-generated method stub
        return null;
    }

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
     * @see fr.umlv.ir3.flexitime.server.core.management.TracksManager#getCourse(java.lang.String, fr.umlv.ir3.flexitime.common.data.general.Track, fr.umlv.ir3.flexitime.common.data.general.Class, fr.umlv.ir3.flexitime.common.data.teachingStructure.SubjectsGroup, fr.umlv.ir3.flexitime.common.data.teachingStructure.Subject)
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    public Course getCourse(String name, Track track, Class _class, SubjectsGroup subjectsGroup, Subject subject) {
        // TODO Auto-generated method stub
        return null;
    }

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
     * @see fr.umlv.ir3.flexitime.server.core.management.TracksManager#addCourse(fr.umlv.ir3.flexitime.common.data.teachingStructure.Course, fr.umlv.ir3.flexitime.common.data.general.Track, fr.umlv.ir3.flexitime.common.data.general.Class, fr.umlv.ir3.flexitime.common.data.teachingStructure.SubjectsGroup, fr.umlv.ir3.flexitime.common.data.teachingStructure.Subject)
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    public void addCourse(Course course, Track track, Class _class, SubjectsGroup subjectsGroup, Subject subject) {
        // TODO Auto-generated method stub
        
    }

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
     * @see fr.umlv.ir3.flexitime.server.core.management.TracksManager#removeCourse(java.lang.String, fr.umlv.ir3.flexitime.common.data.general.Track, fr.umlv.ir3.flexitime.common.data.general.Class, fr.umlv.ir3.flexitime.common.data.teachingStructure.SubjectsGroup, fr.umlv.ir3.flexitime.common.data.teachingStructure.Subject)
     * @author   FlexiTeam - Administrateur
     * @date     15 déc. 2004
     */
    public Group removeCourse(String name, Track track, Class _class, SubjectsGroup subjectsGroup, Subject subject) {
        // TODO Auto-generated method stub
        return null;
    }

}
