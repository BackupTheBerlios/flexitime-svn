/*
 * Created on 13 déc. 2004
 * by Valère FOREL
 * 
 * Copyright: GPL - UMLV(FR) - 2004/2005
 */
package fr.umlv.ir3.flexitime.common.rmi.admin;

import java.rmi.Remote;


/**
 * Users - Implements the interface Users
 * 
 * @version 0.1
 * 
 * @author FlexiTeam - Valère FOREL
 */
public interface IUserManager extends Remote{
   
    /** 
     * checkUser - DOCME Description
     * Quel service est rendu par cette méthode
     * 
     *     <code>exemple d'appel de la methode</code>
     *
     * @param name
     * @param passwd 
     * 
     * @author   FlexiTeam - Valère
     * @date     26 déc. 2004
     */
    public void checkUser(String name, String passwd);

}
