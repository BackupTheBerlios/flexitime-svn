/*
 * Created on 5 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */

package fr.umlv.ir3.flexitime.common.data.activity.impl;

import java.util.Date;

import fr.umlv.ir3.flexitime.common.data.activity.IGroupBusy;

/**
 * Defines an unavailability for a group.
 * Containes a reason for the unavailibility, a start and an end date and a name.
 * 
 * REASON_HOLLYDAYS = 1;
 * REASON_WORK      = 2;
 * 
 * 
 * @version 0.1
 * @see fr.umlv.ir3.flexitime.common.data.activity.IGroupBusy
 * 
 * @author FlexiTeam - Adrien BOUVET
 */
public class GroupBusyImpl implements IGroupBusy
{
    private int reason;
    private Date startDate;
    private Date endDate;
    private String name;
    
    
    /**
     * Constructs an unavailibility for a group. 
     * 
     * @param iReason an Integer representing the reason of the unavailibility.
     * @param sName a string.
     * @param startD the start date of the unavailibility.
     * @param endD the end date of the unavailibility.
     * 
     */
    public GroupBusyImpl(int iReason, String sName, Date startD, Date endD)
    {
        reason = iReason;
        startDate = startD;
        endDate = endD;
        name = sName;        
    }
    
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
     * Sets the reason of the unavailibility.
     * <code>setReason(iReason)</code>
     *
     * @param iReason an Integer representing the reason of unavailibility.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.IGroupBusy#setReason(int)
     */
    public void setReason(int iReason)
    {
        reason = iReason;
    }

    /** 
     * Returns the start date of the unavailibility.
     * <code>Date date = getStartDate()</code>
     *
     * @return the start date of the unavailibility.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.IBusy#getStartDate()
     */
    public Date getStartDate()
    {
        return startDate;
    }

    /** 
     * Sets the start date of the unavailibility.
     * <code>setStartDate(daBusy)</code>
     *
     * @param daBusy a date.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.IBusy#setStartDate(java.util.Date)
     */
    public void setStartDate(Date daBusy)
    {
        startDate = daBusy;
    }

    /** 
     * Returns the end date of the unavailibility.
     * <code>Date date = getEndDate()</code>
     *
     * @return the end date of the unavailibility.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.IBusy#getEndDate()
     */
    public Date getEndDate()
    {
        return endDate;
    }

    /**
     * Sets the end date of the unavailibility.
     * <code>setEndDate(daBusy)</code>
     *
     * @param daBusy a date.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.activity.IBusy#setEndDate(java.util.Date)
     */
    public void setEndDate(Date daBusy)
    {
        endDate = daBusy;
    }

    /**
     * Returns the name of the GroupBusy.
     * <code>String name = getName()</code>
     * 
     * @return the name of the GroupBusy.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.IData#getName()
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name of the GroupBusy.
     * <code>setName(name)</code>
     *
     * @param name a string.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.IData#setName(java.lang.String)
     */
    public void setName(String name)
    {
        this.name = name;
    }
}
