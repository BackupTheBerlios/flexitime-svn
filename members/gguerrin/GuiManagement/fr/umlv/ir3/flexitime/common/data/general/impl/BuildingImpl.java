/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.general.impl;

import java.util.ArrayList;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.general.IBuilding;
import fr.umlv.ir3.flexitime.common.data.general.IFloor;
import fr.umlv.ir3.flexitime.common.data.impl.DataImpl;


/**
 * Defines a building which contains floors.
 * 
 * @version 205
 * @see fr.umlv.ir3.flexitime.common.data.general.IBuilding
 * 
 * @author FlexiTeam - J�r�me GUERS
 */
public class BuildingImpl extends DataImpl implements IBuilding
{
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3760850064486314295L;
    //===========//
    //   Champs  //
    //===========// 
    private List<IFloor> lstFloors;
    
    
    //==================//
    //   Constructeurs  //
    //==================//   
	/**
	 * Default constructor for a building. 
	 */
	protected BuildingImpl()
	{
        lstFloors = new ArrayList<IFloor>();   
    }
	
	/**
	 * Constructs a building with just a name in parameter.
	 * 
	 * @param name a string. 
	 */
	public BuildingImpl(String name)
	{
		super(name);
		lstFloors = new ArrayList<IFloor>();
	}
	
    /**
     * Constructs a building.
     * 
     * @param name a string.
     * @param listFloors a list of floors contains by the building.
     * 
     */
    public BuildingImpl(String name, List<IFloor> listFloors)
    {
        super(name);
        this.lstFloors = listFloors;
    }

    
    //=============//
    //   M�thodes  //
    //=============//
    /** 
     * Returns the number of floors in this building.
     * <code>Int nbFloor = building.getNbFloor()</code>
     *
     * @return the number of floors in this building.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.IBuilding#getNbFloor()
     */
    public int getNbFloor()
    {
        return lstFloors.size();
    }

    /** 
     * Returns the list of floors in this building.
     * <code>List list = building.getLstFloor()</code>
     *
     * @return the list of floors in this building. 
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.IBuilding#getLstFloor()
     */
    public List<IFloor> getLstFloor()
    {
        return lstFloors;
    }

    /** 
     * Sets the list of floors from the list given in parameter.
     * <code>building.setLstFloor(lstFloor)</code>
     *
     * @param lstFloor the original list of floors for this building.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.IBuilding#setLstFloor(java.util.List)
     */
    public void setLstFloor(List<IFloor> lstFloor)
    {
        this.lstFloors = lstFloor;
    }
    
    /** 
     * Adds a floor to the list.
     * <code>building.addFloor(floor)</code>
     *
     * @param floor a floor to add to the list.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.IBuilding#addFloor(fr.umlv.ir3.flexitime.common.data.general.IFloor)
     */
    public void addFloor(IFloor floor)
    {
        lstFloors.add(floor);
        floor.setParentBuilding(this);
    }

    /** 
     * Removes a floor of the list.
     * <code>building.removeFloor(floor)</code>
     *
     * @param floor a floor to remove of the list.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.IBuilding#removeFloor(fr.umlv.ir3.flexitime.common.data.general.IFloor)
     */
    public void removeFloor(IFloor floor)
    {
        lstFloors.remove(floor);
    }
}
