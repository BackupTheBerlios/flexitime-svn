/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.resources.impl;

import java.util.List;

import fr.umlv.ir3.flexitime.common.data.activity.IBusy;
import fr.umlv.ir3.flexitime.common.data.resources.IDevice;


/**
 * Defines a device.
 * 
 * @version 205
 * @see fr.umlv.ir3.flexitime.common.data.resources.IDevice
 * 
 * @author FlexiTeam - J�r�me GUERS
 */
public class DeviceImpl extends ResourceImpl implements IDevice
{
    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3689070659724849206L;
    //===========//
	//  Champs	 //
	//===========//
    private String type;
    
    
	//=============//
	//Constructeurs//
    //=============//
	/**
	 * Default constructor for a device. 
	 */
	protected DeviceImpl()
	{
     super();   
    }
	
	/**
	 * Constructs a device with just a name in parameter.
	 * 
	 * @param name a string. 
	 */
	public DeviceImpl(String name)
	{
		super(name);
	}
    
    /**
     * Constructs a device with just a name in parameter.
     * 
     * @param name a string. 
     * @param type type of the device
     */
    public DeviceImpl(String name, String type)
    {
        super(name);
        this.type = type;
    }
	
    /**
     * Constructs a device.
     * 
     * @param name a string.
     * @param listBusy a list of unavailibilities.
     * @param type the type of device.
     */
    public DeviceImpl(String name, String type, List<IBusy> listBusy)
    {
        super(name, listBusy);
        this.type = type;
    }

    
    //===========//
    // M�thodes  //
	//===========//
    /** 
     * Returns the type of the device.
     * <code>Int i = device.getType()</code>
     *
     * @return the type of device.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.IDevice#getType()
     */
    public String getType()
    {
        return type;
    }

    /** 
     * Sets the type of device.
     * <code>device.setType(type)</code>
     *
     * @param type the type of device.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.IDevice#setType(java.lang.String)
     */
    public void setType(String type)
    {
        this.type = type;
    }
}
