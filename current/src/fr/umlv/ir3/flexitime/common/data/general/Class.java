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
 * Class - DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface Class extends Data {
	
	  /** 
	   * getNbGroup - DOCME Description
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
	   * setNbGroup - DOCME Description
	   * changes the number of groups of a Class.
	   * 
	   * @param iNbGroup the new number of groups of a Class.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void setNbGroup(int iNbGroup);
	  
	  /** 
	   * getNbPerson - DOCME Description
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
	   * setNbPerson - DOCME Description
	   *  changes the number of person in a Class.
	   * 
	   * @param iNbPerson the new number of person in a Class.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void setNbPerson(int iNbPerson);
	  
	  /** 
	   * getTeachingStructure - DOCME Description
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
	   * setTeachingStructure - DOCME Description
	   * changes the teachingStructure of a Class.
	   * 
	   * @param struc the new teachingStructure.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void setTeachingStructure(TeachingStructure struc);
	  
	  /** 
	   * getLstGroups - DOCME Description
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
	   * setLstGroups - DOCME Description
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
	   * addGroup - DOCME Description
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
	   * removeGroup - DOCME Description
	   * remove a group from the Class
	   *
	   * @param group the group removed
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void removeGroup(Group group);
}
