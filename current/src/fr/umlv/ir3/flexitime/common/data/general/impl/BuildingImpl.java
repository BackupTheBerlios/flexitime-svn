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


/**
 * Defines a building which contains floors.
 * 
 * @version 0.1
 * @see fr.umlv.ir3.flexitime.common.data.general.IBuilding
 * 
 * @author FlexiTeam - Adrien BOUVET
 */
public class BuildingImpl implements IBuilding
{
    //===========//
    //   Champs  //
    //===========// 
    private String strName;
    private List listOfFloors;
    
    
    //==================//
    //   Constructeurs  //
    //==================//   
	/**
	 * Default constructor for a building. 
	 */
	protected BuildingImpl()
	{}
	
	/**
	 * Constructs a building with just a name in parameter.
	 * 
	 * @param name a string. 
	 */
	public BuildingImpl(String name)
	{
		this.strName = name;
		listOfFloors = new ArrayList();
	}
	
    /**
     * Constructs a building.
     * 
     * @param name a string.
     * @param listFloors a list of floors contains by the building.
     * 
     */
    public BuildingImpl(String name, List listFloors)
    {
        this.strName = name;
        this.listOfFloors = new ArrayList(listFloors);
    }

    
    //=============//
    //   Méthodes  //
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
        return listOfFloors.size();
    }

    /** 
     * Returns the list of floors in this building.
     * <code>List list = building.getLstFloor()</code>
     *
     * @return the list of floors in this building. 
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.IBuilding#getLstFloor()
     */
    public List getLstFloor()
    {
        return listOfFloors;
    }

    /** 
     * Sets the list of floors from the list given in parameter.
     * <code>building.setLstFloor(lstFloor)</code>
     *
     * @param lstFloor the original list of floors for this building.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.IBuilding#setLstFloor(java.util.List)
     */
    public void setLstFloor(List lstFloor)
    {
        listOfFloors = new ArrayList(lstFloor);
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
        listOfFloors.add(floor);
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
        listOfFloors.remove(floor);
    }

    /** 
     * Returns the name of this building.
     * <code>String name = building.getName()</code>
     *
     * @return the name of the building. 
     * 
     * @see fr.umlv.ir3.flexitime.common.data.IData#getName()
     */
    public String getName()
    {
        return strName;
    }

    /** 
     * Sets the name of this building.
     * <code>building.setName(name)</code>
     *
     * @param name a string.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.IData#setName(java.lang.String)
     */
    public void setName(String name)
    {
        this.strName = name;
    }
}
