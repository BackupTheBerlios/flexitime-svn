/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.general;

import java.util.List;

import fr.umlv.ir3.flexitime.common.data.Data;
import fr.umlv.ir3.flexitime.common.data.ressources.Room;

/**
 * Floor
 *This class represents a floor with all parameters that it can have
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface Floor extends Data {
	
	  /** 
	   * getLstRoom
	   * returns a list of rooms of a floor.
	   * 
	   *
	   * @return a list of floors of a floor.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  List getLstRoom();
	  
	  /** 
	   * setLstRoom
	   * changes a list of rooms of a floor.
	   * 
	   * @param lstRoom the new list of floor.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */	
	  void setLstRoom(List lstRoom);
	  
	  /**
	   * addRoom
	   * add a room in a floor
	   *
	   * @param room the new Room added.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void addRoom(Room room);
	  
	  /**
	   * removeRoom
	   * remove a room in a floor
	   *
	   * @param room the Room removed
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void removeRoom(Room room);

}
