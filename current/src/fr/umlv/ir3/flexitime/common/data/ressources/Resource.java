/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.ressources;
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
public interface Resource {
	
    /** 
	 * getName - DOCME Description
	 * returns the name of the resouce.
	 * 
	 *
	 * @return the name of the resource.
	 * 
	 * @author   FlexiTeam - Guillaume GUERRIN
	 * @date     12 déc. 2004
	 */		
	 String getName();

	 /** 
	  * setName - DOCME Description
	  * changes the name of the resouce.
	  * 
	  *
	  *  @param name the new name.
	  * 
	  * @author   FlexiTeam - Guillaume GUERRIN
	  * @date     12 déc. 2004
	  */	
	  void setName(String name);
	  
	  /** 
	   * getBusy - DOCME Description
	   * returns the unavailabilities of the resouce.
	   * 
	   *
	   * @return the unavailabilities of the resource.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */		  
	  Busy getBusy();
	  
	  /** 
	   * setBusy - DOCME Description
	   * changes the unavailabilities of the resouce.
	   * 
	   *
	   * @param busy the new unavailabilities.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void setBusy(Busy busy);


}
