/*
 * Created on 12 d�c. 2004
 * by Guillaume GUERRIN
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.ressources;
import java.util.List;

import fr.umlv.ir3.flexitime.common.data.Data;
import fr.umlv.ir3.flexitime.common.data.activity.Busy;

/**
 * Resource - DOCME Description
 * This interface represents a resource
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface Resource extends Data {
	
	  
	  /** 
	   * getLstBusy
	   * returns the list of unavailabilities of the resouce.
	   * 
	   *
	   * @return the list of unavailabilities of the resource.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 d�c. 2004
	   */		  
	  List getLstBusy();
	  
	  /** 
	   * setLstBusy
	   * changes the list of unavailabilities of the resouce.
	   * 
	   *
	   * @param lstBusy the new unavailabilities.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 d�c. 2004
	   */
	  void setLstBusy(List lstBusy);
	  
	  /** 
	   * addBusy
	   * add a unavailabilities in a Resource .
	   * 
	   *
	   * @param busy the new unavailabilitie
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     20 d�c. 2004
	   */
	  void addBusy(Busy busy);
	  
	  /** 
	   * removeBusy
	   * remove a unavailabilities of a Resource.
	   * 
	   *
	   * @param busy the new unavailabilitie
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     20 d�c. 2004
	   */	
	  void removeBusy(Busy busy);


}
