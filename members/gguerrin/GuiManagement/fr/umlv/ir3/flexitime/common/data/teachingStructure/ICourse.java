/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.teachingStructure;

import java.awt.Color;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.IData;
import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;

/**
 * Represents a course which belong to a subject
 * 
 * @version 0.3
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
	 * Returns the default length of the course.
	 * 
	 * @return the default length of the course.
	 * @author FlexiTeam - Adrien BOUVET
	 */
	int getDefaultLength();

	/**
	 * Sets the default length of the course.
	 * 
	 * @param hour the default length.
	 * @author FlexiTeam - Adrien BOUVET
	 */
	void setDefaultLength(int hour);

    /**
     * getColor returns the color of the course.
     * 
     * @return the color of the course.
     * @author FlexiTeam - Guillaume GUERRIN
     * @date 12 déc. 2004
     */
    Color getColor();

    /**
     * Changes the color of the course.
     * 
     * @param color the new color.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void setColor(Color color);

    /**
     * Returns the list of Teachers of a course .
     * 
     * @return the list of Teachers of a course.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    List<ITeacher> getLstTeacher();

    /**
     * Changes the list of Teacher of a course.
     * 
     * @param lstTeacher the list of Teacher of a course.
     * @author FlexiTeam - Guillaume GUERRIN
     */
    void setLstTeacher(List<ITeacher> lstTeacher);

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
    
	/**
	 * Returns the subject to which the course belongs.
	 * 
	 * @return the subject to which the course belongs.
	 * @author FlexiTeam - Adrien BOUVET
	 */
	ISubject getParentSubject();

	/**
	 * Sets the subject to which the course belongs.
	 * 
	 * @param subject the subject to which the course belongs.
	 * @author FlexiTeam - Adrien BOUVET
	 */
	void setParentSubject(ISubject subject);

}
