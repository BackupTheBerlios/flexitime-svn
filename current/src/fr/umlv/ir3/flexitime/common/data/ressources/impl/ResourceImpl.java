/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.resources.impl;

import java.util.ArrayList;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.activity.IBusy;
import fr.umlv.ir3.flexitime.common.data.resources.IResource;


/**
 * Defines an implementation of a ressource, it is extended by all the resource classes.
 * 
 * @version 0.1
 * @see fr.umlv.ir3.flexitime.common.data.ressources.IResource
 * 
 * @author FlexiTeam - Adrien BOUVET
 */
public abstract class ResourceImpl implements IResource
{
    //===========//
	//  Champs	 //
	//===========//
    private String strName;
    private List listOfBusy;
    
    
	//=============//
	//Constructeurs//
    //=============//
	/**
	 * Default constructor for a resource. 
	 */
	protected ResourceImpl()
	{}
	
	/**
	 * Constructs a resource with just a name in parameter.
	 * 
	 * @param name  a string;
	 */
	public ResourceImpl(String name)
	{
		this.strName = name;
	}
	
    /**
     * Constructs a resource.
     * 
     * @param name  a string;
     * @param listBusy a list of unavailibilities.
     * 
     */
    public ResourceImpl(String name, List listBusy)
    {
        this.strName = name;
        this.listOfBusy = new ArrayList(listBusy);
    }

    
    //===========//
    // Méthodes  //
	//===========//
    /** 
     * Returns the list of unavailibilities.
     * <code>List l = resource.getLstBusy()</code>
     *
     * @return the list of unavailibilities.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.ressources.IResource#getLstBusy()
     * @author   FlexiTeam - Adrien BOUVET
     */
    public List getLstBusy()
    {
        return listOfBusy;
    }

    /** 
     * Sets a list of unavailibilities to a resource.
     * <code>resource.setLstBusy(lstBusy)</code>
     *
     * @param lstBusy a list of unavailibilities.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.ressources.IResource#setLstBusy(java.util.List)
     * @author   FlexiTeam - Adrien BOUVET
     */
    public void setLstBusy(List lstBusy)
    {
        listOfBusy = new ArrayList(lstBusy);
    }

    /** 
     * Adds an unavailibility to the list.
     * <code>resource.addBusy(busy)</code>
     *
     * @param busy an unavilibility.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.ressources.IResource#addBusy(fr.umlv.ir3.flexitime.common.data.activity.IBusy)
     * @author   FlexiTeam - Adrien BOUVET
     */
    public void addBusy(IBusy busy)
    {
        listOfBusy.add(busy);
    }

    /** 
     * Removes an unavailibility of the list.
     * <code>resource.removeBusy(busy)</code>
     *
     * @param busy the unavailibility to remove.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.ressources.IResource#removeBusy(fr.umlv.ir3.flexitime.common.data.activity.IBusy)
     * @author   FlexiTeam - Adrien BOUVET
     */
    public void removeBusy(IBusy busy)
    {
        listOfBusy.remove(busy);
    }

    /** 
     * Retruns the name of the resource.
     * <code>String name = resource.getName()</code>
     *
     * @return the name of the resource.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.IData#getName()
     * @author   FlexiTeam - Adrien BOUVET
     */
    public String getName()
    {
        return strName;
    }

    /** 
     * Sets the name of the resource.
     * <code>resource.setName(name)</code>
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

