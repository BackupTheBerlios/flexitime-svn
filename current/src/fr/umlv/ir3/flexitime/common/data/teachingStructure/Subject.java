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
 * Subject - DOCME Description
 *This interface represents a Subject which belong to a SubjectsGroup
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface Subject extends Data{
	  
    /** 
	 * getLstCourse
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
	  * setLstCourse
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
	   * addCourse
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
		 * removeCourse
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
