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
public interface Device extends Resources {
	
	/** returns the type of the material.
	   * @return the name of the ressource.
	   */
	  String getType();
	  
	  /** changes the type of the material.
	   *  @param type the new type.
	   */
	  void setType(String name);

}
