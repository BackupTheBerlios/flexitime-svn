/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.ressources.impl;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import junit.framework.TestCase;

import fr.umlv.ir3.flexitime.common.data.activity.IBusy;
import fr.umlv.ir3.flexitime.common.data.impl.DataImpl;
import fr.umlv.ir3.flexitime.common.data.resources.IResource;


/**
 * Defines an implementation of a ressource,<br>
 * it is extended by all the resource classes.
 * 
 * @version 248
 * @see fr.umlv.ir3.flexitime.common.data.resources.IResource
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public abstract class TestResourceImpl extends TestCase
{
    //===========//
	//  Champs	 //
	//===========//
    private SortedSet<IBusy> setBusy;
    
    
	//=============//
	//Constructeurs//
    //=============//
	/**
	 * Default constructor for a resource. 
	 */
	protected TestResourceImpl()
	{
        setBusy = new TreeSet<IBusy>();
    }
	
	
    
    //========= //
    // Méthodes //
	//========= //
    /** 
     * Returns the list of unavailibilities.
     * <code>List l = resource.getLstBusy()</code>
     *
     * @return the list of unavailibilities.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.IResource#getSetBusy()
     */
    public void testGetSetBusy()
    {
    }

    /** 
     * Sets a list of unavailibilities to a resource.
     * <code>resource.setLstBusy(lstBusy)</code>
     *
     * @param busies a list of unavailibilities.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.IResource#setSetBusy(java.util.SortedSet)
     */
    public void testSetSetBusy()
    {
    }

    /** 
     * Adds an unavailibility to the list.
     * <code>resource.addBusy(busy)</code>
     *
     * @param busy an unavilibility.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.IResource#addBusy(fr.umlv.ir3.flexitime.common.data.activity.IBusy)
     */
    public void testAddBusy()
    {
    }

    /** 
     * Removes an unavailibility of the list.
     * <code>resource.removeBusy(busy)</code>
     *
     * @param busy the unavailibility to remove.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.IResource#removeBusy(fr.umlv.ir3.flexitime.common.data.activity.IBusy)
     */
    public void testRemoveBusy(IBusy busy)
    {
    }
}

