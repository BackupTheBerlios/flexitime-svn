/*
 * Created on 12 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.common.data.activity;

import java.util.Date;
import java.util.List;

import sun.misc.Resource;

import fr.umlv.ir3.flexitime.common.data.teachingStructure.Cours;

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface Seance {
	
	/** returns the date of the seance.
	   * @return the date of the seance.
	   */
	  Date getDate();
	  
	  /** changes the date of the seance.
	   *  @param the date of the seance.
	   */
	  void setDate(Date date);
	  
	  /** returns the hours of the beginning of the seance.
	   * @return the hours of the beginning of the seance.
	   */
	  String getBeginHour();
	  
	  /** changes the hours of the beginning of the seance.
	   *  @param the hours of the beginning of the seance.
	   */
	  void setBeginHour(String beginHour);
	
	  /** returns the hours of the end of the seance.
	   * @return the hours of the end of the seance.
	   */
	  Date getEndHour();
	  
	  /** changes the hours of the end of the seance.
	   *  @param the hours of the end of the seance.
	   */
	  void setEndHour(Date date);
	  
	  /** returns the courses of the seance.
	   * @return the courses of the seance.
	   */
	  Cours getCours();
	  
	  /** changes the hours of the end of the seance.
	   *  @param the hours of the end of the seance.
	   */
	  void setCours(Cours cours);
	  
	  /** returns the list of resources of the seance.
	   * @return the list of resources of the seance.
	   */
	  List getLstResources();
	  
	  /** changes the list of resources of the seance.
	   *  @param the list of resources of the seance.
	   */
	  void setLstResources(List lstresources);
	  
	  /** add a resource in the seance
	   * @param resource the resource added
	   */
	  void addResource(Resource resource);
	  
	  /** remove a resource in the seance
	   * @param resource the resource removed
	   */
	  void removeResource(Resource resource);

}
