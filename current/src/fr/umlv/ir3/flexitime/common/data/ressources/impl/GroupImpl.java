/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.ressources.impl;

import java.util.List;

import fr.umlv.ir3.flexitime.common.data.ressources.IGroup;


/**
 * Defines a group.
 * 
 * @version 0.1
 * @see fr.umlv.ir3.flexitime.common.data.ressources.IGroup
 * @see fr.umlv.ir3.flexitime.common.data.ressources.impl.ResourceImpl
 * 
 * @author FlexiTeam - Adrien BOUVET
 */
public class GroupImpl extends ResourceImpl implements IGroup
{
    //===========//
	//  Champs	 //
	//===========//
    private int iNbPerson; 
    
    
	//=============//
	//Constructeurs//
    //=============//
    /**
     * Constructs a group.
     * 
     * @param name a string.
     * @param listBusy a list of unavailibilities.
     * @param nbPerson the number of students in this group.
     * 
     */
    public GroupImpl(String name, List listBusy, int nbPerson)
    {
        super(name, listBusy);
        this.iNbPerson = nbPerson;
    }

    
    //===========//
    // Méthodes  //
	//===========//
    /** 
     * Returns the number of students in this group.
     * <code>Int i = group.getNbPerson()</code>
     *
     * @return the number of students in this group.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.ressources.IGroup#getNbPerson()
     * @author   FlexiTeam - Adrien BOUVET
     */
    public int getNbPerson()
    {
        return iNbPerson;
    }

    /** 
     * Sets the number of students in this group.
     * <code>group.setNbPerson(nbPerson)<code>
     *
     * @param nbPerson the number of students in this group.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.ressources.IGroup#setNbPerson(int)
     * @author   FlexiTeam - Adrien BOUVET
     */
    public void setNbPerson(int nbPerson)
    {
        this.iNbPerson = nbPerson;
    }
}
