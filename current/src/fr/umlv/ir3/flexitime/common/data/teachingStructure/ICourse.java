/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.teachingStructure;

import java.util.List;

import fr.umlv.ir3.flexitime.common.data.IData;
import fr.umlv.ir3.flexitime.common.data.ressources.ITeacher;

/**
 * Represents a course which belong to a subject
 * 
 * @version 0.1
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface ICourse extends IData
{

    /**
     * Returns the type of the course.
     * 
     * @return the type of the course.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    int getType();

    /**
     * Changes the type of the course.
     * 
     * @param type the new type.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void setType(int type);

    /**
     * Returns the number of hours of the course.
     * 
     * @return the number of hours of the course.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    int getNbHours();

    /**
     * Changes the number of hours of the course.
     * 
     * @param nbHours the number of hours.me.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void setNbHours(int nbHours);

    /**
     * getColor returns the color of the course.
     * 
     * @return the color of the course.
     * @author FlexiTeam - Guillaume GUERRIN
     * @date 12 déc. 2004
     */
    int getColor();

    /**
     * Changes the color of the course.
     * 
     * @param color the new color.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void setColor(int color);

    /**
     * Returns the list of Teachers of a course .
     * 
     * @return the list of Teachers of a course.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    List getLstTeacher();

    /**
     * Changes the list of Teacher of a course.
     * 
     * @param lstTeacher the list of Teacher of a course.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void setLstTeacher(List lstTeacher);

    /**
     * Add a teacher in a course
     * 
     * @param teacher the Teacher added.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void addTeacher(ITeacher teacher);

    /**
     * Remove a teacher of a course
     * 
     * @param teacher the Teacher removed.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void removeTeacher(ITeacher teacher);

}
