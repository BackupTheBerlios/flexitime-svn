/*
 * Created on 13 déc. 2004
 * by Valère FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.rmi.admin;

import java.rmi.Remote;
import java.util.HashMap;


/**
 * Preferences - Manages the preferences of a user
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Valère FOREL
 */
public interface IPreferenceManager extends Remote{
    /** 
     * getPreferences - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param login
     * @return 
     * 
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    HashMap getPreferences(String login);
}
