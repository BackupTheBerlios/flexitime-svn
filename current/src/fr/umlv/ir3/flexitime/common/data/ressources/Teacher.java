/*
 * Created on 12 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.common.data.ressources;

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface Teacher extends Resources {
	
	/** returns the surname of the teacher.
	   * @return the surname of the teacher.
	   */
	  String getSurName();
	  
	  /** changes the surname of the teacher.
	   *  @param surname the new surname.
	   */
	  void setSurName(String surName);
	  
	  /** returns the email of the teacher.
	   * @return the email of the teacher.
	   */
	  String getEmail();
	  
	  /** changes the email of the teacher.
	   *  @param email the new surname.
	   */
	  void setEmail(String email);
	  
	  
}
