/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.general.impl;

import java.util.ArrayList;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.general.ITrack;
import fr.umlv.ir3.flexitime.common.data.impl.DataImpl;


/**
 * Defines a track which contains classes.
 *  
 * @version 0.1
 * @see fr.umlv.ir3.flexitime.common.data.general.ITrack
 * 
 * @author FlexiTeam - Adrien BOUVET
 */
public class TrackImpl extends DataImpl implements ITrack
{
    //===========//
    //   Champs  //
    //===========// 
    private List listOfClasses;

    //==================//
    //   Constructeurs  //
    //==================//
	/**
	 * Default constructor for a track. 
	 */
	protected TrackImpl()
	{}
	
	
    /**
     * Constructs a track with just a name in parameter. 
     * 
     * @param sName a string.
     * 
     */
    public TrackImpl(String sName)
    {
        super(sName);  
        this.listOfClasses = new ArrayList();
    }
    
	/**
	 * Constructs a track. 
	 * 
	 * @param sName a string.
	 * @param listClasses a list of classes.
	 */
	public TrackImpl(String sName, List listClasses)
	{
		super(sName);
		this.listOfClasses = new ArrayList(listClasses);		        
	}
    
    //=============//
    //   Méthodes  //
    //=============//
    /** 
     * Returns the list of classes in this track.
     * <code>List list = getLstClass()</code>
     *
     * @return the list of classes in this track.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.ITrack#getLstClass()
     * @author   FlexiTeam - Adrien BOUVET
     */
    public List getLstClass()
    {
        return listOfClasses;
    }

    /** 
     * Creates a new arrayList based on the list given in parameter.
     * <code>setLstClass(lstClass)</code>
     *
     * @param lstClass the original list of classes in this track.  
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.ITrack#setLstClass(java.util.List)
     * @author   FlexiTeam - Adrien BOUVET
     */
    public void setLstClass(List lstClass)
    {
        listOfClasses = new ArrayList(lstClass);
    }

    /** 
     * Adds a class to the list of classes contained by this track.
     * <code>addClass(pClass)</code>
     *
     * @param pClass a class to add to the list.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.ITrack#addClass(fr.umlv.ir3.flexitime.common.data.general.IClass)
     * @author   FlexiTeam - Adrien BOUVET
     */
    public void addClass(IClass pClass)
    {
        listOfClasses.add(pClass);
    }

    /** 
     * Removes a class of the list of classes contained by this track.
     * <code>removeClass(pClass)</code>
     *
     * @param pClass a class to remove of the list.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.ITrack#removeClass(fr.umlv.ir3.flexitime.common.data.general.IClass)
     * @author   FlexiTeam - Adrien BOUVET
     */
    public void removeClass(IClass pClass)
    {
        listOfClasses.remove(pClass);
    }
}

