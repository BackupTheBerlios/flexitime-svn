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
 * Track - DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface Track extends Data {
	
	/** 
	 * getLstClass - DOCME Description
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
	  * setLstClass - DOCME Description
	  * changes the list of class .
	  * 
	  * @param lstClass the new list of Class
	  * 
	  * @author   FlexiTeam - Guillaume GUERRIN
	  * @date     12 déc. 2004
	  */
	  void setLstClass(List lstClass);
	  
	  /**
	   * addClass - DOCME Description
	   * add a class in a track
	   *
	   * @param pClass the Class added.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void addClass(Class pClass);
	  
	 /**
	  * removeClass - DOCME Description
	  * remove a class in a track
	  * 
	  * @param pClass the Class removed.
	  * 
	  * @author   FlexiTeam - Guillaume GUERRIN
	  * @date     12 déc. 2004
	  */	  
	  void removeClass(Class pClass);
}
