/*
 * Created on 20 déc. 2004
 * by Famille
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.teachingStructure;

import java.util.List;

import fr.umlv.ir3.flexitime.common.data.Data;
/**
 * TeachingStructure - DOCME Description
 * The TeachingStructure represents a list of SubjectsGroups defined for a Class
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface TeachingStructure extends Data {
    
    /** 
	 * getLstSubjectsGroup
	 * returns the list of SubjectsGroups.
	 * 
	 *
	 * @return the list of SubjectsGroups.
	 * 
	 * @author   FlexiTeam - Guillaume GUERRIN
	 * @date     20 déc. 2004
	 */	
    List getLstSubjectsGroup();
    
    /** 
	 * setLstSubjectsGroup
	 * changes the list of SubjectsGroup of a teachingStructure.
	 * 
	 *
	 * @param lst the new list of SubjectsGroups.
	 * 
	 * @author   FlexiTeam - Guillaume GUERRIN
	 * @date     20 déc. 2004
	 */	
    void setLstSubjectsGroup(List lst);
    
    /** 
	   * addSubjectsGroup
	   * add a SubjectsGroup in a TeachingStructure .
	   * 
	   *
	   * @param subjectsGroup the new SubjectsGroup
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     20 déc. 2004
	   */
	  void addSubject(SubjectsGroup subjectsGroup);
	  
	  /** 
		 * removeSubjectsGroup
		 * remove a SubjectsGroup of a TeachingStructure.
		 * 
		 *
		 * @param subjectsGroup the new SubjectsGroup
		 * 
		 * @author   FlexiTeam - Guillaume GUERRIN
		 * @date     20 déc. 2004
		 */	
	  void removeSubject(SubjectsGroup subjectsGroup);
}
