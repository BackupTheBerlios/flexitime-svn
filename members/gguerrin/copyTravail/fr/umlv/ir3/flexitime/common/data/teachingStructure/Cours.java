/*
 * Created on 13 déc. 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package fr.umlv.ir3.flexitime.common.data.teachingStructure;

import java.util.List;

import fr.umlv.ir3.flexitime.common.data.ressources.Teacher;

/**
 * @author Famille
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface Cours {
	
	/** returns the type of the cours.
	   * @return the type of the cours.
	   */
	  int getType();
	  
	  /** changes the type of the cours.
	   *  @param type the new type.
	   */
	  void setType(int type);
	  
	  /** returns the number of hours of the cours.
	   * @return the number of hours of the cours.
	   */
	  int getNbHours();
	  
	  /** changes the number of hours of the cours.
	   *  @param nbHours the number of hours.
	   */
	  void setNbHours(int nbHours);
	  
	  /** returns the color of the cours.
	   * @return the color of the cours.
	   */
	  int getColor();
	  
	  /** changes the color of the cours.
	   *  @param color the new color.
	   */
	  void setColor(int color);
	
	/** returns the list of Teachers of a cours .
	   * @return the list of Teachers of a cours.
	   */
	  List getLstTeacher();
	  
	  /** changes the list of Teacher of a cours.
	   *  @param lstMatiere the list of Teacher  of a cours.
	   */
	  void setLstTeacher(String lstTeacher);

	  
	  /** add a teacher in a cours
	   * @param teacher the Teacher added.
	   */
	  void addTeacher(Teacher teacher);
	  
	  /** remove a teacher of a cours
	   *  @param teacher the Teacher removed.
	   */
	  void removeTeacher(Teacher teacher);
	  
}
