/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.resources.impl;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import fr.umlv.ir3.flexitime.common.data.activity.IBusy;
import fr.umlv.ir3.flexitime.common.data.impl.DataImpl;
import fr.umlv.ir3.flexitime.common.data.resources.IDevice;
import fr.umlv.ir3.flexitime.common.data.resources.IGroup;
import fr.umlv.ir3.flexitime.common.data.resources.IResource;
import fr.umlv.ir3.flexitime.common.data.resources.IRoom;
import fr.umlv.ir3.flexitime.common.data.resources.ITeacher;
import fr.umlv.ir3.flexitime.common.rmi.LocalDataManager;
import fr.umlv.ir3.flexitime.server.core.DataManagerImpl;


/**
 * Defines an implementation of a ressource,<br>
 * it is extended by all the resource classes.
 * 
 * @version 248
 * @see fr.umlv.ir3.flexitime.common.data.resources.IResource
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public abstract class ResourceImpl extends DataImpl implements IResource
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
	protected ResourceImpl()
	{
        //setBusy = new TreeSet<IBusy>();
    }
	
	/**
	 * Constructs a resource with just a name in parameter.
	 * 
	 * @param name  a string;
	 */
	public ResourceImpl(String name)
	{
		super(name);
		//setBusy = new TreeSet<IBusy>();
	}
	
    /**
     * Constructs a resource.
     * 
     * @param name  a string;
     * @param busies a list of unavailibilities.
     */
    public ResourceImpl(String name, SortedSet<IBusy> busies)
    {
        super(name);
        //this.setBusy = busies;
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
    public Set<IBusy> getSetBusy()
    {
        if(setBusy == null)
        {
            List<IBusy> l = null;
            try
            {
                if(this instanceof IDevice)
                    l = LocalDataManager.getManager().getBusies(idData, IDevice.class);
                if(this instanceof IGroup)
                    l = LocalDataManager.getManager().getBusies(idData, IGroup.class);
                if(this instanceof IRoom)
                    l = LocalDataManager.getManager().getBusies(idData, IRoom.class);
                if(this instanceof ITeacher)
                    l = LocalDataManager.getManager().getBusies(idData, ITeacher.class);
                setBusy = new TreeSet<IBusy>(l);
            }
            catch (RemoteException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return setBusy;
    }

    /** 
     * Sets a list of unavailibilities to a resource.
     * <code>resource.setLstBusy(lstBusy)</code>
     *
     * @param busies a list of unavailibilities.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.IResource#setSetBusy(java.util.SortedSet)
     */
    public void setSetBusy(Set<IBusy> busies)
    {
        this.setBusy = new TreeSet<IBusy>(busies);
    }

    /** 
     * Adds an unavailibility to the list.
     * <code>resource.addBusy(busy)</code>
     *
     * @param busy an unavilibility.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.IResource#addBusy(fr.umlv.ir3.flexitime.common.data.activity.IBusy)
     */
    public boolean addBusy(IBusy busy)
    {
        return setBusy.add(busy);
    }

    /** 
     * Removes an unavailibility of the list.
     * <code>resource.removeBusy(busy)</code>
     *
     * @param busy the unavailibility to remove.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.IResource#removeBusy(fr.umlv.ir3.flexitime.common.data.activity.IBusy)
     */
    public boolean removeBusy(IBusy busy)
    {
        return setBusy.remove(busy);
    }
}

