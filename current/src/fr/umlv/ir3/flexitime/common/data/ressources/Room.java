/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.ressources;

/**
 * Room - DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface Room extends Resource {
	
    /** 
	 * getType - DOCME Description
	 * returns the type of the room.
	 * 
	 *
	 * @return the type of the room.
	 * 
	 * @author   FlexiTeam - Guillaume GUERRIN
	 * @date     12 déc. 2004
	 */	
	  String getType();
	  
	  /** 
	   * setType - DOCME Description
	   * changes the type of the room.
	   * 
	   * @param type the type of the room.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */ 
	  void setType(String type);
	  
	  /** 
	   * getCapacity- DOCME Description
	   * returns the capacity of the room.
	   * 
	   *
	   * @return the capacity of the room.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */	
	  String getCapacity();
	  
	  /** 
	   * setCapacity - DOCME Description
	   * changes the capacity of the room.
	   * 
	   * @param capacity the capacity of the room.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */ 
	  void setCapacity(String capacity);

}
