/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.teachingStructure;

import java.util.List;

import fr.umlv.ir3.flexitime.common.data.Data;
import fr.umlv.ir3.flexitime.common.data.ressources.Teacher;

/**
 * Course
 * This interface represents a course which belong to a subject
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface Course extends Data {
	
    /** 
	 * getType
	 * returns the type of the course.
	 * 
	 *
	 * @return the type of the course.
	 * 
	 * @author   FlexiTeam - Guillaume GUERRIN
	 * @date     12 déc. 2004
	 */	
	  int getType();
	  
	  /** 
	   * setType
	   * changes the type of the course.
	   * 
	   * @param type the new type.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void setType(int type);
	  
	  /** 
	   * getNbHours
	   * returns the number of hours of the course.
	   * 
	   *
	   * @return the number of hours of the course.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */	
	  int getNbHours();
	  
	  /** 
	   * setNbHours
	   * changes the number of hours of the course.
	   * 
	   * @param nbHours the number of hours.me.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void setNbHours(int nbHours);
	  
	  /** 
	   * getColor
	   * returns the color of the course.
	   * 
	   *
	   * @return the color of the course.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */	
	  int getColor();
	  
	  /** 
	   * setColor
	   * changes the color of the course.
	   * 
	   * @param color the new color.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void setColor(int color);
	
	  /** 
	   * getLstTeacher
	   * returns the list of Teachers of a course .
	   * 
	   *
	   * @return the list of Teachers of a course.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */	
	  List getLstTeacher();
	  
	  /** 
	   * setLstTeacher
	   * changes the list of Teacher of a course.
	   * 
	   * @param lstTeacher the list of Teacher  of a course.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void setLstTeacher(List lstTeacher);

	  
	  /**
	   * addTeacher
	   * add a teacher in a course
	   *
	   * @param teacher the Teacher added.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void addTeacher(Teacher teacher);
	  
	  /**
	   * removeTeacher
	   * remove a teacher of a course
	   * 
	   * @param teacher the Teacher removed.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void removeTeacher(Teacher teacher);
	  
}
