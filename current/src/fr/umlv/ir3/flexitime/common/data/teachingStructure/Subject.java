/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.teachingStructure;

import java.util.List;

/**
 * Subject - DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface Subject {

    /** 
	 * getName - DOCME Description
	 * returns the name of the Subject.
	 * 
	 *
	 * @return the name of the Subject.
	 * 
	 * @author   FlexiTeam - Guillaume GUERRIN
	 * @date     12 déc. 2004
	 */	
	String getName();

    /** 
	 * setName - DOCME Description
	 * changes the name of the Subject.
	 * 
	 *
	 * @param name the new name.
	 * 
	 * @author   FlexiTeam - Guillaume GUERRIN
	 * @date     12 déc. 2004
	 */	
	void setName(String name);

	  
    /** 
	 * getLstCourse - DOCME Description
	 * returns the list of course .
	 * 
	 *
	 * @return the list of course.
	 * 
	 * @author   FlexiTeam - Guillaume GUERRIN
	 * @date     12 déc. 2004
	 */	
	 List getLstCourse();
	  
	 /** 
	  * setLstCourse - DOCME Description
	  * changes the list of course.
	  * 
	  *
	  * @param lstCourse the list of course.
	  * 
	  * @author   FlexiTeam - Guillaume GUERRIN
	  * @date     12 déc. 2004
	  */	
	  void setLstCourse(List lstCourse);
	  
	  /** 
	   * addCourse - DOCME Description
	   * add a course in a Subject
	   * 
	   *
	   * @param course the courses added
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */	
	  void addCourse(Course course);
	  
	    /** 
		 * removeCourse - DOCME Description
		 * remove a course of a Subject
		 * 
		 *
		 * @param course the course removed.
		 * 
		 * @author   FlexiTeam - Guillaume GUERRIN
		 * @date     12 déc. 2004
		 */	
	  	void removeCourse(Course course);

}
