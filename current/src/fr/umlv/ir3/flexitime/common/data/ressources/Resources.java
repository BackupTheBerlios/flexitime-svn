/*
 * Created on 12 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.common.data.ressources;

import fr.umlv.ir3.flexitime.common.data.activity.Unavailabilities;

/**
 * @author GUERRIN Guillaume
 *
 * This interface describe a general resource
 */
public interface Resources {
	
	/** returns the name of the resouce.
	   * @return the name of the resource.
	   */
	  String getName();
	  
	  /** changes the name of the resouce.
	   *  @param name the new name.
	   */
	  void setName(String name);
	  
	  /** returns the unavailabilities of the resouce.
	   * @return the unavailabilities of the resource.
	   */
	  Unavailabilities getUnavailabilities();
	  
	  /** changes the unavailabilities of the resouce.
	   *  @param unavailabilities the new unavailabilities.
	   */
	  void setUnavailabilities(Unavailabilities name);


}
