/*
 * Created on 13 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.common.data.general;

import java.util.List;

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface Building extends General {
	
	/** returns the number of floors of Building.
	   * @return the number of floors of Building.
	   */
	  int getNbFloor();
	  
	  /** changes the number of floorss of Building.
	   *  @param nbFloor the new number of floor.
	   */
	  void setNbFloor(int nbFloor);
	  
	  /** returns a list of floors of Building.
	   * @return a list of floors of Building.
	   */
	  List getLstFloor();
	  
	  /** changes a list of the floor of Building.
	   *  @param lstFloor the new list of floor.
	   */
	  void setLstFloor(List lstFloor);
	  
	  /** add a floor in Building.
	   */
	  void addFloor(Floor floor);
	  
	  /** remove a floor in Building.
	   */
	  void removeFloor(Floor floor);
}
