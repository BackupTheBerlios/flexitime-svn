/*
 * Created on 12 déc. 2004
 * by Guillaume GUERRIN
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.ressources;

/**
 * Device
 * This interface represents a device as a videoprojector 
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface Device extends Resource {
	
	/** 
	 * getType
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
	  * setType
	  * changes the type of the device.
	  * 
	  * @param type the new type.
	  * 
	  * @author   FlexiTeam - Guillaume GUERRIN
	  * @date     12 déc. 2004
	  */ 
	  void setType(String type);

}
