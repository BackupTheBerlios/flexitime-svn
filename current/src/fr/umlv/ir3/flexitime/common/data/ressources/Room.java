/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.ressources;

/**
 * Room - DOCME Description
 *This interface represents a room which belong to a floor
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface Room extends Resource {
	
    //Definition des types
    public final static int TYPE_MACHINE=1;
    public final static int TYPE_COURS=2;
    public final static int TYPE_TP=3;

    /** 
	 * getType
	 * returns the type of the room.
	 * 
	 *
	 * @return the type of the room.
	 * 
	 * @author   FlexiTeam - Guillaume GUERRIN
	 * @date     12 déc. 2004
	 */	
	  int getType();
	  
	  /** 
	   * setType
	   * changes the type of the room.
	   * 
	   * @param iType the type of the room.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */ 
	  void setType(int iType);
	  
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
	   * setCapacity
	   * changes the capacity of the room.
	   * 
	   * @param capacity the capacity of the room.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */ 
	  void setCapacity(String capacity);

}
