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
 * @author FlexiTeam - Jérôme GUERS
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
    // Definition des types
    /**
     * Comment for <code>VIDEOPROJECTOR</code>
     */
    public final static int   VIDEOPROJECTOR      = 1;
    /**
     * Comment for <code>TV</code>
     */
    public final static int   TV                  = 2;
    /**
     * Comment for <code>VIDEO_TAPE_RECORDER</code>
     */
    public final static int   VIDEO_TAPE_RECORDER = 3;
    
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
     * @param listBusy
     *            a list of unavailibilities.
     * @param type
     *            the type of device.
     */
    public DeviceImpl(String name, int type, List<IBusy> listBusy)
    {
        super(name, listBusy);
        this.type = type;
    }

    // ===========//
    // Méthodes //
    // ===========//
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
     * @see fr.umlv.ir3.flexitime.common.data.impl.DataImpl#equals(java.lang.Object)
     */
    public boolean equals(Object obj)
    {
        if (idData == null)
        {
            if (super.equals(obj))
                return (type == ((IDevice)obj).getType());
            return false;
        }
        return super.equals(obj);
    }
}
