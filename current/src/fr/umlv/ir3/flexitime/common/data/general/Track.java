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
 * Track
 * A track is a list of differents classes
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface Track extends Data {
	
	/** 
	 * getLstClass
	 * returns the list of class.
	 * 
	 *
	 * @return the list of class.
	 * 
	 * @author   FlexiTeam - Guillaume GUERRIN
	 * @date     12 déc. 2004
	 */
	  List getLstClass();
	  
	 /** 
	  * setLstClass
	  * changes the list of class .
	  * 
	  * @param lstClass the new list of Class
	  * 
	  * @author   FlexiTeam - Guillaume GUERRIN
	  * @date     12 déc. 2004
	  */
	  void setLstClass(List lstClass);
	  
	  /**
	   * addClass
	   * add a class in a track
	   *
	   * @param pClass the Class added.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void addClass(Class pClass);
	  
	 /**
	  * removeClass
	  * remove a class in a track
	  * 
	  * @param pClass the Class removed.
	  * 
	  * @author   FlexiTeam - Guillaume GUERRIN
	  * @date     12 déc. 2004
	  */	  
	  void removeClass(Class pClass);
}
