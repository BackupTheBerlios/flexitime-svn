/*
 * Created on 15 d�c. 2004
 * by Administrateur
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.rmi;

import fr.umlv.ir3.flexitime.common.event.DataEvent;




/**
 * BusysListener - Interface which gets the event on the busy
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Val�re FOREL
 */
public interface IBusyListener {
    /** 
     * busyChanged - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param event 
     * 
     * @author   FlexiTeam - Val�re
     * @date     27 d�c. 2004
     */
    public void busyChanged(DataEvent event);
}
