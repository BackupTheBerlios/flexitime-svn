/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.teachingStructure;

import java.util.List;

/**
 * SubjectsGroup - DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface SubjectsGroup {

    /** 
	 * getName - DOCME Description
	 * returns the name of the SubjectsGroup.
	 * 
	 *
	 * @return the name of the SubjectsGroup.
	 * 
	 * @author   FlexiTeam - Guillaume GUERRIN
	 * @date     12 déc. 2004
	 */	
	String getName();

    /** 
	 * setName - DOCME Description
	 * changes the name of the SubjectsGroup.
	 * 
	 *
	 * @param name the new name.
	 * 
	 * @author   FlexiTeam - Guillaume GUERRIN
	 * @date     12 déc. 2004
	 */	
	void setName(String name);

    /** 
	 * getLstSubject - DOCME Description
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
	   * setLstSubject - DOCME Description
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
	   * addSubject - DOCME Description
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
		 * removeSubject - DOCME Description
		 * remove a Subject of a SubjectsGroup.
		 * 
		 *
		 * @param Subject the new Subject
		 * 
		 * @author   FlexiTeam - Guillaume GUERRIN
		 * @date     12 déc. 2004
		 */	
	  void removeSubject(Subject Subject);

}
