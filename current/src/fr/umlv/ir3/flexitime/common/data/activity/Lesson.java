/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.activity;

import java.util.Date;
import java.util.List;

import sun.misc.Resource;

import fr.umlv.ir3.flexitime.common.data.teachingStructure.Course;

/**
 * Lesson - DOCME Description
 *
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface Lesson {
    /** 
     * getDate - DOCME Description
     * returns the date of the lesson.
     * 
     *     <code>Date date = lesson.getDate()</code>
     *
     * @return the date of the lesson.
     * 
     * @author   FlexiTeam - Guillaume GUERRIN
     * @date     12 déc. 2004
     */
	  Date getDate();
	    
	  /** 
	     * setDate - DOCME Description
	     * changes the date of the lesson.
	     * 
	     *		<code>	
	     *				Date date = new Date();
	     * 				lesson.setDate(date);
	     * 		</code>
	     *
	     * @param daLesson the date of the lesson.
	     * 
	     * @author   FlexiTeam - Guillaume GUERRIN
	     * @date     12 déc. 2004
	     */
	  void setDate(Date daLesson);
	  
	  /** 
	     * getBeginHour - DOCME Description
	     *  returns the hours of the beginning of the lesson.e lesson.
	     * 
	     *		<code>	
	     *				String str = lesson.getBeginHour();
	     * 		</code>
	     *
	     * @return the hours of the beginning of the lesson.
	     * 
	     * @author   FlexiTeam - Guillaume GUERRIN
	     * @date     12 déc. 2004
	     */
	  String getBeginHour();
	  
	  /** 
	   * setBeginHour - DOCME Description
	   * changes the hours of the beginning of the lesson.
	   * 
	   *		<code>	
	   *				String str = new String();
	   * 				lesson.setBeginHour(str);
	   * 		</code>
	   *
	   * @param strBeginHour hour of the beginning of the lesson.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void setBeginHour(String strBeginHour);
	
	  /** 
	   * getEndHour - DOCME Description
	   * returns the hours of the end of the lesson.
	   * 
	   *		<code>	
	   *				String str = lesson.getEndHour();
	   *		</code>
	   * @return the hours of the end of the lesson.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  String getEndHour();
	  
	  /** 
	   * setEndHour - DOCME Description
	   * changes the hours of the end of the lesson.
	   * 
	   *		<code>	
	   *				String str = new String();
	   * 				lesson.setEndHour(str);
	   *		</code>
	   *
	   *@param the hours of the end of the lesson.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void setEndHour(String strEndHour );
	  
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
	  
	  /** 
	   * getLstResources - DOCME Description
	   * returns the list of resources of the lesson.
	   * 
	   *		<code>	
	   *				List lst = lesson.getLstResources();
	   *		</code>
	   *
	   *@return the list of resources of the lesson.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  List getLstResources();
	  
	  /** 
	   * setLstResources - DOCME Description
	   * changes the list of resources of the lesson.
	   * 
	   *		<code>	
	   *				List lst = new List();
	   * 				lesson.setLstResources(lst);
	   *		</code>
	   *
	   *@param lstResources the list of resources of the lesson.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void setLstResources(List lstResources);
	  
	  /** 
	   * addResource - DOCME Description
	   * add a resource in the lesson
	   * 
	   *		<code>	
	   *				Resource resource = new Resource();
	   * 				lesson.addResource(resource);
	   *		</code>
	   *
	   * @param resource the resource added
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void addResource(Resource resource);
	  
	  /** 
	   *  removeResource - DOCME Description
	   *  remove a resource in the lesson
	   * 
	   *		<code>	
	   *				Resource resource = new Resource();
	   * 				lesson.removeResource(resource);
	   *		</code>
	   *
	   * @param resource the resource removed
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void removeResource(Resource resource);

}
