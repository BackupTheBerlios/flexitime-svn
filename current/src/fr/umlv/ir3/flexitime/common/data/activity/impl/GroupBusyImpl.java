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
public class GroupBusyImpl extends BusyImpl implements IGroupBusy
{
    //===========//
	//  Champs	 //
	//===========//
    private int reason;
    
    
    //=============//
	//Constructeurs//
    //=============//
	/**
	 * Default constructor for a group's unavailibility. 
	 */
	protected GroupBusyImpl()
	{}
	
	/**
	 * Constructs an unavailibility for a group with just a name in parameter. 
	 * 
	 * @param strName a string.
	 */
	public GroupBusyImpl(String strName)
	{
		super(strName);          
	}
	
    /**
     * Constructs an unavailibility for a group. 
     * 
     * @param iReason an Integer representing the reason of the unavailibility.
     * @param strName a string.
     * @param daStart the start date of the unavailibility.
     * @param daEnd the end date of the unavailibility.
     * 
     */
    public GroupBusyImpl(int iReason, String strName, Date daStart, Date daEnd)
    {
        super(strName,daStart,daEnd);
        reason = iReason;           
    }
    
    
    //===========//
    // Méthodes  //
	//===========//
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
}

    