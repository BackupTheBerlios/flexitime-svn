/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.general;

import java.util.List;
import fr.umlv.ir3.flexitime.common.data.Data;

/**
 * Building
 * This interface represents a building with all parameters that it can have
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface Building extends Data {
	
    /** 
     * getNbFloor
     * returns the number of floors of Building.
     * 
     *     <code>int i = lbuilding.getNbFloor()</code>
     *
     * @return the number of floors of Building.
     * 
     * @author   FlexiTeam - Guillaume GUERRIN
     * @date     12 déc. 2004
     */
	  int getNbFloor();


	  /** 
	   * getLstFloor
	   * returns a list of floors of Building.
	   * 
	   *
	   * @return a list of floors of Building.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  List getLstFloor();
	  
	  /** 
	   * setLstFloor
	   *  changes a list of the floor of Building.
	   * 
	   *
	   * @param lstFloor the new list of floor.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void setLstFloor(List lstFloor);
	  
	  /** 
	   * addFloor
	   *  add a floor in Building.
	   * 
	   *
	   * @param floor the floor added.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void addFloor(Floor floor);
	  
	  /** 
	   * removeFloor
	   * remove a floor in Building.
	   * 
	   *
	   * @param floor the floor removed.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void removeFloor(Floor floor);
}
