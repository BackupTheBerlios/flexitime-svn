/*
 * Created on 23 déc. 2004
 * by Famille
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.data.activity;

import fr.umlv.ir3.flexitime.common.data.ressources.Device;


/**
 * DeviceBusy - DOCME Description
 * This interface represents the unavailabilities for a device
 * 
 * @version Révision 72
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface DeviceBusy extends Busy {
    
    /** 
	   * getDevice - DOCME Description
	   * returns the Device of the unavailabilities .
	   * 
	   *
	   * @return the Device for this unavailabilities.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     20 déc. 2004
	   */	
    Device getDevice();
	  
	  /** 
	   * setDevice - DOCME Description
	   * changes the Device of the unavailabilities.
	   * 
	   * @param device the Device of the unavailabilities.
	   * 
	   * @author   FlexiTeam - Guillaume GUERRIN
	   * @date     20 déc. 2004
	   */
	  void setDevice(Device device);

}
