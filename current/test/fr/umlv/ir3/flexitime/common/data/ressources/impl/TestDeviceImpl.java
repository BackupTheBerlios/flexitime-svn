/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.ressources.impl;

import java.util.SortedSet;

import junit.framework.TestCase;

import fr.umlv.ir3.flexitime.common.data.activity.IBusy;
import fr.umlv.ir3.flexitime.common.data.resources.IDevice;
import fr.umlv.ir3.flexitime.common.data.resources.impl.DeviceImpl;

/**
 * Defines a device.<br>
 * Implements the interface IDevice
 * 
 * @version 245
 * @see fr.umlv.ir3.flexitime.common.data.resources.IDevice
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class TestDeviceImpl extends TestCase
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID    = 3689070659724849206L;
    // ===========//
    // Champs //
    // ===========//
    private int               type;


    

    // ======== //
    // Méthodes //
    // ======== //
    /**
     * Returns the type of the device. <code>Int i = device.getType()</code>
     * 
     * @return the type of device.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.IDevice#getType()
     */
    public void testGetType()
    {
        DeviceImpl device = new DeviceImpl("toto",2);
        if(device.getType()!=2)fail("error type");
    }

    /**
     * Sets the type of device. <code>device.setType(type)</code>
     * 
     * @param type
     *            the type of device.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.resources.IDevice#setType(int)
     */
    public void testSetType()
    {
         DeviceImpl device = new DeviceImpl("toto");
         device.setType(2);
         if(device.getType()!=2)fail("error type");
    }
}
