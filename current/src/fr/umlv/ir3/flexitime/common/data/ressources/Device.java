/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.ressources;

/**
 * Device - DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface Device extends Resource {
	
	/** 
	 * getType - DOCME Description
	 * returns the type of the device.
	 * 
	 *
	 * @return the type of the device.
	 * 
	 * @author   FlexiTeam - Guillaume GUERRIN
	 * @date     12 déc. 2004
	 */	
	 String getType();
	  
	 /** 
	  * setType - DOCME Description
	  * changes the type of the device.
	  * 
	  * @param type the new type.
	  * 
	  * @author   FlexiTeam - Guillaume GUERRIN
	  * @date     12 déc. 2004
	  */ 
	  void setType(String type);

}
