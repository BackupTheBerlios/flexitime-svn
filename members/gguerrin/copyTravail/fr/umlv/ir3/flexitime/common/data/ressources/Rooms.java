/*
 * Created on 12 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.common.data.ressources;

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface Rooms extends Resources {
	
	/** returns the type of the room.
	   * @return the type of the room.
	   */
	  String getType();
	  
	  /** changes the type of the room.
	   *  @param the type of the room.
	   */
	  void setType(String name);
	  
	  /** returns the capacity of the room.
	   * @return the capacity of the room.
	   */
	  String getCapacity();
	  
	  /** changes the capacity of the room.
	   *  @param the capacity of the room.
	   */
	  void setCapacity(String name);

}
