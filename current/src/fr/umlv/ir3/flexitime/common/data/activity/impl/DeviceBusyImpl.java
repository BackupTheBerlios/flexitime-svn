/*
 * Created on 6 janv. 2005
 * by Adrien BOUVET
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.activity.impl;

import java.util.Date;

import fr.umlv.ir3.flexitime.common.data.activity.IDeviceBusy;


/**
 * Defines an unavailability for a device.
 * Containes a reason for the unavailibility, a start and an end date and a name.
 * 
 * REASON_BROCKEN   = 1;
 * REASON_LENDED    = 2;
 * REASON_IN_REPAIR = 3;
 * 
 *    
 * @version 0.1
 * @see fr.umlv.ir3.flexitime.common.data.activity.IDeviceBusy
 * 
 * @author FlexiTeam - Adrien BOUVET
 */
public class DeviceBusyImpl implements IDeviceBusy
{
    private int reason;
    private Date startDate;
    private Date endDate;
    private String name;
    
    
    /**
     * Constructs an unavailibility for a device. 
     * 
     * @param iReason an Integer representing the reason of the unavailibility.
     * @param sName a string.
     * @param startD the start date of the unavailibility.
     * @param endD the end date of the unavailibility.
     * 
     */
    public DeviceBusyImpl(int iReason, String sName, Date startD, Date endD)
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
     * @see fr.umlv.ir3.flexitime.common.data.activity.IDeviceBusy#getReason()
     * @author   FlexiTeam - Adrien BOUVET
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
     * @see fr.umlv.ir3.flexitime.common.data.activity.IDeviceBusy#setReason(int)
     * @author   FlexiTeam - Adrien BOUVET
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
     * @author   FlexiTeam - Adrien BOUVET
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
     * @author   FlexiTeam - Adrien BOUVET
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
     * @author   FlexiTeam - Adrien BOUVET
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
     * @author   FlexiTeam - Adrien BOUVET
     */
    public void setEndDate(Date daBusy)
    {
        endDate = daBusy;
    }

    /** 
     * Returns the name of the DeviceBusy.
     * <code>String name = getName()</code>
     *
     * @return the name of the DeviceBusy.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.IData#getName()
     * @author   FlexiTeam - Adrien BOUVET
     */
    public String getName()
    {
        return name;
    }

    /** 
     * Sets the name of the DeviceBusy.
     * <code>setName(name)</code>
     *
     * @param name a string.
     * 
     * @see fr.umlv.ir3.flexitime.common.data.IData#setName(java.lang.String)
     * @author   FlexiTeam - Adrien BOUVET
     */
    public void setName(String name)
    {
        this.name = name;
    }
}
