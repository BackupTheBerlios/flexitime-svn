/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.activity.impl;

import junit.framework.TestCase;
import fr.umlv.ir3.flexitime.common.data.activity.ITeacherBusy;
import fr.umlv.ir3.flexitime.common.tools.Gap;

/**
 * Defines an unavailability for a teacher. Containes a reason for the
 * unavailibility, a start and an end date and a name.
 * 
 * REASON_WORK = 1; REASON_HOLLYDAYS = 2; REASON_SICK = 3; REASON_STAGE = 4;
 * REASON_PERSO = 5;
 * 
 * 
 * @version 240
 * @see fr.umlv.ir3.flexitime.common.data.activity.ITeacherBusy
 * 
 * @author FlexiTeam - Jérôme GUERS
 */
public class TestTeacherBusyImpl extends TestCase
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3256445785217577008L;
    // ===========//
    // Champs //
    // ===========//
    private int               reason; 

    // ======== //
    // Méthodes //
    // ======== //
    /**
     * Returns the reason of the unavailibility.
     * <code>int reason = getReason()</code>
     * 
     * @return the reason of the unavailibility.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.ITeacherBusy#getReason()
     */
    public void testGetReason()
    {
        TeacherBusyImpl bus = new TeacherBusyImpl(new Gap(2004,12,01,12,01,2004,12,02,12,02));
        bus.setReason(2);
        if(bus.getReason()!=2)fail("Mauvaise reason");
    }

    /**
     * Sets the reason of the unavailibility. <code>setReason(iReason)</code>
     * 
     * @param iReason
     *            an Integer representing the reason of unavailibility.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.ITeacherBusy#setReason(int)
     */
    public void testSetReason()
    {
        TeacherBusyImpl bus = new TeacherBusyImpl(new Gap(2004,12,01,12,01,2004,12,02,12,02));
        bus.setReason(2);
        if(bus.getReason()!=2)fail("Mauvaise reason");
    }

}
