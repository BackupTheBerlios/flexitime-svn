/*
 * Created on 5 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.activity.impl;

import fr.umlv.ir3.flexitime.common.data.activity.IGroupBusy;
import fr.umlv.ir3.flexitime.common.tools.Gap;

/**
 * Defines an unavailability for a group. Containes a reason for the
 * unavailibility, a start and an end date and a name.
 * 
 * REASON_HOLLYDAYS = 1; REASON_WORK = 2;
 * 
 * 
 * @version 240
 * @see fr.umlv.ir3.flexitime.common.data.activity.IGroupBusy
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class GroupBusyImpl extends BusyImpl implements IGroupBusy
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3257288028304127033L;
    // ===========//
    // Champs //
    // ===========//
    private int               reason;

    // =============//
    // Constructeurs//
    // =============//
    /**
     * Default constructor for a group's unavailibility.
     */
    protected GroupBusyImpl()
    {}

    /**
     * Constructs an unavailibility for a group between a gap without reason.
     * 
     * @param g
     *            gap of the unavaibulity
     */
    public GroupBusyImpl(Gap g)
    {
        super(g);
    }

    /**
     * Constructs an unavailibility for a group between a gap without reason.
     * 
     * @param g
     *            gap of the unavaibulity
     * @param comment
     *            description of the unaivaibility
     */
    public GroupBusyImpl(Gap g, String comment)
    {
        super(g, comment);
    }

    /**
     * Constructs an unavailibility for a group between a gap for the reason
     * specified.
     * 
     * @param g
     *            gap of the unavaibulity
     * @param iReason
     *            reason of the unavaibility
     */
    public GroupBusyImpl(Gap g, int iReason)
    {
        this(g);
        reason = iReason;
    }
    
    /**
     * Constructs an unavailibility for a group between a gap for the reason
     * specified.
     * 
     * @param g
     *            gap of the unavaibulity
     * @param iReason
     *            reason of the unavaibility
     * @param comment
     *            description of the unaivaibility
     */
    public GroupBusyImpl(Gap g, int iReason, String comment)
    {
        this(g, comment);
        reason = iReason;
    }

    /**
     * Copy a group busy to create a new group busy.
     * 
     * @param busy
     *            the unavaibility to copy
     */
    public GroupBusyImpl(IGroupBusy busy)
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
     * @see fr.umlv.ir3.flexitime.common.data.activity.IGroupBusy#getReason()
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
     * @see fr.umlv.ir3.flexitime.common.data.activity.IGroupBusy#setReason(int)
     */
    public void setReason(int iReason)
    {
        reason = iReason;
    }
}
