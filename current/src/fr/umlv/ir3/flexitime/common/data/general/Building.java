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
 * Building - DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface Building extends Data {
	
    /** 
     * getNbFloor - DOCME Description
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
	  * setNbFloor - DOCME Description
	  * changes the number of floorss of Building.
	  * 
	  *  @param iNbFloor the new number of floor.
	  * 
	  * @author   FlexiTeam - Guillaume GUERRIN
	  * @date     12 déc. 2004
	  */
	  void setNbFloor(int iNbFloor);

	  /** 
	   * getLstFloor - DOCME Description
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
	   * setLstFloor - DOCME Description
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
	   * addFloor - DOCME Description
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
	   * removeFloor - DOCME Description
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
