/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.general.impl;

import java.util.ArrayList;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.general.IFloor;
import fr.umlv.ir3.flexitime.common.data.ressources.IRoom;


/**
 * Defines a floor which contains rooms.
 * 
 * @version 0.1
 * @see fr.umlv.ir3.flexitime.common.data.general.IFloor
 * 
 * @author FlexiTeam - Adrien BOUVET
 */
public class FloorImpl implements IFloor
{
    //===========//
    //   Champs  //
    //===========// 
    private String strName;
    private List listOfRooms; 
    
    
    //==================//
    //   Constructeurs  //
    //==================//
    /**
     * Constructs a floor from a building.
     * 
     * @param name a string.
     * @param listRooms a list of rooms for this floor.
     * 
     */
    public FloorImpl(String name, List listRooms)
    {
        this.strName = name;
        this.listOfRooms = new ArrayList(listRooms);
    }
    
    
    //=============//
    //   M�thodes  //
    //=============//
    /** 
     * Returns the list of rooms at this floor.
     * <code>List l = floor.getLstRoom()</code>
     *
     * @return the list of rooms; 
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.IFloor#getLstRoom()
     */
    public List getLstRoom()
    {
        return listOfRooms;
    }

    /** 
     * Sets the list of rooms at this floor.
     * <code>floor.setLstRoom(lstRoom)</code>
     *
     * @param lstRoom a list of rooms.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.IFloor#setLstRoom(java.util.List)
     */
    public void setLstRoom(List lstRoom)
    {
        this.listOfRooms = new ArrayList(lstRoom);
    }

    /** 
     * Adds a room to the list.
     * <code>floor.addRoom(room)</code>
     *
     * @param room the room to add to the list.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.IFloor#addRoom(fr.umlv.ir3.flexitime.common.data.ressources.IRoom)
     */
    public void addRoom(IRoom room)
    {
        listOfRooms.add(room);
    }

    /** 
     * Removes a floor from the list.
     * <code>floor.removeRoom(room)</code>
     *
     * @param room the room to remove of the list.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.general.IFloor#removeRoom(fr.umlv.ir3.flexitime.common.data.ressources.IRoom)
     */
    public void removeRoom(IRoom room)
    {
        listOfRooms.remove(room);
    }

    /** 
     * Returns the name of this floor.
     * <code>String name = floor.getName()</code>
     *
     * @return the name of this floor. 
     * 
     * @see fr.umlv.ir3.flexitime.common.data.IData#getName()
     */
    public String getName()
    {
        return strName;
    }

    /** 
     * Sets the name of this floor.
     * <code>floor.setName(name)</code>
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
