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
 * @version 245
 * @see fr.umlv.ir3.flexitime.common.data.general.ITrack
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class TrackImpl extends DataImpl implements ITrack
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3258126955743556917L;
    // ===========//
    // Champs //
    // ===========//
    private List<IClass>      lstClass;

    // ==================//
    // Constructeurs //
    // ==================//
    /**
     * Default constructor for a track.
     */
    protected TrackImpl()
    {
        this.lstClass = new ArrayList<IClass>();
    }

    /**
     * Constructs a track with just a name in parameter.
     * 
     * @param sName
     *            a string.
     * 
     */
    public TrackImpl(String sName)
    {
        super(sName);
        this.lstClass = new ArrayList<IClass>();
    }

    /**
     * Constructs a track.
     * 
     * @param sName
     *            a string.
     * @param listClasses
     *            a list of classes.
     */
    public TrackImpl(String sName, List<IClass> listClasses)
    {
        super(sName);
        this.lstClass = listClasses;
    }

    // =============//
    // Méthodes //
    // =============//
    /**
     * Returns the list of classes in this track.
     * <code>List list = getLstClass()</code>
     * 
     * @return the list of classes in this track.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.ITrack#getLstClass()
     */
    public List<IClass> getLstClass()
    {
        return lstClass;
    }

    /**
     * Creates a new arrayList based on the list given in parameter.
     * <code>setLstClass(lstClass)</code>
     * 
     * @param lstClass
     *            the original list of classes in this track.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.ITrack#setLstClass(java.util.List)
     */
    public void setLstClass(List<IClass> lstClass)
    {
        this.lstClass = lstClass;
    }

    /**
     * Adds a class to the list of classes contained by this track.
     * <code>addClass(pClass)</code>
     * 
     * @param pClass
     *            a class to add to the list.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.ITrack#addClass(fr.umlv.ir3.flexitime.common.data.general.IClass)
     */
    public boolean addClass(IClass pClass)
    {
        pClass.setParentTrack(this);
        return lstClass.add(pClass);
    }

    /**
     * Removes a class of the list of classes contained by this track.
     * <code>removeClass(pClass)</code>
     * 
     * @param pClass
     *            a class to remove of the list.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.ITrack#removeClass(fr.umlv.ir3.flexitime.common.data.general.IClass)
     */
    public boolean removeClass(IClass pClass)
    {
        return lstClass.remove(pClass);
    }
}
