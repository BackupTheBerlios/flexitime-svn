/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.general;

import java.util.List;

import fr.umlv.ir3.flexitime.common.data.Data;
import fr.umlv.ir3.flexitime.common.data.ressources.Group;
import fr.umlv.ir3.flexitime.common.data.teachingStructure.TeachingStructure;

/**
 * Class
 *This class represents a Class with all parameters that it can have
 *A Class is a list of groups that works on the same SubjectsGroups.
 * @version 0.1
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface Class extends Data {
	
	  /** 
	   * getNbGroup
	   * returns the number of groups of a Class.
	   * 
	   *
	   * @return the number of groups of a Class.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  int getNbGroup();
	  
	  /** 
	   * getNbPerson
	   * returns the number of person in a Class.
	   * 
	   *
	   * @return the number of person in a Class.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  int getNbPerson();
	  
	  
	  /** 
	   * getTeachingStructure
	   * returns the teachingStructure of a Class.
	   * 
	   *
	   * @return the teachingStructure of a Class.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  TeachingStructure getTeachingStructure();
	  
	  /** 
	   * setTeachingStructure
	   * changes the teachingStructure of a Class.
	   * 
	   * @param struc the new teachingStructure.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void setTeachingStructure(TeachingStructure struc);
	  
	  /** 
	   * getLstGroups
	   * returns the list of groups of a Class.
	   * 
	   *
	   * @return the list of groups of a Class.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  List getLstGroups();
	  
	  /** 
	   * setLstGroups
	   * changes the list of groups of a Class.
	   * 
	   * @param lstGroup the new list of groups of a Class.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */	  
	  void setLstGroups(List lstGroup);
	  
	  /**
	   *  
	   * addGroup
	   * add a new group in the Class
	   *
	   * @param group the group added
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void addGroup(Group group);
	  
	  /**
	   *  
	   * removeGroup
	   * remove a group from the Class
	   *
	   * @param group the group removed
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void removeGroup(Group group);
}
