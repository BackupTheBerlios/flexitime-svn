/*
 * Created on 13 déc. 2004
 * by Valère FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.management;

import fr.umlv.ir3.flexitime.common.data.ressources.*;


/**
 * DevicesManager - Manages the devices in a list
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Valère FOREL
 */
public interface DevicesManager {
    /** 
     * getDevice - get a device with its name
     * 
     *     <code>Device d = myBuildingManager.getDevice("myDevice")</code>
     *
     * @param name name of a device
     * @return a Device
     * 
     * @author   FlexiTeam - Valère FOREL
     * @date     13 déc. 2004
     */
    Device getDevice(String name);
    /** 
     * addDevice - adds a device in the list
     * 
     *     <code>myBuildingManager.addDevice(myDevice)</code>
     *
     * @param device a Device
     * 
     * @author   FlexiTeam - Valère FOREL
     * @date     13 déc. 2004
     */
    void addDevice(Device device);
    /** 
     * removeDevice - removes a device in the list
     * 
     *     <code>Device d = myBuildingManager.removeDevice("myDevice")</code>
     *
     * @param name name of a device to remove
     * @return a Device
     * 
     * @author   FlexiTeam - Valère FOREL
     * @date     13 déc. 2004
     */
    Device removeDevice(String name);
}
