/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.resources.impl;

import java.util.List;

import fr.umlv.ir3.flexitime.common.data.activity.IBusy;
import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;

/**
 * Defines a teacher.
 * 
 * @version 205
 * @see fr.umlv.ir3.flexitime.common.data.resources.ITeacher
 * @see fr.umlv.ir3.flexitime.common.data.resources.impl.ResourceImpl
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class TeacherImpl extends ResourceImpl implements ITeacher
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3906369333239427639L;
    // ===========//
    // Champs //
    // ===========//
    private String            firstName;
    private String            email;

    // =============//
    // Constructeurs//
    // =============//
    /**
     * Default constructor for a teacher.
     */
    protected TeacherImpl()
    {}

    /**
     * Constructs a teacher with just a name and a firstName in parameter.
     * 
     * @param name
     * @param firstName 
     */
    public TeacherImpl(String name, String firstName)
    {
        super(name);
        this.firstName = firstName;
    }
    
    /**
     * Constructs a teacher with just a name and a firstName in parameter.
     * 
     * @param name
     * @param firstName 
     * @param mail 
     */
    public TeacherImpl(String name, String firstName, String mail)
    {
        super(name);
        this.firstName = firstName;
        email = mail;
    }

    /**
     * Constructs a teacher.
     * 
     * @param name
     *            a string.
     * @param firstName
     *            the first name of the teacher.
     * @param listBusy
     *            a list of unavailibilities.
     * @param mail
     *            the email of the teacher.
     * 
     */
    public TeacherImpl(String name, String firstName, String mail, List<IBusy> listBusy)
    {
        super(name, listBusy);
        this.firstName = firstName;
        email = mail;
    }

    // ===========//
    // Méthodes //
    // ===========//
    /**
     * Returns the first name of the teacher.
     * <code>String n = teacher.getFirstName()</code>
     * 
     * @return the first name of the teacher.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.ITeacher#getFirstName()
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Sets the first name of the teacher.
     * <code>teacher.setFirstName(firstName)</code>
     * 
     * @param firstName
     *            the first name of the teacher.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.ITeacher#setFirstName(java.lang.String)
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Returns the email adress of the teacher.
     * <code>String e = teacher.getEmail()</code>
     * 
     * @return the email adress of the teacher.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.ITeacher#getEmail()
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Sets the email adress of the teacher.
     * <code>teacher.setEmail(email)</code>
     * 
     * @param email
     *            the email adress of the teacher.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.ITeacher#setEmail(java.lang.String)
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * Test the equality of two teachers. Add a test to the equality of two
     * datas by comparing the firstName
     * 
     * @param obj
     *            other teacher to compare with
     * @return <code>true</code> if this object is the same as the obj
     *         argument; <code>false</code> otherwise.
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     * @see fr.umlv.ir3.flexitime.common.data.impl.DataImpl#equals(java.lang.Object)
     */
    public boolean equals(Object obj)
    {
        if (idData == 0)
        {
            if (super.equals(obj))
                return firstName.equals( ( (TeacherImpl) obj ).getFirstName());
            return false;
        }
        return super.equals(obj);
    }
}
