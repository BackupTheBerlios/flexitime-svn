/*
 * Created on 13 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.common.data.general;

import java.util.List;

import fr.umlv.ir3.flexitime.common.data.ressources.Rooms;

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface Floor extends General {
	
	/** returns a list of rooms of a floor.
	   * @return a list of floors of a floor.
	   */
	  List getLstRoom();
	  
	  /** changes a list of rooms of a floor.
	   *  @param lstRoom the new list of floor.
	   */
	  void setLstRoom(List lstFloor);
	  
	  /** add a room in a floor
	   *@param room the new Room of floor.
	   */
	  void addRoom(Rooms room);
	  
	  /** remove a room in a floor
	   *  @param room the new Room of floor.
	   */
	  void removeRoom(Rooms room);

}
