/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.teachingStructure;

import java.util.List;

import fr.umlv.ir3.flexitime.common.data.Data;

/**
 * SubjectsGroup - DOCME Description
 *This interface represents a SubjectsGroup which belong to a TeachingStructure
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface SubjectsGroup extends Data{

   
    /** 
	 * getLstSubject
	 * returns the list of Subject of SubjectsGroups .
	 * 
	 *
	 * @return the list of Subject of SubjectsGroups.
	 * 
	 * @author   FlexiTeam - Guillaume GUERRIN
	 * @date     12 déc. 2004
	 */	
	  List getLstSubject();
	  
	  /** 
	   * setLstSubject
	   * changes the list of Subject of blocs.
	   * 
	   *
	   * @param lstSubject the list of Subject of blocs.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */	
	  void setLstSubject(List lstSubject);
	  
	  
	  /** 
	   * addSubject
	   * add a Subject in a SubjectsGroup .
	   * 
	   *
	   * @param Subject the new Subject
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void addSubject(Subject Subject);

	    /** 
		 * removeSubject
		 * remove a Subject of a SubjectsGroup.
		 * 
		 *
		 * @param subject the new Subject
		 * 
		 * @author   FlexiTeam - Guillaume GUERRIN
		 * @date     12 déc. 2004
		 */	
	  void removeSubject(Subject subject);

}
