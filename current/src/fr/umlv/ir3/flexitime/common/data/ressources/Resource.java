/*
 * Created on 12 déc. 2004
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
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface Resource extends Data {
	
	  
	  /** 
	   * getLstBusy - DOCME Description
	   * returns the list of unavailabilities of the resouce.
	   * 
	   *
	   * @return the list of unavailabilities of the resource.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */		  
	  List getLstBusy();
	  
	  /** 
	   * setLstBusy - DOCME Description
	   * changes the list of unavailabilities of the resouce.
	   * 
	   *
	   * @param lstBusy the new unavailabilities.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void setLstBusy(List lstBusy);
	  
	  /** 
	   * addBusy - DOCME Description
	   * add a unavailabilities in a Resource .
	   * 
	   *
	   * @param busy the new unavailabilitie
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     20 déc. 2004
	   */
	  void addBusy(Busy busy);
	  
	  /** 
	   * removeBusy - DOCME Description
	   * remove a unavailabilities of a Resource.
	   * 
	   *
	   * @param busy the new unavailabilitie
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     20 déc. 2004
	   */	
	  void removeBusy(Busy busy);


}
