/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.activity;



import java.util.List;

import fr.umlv.ir3.flexitime.common.data.ressources.Resource;


/**
 * Lesson
 * A lesson is an unavailabilities with different resources as teachers devices and groups
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface Lesson extends Busy{
   
	  
    /** 
	   * getLstResource
	   * returns the list of resources of a Lesson
	   * 
	   *
	   * @return the list of resources of a Lesson
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */		  
	  List getLstResource();
	  
	  /** 
	   * setLstResource
	   * changes the list of resources of a Lesson
	   * 
	   *
	   * @param lstResource the new list of resources of a Lesson
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void setLstResource(List lstResource);
	  
	  /** 
	   * addResource
	   * add a Resource in a lesson .
	   * 
	   *
	   * @param resource the new Resource in a lesson.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     20 déc. 2004
	   */
	  void addResource(Resource resource);
	  
	  /** 
	   * removeResource
	   * remove Resource in a lesson.
	   * 
	   *
	   * @param resource the new Resource in a lesson
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     20 déc. 2004
	   */	
	  void removeResource(Resource resource);

}
