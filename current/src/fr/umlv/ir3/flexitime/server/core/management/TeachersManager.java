/*
 * Created on 13 déc. 2004
 * by Valère FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.management;

import fr.umlv.ir3.flexitime.common.data.ressources.*;


/**
 * TeacherManager - Manages the teachers in a list
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Valère FOREL
 */
public interface TeachersManager {
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
    void addTeacher(Teacher teacher);
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

}
