/*
 * Created on 13 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.common.data.general;

import java.util.List;

import fr.umlv.ir3.flexitime.common.data.teachingStructure.TeachingStructure;



/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface Promotion extends General {
	/** returns the number of groups of a Promotion.
	   * @return the number of groups of a Promotion.
	   */
	  int getNbGroup();
	  
	  /** changes the number of groups of a Promotion.
	   *  @param nbGroup the new number of groups of a Promotion.
	   */
	  void setNbGroup(int nbGroup);
	  
	  /** returns the number of person in a Promotion.
	   * @return the number of person in a Promotion.
	   */
	  int getNbPerson();
	  
	  /** changes the number of person in a Promotion.
	   *  @param nbGroup the new number of person in a Promotion.
	   */
	  void setNbPerson(int nbPerson);
	  
	  /** returns the teachingStructure of a Promotion.
	   * @return the teachingStructure of a Promotion.
	   */
	  TeachingStructure getTeachingStructure();
	  
	  /** changes the teachingStructure of a Promotion.
	   *  @param nbGroup the new number of person in a Promotion.
	   */
	  void setTeachingStructure(TeachingStructure struc);
	  
	  /** returns the list of groups of a Promotion.
	   * @return the list of groups of a Promotion.
	   */
	  List getLstGroups();
	  
	  /** changes the list of groups of a Promotion.
	   *  @param lstGroup the new list of groups of a Promotion.
	   */
	  void setLstGroups(List lstGroup);

}
