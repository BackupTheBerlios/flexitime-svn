/*
 * Created on 23 déc. 2004
 * by Famille
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.activity;

import fr.umlv.ir3.flexitime.common.data.ressources.Group;


/**
 * GroupBusy - DOCME Description
 * This interface represents the unavailabilities for a group
 * 
 * @version Révision 72
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface GroupBusy extends Busy {
    
    /** 
	   * getGroup - DOCME Description
	   * returns the Group of the unavailabilities .
	   * 
	   *
	   * @return the Group for this unavailabilities.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     20 déc. 2004
	   */	
	  Group getGroup();
	  
	  /** 
	   * setGroup - DOCME Description
	   * changes the Group of the unavailabilities.
	   * 
	   * @param group the Group of the unavailabilities.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     20 déc. 2004
	   */
	  void setGroup(Group group);

}
