/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.resources.impl;

import java.util.List;

import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;


/**
 * Defines a teacher.
 * 
 * @version 0.1
 * @see fr.umlv.ir3.flexitime.common.data.ressources.ITeacher
 * @see fr.umlv.ir3.flexitime.common.data.ressources.impl.ResourceImpl
 * 
 * @author FlexiTeam - Adrien BOUVET
 */
public class TeacherImpl extends ResourceImpl implements ITeacher
{
    //===========//
	//  Champs	 //
	//===========//
    private String strFirstName;
    private String strEmail;
    
	//=============//
	//Constructeurs//
    //=============//
	/**
	 * Default constructor for a teacher. 
	 */
	protected TeacherImpl()
	{}
	
	/**
	 * Constructs a teacher with just a name in parameter.
	 * 
	 * @param name a string.
	 */
	public TeacherImpl(String name)
	{
		super(name);
	}
	
    /**
     * Constructs a teacher.
     * 
     * @param name a string.
     * @param firstName the first name of the teacher.
     * @param listBusy a list of unavailibilities.
     * @param email the email of the teacher.
     * 
     */
    public TeacherImpl(String name, String firstName, List listBusy, String email)
    {
        super(name, listBusy);
        this.strFirstName = firstName;        
        this.strEmail = email;
    }

    
    //===========//
    // Méthodes  //
	//===========//
    /** 
     * Returns the first name of the teacher.
     * <code>String n = teacher.getFirstName()</code>
     *
     * @return the first name of the teacher.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.ressources.ITeacher#getFirstName()
     */
    public String getFirstName()
    {
        return strFirstName;
    }

    /** 
     * Sets the first name of the teacher.
     * <code>teacher.setFirstName(firstName)</code>
     *
     * @param firstName the first name of the teacher.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.ressources.ITeacher#setFirstName(java.lang.String)
     */
    public void setFirstName(String firstName)
    {
        this.strFirstName = firstName;
    }

    /** 
     * Returns the email adress of the teacher.
     * <code>String e = teacher.getEmail()</code>
     *
     * @return the email adress of the teacher. 
     * 
     * @see fr.umlv.ir3.flexitime.common.data.ressources.ITeacher#getEmail()
     */
    public String getEmail()
    {
        return strEmail;
    }

    /** 
     * Sets the email adress of the teacher.
     * <code>teacher.setEmail(email)</code>
     *
     * @param email the email adress of the teacher. 
     * 
     * @see fr.umlv.ir3.flexitime.common.data.ressources.ITeacher#setEmail(java.lang.String)
     */
    public void setEmail(String email)
    {
        this.strEmail = email;
    }
}

