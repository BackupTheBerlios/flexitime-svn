/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.teachingStructure.impl;

import java.util.ArrayList;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.ressources.ITeacher;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse;


/**
 * Defines a course.
 * It can be a CM, TD or TP.
 * It containes a list of professors associated to this course.
 * 
 * @version 0.1
 * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse
 * 
 * @author FlexiTeam - Adrien BOUVET
 */
public class CourseImpl implements ICourse
{
    //===========//
	//  Champs	 //
	//===========//
    private String strName;
    private int iType;
    private int iNbHours;
    private int iColor;
    private List listOfTeachers;
    
	//=============//
	//Constructeurs//
    //=============//
    /**
     * Constructs a course.
     * 
     * @param name a string.
     * @param type an int representing the type of the course.
     * @param nbHours the number of hours for this course.
     * @param color an int representing the color of the course.
     * @param listTeachers a list of teachers.
     * 
     */
    public CourseImpl(String name, int type, int nbHours, int color, List listTeachers)
    {
        this.strName = name;
        this.iType = type;
        this.iNbHours = nbHours;
        this.iColor = color;
        this.listOfTeachers = new ArrayList(listTeachers);        
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
        return iType;
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
        this.iType = type;
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
        return iNbHours;
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
        this.iNbHours = nbHours;
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
    public int getColor()
    {
        return iColor;
    }

    /** 
     * Sets the color of the course.
     * <code>course.setColor(color)</code>
     *
     * @param color a color represented by an int.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse#setColor(int)
     * @author   FlexiTeam - Adrien BOUVET
     */
    public void setColor(int color)
    {
        this.iColor = color;
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
    public List getLstTeacher()
    {
        return listOfTeachers;
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
    public void setLstTeacher(List lstTeacher)
    {
        this.listOfTeachers = new ArrayList(lstTeacher);
    }

    /** 
     * Adds a teacher to the list.
     * <code>course.addTeacher(teacher)</code>
     *
     * @param teacher a teacher.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse#addTeacher(fr.umlv.ir3.flexitime.common.data.ressources.ITeacher)
     * @author   FlexiTeam - Adrien BOUVET
     */
    public void addTeacher(ITeacher teacher)
    {
        listOfTeachers.add(teacher);
    }

    /** 
     * Removes a teacher of the list.
     * <code>course.removeTeacher(teacher)</code>
     *
     * @param teacher a teacher.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.teachingStructure.ICourse#removeTeacher(fr.umlv.ir3.flexitime.common.data.ressources.ITeacher)
     * @author   FlexiTeam - Adrien BOUVET
     */
    public void removeTeacher(ITeacher teacher)
    {
        listOfTeachers.remove(teacher);
    }

    /** 
     * Returns the name of this course.
     * <code>String s = course.getName()</code>
     *
     * @return the name of this course.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.IData#getName()
     * @author   FlexiTeam - Adrien BOUVET
     */
    public String getName()
    {
        return strName;
    }

    /** 
     * Sets the name of this course.
     * <code>course.setName(name)</code>
     *
     * @param name a string.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.IData#setName(java.lang.String)
     * @author   FlexiTeam - Adrien BOUVET
     */
    public void setName(String name)
    {
        this.strName = name;
    }

}

