/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.ressources.impl;

import java.util.SortedSet;

import junit.framework.TestCase;

import fr.umlv.ir3.flexitime.common.data.activity.IBusy;
import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;

/**
 * Defines a teacher.
 * 
 * @version 245
 * @see fr.umlv.ir3.flexitime.common.data.resources.ITeacher
 * @see fr.umlv.ir3.flexitime.common.data.resources.impl.ResourceImpl
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class TestTeacherImpl extends TestCase
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3906369333239427639L;
    // ====== //
    // Champs //
    // ====== //
    private String            firstName;
    private String            email;

    // ============= //
    // Constructeurs //
    // ============= //
    /**
     * Default constructor for a teacher.
     */
    protected TestTeacherImpl()
    {
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
    public void testGetFirstName()
    {
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
    public void testSetFirstName()
    {
    }

    /**
     * Returns the email adress of the teacher.
     * <code>String e = teacher.getEmail()</code>
     * 
     * @return the email adress of the teacher.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.ITeacher#getEmail()
     */
    public void testGetEmail()
    {
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
    public void testSetEmail()
    {
    }
}
