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
 * Course - DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface Course extends Data {
	
    /** 
	 * getType - DOCME Description
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
	   * setType - DOCME Description
	   * changes the type of the course.
	   * 
	   * @param type the new type.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void setType(int type);
	  
	  /** 
	   * getNbHours - DOCME Description
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
	   * setNbHours - DOCME Description
	   * changes the number of hours of the course.
	   * 
	   * @param nbHours the number of hours.me.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void setNbHours(int nbHours);
	  
	  /** 
	   * getColor - DOCME Description
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
	   * setColor - DOCME Description
	   * changes the color of the course.
	   * 
	   * @param color the new color.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void setColor(int color);
	
	  /** 
	   * getLstTeacher - DOCME Description
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
	   * setLstTeacher - DOCME Description
	   * changes the list of Teacher of a course.
	   * 
	   * @param lstTeacher the list of Teacher  of a course.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void setLstTeacher(List lstTeacher);

	  
	  /**
	   * addTeacher - DOCME Description
	   * add a teacher in a course
	   *
	   * @param teacher the Teacher added.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void addTeacher(Teacher teacher);
	  
	  /**
	   * removeTeacher - DOCME Description
	   * remove a teacher of a course
	   * 
	   * @param teacher the Teacher removed.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */
	  void removeTeacher(Teacher teacher);
	  
}
