/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.activity.impl;

import fr.umlv.ir3.flexitime.common.data.activity.IRoomBusy;
import fr.umlv.ir3.flexitime.common.tools.Gap;

/**
 * Defines an unavailability for a room. Containes a reason for the
 * unavailibility, a start and an end date and a name.
 * 
 * REASON_IN_WORK = 1;
 * REASON_LENDED = 2;
 * REASON_CLOSED = 3;
 * 
 * 
 * @version 240
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
     * Constructs an unavailibility for a room without reason.
     * 
     * @param g
     *            the gap between the unavailibility.
     */
    public RoomBusyImpl(Gap g)
    {
        super(g);
    }

    /**
     * Constructs an unavailibility for a room for the reason specified.
     * 
     * @param g
     *            the gap between the unavailibility.
     * @param iReason
     *            an Integer representing the reason of the unavailibility.
     */
    public RoomBusyImpl(Gap g, int iReason)
    {
        this(g);
        reason = iReason;
    }
    
    /**
     * Copy a room busy to create a new romm busy.
     * 
     * @param busy
     *            the unavaibility to copy
     */
    public RoomBusyImpl(IRoomBusy busy)
    {
        this(busy.getGap(), busy.getReason());
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
