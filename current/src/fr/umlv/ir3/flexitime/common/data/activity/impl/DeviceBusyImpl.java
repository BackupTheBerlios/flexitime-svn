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
public class DeviceBusyImpl extends BusyImpl implements IDeviceBusy
{
	//===========//
	//  Champs   //
	//===========//
    private int reason;
    
    
    //=============//
	//Constructeurs//
    //=============//

    /**
     * Constructs an unavailibility for a device. 
     * 
     * @param iReason an Integer representing the reason of the unavailibility.
     * @param strName a string.
     * @param daStart the start date of the unavailibility.
     * @param daEnd the end date of the unavailibility.
     * 
     */
    public DeviceBusyImpl(int iReason, String strName, Date daStart, Date daEnd)
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

    
    
}
