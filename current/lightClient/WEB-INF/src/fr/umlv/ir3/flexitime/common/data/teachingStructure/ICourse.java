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
 * @version 285
 * @author FlexiTeam - Jérôme GUERS
 */
public interface ICourse extends IData
{
    /**
     * Comment for <code>CM</code>
     */
    public final static int   CM               = 1;
    /**
     * Comment for <code>TD</code>
     */
    public final static int   TD               = 2;
    /**
     * Comment for <code>TP</code>
     */
    public final static int   TP               = 3;
    
    /**
     * Returns the type of the course.
     * 
     * @return the type of the course.
     */
    public int getType();

    /**
     * Changes the type of the course.
     * 
     * @param type the new type.
     */
    public void setType(int type);

    /**
     * Returns the number of hours of the course.
     * 
     * @return the number of hours of the course.
     */
    public int getNbHours();

    /**
     * Changes the number of hours of the course.
     * 
     * @param nbHours the number of hours.me.
     */
    public void setNbHours(int nbHours);

	/**
	 * Returns the default length of the course.
	 * 
	 * @return the default length of the course.
	 */
	public int getDefaultLength();

	/**
	 * Sets the default length of the course.
	 * 
	 * @param hour the default length.
	 */
	public void setDefaultLength(int hour);

    /**
     * getColor returns the color of the course.
     * 
     * @return the color of the course.
     */
    public Color getColor();

    /**
     * Changes the color of the course.
     * 
     * @param color the new color.
     */
    public void setColor(Color color);

    /**
     * Returns the list of Teachers of a course .
     * 
     * @return the list of Teachers of a course.
     */
    public List<ITeacher> getLstTeacher();

    /**
     * Changes the list of Teacher of a course.
     * 
     * @param lstTeacher the list of Teacher of a course.
     */
    public void setLstTeacher(List<ITeacher> lstTeacher);

    /**
     * Add a teacher in a course
     * 
     * @param teacher the Teacher added.
     * @return false if teacher was not added
     */
    public boolean addTeacher(ITeacher teacher);

    /**
     * Remove a teacher of a course
     * 
     * @param teacher the Teacher removed.
     * @return false if teacher was not removed
     */
    public boolean removeTeacher(ITeacher teacher);
    
	/**
	 * Returns the subject to which the course belongs.
	 * 
	 * @return the subject to which the course belongs.
	 */
	public ISubject getParentSubject();

	/**
	 * Sets the subject to which the course belongs.
	 * 
	 * @param subject the subject to which the course belongs.
	 */
	public void setParentSubject(ISubject subject);
}
