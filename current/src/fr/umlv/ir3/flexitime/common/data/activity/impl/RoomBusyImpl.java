/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.activity.impl;

import java.util.Date;

import fr.umlv.ir3.flexitime.common.data.activity.IRoomBusy;

/**
 * Defines an unavailability for a room. Containes a reason for the
 * unavailibility, a start and an end date and a name.
 * 
 * REASON_IN_WORK = 1;
 * REASON_LENDED = 2;
 * REASON_CLOSED = 3;
 * 
 * 
 * @version 199
 * @see fr.umlv.ir3.flexitime.common.data.activity.IRoomBusy
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class RoomBusyImpl extends BusyImpl implements IRoomBusy
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3546365028442977075L;
    // ===========//
    // Champs //
    // ===========//
    private int               reason;

    // =============//
    // Constructeurs//
    // =============//
    /**
     * Default constructor for a room's unavailibility.
     */
    protected RoomBusyImpl()
    {}

    /**
     * Constructs an unavailibility for a room.
     * 
     * @param daStart
     *            the start date of the unavailibility.
     * @param daEnd
     *            the end date of the unavailibility.
     * @param iReason
     *            an Integer representing the reason of the unavailibility.
     */
    public RoomBusyImpl(Date daStart, Date daEnd, int iReason)
    {
        super(daStart, daEnd);
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
     * @see fr.umlv.ir3.flexitime.common.data.activity.IRoomBusy#getReason()
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
     * @see fr.umlv.ir3.flexitime.common.data.activity.IRoomBusy#setReason(int)
     */
    public void setReason(int iReason)
    {
        reason = iReason;
    }
}
