/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.ressources.impl;

import java.util.SortedSet;

import junit.framework.TestCase;

import fr.umlv.ir3.flexitime.common.data.activity.IBusy;
import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.resources.IGroup;

/**
 * Defines a group.<br>
 * 
 * 
 * @version 245
 * @see fr.umlv.ir3.flexitime.common.data.resources.IGroup
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class TestGroupImpl extends TestCase
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3904677193450663986L;
    // ======== //
    // Champs //
    // ======== //
    private int               nbPerson;
    private IClass            parentClass;

    // ============= //
    // Constructeurs //
    // ============= //
    /**
     * Default constructor for a group.
     */
    protected TestGroupImpl()
    {
    }

    
    // ===========//
    // Méthodes //
    // ===========//
    /**
     * Returns the number of students in this group.
     * <code>Int i = group.getNbPerson()</code>
     * 
     * @return the number of students in this group.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.IGroup#getNbPerson()
     */
    public void testGetNbPerson()
    {
    }

    /**
     * Sets the number of students in this group.
     * <code>group.setNbPerson(nbPerson)<code>
     *
     * @param nbPerson the number of students in this group.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.IGroup#setNbPerson(int)
     */
    public void testSetNbPerson()
    {
    }

    /**
     * Returns the parent class of this group.
     * <code>ClassImpl c = group.getParentClass()</code>
     * 
     * @return the parent class of this group.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.IGroup#getParentClass()
     */
    public void testGetParentClass()
    {
    }

    /**
     * Sets the parent class of this group.
     * <code>group.setParentClass(class)<code>
     *
     * @param parentClass the parent class of this group.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.IGroup#setParentClass(IClass)
     */
    public void testSetParentClass()
    {
    }
}
