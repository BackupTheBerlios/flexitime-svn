/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.resources.impl;

import java.util.SortedSet;

import fr.umlv.ir3.flexitime.common.data.activity.IBusy;
import fr.umlv.ir3.flexitime.common.data.general.IClass;
import fr.umlv.ir3.flexitime.common.data.resources.IDevice;

/**
 * Defines a device.
 * 
 * @version 245
 * @see fr.umlv.ir3.flexitime.common.data.resources.IDevice
 * 
 * @author FlexiTeam - J�r�me GUERS
 */
public class DeviceImpl extends ResourceImpl implements IDevice
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID    = 3689070659724849206L;
    // ===========//
    // Champs //
    // ===========//
    private int               type;

    // =============//
    // Constructeurs//
    // =============//
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
     * @param name
     *            a string.
     */
    public DeviceImpl(String name)
    {
        super(name);
    }

    /**
     * Constructs a device with just a name in parameter.
     * 
     * @param name
     *            a string.
     * @param type
     *            type of the device
     */
    public DeviceImpl(String name, int type)
    {
        super(name);
        this.type = type;
    }

    /**
     * Constructs a device.
     * 
     * @param name
     *            a string.
     * @param busies
     *            a list of unavailibilities.
     * @param type
     *            the type of device.
     */
    public DeviceImpl(String name, int type, SortedSet<IBusy> busies)
    {
        super(name, busies);
        this.type = type;
    }

    // ======== //
    // M�thodes //
    // ======== //
    /**
     * Returns the type of the device. <code>Int i = device.getType()</code>
     * 
     * @return the type of device.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.IDevice#getType()
     */
    public int getType()
    {
        return type;
    }

    /**
     * Sets the type of device. <code>device.setType(type)</code>
     * 
     * @param type
     *            the type of device.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.IDevice#setType(int)
     */
    public void setType(int type)
    {
        this.type = type;
    }
    
    /**
     * Test the equality of two devices. Add a test to the equality of two
     * datas by comparing the type
     * 
     * @param obj
     *            other device to compare with
     * @return <code>true</code> if this object is the same as the obj
     *         argument; <code>false</code> otherwise.
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public boolean equals(Object obj)
    {
        if (obj == null) return false;
        if (! ( obj instanceof IClass )) return false;
        IDevice other = (IDevice) obj;
        if ( ( ( idData != null ) && ( other.getIdData() == null ) )
                || ( ( idData == null ) && ( other.getIdData() != null ) ))
            return false;
        if (idData == null)
        {
            if (this.getName().equals(other.getName()))
                return (type == other.getType());
            return false;
        }
        return ( idData == other.getIdData() );
    }

    /**
     * Generated by the hashcode of the name.
     * 
     * @return a class hashcode
     * 
     * @see java.lang.Object#hashCode()
     */
    public int hashCode()
    {
        return this.getName().hashCode();
    }
}
