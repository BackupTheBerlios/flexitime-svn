/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.activity.impl;

import java.util.Date;

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
 * @version 199
 * @see fr.umlv.ir3.flexitime.common.data.activity.IDeviceBusy
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class DeviceBusyImpl extends BusyImpl implements IDeviceBusy
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
    protected DeviceBusyImpl()
    {}

    /**
     * Constructs an unavailibility for a device without a reason.
     * 
     * @param daStart
     *            the start date of the unavailibility.
     * @param daEnd
     *            the end date of the unavailibility.
     */
    DeviceBusyImpl(Date daStart, Date daEnd)
    {
        super(daStart, daEnd);
    }

    /**
     * Constructs an unavailibility for a device between a gap without reason.
     * 
     * @param g
     *            gap of the unavaibulity
     */
    DeviceBusyImpl(Gap g)
    {
        super(g);
    }

    /**
     * Constructs an unavailibility for a device for the reason specified.
     * 
     * @param daStart
     *            the start date of the unavailibility.
     * @param daEnd
     *            the end date of the unavailibility.
     * @param iReason
     *            an Integer representing the reason of the unavailibility.
     */
    DeviceBusyImpl(Date daStart, Date daEnd, int iReason)
    {
        super(daStart, daEnd);
        reason = iReason;
    }

    /**
     * Constructs an unavailibility for a device between a gap for the reason
     * specified.
     * 
     * @param g
     *            gap of the unavaibulity
     * @param iReason
     *            reason of the unavaibility
     */
    DeviceBusyImpl(Gap g, int iReason)
    {
        super(g);
        reason = iReason;
    }

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
    public int getReason()
    {
        return reason;
    }

    /**
     * Sets the reason of the unavailibility. <code>setReason(iReason)</code>
     * 
     * @param iReason
     *            an Integer representing the reason of unavailibility.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.IDeviceBusy#setReason(int)
     */
    public void setReason(int iReason)
    {
        reason = iReason;
    }
}
