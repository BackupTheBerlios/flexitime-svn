/*
 * Created on 13 déc. 2004
 * by Valère FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.rmi.admin;


import fr.umlv.ir3.flexitime.common.event.DataEvent;


/**
 * Preferences - Manages the preferences of a user
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Valère FOREL
 */
public interface IPreferenceListener {
    /** 
     * preferenceChanged - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param event 
     * 
     * @author   FlexiTeam - Valère
     * @date     27 déc. 2004
     */
    public void preferenceChanged(DataEvent event);
}
