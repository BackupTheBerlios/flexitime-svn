/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.activity;



import fr.umlv.ir3.flexitime.common.data.teachingStructure.Course;

/**
 * Lesson - DOCME Description
 * 
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface Lesson extends Busy{
   
	  
	  /** 
	   * getCourse - DOCME Description
	   * returns the course of the lesson.
	   * 
	   *		<code>	
	   *				Course course = lesson.getCourse();
	   *		</code>
	   *
	   *@return the course of the lesson.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  Course getCourse();
	  
	  /** 
	   * setCourse - DOCME Description
	   * changes the course of the lesson.
	   * 
	   *		<code>	
	   *				Course course = new Course();
	   * 				lesson.setCourse(course);
	   *		</code>
	   *
	   *@param course the course of the lesson.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void setCourse(Course course);
	  

	  

}
