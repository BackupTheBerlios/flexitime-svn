/*
 * Created on 23 d�c. 2004
 * by Guillaume GUERRIN
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.rmi;

import fr.umlv.ir3.flexitime.common.event.DataEvent;




/**
 * IGroupListener - Interface which gets the event on the group
 * 
 * @version Verion ou r�vision SVN
 * 
 * @author FlexiTeam - Guillaume GUERRIN
 */
public interface IGroupListener {
    /** 
     * groupChanged - DOCME Description
     * Quel service est rendu par cette m�thode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param event 
     * 
     * @author   FlexiTeam - Val�re
     * @date     27 d�c. 2004
     */
    public void groupChanged(DataEvent event);
}