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
import fr.umlv.ir3.flexitime.common.data.resources.impl.DeviceImpl;
import fr.umlv.ir3.flexitime.common.data.resources.impl.TeacherImpl;

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
          TeacherImpl teach = new TeacherImpl("toto","toto");
          if(teach.getFirstName().compareTo("toto")!=0 )fail("error type");
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
        TeacherImpl teach = new TeacherImpl("toto","toto");
        teach.setFirstName("titi");
        if(teach.getFirstName().compareTo("titi")!=0 )fail("error prenom");
    }
}
