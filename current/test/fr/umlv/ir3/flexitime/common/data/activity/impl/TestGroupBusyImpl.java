/*
 * Created on 5 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.activity.impl;

import junit.framework.TestCase;
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
public class TestGroupBusyImpl extends TestCase
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
    protected TestGroupBusyImpl()
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
     * @see fr.umlv.ir3.flexitime.common.data.activity.IGroupBusy#getReason()
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
     * @see fr.umlv.ir3.flexitime.common.data.activity.IGroupBusy#setReason(int)
     */
    public void testSetReason()
    {
    }
}
