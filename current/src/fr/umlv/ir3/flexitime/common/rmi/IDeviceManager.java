/*
 * Created on 23 déc. 2004
 * by Guillaume GUERRIN
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.rmi;

import java.rmi.Remote;

import fr.umlv.ir3.flexitime.common.data.ressources.Device;


/**
 * IDeviceManager - DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version Verion ou révision SVN
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface IDeviceManager extends Remote,AbstractManager {
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
    void saveDevice(Device device);
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
    /** 
     * lockDevice - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param device
     * @return 
     * 
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    boolean lockDevice(Device device);
    /** 
     * unlockDevice - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param device
     * @return 
     * 
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    boolean unlockDevice(Device device);
}
