/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.activity.impl;

import java.util.Date;

import fr.umlv.ir3.flexitime.common.data.activity.ITeacherBusy;

/**
 * Defines an unavailability for a teacher. Containes a reason for the
 * unavailibility, a start and an end date and a name.
 * 
 * REASON_WORK      = 1;
 * REASON_HOLLYDAYS = 2;
 * REASON_SICK      = 3;
 * REASON_STAGE     = 4;
 * REASON_PERSO     = 5;
 * 
 * 
 * @version 199
 * @see fr.umlv.ir3.flexitime.common.data.activity.ITeacherBusy
 * 
 * @author FlexiTeam - J�r�me GUERS
 */
public class TeacherBusyImpl extends BusyImpl implements ITeacherBusy
{

    /**
     * Comment for <code>serialVersionUID</code>
     */
    private static final long serialVersionUID = 3256445785217577008L;
    // ===========//
    // Champs //
    // ===========//
    private int               reason;

    // =============//
    // Constructeurs//
    // =============//
    /**
     * Default constructor for a teacher's unavailibility.
     */
    protected TeacherBusyImpl()
    {}

    /**
     * Constructs an unavailibility for a teacher.
     * 
     * @param daStart
     *            the start date of the unavailibility.
     * @param daEnd
     *            the end date of the unavailibility.
     * @param iReason
     *            an Integer representing the reason of the unavailibility.
     */
    public TeacherBusyImpl(Date daStart, Date daEnd, int iReason)
    {
        super(daStart, daEnd);
        reason = iReason;
    }

    // ===========//
    // M�thodes //
    // ===========//
    /**
     * Returns the reason of the unavailibility.
     * <code>int reason = getReason()</code>
     * 
     * @return the reason of the unavailibility.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.ITeacherBusy#getReason()
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
     * @see fr.umlv.ir3.flexitime.common.data.activity.ITeacherBusy#setReason(int)
     */
    public void setReason(int iReason)
    {
        reason = iReason;
    }

}
