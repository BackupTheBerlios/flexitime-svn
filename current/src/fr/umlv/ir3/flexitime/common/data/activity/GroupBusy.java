/*
 * Created on 23 déc. 2004
 * by Famille
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.activity;

import fr.umlv.ir3.flexitime.common.data.ressources.Group;


/**
 * GroupBusy
 * This interface represents the unavailabilities for a group
 * 
 * @version Révision 72
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface GroupBusy extends Busy {
    
    public final static int REASON_HOLLYDAYS=1;
    public final static int REASON_WORK=2;

	  
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
