/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.ressources.impl;

import java.util.List;

import fr.umlv.ir3.flexitime.common.data.ressources.IDevice;


/**
 * Defines a device.
 * 
 * @version 0.1
 * @see fr.umlv.ir3.flexitime.common.data.ressources.IDevice
 * @see fr.umlv.ir3.flexitime.common.data.ressources.impl.ResourceImpl
 * 
 * @author FlexiTeam - Adrien BOUVET
 */
public class DeviceImpl extends ResourceImpl implements IDevice
{
    //===========//
	//  Champs	 //
	//===========//
    private String strType;
    
    
	//=============//
	//Constructeurs//
    //=============//
	/**
	 * Default constructor for a device. 
	 */
	public DeviceImpl()
	{}
	
	
    /**
     * Constructs a device.
     * 
     * @param name a string.
     * @param listBusy a list of unavailibilities.
     * @param type the type of device.
     * 
     */
    public DeviceImpl(String name, List listBusy, String type)
    {
        super(name, listBusy);
        this.strType = type;
    }

    
    //===========//
    // Méthodes  //
	//===========//
    /** 
     * Returns the type of the device.
     * <code>Int i = device.getType()</code>
     *
     * @return the type of device.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.ressources.IDevice#getType()
     * @author   FlexiTeam - Adrien BOUVET
     */
    public String getType()
    {
        return strType;
    }

    /** 
     * Sets the type of device.
     * <code>device.setType(type)</code>
     *
     * @param type the type of device.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.ressources.IDevice#setType(java.lang.String)
     * @author   FlexiTeam - Adrien BOUVET
     */
    public void setType(String type)
    {
        this.strType = type;
    }
}
