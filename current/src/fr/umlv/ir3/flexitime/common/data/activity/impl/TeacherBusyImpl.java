/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.activity.impl;

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
     * Constructs an unavailibility for a teacher without reason.
     * 
     * @param g
     *            the gap between the unavailibility.
     */
    public TeacherBusyImpl(Gap g)
    {
        super(g);
    }
    
    /**
     * Constructs an unavailibility for a teacher without reason.
     * 
     * @param g
     *            the gap between the unavailibility.
     * @param comment
     *            description of the unaivaibility
     * 
     */
    public TeacherBusyImpl(Gap g, String comment)
    {
        super(g, comment);
    }

    /**
     * Constructs an unavailibility for a teacher for the reason specified.
     * 
     * @param g
     *            the gap between the unavailibility.
     * @param iReason
     *            an Integer representing the reason of the unavailibility.
     */
    public TeacherBusyImpl(Gap g, int iReason)
    {
        this(g);
        reason = iReason;
    }

    /**
     * Constructs an unavailibility for a teacher for the reason specified.
     * 
     * @param g
     *            the gap between the unavailibility.
     * @param iReason
     *            an Integer representing the reason of the unavailibility.
     * @param comment
     *            description of the unaivaibility
     */
    public TeacherBusyImpl(Gap g, int iReason, String comment)
    {
        this(g, comment);
        reason = iReason;
    }

    /**
     * Copy a teacher busy to create a new teacher busy.
     * 
     * @param busy
     *            the unavaibility to copy
     */
    public TeacherBusyImpl(ITeacherBusy busy)
    {
        this(busy.getGap(), busy.getReason(), busy.getComment());
    }

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
