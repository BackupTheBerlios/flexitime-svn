/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.ressources;

/**
 * Teacher - DOCME Description
 *This interface represents a teacher
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface Teacher extends Resource {
	
    /** 
	 * getSurName
	 * returns the surname of the teacher.
	 * 
	 *
	 * @return the surname of the teacher.
	 * 
	 * @author   FlexiTeam - Guillaume GUERRIN
	 * @date     12 déc. 2004
	 */	
	 String getSurName();
	  
	  /** 
	   * setSurName
	   * changes the surname of the teacher.
	   * 
	   * @param surName the new surname.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */ 
	  void setSurName(String surName);
	  
	  /** 
	   * getEmail
	   * returns the email of the teacher.
	   * 
	   *
	   * @return the email of the teacher.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */	
	  String getEmail();
	  
	  /** 
	   * setEmail
	   * changes the email of the teacher.
	   * 
	   * @param email the new email.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     12 déc. 2004
	   */ 
	  void setEmail(String email);
	  
	  
}
