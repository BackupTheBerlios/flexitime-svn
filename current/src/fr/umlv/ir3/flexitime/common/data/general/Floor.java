/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.general;

import java.util.List;

import fr.umlv.ir3.flexitime.common.data.ressources.Room;

/**
 * Floor - DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface Floor extends General {
	
	  /** 
	   * getLstRoom - DOCME Description
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
	   * setLstRoom - DOCME Description
	   * changes a list of rooms of a floor.
	   * 
	   * @param lstRoom the new list of floor.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */	
	  void setLstRoom(List lstFloor);
	  
	  /**
	   * addRoom - DOCME Description
	   * add a room in a floor
	   *
	   * @param room the new Room added.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void addRoom(Room room);
	  
	  /**
	   * removeRoom - DOCME Description
	   * remove a room in a floor
	   *
	   * @param room the Room removed
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void removeRoom(Room room);

}
