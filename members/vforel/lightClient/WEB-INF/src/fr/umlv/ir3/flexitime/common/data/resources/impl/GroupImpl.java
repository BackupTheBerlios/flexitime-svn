/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.resources.impl;

import java.util.SortedSet;

import fr.umlv.ir3.flexitime.common.data.activity.IBusy;
import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.resources.IGroup;

/**
 * Defines a group.
 * 
 * @version 245
 * @see fr.umlv.ir3.flexitime.common.data.resources.IGroup
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class GroupImpl extends ResourceImpl implements IGroup
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
    protected GroupImpl()
    {
        super();
    }

    /**
     * Constructs a group with just a name in parameter.
     * 
     * @param name
     *            a string.
     * @param nbPerson
     *            number of person in this group
     */
    public GroupImpl(String name, int nbPerson)
    {
        super(name);
        this.nbPerson = nbPerson;
    }

    /**
     * Constructs a group with a name and a parent class in parameter.
     * 
     * @param name
     *            a string
     * @param nbPerson
     * @param parentClass
     *            the parent class of this group
     */
    public GroupImpl(String name, int nbPerson, IClass parentClass)
    {
        this(name, nbPerson);
        this.parentClass = parentClass;
    }

    /**
     * Constructs a group.
     * 
     * @param name
     *            a string.
     * @param busies
     *            a list of unavailibilities.
     * @param nbPerson
     *            the number of students in this group.
     * @param parentClass
     *            the parent class of this group.
     */
    public GroupImpl(String name, int nbPerson, IClass parentClass,
            SortedSet<IBusy> busies)
    {
        super(name, busies);
        this.nbPerson = nbPerson;
        this.parentClass = parentClass;
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
    public int getNbPerson()
    {
        return nbPerson;
    }

    /**
     * Sets the number of students in this group.
     * <code>group.setNbPerson(nbPerson)<code>
     *
     * @param nbPerson the number of students in this group.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.IGroup#setNbPerson(int)
     */
    public void setNbPerson(int nbPerson)
    {
        this.nbPerson = nbPerson;
    }

    /**
     * Returns the parent class of this group.
     * <code>ClassImpl c = group.getParentClass()</code>
     * 
     * @return the parent class of this group.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.IGroup#getParentClass()
     */
    public IClass getParentClass()
    {
        return parentClass;
    }

    /**
     * Sets the parent class of this group.
     * <code>group.setParentClass(class)<code>
     *
     * @param parentClass the parent class of this group.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.IGroup#setParentClass(IClass)
     */
    public void setParentClass(IClass parentClass)
    {
        this.parentClass = parentClass;
    }
}
