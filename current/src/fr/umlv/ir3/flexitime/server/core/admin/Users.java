/*
 * Created on 13 d�c. 2004
 * by Val�re FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.server.core.admin;


/**
 * Users - Creates a list of users who can use the program
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Val�re FOREL
 */
public interface Users {
    User getUser(String name);
    /** 
     * addUser - adds a user une the list
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @param passwd 
     * 
     * @author   FlexiTeam - Val�re FOREL
     * @date     13 d�c. 2004
     */
    void addUser(String name, String passwd);
    User removeUser(String name);
    /** 
     * checkUser - check if a user exists
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name 
     * 
     * @author   FlexiTeam - Val�re FOREL
     * @date     14 d�c. 2004
     */
    void checkUser(String name);
    
}
