/*
 * Created on 23 déc. 2004
 * by Guillaume GUERRIN
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.rmi;


import fr.umlv.ir3.flexitime.common.event.DataEvent;


/**
 * IDeviceListener - Interface which gets the event on the device
 * 
 * @version Verion ou révision SVN
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface IDeviceListener{
    /** 
     * deviceChanged - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param event 
     * 
     * @author   FlexiTeam - Valère
     * @date     27 déc. 2004
     */
    public void deviceChanged(DataEvent event);
}
