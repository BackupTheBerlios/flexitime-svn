/*
 * Created on 23 déc. 2004
 * by Famille
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.activity;



/**
 * DeviceBusy 
 * This interface represents the unavailabilities for a device
 * 
 * @version Révision 72
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface DeviceBusy extends Busy {
    
    public final static int REASON_BROCKEN=1;
    public final static int REASON_LENDED=2;
    public final static int REASON_IN_REPAIR=3;

	  
	  /** 
	   * setReason 
	   * changes the Reason of the unavailabilities.
	   * 
	   * @param iReason the Reason of the unavailabilities.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     20 déc. 2004
	   */
	  void setReason(int iReason);

}
