/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.general.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import fr.umlv.ir3.flexitime.common.data.admin.IUser;
import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.general.ITrack;
import fr.umlv.ir3.flexitime.common.data.impl.DataImpl;
import fr.umlv.ir3.flexitime.common.tools.TimeBloc;

/**
 * Defines a track which contains classes.
 * 
 * @version 290
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
    private List<TimeBloc>    lstTimeBloc;
    private Set<IUser> setUser;

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

    // ======== //
    // Méthodes //
    // ======== //
    
    /**
     * Return lstTimeBloc
     * @return Returns the lstTimeBloc.
     */
    public List<TimeBloc> getLstTimeBloc()
    {
        return lstTimeBloc;
    }
    
    /**
     * Set lstTimeBloc
     * @param lstTimeBloc The lstTimeBloc to set.
     */
    public void setLstTimeBloc(List<TimeBloc> lstTimeBloc)
    {
        this.lstTimeBloc = lstTimeBloc;
    }
    
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
    
    
    /** 
     * @see fr.umlv.ir3.flexitime.common.data.general.ITrack#getSetUser()
     */
    public Set<IUser> getSetUser()
    {
        return setUser;
    }
    
    /**
     * 
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.ITrack#setSetUser(java.util.Set)
     */
    public void setSetUser(Set<IUser> setUser)
    {
        this.setUser = setUser;
    }
}
