/*
 * Created on 13 déc. 2004
 * by Valère FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.admin;


/**
 * Users - DOCME Description
 * explication supplémentaire si nécessaire
 * in english please...
 * Que fait cette classe, qu'est-ce qu'elle 
 * représente, ...
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Valère FOREL
 */
public interface Users {
    User getUser(String name);
    /** 
     * addUser - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @param passwd 
     * 
     * @author   FlexiTeam - Valère FOREL
     * @date     13 déc. 2004
     */
    void addUser(String name, String passwd);
    User removeUser(String name);
    
}
