/*
 * Created on 23 déc. 2004
 * by Famille
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.activity;

import fr.umlv.ir3.flexitime.common.data.ressources.Room;


/**
 * RoomBusy - DOCME Description
 * This interface represents the unavailabilities for a Room
 * 
 * @version Révision 72
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface RoomBusy extends Busy {
    
    /** 
	   * getRoom - DOCME Description
	   * returns the Room of the unavailabilities .
	   * 
	   *
	   * @return the Room for this unavailabilities.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     20 déc. 2004
	   */	
    Room getRoom();
	  
	  /** 
	   * setRoom - DOCME Description
	   * changes the Room of the unavailabilities.
	   * 
	   * @param room the Room of the unavailabilities.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     20 déc. 2004
	   */
	  void setRoom(Room room);

}
