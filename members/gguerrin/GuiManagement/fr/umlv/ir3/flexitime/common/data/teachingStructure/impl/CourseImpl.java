/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.teachingStructure.impl;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.impl.DataImpl;
import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ISubject;


/**
 * Defines a course.
 * It can be a CM, TD or TP.
 * It containes a list of professors associated to this course.
 * 
 * @version 0.3
 * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse
 * 
 * @author FlexiTeam - Adrien BOUVET
 */
public class CourseImpl extends DataImpl implements ICourse
{
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3257852077735753267L;
    //===========//
	//  Champs	 //
	//===========//
    private int type;
    private int nbHours;
    private Color color;
    private List<ITeacher> lstTeacher;
    private int defaultLength;
    private ISubject parentSubject;
    
    
	//=============//
	//Constructeurs//
    //=============//
	/**
	 * Default constructor for a course. 
	 */
	protected CourseImpl()
	{}
	
	/**
	 * Constructs a course with just a name in parameter.
	 * 
	 * @param name a string.
	 */
	public CourseImpl(String name)
	{
		super(name);
        lstTeacher = new ArrayList<ITeacher>();
	}
	
	/**
	 * Constructs a course with a name and the parent subject in parameter.
	 * 
	 * @param name a string.
	 * @param subject the parent subject of this course.
	 */
	public CourseImpl(String name, SubjectImpl subject)
	{
		super(name);
		this.parentSubject = subject;
        lstTeacher = new ArrayList<ITeacher>();
	}
	
    /**
     * Constructs a course.
     * 
     * @param name a string.
     * @param type an int representing the type of the course.
     * @param nbHours the number of hours for this course.
     * @param color an int representing the color of the course.
     * @param listTeachers a list of teachers.
     * @param defaultLength deault length of this course
	 * @param subject the parent subject of this course.
     * 
     */
    public CourseImpl(String name, int type, int nbHours, Color color, List<ITeacher> listTeachers, int defaultLength, SubjectImpl subject)
    {
        super(name);
        this.type = type;
        this.nbHours = nbHours;
        this.color = color;
        this.lstTeacher = listTeachers;
        this.defaultLength = defaultLength;
        this.parentSubject = subject;
    }
    /**
     * Constructs a Course
     * 
     * @param name name of this course
     * @param type type of this course
     * @param nbHours length in hours of this course
     * @param color color
     * @param defaultLength defult lenghth of this course
     */
    public CourseImpl(String name, int type, int nbHours, Color color, int defaultLength)
    {
        super(name);
        this.type = type;
        this.nbHours = nbHours;
        this.color = color;
        this.defaultLength = defaultLength;
        lstTeacher = new ArrayList<ITeacher>();
    }

    
    //===========//
    // Méthodes  //
	//===========//
    /** 
     * Returns the type of the course.
     * <code>Int i = course.getType()</code>
     *
     * @return an int representing the type of the course.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse#getType()
     * @author   FlexiTeam - Adrien BOUVET
     */
    public int getType()
    {
        return type;
    }

    /** 
     * Sets the type of course.
     * <code>course.setType(type)</code>
     *
     * @param type an int representing the type of course.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse#setType(int)
     * @author   FlexiTeam - Adrien BOUVET
     */
    public void setType(int type)
    {
        this.type = type;
    }

    /** 
     * Returns the number of hours for this course.
     * <code>Int i = course.getNbHours()</code>
     *
     * @return the number of hours for this course.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse#getNbHours()
     * @author   FlexiTeam - Adrien BOUVET
     */
    public int getNbHours()
    {
        return nbHours;
    }

    /** 
     * Sets the number of hours for this course.
     * <code>course.setNbHours(nbHours)</code>
     *
     * @param nbHours the number of hours for this course. 
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse#setNbHours(int)
     * @author   FlexiTeam - Adrien BOUVET
     */
    public void setNbHours(int nbHours)
    {
        this.nbHours = nbHours;
    }


	/** 
	 * Returns the default length of the course.
	 * <code>Int i = course.getDefaultLength()</code>
	 *
	 * @return the default length of the course.
	 * 
	 * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse#getDefaultLength()
	 * @author   FlexiTeam - Adrien BOUVET
	 */
	public int getDefaultLength()
	{
		return defaultLength;
	}

	/** 
	 * Sets the default length of the course.
	 * <code>course.setDefaultLength(hour)</code>
	 *
	 * @param hour the default length. 
	 * 
	 * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse#setDefaultLength(int)
	 * @author   FlexiTeam - Adrien BOUVET
	 */
	public void setDefaultLength(int hour)
	{
		this.defaultLength = hour;		
	}

    /** 
     * Returns the color of the course.
     * <code>Int i = course.getColor()</code>
     *
     * @return the int representing the color of the course.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse#getColor()
     * @author   FlexiTeam - Adrien BOUVET
     */
    public Color getColor()
    {
        return color;
    }

    /** 
     * Sets the color of the course.
     * <code>course.setColor(color)</code>
     *
     * @param color a color represented by an int.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse#setColor(Color)
     * @author   FlexiTeam - Adrien BOUVET
     */
    public void setColor(Color color)
    {
        this.color = color;
    }

    /** 
     * Returns the list of teachers.
     * <code>List l = course.getLstTeacher()</code>
     *
     * @return the list of teachers.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse#getLstTeacher()
     * @author   FlexiTeam - Adrien BOUVET
     */
    public List<ITeacher> getLstTeacher()
    {
        return lstTeacher;
    }

    /** 
     * Sets the list of teachers.
     * <code>exemple d'appel de la methode</code>
     *
     * @param lstTeacher the list of teachers.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse#setLstTeacher(java.util.List)
     * @author   FlexiTeam - Adrien BOUVET
     */
    public void setLstTeacher(List<ITeacher> lstTeacher)
    {
        this.lstTeacher = lstTeacher;
    }

    /** 
     * Adds a teacher to the list.
     * <code>course.addTeacher(teacher)</code>
     *
     * @param teacher a teacher.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse#addTeacher(fr.umlv.ir3.flexitime.common.data.resources.ITeacher)
     * @author   FlexiTeam - Adrien BOUVET
     */
    public void addTeacher(ITeacher teacher)
    {
        lstTeacher.add(teacher);
    }

    /** 
     * Removes a teacher of the list.
     * <code>course.removeTeacher(teacher)</code>
     *
     * @param teacher a teacher.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse#removeTeacher(fr.umlv.ir3.flexitime.common.data.resources.ITeacher)
     * @author   FlexiTeam - Adrien BOUVET
     */
    public void removeTeacher(ITeacher teacher)
    {
        lstTeacher.remove(teacher);
    }
    
	/** 
	 * Returns the subject to which the course belongs.
	 * <code>SubjectImpl s = course.getParentSubject()</code>
	 *
	 * @return the subject to which the course belongs.
	 * 
	 * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse#getParentSubject()
	 */
	public ISubject getParentSubject()
	{
		return parentSubject;
	}


	/** 
	 * Sets the subject to which the course belongs.
	 * <code>course.setParentSubject(subject)</code>
	 *
	 * @param subject the subject to which the course belongs.
	 * 
	 * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse#setParentSubject(fr.umlv.ir3.flexitime.common.data.teachingStructure.impl.SubjectImpl)
	 */
	public void setParentSubject(ISubject subject)
	{
		this.parentSubject = subject;
	}
    
}

