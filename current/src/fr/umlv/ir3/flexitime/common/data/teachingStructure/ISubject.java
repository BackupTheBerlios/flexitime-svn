/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.teachingStructure;

import java.util.List;

import fr.umlv.ir3.flexitime.common.data.IData;

/**
 * Represents a Subject which belong to a SubjectsGroup
 * 
 * @version 0.1
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface ISubject extends IData
{

    /**
     * Returns the list of course .
     * 
     * @return the list of course.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    List getLstCourse();

    /**
     * Changes the list of course.
     * 
     * @param lstCourse the list of course.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void setLstCourse(List lstCourse);

    /**
     * Add a course in a Subject
     * 
     * @param course the courses added
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void addCourse(ICourse course);

    /**
     * Remove a course of a Subject
     * 
     * @param course the course removed.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void removeCourse(ICourse course);

}
