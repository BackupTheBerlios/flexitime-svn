/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.activity.impl;

import junit.framework.TestCase;
import fr.umlv.ir3.flexitime.common.data.activity.IDeviceBusy;
import fr.umlv.ir3.flexitime.common.tools.Gap;

/**
 * Defines an unavailability for a device. Containes a reason for the
 * unavailibility, a start and an end date and a name.
 * 
 * REASON_BROCKEN   = 1;
 * REASON_LENDED    = 2;
 * REASON_IN_REPAIR = 3;
 * 
 * 
 * @version 240
 * @see fr.umlv.ir3.flexitime.common.data.activity.IDeviceBusy
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class TestDeviceBusyImpl extends TestCase
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3544667382438965552L;
    // ===========//
    // Champs //
    // ===========//
    private int               reason;

    // =============//
    // Constructeurs//
    // =============//
    /**
     * Default constructor for a device's unavailibility.
     */
    protected TestDeviceBusyImpl()
    {}

    
    // ===========//
    // Méthodes //
    // ===========//

    /**
     * Returns the reason of the unavailibility.
     * <code>int reason = getReason()</code>
     * 
     * @return the reason of the unavailibility.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.IDeviceBusy#getReason()
     */
    public void testGetReason()
    {
    }

    /**
     * Sets the reason of the unavailibility. <code>setReason(iReason)</code>
     * 
     * @param iReason
     *            an Integer representing the reason of unavailibility.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.IDeviceBusy#setReason(int)
     */
    public void testSetReason()
    {
    }
}
