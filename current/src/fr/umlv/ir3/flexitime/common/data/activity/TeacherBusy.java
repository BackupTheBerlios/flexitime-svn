/*
 * Created on 23 déc. 2004
 * by Famille
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.activity;


import fr.umlv.ir3.flexitime.common.data.ressources.Teacher;


/**
 * TeacherBusy - DOCME Description
 * This interface represents the unavailabilities for a teacher
 * 
 * @version Révision 72
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface TeacherBusy extends Busy{
    
    /** 
	   * getTeacher - DOCME Description
	   * returns the Teacher of the unavailabilities .
	   * 
	   *
	   * @return the Teacher for this unavailabilities.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     20 déc. 2004
	   */	
	  Teacher getTeacher();
	  
	  /** 
	   * setTeacher - DOCME Description
	   * changes the Teacher of the unavailabilities.
	   * 
	   * @param teacher the Teacher  of the unavailabilities.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     20 déc. 2004
	   */
	  void setTeacher(Teacher teacher);

}
